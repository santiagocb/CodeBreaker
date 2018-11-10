name := "CodeBreaker"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.12" % "3.0.0" % "test",
  "com.typesafe.akka" %% "akka-http"   % "10.1.5",
  "com.typesafe.akka" %% "akka-stream" % "2.5.12",
  "com.typesafe.play" %% "play-json" % "2.6.2"
)