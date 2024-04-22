import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class StressTest extends Simulation {

  val httpProtocol = http
    .baseUrl("https://automationintesting.online") // Here is the root for all relative URLs
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

  val scn = scenario("StressTest") // A scenario is a chain of requests and pauses
    .repeat(1000, "n") { // Repeat scenario 1000 times for each user
      exec(http("request_${n}")
        .get("/"))
        .pause(1) // Pause for 1 second
    }

  setUp(
    scn.inject(atOnceUsers(1000)) // Inject 1000 users at once
  ).protocols(httpProtocol)
}