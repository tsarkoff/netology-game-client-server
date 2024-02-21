import java.io.*;
import java.net.*;

public class GameServer {
    public static final String SERVER_ADDRESS = "netology.homework";
    public static final int SERVER_PORT = 8088;

    public static void listen() {
        try (ServerSocket ss = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server: I am started and listening on port " + SERVER_PORT);
            while (true) {
                Socket cs = ss.accept();
                BufferedReader br = new BufferedReader(new InputStreamReader(cs.getInputStream()));
                PrintWriter pw = new PrintWriter(cs.getOutputStream(), true);
                pw.println("Server: Hi, you are connected!");
                System.out.println(br.readLine());
                pw.println("Server: Please provide your name");
                pw.println("Server: Dear " + br.readLine() + ", are you adult (YES/NO)");
                pw.println("Server: Welcome to " + (br.readLine().equals("YES") ? "Adult" : "Kids") + " Zone!");
                System.out.println(br.readLine());
                ss.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}