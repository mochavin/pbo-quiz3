package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PredictivePrototype {
  // wordToSignature method
  public static String wordToSignature(String word) {
    // using string buffer to append the string because it is mutable, unlike string
    // which is immutable, so it is more efficient, especially when dealing with
    // large strings, as it does not create a new string every time a character is
    // appended
    StringBuffer sb = new StringBuffer();

    // lower case the word
    word = word.toLowerCase();

    // for loop to iterate through the word
    for (int i = 0; i < word.length(); i++) {
      // if the character is a, b or c
      if (word.charAt(i) == 'a' || word.charAt(i) == 'b' || word.charAt(i) == 'c') {
        sb.append("2");
      }
      // if the character is d, e or f
      else if (word.charAt(i) == 'd' || word.charAt(i) == 'e' || word.charAt(i) == 'f') {
        sb.append("3");
      }
      // if the character is g, h or i
      else if (word.charAt(i) == 'g' || word.charAt(i) == 'h' || word.charAt(i) == 'i') {
        sb.append("4");
      }
      // if the character is j, k or l
      else if (word.charAt(i) == 'j' || word.charAt(i) == 'k' || word.charAt(i) == 'l') {
        sb.append("5");
      }
      // if the character is m, n or o
      else if (word.charAt(i) == 'm' || word.charAt(i) == 'n' || word.charAt(i) == 'o') {
        sb.append("6");
      }
      // if the character is p, q, r or s
      else if (word.charAt(i) == 'p' || word.charAt(i) == 'q' || word.charAt(i) == 'r' || word.charAt(i) == 's') {
        sb.append("7");
      }
      // if the character is t, u or v
      else if (word.charAt(i) == 't' || word.charAt(i) == 'u' || word.charAt(i) == 'v') {
        sb.append("8");
      }
      // if the character is w, x, y or z
      else if (word.charAt(i) == 'w' || word.charAt(i) == 'x' || word.charAt(i) == 'y' || word.charAt(i) == 'z') {
        sb.append("9");
      }
      // if the character is not a letter
      else {
        sb.append(" ");
      }
    }

    return sb.toString();
  }

  // check if the word is valid
  public static boolean isValidWord(String word) {
    // iterate through the word
    for (int i = 0; i < word.length(); i++) {
      // if the character is not a letter
      if (!Character.isLetter(word.charAt(i))) {
        return false;
      }
    }

    return true;
  }

  // read dictionary method
  public static Set<String> readDictionary(String filename) {
    // read the file
    File file = new File(filename);
    Scanner scanner;
    try {
      scanner = new Scanner(file);
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
      return null;
    }

    // create a new dictionary
    Set<String> words = new HashSet<String>();

    // iterate all the words in the file
    while (scanner.hasNextLine()) {
      String word = scanner.nextLine();
      if(!isValidWord(word)) {
        continue;
      }
      word = word.toLowerCase();
      // add the word and signature to the dictionary
      words.add(word);
    }
    scanner.close();

    return words;
  }

  public static Set<String> signatureToWords(String signature) {
    // read the dictionary
    Set<String> words = readDictionary("words");

    // create a new set
    Set<String> result = new HashSet<String>();

    // iterate through the dictionary
    for (String word : words) {
      // if the signature of the word is equal to the signature
      if (wordToSignature(word).equals(signature)) {

        // add the word to the set
        result.add(word);
      }
    }

    return result;
  }

  // main class
  public static void main(String[] args) {
    System.out.println(wordToSignature("home"));

    // take user input
    String input = System.console().readLine();
    System.out.println(signatureToWords(input));

    for (String s : args) {
      System.out.println(s + " : " + wordToSignature(s));
    }
  }
}
