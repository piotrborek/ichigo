ThisBuild / scalaVersion := "3.6.4"
ThisBuild / organization := "dev.pb"

lazy val dependencies = new {
  val munit = "org.scalameta" %% "munit" % "1.1.0" % Test
}

lazy val root = (project in file("."))
  .aggregate(oghma)
  .dependsOn(oghma)

lazy val oghma = project
  .in(file("oghma"))
  .settings(
    name := "oghma",
    version := "1.0.0",
    libraryDependencies ++= Seq(
      dependencies.munit
    )
  )
