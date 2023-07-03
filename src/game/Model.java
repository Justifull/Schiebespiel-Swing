package game;

import coord.Coordinate;
import javax.swing.*;
import static coord.Coordinate.cord;


public class Model {
    // Parameter von Model.
    public Coordinate[] coordinates;
    private final Coordinate[] coordinatesWin;

    // Initialisieren des Models mit zufälligem Feld.
    public Model() {
        // Array mit allen Coordinates an richtiger Position für den Abgleich bei "testForWin()".
        Coordinate[] fieldArray = new Coordinate[16];
        // Array, welches die Coordinates der Buttons enthält und in welchem diese
        // auch beim shuffle oder drücken eines Buttons ausgewechselt werden.
        Coordinate[] fieldArrayToShuffle = new Coordinate[16];

        // Erstellen aller möglichen Coordinates.
        int x = 14;
        int y = 14;
        for (int i = 0; i < fieldArray.length; i++) {
            if (x != 335) {
                fieldArray[i] = cord(x, y);
                fieldArrayToShuffle[i] = cord(x, y);
                x = x + 107;
            } else {
                fieldArray[i] = cord(x, y);
                fieldArrayToShuffle[i] = cord(x, y);
                x = 14;
                y = y + 107;
            }
        }

        this.coordinatesWin = fieldArray;
        this.coordinates = fieldArrayToShuffle;
    }

    // Shuffelt das Array, welches die Coordinates für die Buttons beinhaltet, indem
    // es von 1000 zufälligen Zügen alle legitimen ausführt.
    public void shuffleCoordinates() {
        for (int i = 0; i < 1000; i++) {
            int randomNum = (int) (Math.random() * coordinates.length - 1);
            if (coordinates[15].isCloseTo(coordinates[randomNum])) {
                swapButtonCoordinates(randomNum);
            }
        }
    }

    // Ausgabe der Coordinates eines Buttons, mithilfe seiner ID, aus dem Coordinate-Array nach Index.
    public Coordinate getCoordinate(int i) {
        return coordinates[i];
    }

    // Ausgabe des Indexes eines Buttons im Coordinate-Array mithilfe seiner X-Y-Koordinaten.
    public Integer getButtonId(JButton button) {
        Coordinate cord = cord(button.getX(), button.getY());
        for (int i = 0; i < coordinates.length; i++) {
            if (coordinates[i].equals(cord)) return i;
        }
        return null;
    }

    // Austausch der Coordinates des Blank-Feldes mit den Coordinates des Index i.
    public void swapButtonCoordinates(int i) {
        Coordinate save = coordinates[i];
        coordinates[i] = coordinates[15];
        coordinates[15] = save;
    }

    // Test, ob jeder Button im Array die seinem Wert entsprechenden Coordinate hat.
    public boolean testForWin(JButton[] buttonArray) {
        for (int i = 0; i < buttonArray.length - 1; i++) {
            if (!coordinatesWin[i].equals(buttonArray[i])) return false;
        }
        return true;
    }

    // Test, ob ein Button auf seinem richtigen Feld ist.
    public boolean testButtonForCorrectCoordinates(JButton button) {
        int buttonId = getButtonId(button);
        return coordinates[buttonId].equals(coordinatesWin[buttonId]);
    }
}
