package HeadFirstJava.Networking_Threads;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class InfoClient {
  private final int INFO_PORT = 5000;
  private final String TARGET_HOST = "localhost";
  private final String QUIT = "Quit";

  public InfoClient() {
    try {
      BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
      Socket clientSocket = new Socket(TARGET_HOST, INFO_PORT);
      DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
      BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      System.out.println(inFromServer.readLine());
      System.out.println(inFromServer.readLine());
      System.out.println(inFromServer.readLine());
      System.out.println();
      boolean isQuit = false;
      while (!isQuit) {
        System.out.println("Perintah Anda : ");
        String cmd = inFromUser.readLine();
        cmd = cmd.toUpperCase();
        if (cmd.equals(QUIT)) {
          isQuit = true;
        }
        outToServer.writeBytes(cmd + "\n");
        String result = inFromServer.readLine();
        System.out.println("Dari Server " + result);
      }
      outToServer.close();
      inFromServer.close();
      clientSocket.close();
    } catch (IOException e) {
      System.out.println("Error:" + e);
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new InfoClient();
  }
}
