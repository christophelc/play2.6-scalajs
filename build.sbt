scalaVersion in ThisBuild := "2.12.2"

lazy val commonSettings = Seq(
    version := "0.1-SNAPSHOT",
    scalaVersion := "2.12.2"
)

lazy val client = project.enablePlugins(ScalaJSPlugin, ScalaJSWeb).settings(
  commonSettings,
  scalaJSUseMainModuleInitializer := true,
  libraryDependencies ++= Seq(
   "org.scala-js" %%% "scalajs-dom" % "0.9.1"
  )
).dependsOn(sharedJs)

lazy val shared = (crossProject.crossType(CrossType.Pure) in file("shared")).settings(
  commonSettings
).jsConfigure(_ enablePlugins ScalaJSWeb)

lazy val sharedJvm = shared.jvm
lazy val sharedJs = shared.js

lazy val server = project.enablePlugins(PlayScala).settings(
  commonSettings,
  name := "play-scala-server",
  libraryDependencies ++= Seq(
   jdbc,
   ehcache,
   ws,
   guice,
   "com.typesafe.play" %% "play-json" % "2.6.0",
   "com.vmunier" %% "scalajs-scripts" % "1.1.1"
  ),
  scalaJSProjects := Seq(client),
  pipelineStages in Assets := Seq(scalaJSPipeline),
  pipelineStages := Seq(digest, gzip),
  // triggers scalaJSPipeline when using compile or continuous compilation
  compile in Compile := ((compile in Compile) dependsOn scalaJSPipeline).value
).dependsOn(sharedJvm)

// loads the server project at sbt startup
onLoad in Global := (Command.process("project server", _: State)) compose (onLoad in Global).value
