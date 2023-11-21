package predictivegui;

import java.util.*;

public class Controller {
  public static Controller instance;
  private static int index = 0; // index iterator for the words array
  private static String[] wordsArray;

  private Model model;
  private View view;

  public Controller(View view, Model model) {
    this.view = view;
    this.model = model;
  }

  private boolean isNumber(String s) {
    try {
      Integer.parseInt(s);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public void keyPressed(int key) {
    if (key == 12) {
      // delete last char
      String text = this.view.textArea.getText();
      if (text.length() > 0) {
        this.view.textArea.setText(text.substring(0, text.length() - 1));
      }
    } else if (key == 10) {
      // predict
      String text = this.view.textArea.getText();
      if (text.length() > 0) {
        String[] words = text.split(" ");
        String lastWord = words[words.length - 1];
        if(!isNumber(lastWord)) {
          this.view.textArea.setText(text.substring(0, text.length() - lastWord.length()) + wordsArray[index%wordsArray.length]);
          index++;
        }
        Set<String> wordsSet = this.model.signatureToWords(lastWord);
        if (wordsSet.size() > 0) {
          wordsArray = wordsSet.toArray(new String[wordsSet.size()]);
          this.view.textArea.setText(text.substring(0, text.length() - lastWord.length()) + wordsArray[0]);
          index++;
        }
      }
    } else if (key == 11) {
      this.view.textArea.append(" ");
      index = 0;
    }
    else {
      this.view.textArea.append(String.valueOf(key));
    }

  }
}