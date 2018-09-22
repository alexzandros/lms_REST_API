import org.zeromq.ZMQ;
public class App {

    static ZMQ.Context context = null;
    static ZMQ.Socket socket = null;

    private static void init_scope(){
        if (context == null){
            context = ZMQ.context(1);
            if (socket == null){
                socket = context.socket(ZMQ.REQ);
                zmq.ZMQ.setSocketOption(socket.base(), zmq.ZMQ.ZMQ_RCVTIMEO, 10000);
                zmq.ZMQ.setSocketOption(socket.base(), zmq.ZMQ.ZMQ_LINGER, 0);
                socket.connect("tcp://localhost:6913");
            }
        }
    }


    public static String listarUsuarios(int numPagina, int elemPorPagina ){
        init_scope();
        StringBuilder sb = new StringBuilder();
        sb.append("listar_usuarios").append(" ");
        sb.append(Integer.toString(numPagina)).append(" ");
        sb.append(Integer.toString(elemPorPagina));
        socket.send(sb.toString());
        String mensaje = socket.recvStr();
        if (mensaje == null){
            mensaje = "Error - no hay respuesta del backend!!";
            socket.close();
            context.close();
            socket = null;
            context = null;
        }
        return mensaje;
    }


    public static String insertarUsuario(String usuario){
        init_scope();
        StringBuilder sb = new StringBuilder();
        sb.append("insertar_usuario").append(" ");
        sb.append(usuario);
        socket.send(sb.toString());
        String mensaje = socket.recvStr();
        if (mensaje == null){
            mensaje = "Error - no hay respuesta del backend!!";
            socket.close();
            context.close();
            socket = null;
            context = null;
        }
        return mensaje;
    }

    public static String loguearUsuario(String usuario){
        init_scope();
        StringBuilder sb = new StringBuilder();
        sb.append("loguear_usuario").append(" ");
        sb.append(usuario);
        socket.send(sb.toString());
        String mensaje = socket.recvStr();
        if (mensaje == null){
            mensaje = "Error - no hay respuesta del backend!!";
            socket.close();
            context.close();
            socket = null;
            context = null;
        }
        return mensaje;
    }
}
