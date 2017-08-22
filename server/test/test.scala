package myapptest

import org.scalatestplus.play._

//import org.junit.runner._
//import play.api.test._

import scala.collection.mutable

class StackSpec extends PlaySpec {

  "A Stack" must {
    "pop values in last-in-first-out order" in {
      val stack = new mutable.Stack[Int]
      stack.push(1)
      stack.push(2)
      stack.pop() mustBe 2
      stack.pop() mustBe 1
    }
    "throw NoSuchElementException if an empty stack is popped" in {
      val emptyStack = new mutable.Stack[Int]
      a[NoSuchElementException] must be thrownBy {
        emptyStack.pop()
      }
    }
  }
}
/*
class TutorialTestWithScalaTest extends PlaySpec {

  // Initialize App
  TutorialApp.setupUI()

  describe("TutorialApp") {
    it("should contain 'Hello World' text in its body") {
      assert(jQuery("p:contains('Hello World')").length == 1)
    }

    it("should append 'You clicked the button!' text when the user clicks on the 'Click me!' button") {
      def messageCount =
        jQuery("p:contains('You clicked the button!')").length

      val button = jQuery("button:contains('Click me!')")
      assert(button.length == 1)
      assert(messageCount == 0)

      for (c <- 1 to 5) {
        button.click()
        assert(messageCount == c)
      }
    }

  }
}
 */
