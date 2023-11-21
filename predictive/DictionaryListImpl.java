package predictive;

import java.io.*;
import java.util.*;

public class DictionaryListImpl {

  public ArrayList<WordSig> dictionaryList;

  public DictionaryListImpl() {
    this.dictionaryList = new ArrayList<>();
    readDictionaryFromFile();
    Collections.sort(dictionaryList, (ws1, ws2) -> ws1.getSignature().compareTo(ws2.getSignature()));
  }

  private void readDictionaryFromFile() {
    Set<String> dictionarySet = new HashSet<>();
    try (Scanner scanner = new Scanner(new File("words"))) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine().trim();
        if (PredictivePrototype.isValidWord(line)) {
          String signature = PredictivePrototype.wordToSignature(line);
          if (!dictionarySet.contains(line.toLowerCase())) {
            dictionarySet.add(line.toLowerCase());
            dictionaryList.add(new WordSig(line.toLowerCase(), signature));
          }
        }
      }
    } catch (FileNotFoundException e) {
      System.err.println("Error: File 'words' not found. Make sure the file exists and try again.");
      e.printStackTrace();
    }
  }

  // SignatureToWords method using binary search
  public static Set<String> signatureToWords(String signature, ArrayList<WordSig> words) {

    // create a new set
    Set<String> result = new HashSet<String>();

    // search the signature in the dictionary
    int index = Collections.binarySearch(words, new WordSig("", signature));

    // if the signature is not found
    if (index < 0) {
      return result;
    }

    // if the signature is found
    int start = index;
    int end = index;
    while (start < words.size() && words.get(start).getSignature().equals(signature)) {
      result.add(words.get(start).getWords());
      start++;
    }
    while (end >= 0 && words.get(end).getSignature().equals(signature)) {
      result.add(words.get(end).getWords());
      end--;
    }

    return result;
  }

  public static void main(String[] args) {
    DictionaryListImpl dictionary = new DictionaryListImpl();

    // print the words of each signature in the command line
    for (String s : args) {
      System.out.println("signatureToWords(\"" + s + "\") ->" + " : " + DictionaryListImpl.signatureToWords(s, dictionary.dictionaryList));
    }
  }
}
