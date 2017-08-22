package jstest

import scala.scalajs.js
//import scala.scalajs.js.JSON

//import org.scalajs.jquery.jquery
import org.scalajs.jquery.JQueryStatic
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("jquery", JSImport.Namespace)
object jquery extends JQueryStatic

/*
object Main extends js.JSApp {
  @js.annotation.JSExport
  override def main(): Unit = {
    jquery("body").html("Hello world!")
  }
}
*/

import org.scalatest._

class TutorialTest extends FunSuite {

  TutorialApp.setupUI()
  test("HelloWorld") {
    assert(jquery("p:contains('Hello World')").length == 1)
  }

/*
  test("ButtonClick") {
    def messageCount =
      jquery("p:contains('You clicked the button!')").length

    val button = jquery("button:contains('Click me!')")
    assert(button.length == 1)
    assert(messageCount == 0)

    for (c <- 1 to 5) {
      button.click()
      assert(messageCount == c)
    }
  }
*/
}
/*
abstract class UnitTest(component: String) extends FlatSpec
  with Matchers{

}

class JsTest extends UnitTest("main") {
    "Basic tag creation" in {
	assert(a.toString === "<a/>")
	assert(html.toString === "<html/>")
    }
    "Page should contain search text box with button." - {
      assert(jquery("#scalajsShoutOut").value() == "Delhi")
      //val button = jquery("#submit")
      //assert(button.length == 1)
    }
}
*/

import scala.scalajs.js.JSApp

object TutorialApp extends JSApp {
  @js.annotation.JSExport
  override def main(): Unit = {
    jquery(setupUI _)
  }

  @js.annotation.JSExport
  def setupUI(): Unit = {
    jquery("body").html("Hello world!")
/*
    jquery("""<button type="button">Click me!</button>""")
      .click(addClickedMessage _)
      .appendTo(jquery("body"))
    jquery("body").append("<p>Hello World</p>")
*/
  }

  def addClickedMessage(): Unit = {
    jquery("body").append("<p>You clicked the button!</p>")
  }
}
