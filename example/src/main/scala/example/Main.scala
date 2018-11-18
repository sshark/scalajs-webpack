package example

import modal.ModalHelper._
import modal.{JQueryModalOptions, Modal}
import org.querki.jquery.$

import scala.scalajs.js.annotation.JSExportTopLevel

object Main {

  @JSExportTopLevel("entrypoint.main")
  def main(args: Array[String]): Unit = {
    $(
      """<h1>An example to import <a target="_blank" href="http://jquerymodal.com/"><code>jquery-modal</code></a>, a jQuery plugin, into ScalaJS</h1>
        |<div id="simple-modal" class="modal">
        |  <p>Great to get out once in a while</p>
        |  <a href="#" rel="modal:close">Close</a>
        |</div>
        |<div id="fadein-modal" class="modal">
        |  <p>Only shouting "close" can shut me</p>
        |  <a href="#" rel="modal:close">Close!!!</a>
        |</div>
        |<h2>Open modal using hyperlink's <code>ref</code> attribute</h2>
        |<p><a href="#simple-modal" rel="modal:open">Open Modal</a></p>
        |<h2>Open a fade in modal using jQuery</h2>
        |<div><button id="fadein-action" class="pure-button-primary pure-button">Open Modal</button></div>"""
        .stripMargin).appendTo($("body"))

    $("#fadein-action").click(() => $("#fadein-modal").modal(
      JQueryModalOptions.defaultModalOptions
        .showClose(false)
        .escapeClose(false)))

    Modal
  }
}
