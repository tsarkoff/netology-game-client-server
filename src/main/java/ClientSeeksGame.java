import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClientSeeksGame {
    public static void connect() {
        System.out.printf("Client: I am connecting... to Server address = %s, port = %d%n", GameServer.SERVER_ADDRESS, GameServer.SERVER_PORT);
        try (Socket cs = new Socket(GameServer.SERVER_ADDRESS, GameServer.SERVER_PORT)) {
            PrintWriter pw = new PrintWriter(cs.getOutputStream(), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            System.out.println(br.readLine()); // Server: confirms a connection
            pw.println(String.format("Client: Hi, I am connected from address = %s and port = %d", cs.getLocalAddress(), cs.getLocalPort()));
            System.out.println(br.readLine() + ":\nClient: Alex"); // Server: asks a name
            pw.println("Alex");
            System.out.println(br.readLine() + ":\nClient: NO"); // Server: asks an age
            pw.println("NO");
            System.out.println(br.readLine()); // Server: welcomes to Zone
            pw.println("Client: Thanks for accepting Kids Zone!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}