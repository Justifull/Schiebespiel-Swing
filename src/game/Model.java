package game;

import coord.Coordinate;

import javax.swing.*;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static coord.Coordinate.cord;


public class Model {
    public Coordinate[] coordinates = {cord(14, 14), cord(121, 14), cord(228, 14), cord(335, 14),
                                        cord(14, 121), cord(121, 121), cord(228, 121), cord(335, 121),
                                        cord(14, 228), cord(121, 228), cord(228, 228), cord(335, 228),
                                        cord(14, 335), cord(121, 335), cord(228, 335), cord(335, 335)};

    public Coordinate[] coordinatesWin = {cord(14, 14), cord(121, 14), cord(228, 14), cord(335, 14),
                                            cord(14, 121), cord(121, 121), cord(228, 121), cord(335, 121),
                                            cord(14, 228), cord(121, 228), cord(228, 228), cord(335, 228),
                                            cord(14, 336), cord(121, 336), cord(228, 336), cord(335, 336)};

    static void shuffleArray(Coordinate[] ar)
    {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            Coordinate a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    public Model() {
        shuffleArray(coordinates);
    }

    public Coordinate get(int i) {
        return coordinates[i];
    }

    public Integer getButton(JButton button) {
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

    public boolean testwin() {
        return Arrays.equals(coordinates, coordinatesWin);
    }

    public boolean testColor(JButton button) {
        int buttonId = Integer.parseInt(button.getText()) - 1;
        return coordinates[buttonId].equals(coordinatesWin[buttonId]);
    }
}
