name := "tools"

organization := "com.katlex"

scalaVersion := "2.10.0"

resolvers <+= sbtResolver

libraryDependencies ++= Seq("org.scala-sbt" % "launcher-interface" % "0.12.0" % "provided")

publishTo := Some {
  val target = "snapshots"
  //val target = "releases"
  Resolver.file("katlex-repo", file(sys.props("user.home") + "/katlex.github.com/maven2/" + target))
}
