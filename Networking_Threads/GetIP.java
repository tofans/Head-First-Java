package HeadFirstJava.Networking_Threads;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetIP {

  public void getsIP() {
    try {
      InetAddress address = InetAddress.getByName("localhost");
      System.out.println(address.getHostAddress());
      System.out.println(address.getHostName());
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    GetIP ip = new GetIP();
    ip.getsIP();
  }
}
