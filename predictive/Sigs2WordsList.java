package predictive;

public class Sigs2WordsList {
  public static void main(String[] args) {
    DictionaryListImpl dictionary = new DictionaryListImpl();

    // print the words of each signature in the command line
    for (String s : args) {
      System.out.println("signatureToWords(\"" + s + "\") ->" + " : " + DictionaryListImpl.signatureToWords(s, dictionary.dictionaryList));
    }
  }
}
