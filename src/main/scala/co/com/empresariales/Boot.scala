package co.com.empresariales

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.stream.ActorMaterializer
import akka.http.scaladsl.server.Directives._
import play.api.libs.json.JsValue
import play.api.libs.json._

import scala.io.StdIn
import scala.concurrent.ExecutionContext

object Boot extends App {
  val host = "0.0.0.0"
  val port = 9000

  implicit val system: ActorSystem = ActorSystem("helloworld")
  implicit val executor: ExecutionContext = system.dispatcher
  implicit val materializer: ActorMaterializer = ActorMaterializer()



  val route =
    pathPrefix("guess") {
      path(Segment) {
        number => get {
          val result = CodeBreaker.codeBreaker2(number)
          /*val jsonResponse = Json.parse(
            s"""
              {
                message: "algo",
                result: $result
              }
            """.stripMargin)*/
          complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, s"$result"))
        }
      } ~
      post {
        entity(as[String]) {
          secret =>
            val json = Json.parse(secret)
            val value = (json \ "secret").get.as[String]
            if (value == "")  {
              CodeBreaker.generateSecret()
            }
            else {
              CodeBreaker.secret = value
            }
            complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, s"Listo"))
        }
      }
    }

  val bindingFuture = Http().bindAndHandle(route, host, port)

  println(s"Server online at http://localhost:$port/\nPress RETURN to stop...")
  StdIn.readLine() // let it run until user presses return
  bindingFuture
    .flatMap(_.unbind()) // trigger unbinding from the port
    .onComplete(_ => system.terminate()) // and shutdown when done
}
