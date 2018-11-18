package example

import modal.Modal
import org.querki.jquery.$

import scala.scalajs.js.annotation.JSExportTopLevel

import modal.ModalHelper._

object Main  {

  @JSExportTopLevel("entrypoint.main")
  def main(args: Array[String]): Unit = {
    $(
      """<div id="ex1" class="modal">
        |  <p>Thanks for clicking. That felt good.</p>
        |  <a href="#" rel="modal:close">Close</a>
        |</div>
        |<p><a href="#ex1" rel="modal:open">Open Modal</a></p>
        |<div><button type="button">Open Modal</button></div>"""
        .stripMargin).click(() => $("#ex1").modal()).appendTo($("body"))

    Modal
  }
}
