import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "ftlFiddle"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    anorm,
    "org.freemarker" % "freemarker" % "2.3.19",
    "org.springframework" % "spring-support" % "2.0.6"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )
}