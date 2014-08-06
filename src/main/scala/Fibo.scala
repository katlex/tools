import xsbti.{Exit, AppConfiguration, AppMain}
import scala.util.control.Exception

/**
 * Calculates a given item of Fibonacci sequence
 */
class Fibo extends AppMain {
  def run(configuration: AppConfiguration) = {

    // read and parse first argument for item index, use 1 by default
    val n = configuration.arguments().headOption.flatMap { s =>
      Exception.catching(classOf[NumberFormatException]).opt {
        Integer.parseInt(s)
      }
    } .getOrElse(1)
    
    // define lazy evaluated stream of Fibonacci numbers
    def fiboStream = {
      def f(a1:BigDecimal, a2:BigDecimal): Stream[BigDecimal] =
        a2 #:: f(a2, a1 + a2)
      1 #:: f(1, 1)
    }
    
    // show necessary item to the user
    println(fiboStream.drop(n - 1).head)
    
    new Exit {
      def code() = 0
    }
  }
}
