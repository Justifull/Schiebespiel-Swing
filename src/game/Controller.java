package game;

import javax.swing.*;

public class Controller {
    // Parameter von Controller.
    protected Model model;
    protected View view;

    // Initialisieren des Controllers.
    public Controller(Model m, View v) {
        this.model = m;
        this.view = v;
    }

    // Start Methode
    public void start() {
        // Shuffelt die Coordinates der Buttons.
        model.shuffleCoordinates();

        // Button Coordinates updaten.
        view.update();

        // Buttons einfärben, welche auf den richtigen Feldern sind.
        view.colorButtons();

        // ActionListener den Buttons hinzufügen.
        JButton[] buttons = view.getButtons();
        for (int i = 0; i < buttons.length; i++) {
            JButton button = buttons[i];
            if (i < 15) {
                button.addActionListener(e -> {
                    buttonPressed(button);
                });
            } else {
                button.setEnabled(false);
            }
        }
    }

    // ActionListener Methode für das Drücken der Buttons.
    private void buttonPressed(JButton button) {
        Integer buttonId = model.getButtonId(button);

        // Körper nur ausführen, wenn das Blank-Feld neben-, über-, oder unter dem Button ist.
        if (model.getCoordinate(15).isCloseTo(model.getCoordinate(buttonId))) {

            // Austauschen des Blank-Buttons mit dem gedrückten.
            model.swapButtonCoordinates(buttonId);

            // Button Coordinates updaten.
            view.update();

            // Buttons einfärben, welche auf den richtigen Feldern sind.
            view.colorButtons();

            // Testen, ob alle Felder auf der richtigen Postion sind, wenn ja Spiel beenden.
            if (model.testForWin(view.getButtons())) {
                // winLabel sichtbar machen und alle Buttons deaktivieren.
                view.getLabel().setVisible(true);
                for (JButton buttonWin : view.getButtons()) {
                    buttonWin.setEnabled(false);
                }
            }
        }
    }
}
