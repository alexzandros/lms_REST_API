import spark.kotlin.*

fun main(args: Array<String>) {
//    val http: Http = ignite()

    get("/listarUsuarios/:pagina/:numelem") {
        val pagina = params(":pagina").toInt()        
        val numelem = params(":numelem").toInt()  
        response.type("application/json")
        App.listarUsuarios(pagina, numelem)
    }

    get("/listarUsuarios") {
        response.type("application/json")
        App.listarUsuarios(1, 10)
    }

    post("/usuarios"){
        if (request.contentType() == "application/json"){
            if (App.insertarUsuario(request.body()).isNullOrEmpty()){
                response.status(201)
                "ok"
            }
            else{
                response.status(500)
                "Error Interno del Servidor"
            }
        }
        else
            halt(415)
    }
}
