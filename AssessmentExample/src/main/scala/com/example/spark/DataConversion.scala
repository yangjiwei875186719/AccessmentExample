package com.example.spark

import com.example.entity.{Assessment, UserInfo}

/**
 * @author ：root
 * @date ：Created in 2020/6/10 17:53
 * @description：${description}数据转换
 * @modified By：
 */
class DataConversion {
  def dataAnaylize(userInfo:UserInfo): Assessment ={

    //身份证号
    val no = userInfo.getNo
    //姓名
    val name = userInfo.getName
    //性别
    val sex = userInfo.getSex
    //年龄
    val age = userInfo.getAge
    //公积金比例
    val providentFunRatio = userInfo.getProvidentFunRatio
    //月收入
    val monthlyIncome = userInfo.getMonthlyIncome
    //月支出
    val monthlySpending = userInfo.getMonthlySpending
    //违约记录
    val defaultRecord = userInfo.getDefaultRecord
    //用户照片
    val userPhotos = userInfo.getUserPhotos

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

    new Assessment(no,name,sex,age,retLevel,userPhotos)
  }
}
