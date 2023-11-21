package predictive;

public class Sigs2WordsTree {
  public static void main(String[] args) {
    DictionaryTreeImpl dictionary = new DictionaryTreeImpl();

    // print the words of each signature in the command line
    for (String s : args) {
      System.out.println("signatureToWords(\"" + s + "\") ->" + " : " + dictionary.signatureToWords(s));
    }
  }
}
