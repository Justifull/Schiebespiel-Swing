package game;

import javax.swing.*;
import java.util.Arrays;

public class Controller {
    protected Model model;
    protected View view;

    public Controller(Model m, View v) {
        this.model = m;
        this.view = v;
    }

    public void start() {
        JButton[] buttons = view.getButtons();
        for (int i = 0; i < buttons.length; i++) {
            JButton button = buttons[i];
            if (i < 15) {
                button.addActionListener(e -> {
                    pressed(button);
                });
            } else {
                button.setEnabled(false);
            }
        }
    }

    private void pressed(JButton button) {
        Integer buttonId = model.getButtonId(button);
        if (model.getCoordinate(15).close(model.getCoordinate(buttonId))) {

            model.swap(buttonId);

            view.colorButtons();

            if (model.testwin(view.getButtons())) {
                view.getLabel().setVisible(true);
                for (JButton buttonWin : view.getButtons()) {
                    buttonWin.setEnabled(false);
                }
                System.out.println(Arrays.toString(model.coordinates));
            }

            view.update();
        }
    }
}
