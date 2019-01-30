package com.cg.rdd.aggregate
import com.cg.rdd.load._
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}
object StatCalc  extends java.io.Serializable
{
   
   val d = LoadCSV.loadFile
   val emp_data = d.textFile("C:\\Users\\sudsharm\\workspace\\SparkProjectCSV\\resources\\data.CSV")
   val emp_header = emp_data.first()
   val emp_header1 = emp_header.split(",")
   val emp_data_without_header = emp_data.filter(line => !line.equals(emp_header))
   
   def maxCal(col:Int)=
   {
     val emp_list=emp_data_without_header.map(l=>l.split(",")).map(x=>x(col).toDouble)
      println("Maximum "+emp_header1(col) +":"+ emp_list.max())
   }
    def minCal(col:Int)=
   {
     val emp_list=emp_data_without_header.map(l=>l.split(",")).map(x=>x(col).toDouble)
     println("Minimum "+emp_header1(col) +":"+ emp_list.min())
   }
   def meanCal(col:Int)=
   {
     val emp_list=emp_data_without_header.map(l=>l.split(",")).map(x=>x(col).toDouble)
     println("Mean of "+emp_header1(col) +":"+emp_list.mean())
   }
   def stdCal(col:Int)=
   {
     val emp_list=emp_data_without_header.map(l=>l.split(",")).map(x=>x(col).toDouble)
     println("Std dev of "+emp_header1(col) +":"+emp_list.stdev())
   }
   def stdSampleCal(col:Int)=
   {
     val emp_list=emp_data_without_header.map(l=>l.split(",")).map(x=>x(col).toDouble)
     println("Sample Std dev of  "+emp_header1(col) +":"+emp_list.sampleStdev())
   }
   def skewCal(col:Int)=
   {
     val emp_list=emp_data_without_header.map(l=>l.split(",")).map(x=>x(col).toDouble)
     val mean=emp_list.mean()
     val n=emp_list.count()
     var xsquare=d.accumulator(0.0)
     var xcube=d.accumulator(0.0)
     emp_list.foreach(x=>xsquare+=Math.pow(x-mean, 2))
     emp_list.foreach(x=>xcube+=Math.pow(x-mean, 3))
     var m3=xcube.value/n
     println("xcube"+xcube)
     println("xsq"+xsquare)
     var m2=Math.pow(xsquare.value/n,3/2)
     var g1=m3/m2
     println("n"+n)
     println("g1"+g1)
     println("m3"+m3)
     var skewness=g1*(Math.pow(n*(n-1), 0.5))/(n-2)
     println("Skewness of  "+emp_header1(col) +":"+skewness)
   }
   def kurtosisCal(col:Int)=
   {
     val emp_list=emp_data_without_header.map(l=>l.split(",")).map(x=>x(col).toDouble)
     val mean=emp_list.mean()
     val n=emp_list.count()
     var xsquare=d.accumulator(0.0)
     var xfour=d.accumulator(0.0)
     emp_list.foreach(x=>xsquare+=Math.pow(x-mean, 2))
     emp_list.foreach(x=>xfour+=Math.pow(x-mean, 4))
     var m4=xfour.value/n
     var m2=Math.pow(xsquare.value/n,2)
     var kurtosis=m4/m2-3
     println("Kurtosis of  "+emp_header1(col) +":"+kurtosis)
   }
   def varianceCal(col:Int)=
   {
     val emp_list=emp_data_without_header.map(l=>l.split(",")).map(x=>x(col).toDouble)
     println("Variance of  "+emp_header1(col) +":"+emp_list.variance())
   }
   def medianCal(col:Int)=
   {
     val emp_list=emp_data_without_header.map(l=>l.split(",")).map(x=>x(col).toDouble)
      val emp_list1=emp_list.sortBy(x=>x,true,2)
     var noOfEle = emp_list1.count()
     val x = emp_list1.zipWithIndex
     val y = x.map{case (k,v) => (v,k)} 
     val a = y.lookup((noOfEle/2)+1)
     val b = y.lookup((noOfEle/2))
     val median = (a(0)+b(0))/2
     median    
   }
   def displayHeader(col:Int)
   {
      emp_header1(col)
   }
}