ThisBuild / scalaVersion := "3.6.4"
ThisBuild / organization := "dev.pb"

lazy val dependencies = new {
  val cats_effect = "org.typelevel" %% "cats-effect" % "3.6.0"
  val fs2_core = "co.fs2" %% "fs2-core" % "3.12.0"
  val fs2_io = "co.fs2" %% "fs2-io" % "3.12.0"
  val munit = "org.scalameta" %% "munit" % "1.1.0" % Test
  val munit_cats_effect = "org.typelevel" %% "munit-cats-effect-3" % "1.0.7" % Test
}

lazy val root = (project in file("."))
  .aggregate(oghma)

lazy val oghma = project
  .in(file("oghma"))
  .settings(
    name := "oghma",
    version := "1.0.0",
    libraryDependencies ++= Seq(
      dependencies.cats_effect,
      dependencies.fs2_core,
      dependencies.fs2_io,
      dependencies.munit,
      dependencies.munit_cats_effect
    )
  )
