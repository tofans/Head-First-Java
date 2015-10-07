package HeadFirstJava.Networking_Threads;

import java.io.*;
import java.net.*;

public class DailyAdviceServer {

  String[] adviceList = {"AB", "BC", "CD", "EF", "GH", "IJ"};

  public void go() {
    try {
      ServerSocket socket = new ServerSocket(80);
      while (true) {
        Socket sock = socket.accept();
        PrintWriter writer = new PrintWriter(sock.getOutputStream());
        String advice = getAdvice();
        writer.println(advice);
        writer.close();
        System.out.println(advice);
        System.out.println(sock.getOutputStream());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private String getAdvice() {
    int random = (int) (Math.random() * adviceList.length);
    return adviceList[random];
  }

  public static void main(String[] args) {
    DailyAdviceServer server = new DailyAdviceServer();
    server.go();
  }
}
