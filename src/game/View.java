package game;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    // Parameter von View.
    // (JButton-Array & winLabel, welches beim Gewinn angezeigt werden soll)
    private final JButton[] buttons = new JButton[16];
    private final JLabel winLabel = new JLabel("WIN");
    protected Model model;

    // Initialisieren des View.
    public View(Model m) {
        setTitle("Schiebespiel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(460, 490);
        setLayout(null);
        setVisible(true);

        this.model = m;

        // Einstellen des Win-Labels.
        winLabel.setBounds(170, 185, 140, 70);
        winLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
        winLabel.setForeground(Color.RED);
        winLabel.setVisible(false);

        // Erstellen der Button-Felder.
        for (int i = 0; i < 16; i++) {
            if (i < 15) {
                buttons[i] = new JButton(String.valueOf(i + 1));
                buttons[i].setVisible(true);
            }
            else {
                buttons[i] = new JButton("");
                buttons[i].setVisible(false);
            }
            buttons[i].setBounds(model.getCoordinate(i).x(), model.getCoordinate(i).y(), 107, 107);
            buttons[i].setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
        }

        // Hinzufügen der Elemente zum View.
        add(winLabel);
        for (JButton button : buttons) {
            add(button);
        }

        // Buttons einfärben, welche auf den richtigen Feldern sind.
        colorButtons();
    }

    // Get-Methode für die Buttons.
    public JButton[] getButtons() {
        return this.buttons;
    }

    // Get-Methode für das Win-Label.
    public JLabel getLabel() {
        return this.winLabel;
    }

    // Prüfen, ob Button auf richtiger Position ist, wenn ja, dann Text grün einfärben.
    public void colorButtons() {
        for (int i = 0; i < buttons.length - 1; i++) {
            JButton button = buttons[i];
            if (model.testButtonForCorrectCoordinates(button)) button.setForeground(Color.GREEN);
            else button.setForeground(Color.BLACK);
        }
    }

    // Updaten der Buttons mit neuen / alten Coordinates.
    public void update() {
        for (int i = 0; i < buttons.length - 1; i++) {
            buttons[i].setBounds(model.getCoordinate(i).x(), model.getCoordinate(i).y(), 107, 107);
        }
    }

}
