package HeadFirstJava.Networking_Threads;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ExHTTPClient {
  public static void main(String[] args) {
    try {
      Socket socket = new Socket(args[0], 80);
      System.out.println("Client " + socket);
      getHTML(socket, args[1]);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void getHTML(Socket aSocket, String aArg) {
    try {
      DataOutputStream outbound = new DataOutputStream(aSocket.getOutputStream());
      DataInputStream inbound = new DataInputStream(aSocket.getInputStream());
      outbound.writeByte(Integer.parseInt("GET " + aArg + "HTTP/1.0\r\n\r\n"));
      String responeLine;
      while ((responeLine = inbound.readLine()) !=null) {
        System.out.println(responeLine);
      }
      outbound.close();
      inbound.close();
      aSocket.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
