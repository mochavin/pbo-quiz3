package predictivegui;

import java.util.Set;

import predictive.DictionaryMapImpl;

public class Model {
  private DictionaryMapImpl dictionary;

  // constructor
  public Model() {
    this.dictionary = new DictionaryMapImpl();
  }

  // query signatureToWords method
  public Set<String> signatureToWords(String signature) {
    return dictionary.signatureToWords(signature);
  }

  public String changePredict() {
    return "ok";
  }

  public void done() {

  }
}