package co.com.empresariales

import scala.util.Random

object CodeBreaker {

  var secret = generateSecret()

  def generateSecret(): String = {
    var key = Range(1, 5)
      .map(_ => Random.nextInt(9).toString)
      .mkString("")
    while(key.toList.distinct.length != 4) {
      key = Range(1, 5)
        .map(_ => Random.nextInt(9).toString)
        .mkString("")
    }
    key
  }

  def codeBreaker(value: String): String = {
    var ret = ""
    for( i <- 0 until secret.length){
      val char = secret.charAt(i)
      if(value.contains(char)){
        val charValue = value.charAt(i)
        if(charValue == char) ret = ret + "X"
        else ret = ret + "_"
      }
      else ret = ret + ""
    }
    ret.sorted
  }

  def codeBreaker2(value: String): String = {
    val concat = secret.toList.zip(value.toList)
    val x = concat.map(tupla => {
      if(tupla._1 == tupla._2) "X"
      else {
        if(value.contains(tupla._1)) "_"
        else ""
      }
    })
    x.sorted.mkString("")
  }
}
