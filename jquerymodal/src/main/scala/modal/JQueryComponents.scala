package modal

import org.querki.jquery.{JQuery, JQueryStatic}
import org.querki.jsext.{JSOptionBuilder, OptMap, noOpts}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
trait JQueryModalOptions extends js.Object

object JQueryModalOptions extends ModalOptionsBuilder(noOpts) {
  val defaultModalOptions: ModalOptionsBuilder = JQueryModalOptions
    .clickClose(false)
    .escapeClose(true)
    .showClose(true)
    .fadeDelay(0.5)
    .fadeDuration(800)
}

class ModalOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[JQueryModalOptions, ModalOptionsBuilder](new ModalOptionsBuilder(_)) {
  def escapeClose(value: Boolean): ModalOptionsBuilder = jsOpt("escapeClose", value)
  def clickClose(value: Boolean): ModalOptionsBuilder = jsOpt("clickClose", value)
  def showClose(value: Boolean): ModalOptionsBuilder = jsOpt("showClose", value)
  def fadeDuration(value: Int): ModalOptionsBuilder = jsOpt("fadeDuration", value)
  def fadeDelay(value: Double): ModalOptionsBuilder = jsOpt("fadeDelay", value)
}

@JSImport("jquery-modal", JSImport.Default)
@js.native
object Modal extends Modal

@js.native
trait Modal extends JQuery {
  def close(): JQuery = js.native
  def modal(params: JQueryModalOptions): JQuery = js.native
  def modal(): JQuery = js.native
}

object ModalHelper {
  implicit class JQueryStaticToModal(private val jQuery: JQueryStatic.type)
    extends AnyVal {

    @inline def modal: Modal =
      jQuery.asInstanceOf[js.Dynamic].modal.asInstanceOf[Modal]
  }

  implicit def toModal(jQuery: JQuery) = jQuery.asInstanceOf[Modal]
}
