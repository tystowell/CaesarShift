import java.util.*;

class Encryption{
  static int[] asciiValues;
  public static void main(String[] args){
    Scanner reader = new Scanner(System.in);
    String str = reader.nextLine();
    int shift = reader.nextInt();
    char[] letters = str.toCharArray();
    asciiValues = new int[letters.length];
    double[] frequencies = new double[96];
    for (int i = 0; i < letters.length; i ++) {//Converts to ASCII
      asciiValues[i] = (byte) letters[i];
    }
    shiftLetters(shift);
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
