package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DictionaryTreeImpl {

  private static final int NUM_BRANCHES = 8; // Since signatures have digits 2-9

  private static class Node {
    Set<String> words;
    Node[] branches;

    Node() {
      this.words = new HashSet<>();
      this.branches = new Node[NUM_BRANCHES];
    }
  }

  private Node root;

  public DictionaryTreeImpl() {
    this.root = new Node();
    readDictionaryFromFile();
  }

  private void readDictionaryFromFile() {
    try (Scanner scanner = new Scanner(new File("words"))) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine().trim().toLowerCase();
        if (PredictivePrototype.isValidWord(line)) {
          insertWord(line);
        }
      }
    } catch (FileNotFoundException e) {
      System.err.println("Error: File not found. Make sure the file exists and try again.");
      e.printStackTrace();
    }
  }

  private void insertWord(String s) {
    Node current = root;
    String signature = PredictivePrototype.wordToSignature(s);
    for (int i = 0; i < s.length(); i++) {
      int index = Character.getNumericValue(signature.charAt(i)) - 2;
      if (current.branches[index] == null) {
        current.branches[index] = new Node();
      }
      current = current.branches[index];
      // add substring of s from 0 to i + 1 to the set of words
      current.words.add(s.substring(0, i + 1));
    }
  }

  public Set<String> signatureToWords(String signature) {
    Node current = root;

    for (int i = 0; i < signature.length(); i++) {
      int index = Character.getNumericValue(signature.charAt(i)) - 2;
      if (current.branches[index] == null) {
        return new HashSet<String>();
      }
      current = current.branches[index];
    }    

    return current.words;
  }

  // main class
  public static void main(String[] args) {
    DictionaryTreeImpl dictionary = new DictionaryTreeImpl();

    // print the words of each signature in the command line
    for (String s : args) {
      System.out.println("signatureToWords(\"" + s + "\") ->" + " : " + dictionary.signatureToWords(s));
    }
  }
}
