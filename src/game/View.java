package game;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    private JButton[] buttons = new JButton[16];

    private final JLabel winLabel = new JLabel("WIN");

    protected Model model;

    public View(Model m) {
        setTitle("Schiebespiel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(460, 490);
        setLayout(null);
        setVisible(true);

        this.model = m;

        winLabel.setBounds(170, 185, 140, 70);
        winLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
        winLabel.setForeground(Color.RED);
        winLabel.setVisible(true);

        for (int i = 0; i < 16; i++) {
            if (i < 15) {
                buttons[i] = new JButton(String.valueOf(i + 1));
                buttons[i].setVisible(true);
            }
            else {
                buttons[i] = new JButton("");
                buttons[i].setVisible(false);
            }
            buttons[i].setBounds(model.getCoordinate(i).x, model.getCoordinate(i).y, 107, 107);
            buttons[i].setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
        }

        add(winLabel);

        for (JButton button : buttons) {
            add(button);
        }

        colorButtons();
    }

    public JButton[] getButtons() {
        return this.buttons;
    }

    public JLabel getLabel() {
        return this.winLabel;
    }

    public void colorButtons() {
        for (int i = 0; i < buttons.length - 2; i++) {
            JButton button = buttons[i];
            if (model.testColor(button)) button.setForeground(Color.GREEN);
            else button.setForeground(Color.BLACK);
        }
    }

    public void update() {
        for (int i = 0; i < buttons.length - 1; i++) {
            buttons[i].setBounds(model.getCoordinate(i).x, model.getCoordinate(i).y, 107, 107);
        }
    }

}
