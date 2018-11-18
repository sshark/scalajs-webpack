import sbt.Keys.version
import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport.npmDevDependencies

val root = project.aggregate(example, jquerymodal)

lazy val example = project
  .enablePlugins(ScalaJSBundlerPlugin)
  .settings(commonSettings: _*)
  .settings(
    scalaJSUseMainModuleInitializer := true,
    jsEnv in Test := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv(),
    emitSourceMaps  := false,
    libraryDependencies ++= Seq(
      "org.scalatest" %%% "scalatest" % "3.0.5" % Test,
      "org.querki" %%% "jquery-facade" % "1.2",
      "org.querki" %%% "querki-jsext" % "0.8"),
    npmDevDependencies in Compile ++= Seq(
      "html-webpack-plugin" -> "3.2.0",
      "copy-webpack-plugin" -> "4.5.1",
      "webpack-merge" -> "4.1.2",
      "imports-loader" -> "0.8.0",
      "expose-loader" -> "0.7.5"),
    version in webpack := "4.5.0",
    version in startWebpackDevServer := "3.1.3",
    webpackResources := baseDirectory.value / "webpacks" * "*",
    webpackConfigFile in fastOptJS := Some(baseDirectory.value / "webpacks" / "dev.webpack.config.js"))
  .dependsOn(jquerymodal)

lazy val jquerymodal = project
  .enablePlugins(ScalaJSBundlerPlugin)
  .settings(commonSettings: _*)
  .settings(
    scalaJSUseMainModuleInitializer := false,
    libraryDependencies ++= Seq(
      "org.querki" %%% "jquery-facade" % "1.2",
      "org.querki" %%% "querki-jsext" % "0.8"),
    npmDependencies in Compile ++= Seq(
      "jquery" -> "3.3.1",
      "jquery-modal" -> "0.9.1"),
    webpackBundlingMode in fastOptJS := BundlingMode.LibraryOnly())

lazy val commonSettings = Seq(
  scalaVersion := "2.12.6"
)

addCommandAlias("dev", ";fastOptJS::startWebpackDevServer;~fastOptJS")
