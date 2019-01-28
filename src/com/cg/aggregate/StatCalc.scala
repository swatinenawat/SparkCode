package com.cg.aggregate
import com.cg.load.LoadCSV
import org.apache.spark.sql.functions._

class StatCalc 
{
   val df1=LoadCSV.loadFile
   def maxCal(col:Int)=
   {
    
     df1.agg(max(df1.columns(col))).show()
   }
    def minCal(col:Int)=
   {
     df1.agg(min(df1.columns(col))).show()
   }
   def meanCal(col:Int)=
   {
     df1.agg(mean(df1.columns(col))).show()
   }
   def stdCal(col:Int)=
   {
     df1.agg(stddev(df1.columns(col))).show()
   }
   def stdSampleCal(col:Int)=
   {
     df1.agg(stddev_samp(df1.columns(col))).show()
   }
   def skewCal(col:Int)=
   {
     df1.agg(skewness(df1.columns(col))).show()
   }
   def kurtosisCal(col:Int)=
   {
     df1.agg(kurtosis(df1.columns(col))).show()
   }
   def varianceCal(col:Int)=
   {
     df1.agg(variance(df1.columns(col))).show()
   }
   def medianCal(col:Int)=
   {
     var temp = df1.stat.approxQuantile(df1.columns(col), Array(0.5), 0.01).head
     println("Median : "+temp)
    
   }
}