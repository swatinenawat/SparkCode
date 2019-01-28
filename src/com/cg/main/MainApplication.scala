package com.cg.main
import com.cg.aggregate._
object MainApplication 
{
  def main(args:Array[String])
  {
    var m=new StatCalc()
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
          case 1=> m.maxCal(col)
          case 2=> m.minCal(col)
          case 3=> m.meanCal(col)
          case 4=> m.stdCal(col)
          case 5=> m.stdSampleCal(col)
          case 6=> m.skewCal(col)
          case 7=> m.kurtosisCal(col)
          case 8=> m.varianceCal(col)
          case 9=> m.medianCal(col)
          case 10=> System.exit(1)
          case _ => println("Invalid")
        }
    }while(true)
  }
}