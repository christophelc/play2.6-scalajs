package example

import org.scalajs.dom
import shared.SharedMessages

import scala.scalajs.js
import js.Dynamic.{ global => g }

  object ScalaJSExample extends js.JSApp {
    def main(): Unit = {
      // @scalajs.html.scripts in header
      g.onload = () => {
        dom.document.getElementById("scalajsShoutOut").textContent = SharedMessages.itWorks
      }
      // @scalajs.html.scripts before </body>
      // dom.document.getElementById("scalajsShoutOut").textContent = SharedMessages.itWorks      
    }
  }
