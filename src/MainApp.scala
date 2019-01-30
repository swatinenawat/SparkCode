import java.io.BufferedReader

import java.io.InputStreamReader

import java.util.StringTokenizer

 

import scala.util.Try

 

object mrinal {

  def main(args: Array[String]) {

 

    class FastReader {

 

      private[this] val br = new BufferedReader(new InputStreamReader(System.in))

 

      private[this] var st: StringTokenizer = null

 

      def next() = {

        while (st == null || !st.hasMoreElements()) {

          st = new StringTokenizer(br.readLine())

        }

        st.nextToken()

      }

      def nextInt = {

        next().toInt

      }

   //   def nextBigInt = BigInt(next())

   //   def nextLong = next() toLong

    //  def nextFloat = next() toFloat

     // def nextDouble = next() toDouble

     // def nextString = Try(br.readLine()).getOrElse("")

      def close = br.close()

    }

 

    val fr = new FastReader

 

    val numOfElem = fr.nextInt


    var _loop = 0

    val toMatrix = Array.ofDim[(Set[Int])](numOfElem, numOfElem)

    while (_loop < numOfElem) {

      //elemArr(_loop) = fr.nextInt
      toMatrix(_loop)(_loop) = (Set(fr.nextInt))
      _loop = _loop + 1

    }

 

    val numOfMagQuer = fr.nextInt

 

  

 

    var i,j=0

 

        while (i < numOfElem) {

          j = i+1

          while (j < numOfElem) {
              toMatrix(i)(j)=toMatrix(i)(j-1) ++ toMatrix(j)(j)

           j = j + 1

          }

          i = i + 1

        }

 

    val strbuffer = new StringBuffer()

 

    for (x <- 0 until numOfMagQuer) {

     // strbuffer.append(elemArr.slice(fr.nextInt - 1, fr.nextInt).toSet.size + "\n")

      strbuffer.append(toMatrix(fr.nextInt - 1)(fr.nextInt - 1).size+ "\n")

    }

    println(strbuffer.toString())

  }

}