name := "tools"

organization := "com.katlex"

scalaVersion := "2.10.0"

resolvers <+= sbtResolver

libraryDependencies ++= Seq("org.scala-sbt" % "launcher-interface" % "0.12.0" % "provided")
