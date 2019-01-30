package com.cg.rdd.load
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object LoadCSV 
{
  def loadFile =
  {
    var conf = new SparkConf()
                .setAppName("Read CSV File")
                .setMaster("local[*]")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    sc
  }
}