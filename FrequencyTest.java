import java.util.*;

class FrequencyTest{
  static int[] asciiValues;
  static double estimatedFrequencies[] = {0.171662, 0.000072, 0.002442, 0.000179, 0.000561, 0.00016, 0.000226, 0.002447, 0.002178, 0.002233, 0.000628, 0.000215, 0.007384, 0.013734, 0.015124, 0.001549, 0.005516, 0.004594, 0.003322, 0.001847, 0.001348, 0.001663, 0.001153, 0.00103, 0.001054, 0.001024, 0.004354, 0.001214, 0.001225, 0.000227, 0.001242, 0.001474, 0, 0.003132, 0.002163, 0.003906, 0.003151, 0.002673, 0.001416, 0.001876, 0.002321, 0.003211, 0.001726, 0.000687, 0.001884, 0.003529, 0.002085, 0.001842, 0.002614, 0.000316, 0.002519, 0.004, 0.003322, 0.000814, 0.000892, 0.002527, 0.000343, 0.000304, 0.000076, 0.000086, 0.000016, 0.000088, 0.000003, 0.00116, 0.000009, 0.05188, 0.010195, 0.02113, 0.02507, 0.08577, 0.013725, 0.015597, 0.027444, 0.049019, 0.000867, 0.006753, 0.03175, 0.016437, 0.049701, 0.0577, 0.01548, 0.000747, 0.042586, 0.043686, 0.0637, 0.021, 0.008462, 0.013034, 0.00195, 0.01133, 0.000596, 0.000026, 0.000007, 0.000026, 0.000003, 0};
  public static void main(String[] args){
    Scanner reader = new Scanner(System.in);
    String str = reader.nextLine();
    char[] letters = str.toCharArray();
    asciiValues = new int[letters.length];
    double[] frequencies = new double[96];
    for (int i = 0; i < letters.length; i ++) {//Converts to ASCII
      asciiValues[i] = (byte) letters[i];
    }
    int bestShiftAmount = 0;
    double closestNumber = 100;
    for(int a = 0; a < frequencies.length; a ++){
      for(int i = 0; i < frequencies.length; i ++){
        frequencies[i] = 0;
      }
      shiftLetters(-a);
      for(int i = 0; i < asciiValues.length; i ++){//Fills frequncies
        frequencies[asciiValues[i] - 32] += (double) 1/asciiValues.length;
      }
      double discrepency = 0;
      for(int i = 0; i < frequencies.length; i ++){
        discrepency += Math.abs(frequencies[i] - estimatedFrequencies[i]);
      }
      if(discrepency < closestNumber){
        closestNumber = discrepency;
        bestShiftAmount = a;
      }
      shiftLetters(a);
    }
    System.out.println(bestShiftAmount);
    shiftLetters(-bestShiftAmount);
    for(int i = 0; i < asciiValues.length; i ++){//Converts to letters
      letters[i] = (char) asciiValues[i];
    }
    System.out.println("");
    for(int i = 0; i < letters.length; i ++){
      System.out.print(letters[i]);
    }
  }
  static void shiftLetters(int num){
    for(int i = 0; i < asciiValues.length; i ++){
      asciiValues[i] += num;
      if(asciiValues[i] < 32){
        asciiValues[i] = 128 - (32 - asciiValues[i]);
      }
      if(asciiValues[i] > 127){
        asciiValues[i] = 31 + (asciiValues[i] - 127);
      }
    }
  }
}
