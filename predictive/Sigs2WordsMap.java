package predictive;

public class Sigs2WordsMap {
  public static void main(String[] args) {
    DictionaryMapImpl dictionary = new DictionaryMapImpl();

    // print the words of each signature in the command line
    for (String s : args) {
      System.out.println("signatureToWords(\"" + s + "\") ->" + " : " + dictionary.signatureToWords(s));
    }
  }
}
