val `facade-project` =
  project.in(file("."))
    .aggregate(usage)

lazy val usage =
  project.in(file("usage"))
    .enablePlugins(ScalaJSBundlerPlugin)
    .settings(commonSettings: _*)
    .settings(
      scalaJSUseMainModuleInitializer := true,
      jsEnv in Test := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv(),
      libraryDependencies ++= Seq(
        "org.querki" %%% "jquery-facade" % "1.2",
        "org.querki" %%% "querki-jsext" % "0.8",
        "org.scalatest" %%% "scalatest" % "3.0.5" % Test),
      webpackConfigFile := Some(baseDirectory.value / "dev.webpack.config.js"),
      npmDevDependencies in Compile ++= Seq(
        "webpack-merge" -> "4.1.2",
        "imports-loader" -> "0.8.0",
        "expose-loader" -> "0.7.5"),
      npmDependencies in Compile ++= Seq(
        "jquery" -> "3.3.1",
        "jquery-modal" -> "0.9.1"))
    .dependsOn(facade)

lazy val facade =
  project.in(file("facade"))
    .enablePlugins(ScalaJSBundlerPlugin)
    .settings(commonSettings: _*)
    .settings(
      libraryDependencies ++= Seq(
        "org.querki" %%% "jquery-facade" % "1.2",
        "org.querki" %%% "querki-jsext" % "0.8"),
      npmDependencies in Compile ++= Seq(
        "jquery" -> "3.3.1",
        "jquery-modal" -> "0.9.1"))

lazy val commonSettings = Seq(
  scalaVersion := "2.12.6"
)
