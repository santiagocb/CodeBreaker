package empresariales

import co.com.empresariales.CodeBreaker
import org.scalatest.FunSuite

class CodeBreakerTest extends FunSuite {


  test("1234 con resultado X") {
    CodeBreaker.secret="1234"
    val value = "1789"
    val result = CodeBreaker.codeBreaker(value)
    assert(result == "X")
    val result2 = CodeBreaker.codeBreaker2(value)
    assert(result2 == "X")
  }

  test("1234 con resultado _") {
    CodeBreaker.secret="1234"
    val value = "7189"
    val result = CodeBreaker.codeBreaker(value)
    assert(result == "_")
    val result2 = CodeBreaker.codeBreaker2(value)
    assert(result2 == "_")
  }

  test("1234 con resultado X_") {
    CodeBreaker.secret="1234"
    val value = "1782"
    val result = CodeBreaker.codeBreaker(value)
    assert(result == "X_")
    val result2 = CodeBreaker.codeBreaker2(value)
    assert(result2 == "X_")
  }

  test("1234 con resultado XX_") {
    CodeBreaker.secret="1234"
    val value = "1247"
    val result = CodeBreaker.codeBreaker(value)
    assert(result == "XX_")
    val result2 = CodeBreaker.codeBreaker2(value)
    assert(result2 == "XX_")
  }

  test("1234 con resultado XXXX") {
    CodeBreaker.secret="1234"
    val value = "1234"
    val result = CodeBreaker.codeBreaker(value)
    assert(result == "XXXX")
    val result2 = CodeBreaker.codeBreaker2(value)
    assert(result2 == "XXXX")
  }

  test("1234 con resultado ____") {
    CodeBreaker.secret="1234"
    val value = "2341"
    val result = CodeBreaker.codeBreaker(value)
    assert(result == "____")
    val result2 = CodeBreaker.codeBreaker2(value)
    assert(result2 == "____")
  }

  test("1234 con resultado XX__") {
    CodeBreaker.secret="1234"
    val value = "2134"
    val result = CodeBreaker.codeBreaker(value)
    assert(result == "XX__")
    val result2 = CodeBreaker.codeBreaker2(value)
    assert(result2 == "XX__")
  }

  test("6578 con resultado XXXX") {
    CodeBreaker.secret = "6578"
    val value = "6578"
    val result = CodeBreaker.codeBreaker(value)
    assert(result == "XXXX")
    val result2 = CodeBreaker.codeBreaker2(value)
    assert(result2 == "XXXX")
  }

  test("8765 con resultado ____") {
    CodeBreaker.secret = "6578"
    val value = "8765"
    val result = CodeBreaker.codeBreaker(value)
    assert(result == "____")
    val result2 = CodeBreaker.codeBreaker2(value)
    assert(result2 == "____")
  }

  test("9876 con resultado XXXX") {
    CodeBreaker.secret = "9876"
    val value = "9876"
    val result = CodeBreaker.codeBreaker(value)
    assert(result == "XXXX")
    val result2 = CodeBreaker.codeBreaker2(value)
    assert(result2 == "XXXX")
  }

  test("6509 con resultado XXXX") {
    CodeBreaker.secret = "6509"
    val value = "6509"
    val result = CodeBreaker.codeBreaker(value)
    assert(result == "XXXX")
    val result2 = CodeBreaker.codeBreaker2(value)
    assert(result2 == "XXXX")
  }

  /*
  test("Secreto aleatorio") {
    CodeBreaker.secret = Range(1, 5)
      .map(_ => Random.nextInt(9).toString)
      .mkString("")
    println(CodeBreaker.secret)
    val value = "6666"
    val result = CodeBreaker.codeBreaker(value)
    assert(result == "XXXX")
    val result2 = CodeBreaker.codeBreaker2(value)
    assert(result2 == "XXXX")
  }
  */
}
