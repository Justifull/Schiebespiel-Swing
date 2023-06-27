package game;

import javax.swing.*;
import java.awt.*;

public class Controller {
    protected Model model;
    protected View view;

    public Controller(Model m, View v) {
        this.model = m;
        this.view = v;
    }

    public void start() {
        for (int i = 0; i < view.getButtons().length - 1; i++) {
            JButton button = view.getButtons()[i];
            button.setVisible(true);
            button.setBounds(model.get(i).x, model.get(i).y, 107, 107);
            button.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
            button.setOpaque(true);
            if (i < 15) {
                button.setBackground(Color.LIGHT_GRAY);
                button.addActionListener(e -> {
                    pressed(button);
                });
            } else {
                button.setEnabled(false);
                button.setBackground(Color.DARK_GRAY);
            }
        }

        view.getLabel().setBounds(139, 153, 86, 173);
        view.getLabel().setVisible(false);

        colorButton();
    }

    private void pressed(JButton button) {
        int buttonId = model.getButton(button);
        if (model.get(15).close(model.get(buttonId))) {

            model.swap(buttonId);

            colorButton();

            if (model.testwin()) {
                view.getLabel().setVisible(true);
                for (JButton buttonWin : view.getButtons()) {
                    buttonWin.setEnabled(false);
                }
            }

            view.update();
        }
    }

    public void colorButton() {
        for (int i = 0; i < view.getButtons().length - 2; i++) {
            JButton button = view.getButtons()[i];
            if (model.testColor(button)) button.setForeground(Color.GREEN);
            else button.setForeground(Color.BLACK);
        }
    }
}
