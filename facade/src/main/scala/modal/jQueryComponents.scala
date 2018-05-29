package modal

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobal, JSImport}
import org.querki.jsext.{JSOptionBuilder, OptMap, noOpts}


@js.native
@JSGlobal
object JQueryModal extends js.Object {
  def modal(params: JQueryModalOptions): AnyRef = js.native
}

@JSImport("jquery-modal", JSImport.Namespace)
@js.native
object JQueryModalStatic extends js.Object {
  def close(): Any = js.native
}

@js.native
trait JQueryModalOptions extends js.Object
object JQueryModalOptions extends JQueryModalOptionsBuilder(noOpts) {
  val defaultModalOptions: JQueryModalOptionsBuilder = JQueryModalOptions
    .clickClose(false)
    .escapeClose(true)
    .showClose(true)
    .fadeDelay(0.5)
    .fadeDuration(800)
}

class JQueryModalOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[JQueryModalOptions, JQueryModalOptionsBuilder](new JQueryModalOptionsBuilder(_)) {
  def escapeClose(value: Boolean): JQueryModalOptionsBuilder = jsOpt("escapeClose", value)
  def clickClose(value: Boolean): JQueryModalOptionsBuilder = jsOpt("clickClose", value)
  def showClose(value: Boolean): JQueryModalOptionsBuilder = jsOpt("showClose", value)
  def fadeDuration(value: Int): JQueryModalOptionsBuilder = jsOpt("fadeDuration", value)
  def fadeDelay(value: Double): JQueryModalOptionsBuilder = jsOpt("fadeDelay", value)
}

