package com.example.spark

import java.util.Properties

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Row, SparkSession}
import org.apache.spark.sql.types.{DoubleType, IntegerType, LongType, StringType, StructField, StructType}

object HdfsToMysql {
  /**
   *
   * @param
   */
  def main(args: Array[String]): Unit = {

    //spark2.x SQL的编程API(SparkSession)
    //是spark2.x SQL执行的入口
    val session = SparkSession.builder()
      .appName("HdfsToMysql")
      .master("local[*]")
      .getOrCreate()

    //创建RDD
    val lines: RDD[String] = session.sparkContext.textFile("hdfs://master:9000/Sparkdata/Assessmentdata/smalluserinfo.txt")

    /*
    //身份证号
      //姓名
      //性别
      //年龄
      //公积金比例
      //月收入
      //月支出
      //违约记录
      //用户照片
     */

    //将数据进行整理
    val rowRDD: RDD[Row] = lines.map(line => {
      val fields = line.split(" ")
      val no: String = fields(0)
      val name: String = fields(1)
      val sex: String = fields(2)
      val age: Int = fields(3).toInt
      val providentFunRatio: Double = fields(4).toDouble
      val monthlyIncome: Double = fields(5).toDouble
      val monthlySpending: Double = fields(6).toDouble
      val defaultRecord: String = fields(7)
      val userPhotos: String = fields(8)
      Row(no,name,sex,age,providentFunRatio,monthlyIncome,monthlySpending,defaultRecord,userPhotos)
    })

    //结果类型，其实就是表头，用于描述DataFrame
    val schema: StructType = StructType(List(
      StructField("no", StringType, true),
      StructField("name", StringType, true),
      StructField("sex", StringType, true),
      StructField("age", IntegerType, true),
      StructField("providentFunRatio", DoubleType, true),
      StructField("monthlyIncome", DoubleType, true),
      StructField("monthlySpending", DoubleType, true),
      StructField("defaultRecord", StringType, true),
      StructField("userPhotos", StringType, true)
    ))
    val df: DataFrame = session.createDataFrame(rowRDD, schema)


    val props = new Properties()
    props.put("user","root")
    props.put("password","root")
    df.write.mode("Overwrite").jdbc("jdbc:mysql://localhost:3306/febs_st_bus?serverTimezone=GMT%2B8", "userinfo", props)

    session.close()

  }

}
