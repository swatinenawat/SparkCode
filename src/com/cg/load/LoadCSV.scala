package com.cg.load

object LoadCSV 
{
  def loadFile =
  {
  val spark = org.apache.spark.sql.SparkSession.builder
        .master("local")
        .appName("Spark CSV Reader")
        .getOrCreate;
    val df = spark.read
         .format("csv")
         .option("header", "true") //reading the headers
         .option("inferSchema", "true")
         .option("mode", "DROPMALFORMED")
         .load("C:\\Users\\sudsharm\\workspace\\FileAnalysis\\resources\\data.CSV")
   df
  }
}