import org.zeromq.ZMQ;
public class App {
    public String getGreeting() {
        return "Hello world.";
    }
    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        System.out.println(listarUsuarios(1, 10));
    }


    public static String listarUsuarios(int numPagina, int elemPorPagina ){
        StringBuilder sb = new StringBuilder();
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket socket = context.socket(ZMQ.REQ);
        socket.connect("tcp://localhost:6913");
        sb.append("listar_usuarios").append(" ");
        sb.append(Integer.toString(numPagina)).append(" ");
        sb.append(Integer.toString(elemPorPagina));
        socket.send(sb.toString());
        String mensaje = socket.recvStr();
        return mensaje;
    }


    public static String insertarUsuario(String usuario){
        StringBuilder sb = new StringBuilder();
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket socket = context.socket(ZMQ.REQ);
        socket.connect("tcp://localhost:6913");
        sb.append("insertar_usuario").append(" ");
        sb.append(usuario);
        socket.send(sb.toString());
        String mensaje = socket.recvStr();
        return mensaje;
    }
}
