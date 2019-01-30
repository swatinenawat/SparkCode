package com.cg.rdd.main
import com.cg.rdd.aggregate._
object MainApplication 
{
  def main(args:Array[String])
  {
    do
    {
        println("Welcome to Stat Cal")
        println("1:Max\t2:Min\t3:Mean\t4:StdDev1\t5:StdDev2\t6:Skewness\t7:Kurtosis\t8:Variance\t9:Median\t10:Exit")
        println("Enter your choice ")
        var choice = readInt()
        var col=0
        if(choice!=10)
        {
          println("Enter column number")
          col=readInt()
        }
        choice match
        {
          case 1=> StatCalc.maxCal(col)
          case 2=> StatCalc.minCal(col)
          case 3=> StatCalc.meanCal(col)
          case 4=> StatCalc.stdCal(col)
          case 5=> StatCalc.stdSampleCal(col)
          case 6=> StatCalc.skewCal(col)
          case 7=> StatCalc.kurtosisCal(col)
          case 8=> StatCalc.varianceCal(col)
          case 9=> val x= StatCalc.medianCal(col); println("Median of  "+StatCalc.displayHeader(col) +":"+x)
          case 10=> System.exit(1)
          case _ => println("Invalid")
        }
    }while(true)
  }
}