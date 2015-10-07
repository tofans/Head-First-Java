package HeadFirstJava.Networking_Threads;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class DisplayNet {

  public static void main(String[] args) {
    try {
      //panggil method getNetworkInterfaces()
      //untuk mendapatkan semua antarmuka jaringan
      //yang digunakan di komputer lokal
      Enumeration e = NetworkInterface.getNetworkInterfaces();
      while (e.hasMoreElements()) {
        NetworkInterface netFace = (NetworkInterface) e.nextElement();
        System.out.println("Network Interface " + netFace.getName());

        //ambil semua informasi alamat IP dari
        //tiap antarmuka jaringan
        Enumeration e2 = netFace.getInetAddresses();

        //perulangan untuk tiap alamat IP
        //yang didapat pada tiap antarmuka jaringannya
        while (e2.hasMoreElements()) {
          InetAddress ip = (InetAddress) e2.nextElement();
          System.out.println();
          System.out.println("IP Adress " + ip.toString());
        }
      }
    } catch (SocketException e1) {
      e1.printStackTrace();
    }
  }
}
