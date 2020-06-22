package com.example.spark

import java.util.Properties

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.types.{DoubleType, IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, Row, SaveMode, SparkSession}

object AssessmentAnalysis {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .master("local[2]")
      .appName("AssessmentAnalysis")
      .getOrCreate()




  import spark.implicits._

    val mysqlDF = spark.read.format("jdbc").option("driver", "com.mysql.cj.jdbc.Driver").option("url", "jdbc:mysql://127.0.0.1:3306/febs_st_bus?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false").option("dbtable", "userinfo").option("user", "root").option("password", "root").load()

    val retRDD = mysqlDF.map(row => {

      //身份证号
      val no = row.getString(0)
      //姓名
      val name = row.getString(1)
      //性别
      val sex = row.getString(2)
      //年龄
      val age = row.getInt(3)
      //公积金比例
      val providentFunRatio = row.getDouble(4)
      //月收入
      val monthlyIncome = row.getDouble(5)
      //月支出
      val monthlySpending = row.getDouble(6)
      //违约记录
      val defaultRecord = row.getString(7)
      //用户照片
      val userPhotos = row.getString(8)

      /**
       * 年龄等级：
       * 15-23->60分
       * 23-30->70分
       * 30-45->90分
       * 45岁以上->80分
       */
      val ageScore = age match {
        case age if (15 <= age && age < 23) => 60
        case age if (23 <= age && age < 30) => 70
        case age if (30 <= age && age < 45) => 90
        case age if (45 <= age) => 80
      }

      /**
       * 公积金比例等级：
       * 0.05-0.07->60分
       * 0.08-0.09->70分
       * 0.09-0.10->80分
       * 0.11-0.12->90分
       */
      val providentFunRatioScore = providentFunRatio match {
        case providentFunRatio if (0.05 <= providentFunRatio && providentFunRatio < 0.07) => 60
        case providentFunRatio if (0.07 <= providentFunRatio && providentFunRatio < 0.09) => 70
        case providentFunRatio if (0.09 <= providentFunRatio && providentFunRatio < 0.10) => 80
        case providentFunRatio if (0.10 <= providentFunRatio && providentFunRatio < 0.12) => 90
      }

      /**
       * 月收入等级：
       * 0-3000->60分
       * 3000-5000->70分
       * 5000-8000->80分
       * 8000以上->90分
       */
      val monthlyIncomeScore = monthlyIncome match {
        case monthlyIncome if (0 <= monthlyIncome && monthlyIncome < 3000) => 60
        case monthlyIncome if (3000 <= monthlyIncome && monthlyIncome < 5000) => 70
        case monthlyIncome if (5000 <= monthlyIncome && monthlyIncome < 8000) => 80
        case monthlyIncome if (8000 <= monthlyIncome) => 90
      }

      /**
       * 月支出等级：
       * 3000以内->60分
       * 3000-5000->70分
       * 5000-8000->80分
       * 8000以上->90分
       */
      val monthlySpendingScore = monthlySpending match {
        case monthlySpending if (0 <= monthlySpending && monthlySpending < 3000) => 60
        case monthlySpending if (3000 <= monthlySpending && monthlySpending < 5000) => 70
        case monthlySpending if (5000 <= monthlySpending && monthlySpending < 8000) => 80
        case monthlySpending if (8000 <= monthlySpending) => 90
      }

      val defaultRecordScore = defaultRecord match {
        case "Y" => 0
        case "N" => 100
      }

      val retScore = monthlyIncomeScore * 0.2 + monthlySpendingScore * 0.2 + providentFunRatioScore * 0.1 +
        ageScore * 0.1 + defaultRecordScore * 0.4

      val retLevel = retScore match {
        case retScore if (retScore > 90) => "优秀"
        case retScore if (75 <= retScore && retScore < 90) => "良好"
        case retScore if (60 <= retScore && retScore < 75) => "一般"
        case retScore if (retScore < 60) => "不及格"
      }

      val out = no + "|" + name + "|" + sex + "|" + age + "|" + retLevel + "|" + userPhotos

      out
    })

    val retDF = retRDD.map(line => {
      val items = line.split("\\|", -1)
      Assessment(items(0), items(1), items(2), items(3).toInt, items(4), items(5))
    }).toDF()

    retDF.show()

    retDF.write.format("jdbc").mode(SaveMode.Overwrite).option("driver", "com.mysql.cj.jdbc.Driver").option("url", "jdbc:mysql://localhost:3306/febs_st_bus?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false").option("dbtable", "assessment").option("user", "root").option("password", "root").save()
  }

  case class Assessment(no: String, name: String, sex: String, age: Int, level: String, userPhotos: String)

}
