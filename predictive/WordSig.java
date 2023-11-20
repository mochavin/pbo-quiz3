package predictive;

public class WordSig implements Comparable<WordSig> {
  private String words;
  private String signature;
  public WordSig(String words, String signature) {
    this.words = words;
    this.signature = signature;
  }
  public int compareTo(WordSig ws) {
    return this.signature.compareTo(ws.signature);
  }
  public String getWords() {
    return this.words;
  }
  public String getSignature() {
    return this.signature;
  }
}
