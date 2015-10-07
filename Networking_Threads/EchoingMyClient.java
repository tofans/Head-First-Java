package HeadFirstJava.Networking_Threads;

import com.jidesoft.utils.Base64;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class EchoingMyClient {
  public static void main(String[] args) {
    try {
      Socket client = new Socket(InetAddress.getLocalHost(), 1234);
      InputStream clientIn = client.getInputStream();
      OutputStream clientOut = client.getOutputStream();
      PrintWriter pw = new PrintWriter(clientOut, true);
      BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));
      BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Type the messege for the server : ");
      pw.println(stdIn.readLine());
      System.out.println("Server Messesage : ");
      System.out.println(br.readLine());
      pw.close();
      br.close();
      client.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
