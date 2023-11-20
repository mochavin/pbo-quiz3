package predictive;

import java.util.Arrays;

public class Words2SigProto {
  public static void main(String[] args) {
    // if the number of arguments is 0
    if(args.length == 0) {
      System.out.println("Please enter some words");
      return;
    }

    String signatures[] = new String[args.length];

    for(int i = 0; i < args.length; i++) {
      signatures[i] = PredictivePrototype.wordToSignature(args[i]);
    }

    System.out.println("input: " + Arrays.toString(args));
    System.out.println("output: " + String.join(" ", signatures));
  }
}
