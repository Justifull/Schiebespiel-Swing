package game;

import javax.swing.*;

public class View extends JFrame {

    private JButton[] buttons = new JButton[17];

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

        for (int i = 0; i < 17; i++) {
            if (i < 15) buttons[i] = new JButton(String.valueOf(i + 1));
            else buttons[i] = new JButton("");
        }

        for (JButton button : buttons) {
            add(button);
        }
        add(winLabel);
    }

    public JButton[] getButtons() {
        return this.buttons;
    }

    public JLabel getLabel() {
        return this.winLabel;
    }

    public void update() {
        for (int i = 0; i < getButtons().length - 1; i++) {
            JButton button = getButtons()[i];
            button.setBounds(model.get(i).x, model.get(i).y, 107, 107);
        }
    }

}
