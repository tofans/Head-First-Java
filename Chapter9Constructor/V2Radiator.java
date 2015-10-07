package HeadFirstJava.Chapter9Constructor;

import java.util.ArrayList;

class V2Radiator {
  V2Radiator(ArrayList aList) {
    for (int x = 0; x < 5 ; x++) {
      aList.add(new SimUnit("V2Radiator"));
    }
  }
}
