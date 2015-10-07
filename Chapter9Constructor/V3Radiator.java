package HeadFirstJava.Chapter9Constructor;

import java.util.ArrayList;

public class V3Radiator extends V2Radiator {

  V3Radiator(ArrayList aList) {
    super(aList);
    for (int g=0 ; g<10 ; g++) {
      aList.add(new SimUnit("V3Radiator"));
    }
  }
}
