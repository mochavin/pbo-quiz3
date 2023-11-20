package predictive;

import java.io.*;
import java.util.*;

public class DictionaryListImpl {

  // read the dictionary from a file and store it in a list
  public static ArrayList<WordSig> readArrayList(String File) {
    // read the file
    File file = new File(File);
    Scanner scanner;
    try {
      scanner = new Scanner(file);
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
      return null;
    }

    // create a new dictionary
    ArrayList<WordSig> words = new ArrayList<WordSig>();

    // iterate all the words in the file
    while (scanner.hasNextLine()) {
      String word = scanner.nextLine();
      if (!PredictivePrototype.isValidWord(word)) {
        continue;
      }
      word = word.toLowerCase();
      // add the word and signature to the dictionary
      words.add(new WordSig(word, PredictivePrototype.wordToSignature(word)));
    }
    scanner.close();

    // sort the list
    Collections.sort(words);

    return words;
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
    // read the dictionary
    ArrayList<WordSig> words = readArrayList("words");

    // print the words of each signature in the command line
    for (String s : args) {
      System.out.println("signatureToWords(" + s + ") ->" + " : " + signatureToWords(s, words));
    }
  }
}
