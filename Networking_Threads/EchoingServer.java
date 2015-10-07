package HeadFirstJava.Networking_Threads;

import com.jidesoft.utils.Base64;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoingServer {
  public static void main(String[] args) {
    ServerSocket server = null;
    Socket client;

    try {
      server = new ServerSocket(1234);

    } catch (IOException e) {
      System.out.println("Can't open socket.");
      System.exit(1);
    }

    while (true) {
      try {
        client = server.accept();
        OutputStream clientOut = client.getOutputStream();
        PrintWriter writer = new PrintWriter(clientOut, true);
        InputStream clientIn = client.getInputStream();
        BufferedReader bf = new BufferedReader(new InputStreamReader(clientIn));
        writer.println(bf.readLine());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
