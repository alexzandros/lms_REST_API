import org.zeromq.ZMQ;
/*O
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App {
    public String getGreeting() {
        return "Hello world.";
    }
    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        System.out.println(new App().getMyData());
    }


    public static String getMyData(){
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket socket = context.socket(ZMQ.REQ);
        socket.connect("tcp://localhost:6913");
        socket.send("Pedí los datos desde Java");
        String mensaje = socket.recvStr();
        return mensaje;
    }
}