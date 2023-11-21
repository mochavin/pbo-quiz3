package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DictionaryMapImpl implements Dictionary {
  
  public static Map<String, Set<String>> dictionaryMap;

  public DictionaryMapImpl() {
    DictionaryMapImpl.dictionaryMap = new HashMap<>();
    readDictionaryFromFile();
  }

  private void readDictionaryFromFile() {
    try (Scanner scanner = new Scanner(new File("words"))) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine().trim();
        if (PredictivePrototype.isValidWord(line)) {
          String signature = PredictivePrototype.wordToSignature(line);
          if (!dictionaryMap.containsKey(signature)) {
            dictionaryMap.put(signature, new HashSet<String>());
          }
          dictionaryMap.get(signature).add(line.toLowerCase());
        }
      }
    } catch (FileNotFoundException e) {
      System.err.println("Error: File 'words' not found. Make sure the file exists and try again.");
      e.printStackTrace();
    }
  }

  public Set<String> signatureToWords(String signature) {
    if (dictionaryMap.containsKey(signature)) {
      return dictionaryMap.get(signature);
    }
    return new HashSet<String>();
  }

  // main class
  public static void main(String[] args) {
    DictionaryMapImpl dictionary = new DictionaryMapImpl();

    // print the words of each signature in the command line
    for (String s : args) {
      System.out.println("signatureToWords(\"" + s + "\") ->" + " : " + dictionary.signatureToWords(s));
    }
  }
}
