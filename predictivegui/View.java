package predictivegui;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

  public JTextArea textArea;

  public View() {
    setTitle("Predictive Text");
    setLocationRelativeTo(null);
    setResizable(false);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    JPanel mainPanel = new JPanel(new GridLayout(2, 1));
    JPanel keypadPanel = new JPanel(new GridLayout(4, 3));

    textArea = new JTextArea(5, 20);
    textArea.setWrapStyleWord(true);
    textArea.setLineWrap(true);

    String[] buttonLabels = { "1", "2 (ABC)", "3 (DEF)", "4 (GHI)", "5 (JKL)", "6 (MNO)", "7 (PQRS)", "8 (TUV)",
        "9 (WXYZ)", "*", "0", "#" };
    // Create and add buttons to the keypad panel
    for (int i = 0; i < buttonLabels.length; i++) {

      JButton button = new JButton(buttonLabels[i]);

      final int j = i;
      button.addActionListener(e -> Controller.instance.keyPressed(j+1));
      keypadPanel.add(button);
    }

    mainPanel.add(textArea);
    mainPanel.add(keypadPanel);

    add(mainPanel);
    pack();
  }
}