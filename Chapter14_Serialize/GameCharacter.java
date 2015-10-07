package HeadFirstJava.Chapter14_Serialize;

import java.io.Serializable;

public class GameCharacter implements Serializable {
  int power;
  String type;
  String[] weapons;

  public GameCharacter(int aPower, String aType, String[] aWepon) {
    power = aPower;
    type = aType;
    weapons = aWepon;
  }

  public int getPower() {
    return power;
  }

  public String getType() {
    return type;
  }

  public String getWeapons() {
    String weponList = "";
    for (int i = 0; i < weapons.length; i++) {
      weponList += weapons[i] + " ";
    }
    return weponList;
  }
}
