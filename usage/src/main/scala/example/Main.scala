package example

import modal.{JQueryModal, JQueryModalOptions}
import org.querki.jquery.{$, JQuery}
import org.scalajs.dom.Event

/*
@js.native
@JSImport("jquery-modal", JSImport.Namespace)
object modJQueryModal extends js.Object
*/

object Main {
  implicit def jq2JQueryModal(jq: JQuery): JQueryModal.type = jq.asInstanceOf[JQueryModal.type]

  def main(args: Array[String]): Unit = {
    $(() => {
      $("div").html("<p>Hello, World!</p>")
      $("#show-me").modal(JQueryModalOptions.defaultModalOptions)
      $("button").click((e: Event) => $("#show-me").modal(JQueryModalOptions.defaultModalOptions))
    })
  }
}