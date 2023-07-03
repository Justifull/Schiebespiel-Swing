package game;

import coord.Coordinate;

import javax.swing.*;

import static coord.Coordinate.cord;


public class Model {
    public Coordinate[] coordinates;
    public Coordinate[] coordinatesWin;


    public void shuffleArray() {
        for (int i = 0; i < 1000; i++) {
            int randomNum = (int) (Math.random() * coordinates.length - 1);
            if (coordinates[15].close(coordinates[randomNum])) {
                swap(randomNum);
            }
        }
    }

    public Model() {
        Coordinate[] createArray = new Coordinate[16];
        Coordinate[] shuffledArray = new Coordinate[16];

        int x = 14;
        int y = 14;
        for (int i = 0; i < createArray.length; i++) {
            if (x != 335) {
                createArray[i] = cord(x, y);
                shuffledArray[i] = cord(x, y);
                x = x + 107;
            } else {
                createArray[i] = cord(x, y);
                shuffledArray[i] = cord(x, y);
                x = 14;
                y = y + 107;
            }
        }

        this.coordinatesWin = createArray;
        this.coordinates = shuffledArray;
        shuffleArray();
    }

    public Coordinate getCoordinate(int i) {
        return coordinates[i];
    }

    public Integer getButtonId(JButton button) {
        Coordinate cord = cord(button.getX(), button.getY());
        for (int i = 0; i < coordinates.length - 1; i++) {
            if (coordinates[i].equals(cord)) return i;
        }
        return null;
    }

    public void swap(int i) {
        Coordinate save = coordinates[i];
        coordinates[i] = coordinates[15];
        coordinates[15] = save;
    }

    public boolean testwin(JButton[] buttonArray) {
        for (int i = 0; i < buttonArray.length; i++) {
            if (buttonArray[i].getX() != coordinatesWin[i].x || buttonArray[i].getY() != coordinatesWin[i].y) return false;
        }
        return true;
    }

    public boolean testColor(JButton button) {
        int buttonId = Integer.parseInt(button.getText()) - 1;
        return coordinates[buttonId].equals(coordinatesWin[buttonId]);
    }
}
