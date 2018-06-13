import spark.kotlin.*

fun main(args: Array<String>) {
    val http: Http = ignite()

    http.get("/hello") {
        response.type("application/json")
        App.getMyData()
    }
}
