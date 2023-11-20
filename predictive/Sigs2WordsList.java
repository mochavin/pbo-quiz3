package predictive;

import java.util.ArrayList;

public class Sigs2WordsList {
  public static void main(String[] args) {
    ArrayList<WordSig> words = DictionaryListImpl.readArrayList("words");

    // print the words of each signature in the command line
    for (String s : args) {
      System.out.println("signatureToWords(\"" + s + "\") ->" + " : " + DictionaryListImpl.signatureToWords(s, words));
    }
  }
}
