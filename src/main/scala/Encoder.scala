import io.Source
import java.net.{URLDecoder, URLEncoder}
import xsbti.{Exit, AppConfiguration, AppMain}

/**
 * Encode/decode input stream using URL encoding
 * encode, by default, decode, it specified
 */
class Encoder extends AppMain {
  val DEFAULT_ENC = "UTF-8"

  def run(configuration: AppConfiguration) = {
    val args = configuration.arguments()

    // determine if we need encode or decode stdin
    val codeFunction: String => String =
      args.headOption match {
        case Some("--decode") =>
          URLDecoder.decode(_, DEFAULT_ENC)
        case _ =>
          URLEncoder.encode(_, DEFAULT_ENC)
      }

    // build a string and pass stdin through code function
    print(codeFunction(Source.fromInputStream(System.in).mkString))

    new Exit {
      def code() = 0
    }
  }
}
