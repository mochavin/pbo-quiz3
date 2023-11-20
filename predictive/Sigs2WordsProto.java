package predictive;

public class Sigs2WordsProto {
  public static void main(String[] args) {
    // System.out.println(PredictivePrototype.signatureToWords("4663"));

    // print the words of each signature in the command line
    for (String s : args) {
      System.out.println(s + " : " + PredictivePrototype.signatureToWords(s));
    }
  }
}
