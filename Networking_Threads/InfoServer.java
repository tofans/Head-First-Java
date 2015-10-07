package HeadFirstJava.Networking_Threads;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class InfoServer {

  private final int INFO_PORT = 5000;
  private String dataFromClient;


  public InfoServer() {
    BufferedReader inFromClient;
    DataOutputStream outToClient;
    Socket serverSocket;

    try {
      ServerSocket infoServer = new ServerSocket(INFO_PORT);
      System.out.println("Server Telah Siap....");
      while (true) {
        serverSocket = infoServer.accept();
        System.out.println("Ada client yg Connected");
        inFromClient = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        outToClient = new DataOutputStream(serverSocket.getOutputStream());
        outToClient.writeBytes("InfoServer versi 0.1\n hanya untuk testing..\n Silahkan berikan perintah TIME | NET | QUIT\n");
        boolean isQuit = false;
        while (!isQuit) {
          dataFromClient = inFromClient.readLine();
          if (dataFromClient.startsWith("TIME")) {
            outToClient.writeBytes(InetAddress.getByName("localhost").toString() + "\n");
          } else if (dataFromClient.startsWith("QUIT")){
            isQuit = true;
          }
        }
        outToClient.close();
        inFromClient.close();
        serverSocket.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new InfoServer();
  }
}
