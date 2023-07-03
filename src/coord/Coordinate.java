package coord;

import javax.swing.*;

public record Coordinate(int x, int y) {
    // Initialisieren von einer Coordinate über "cord".
    // (Nicht Konstruktor, da "record" und nicht "class")
    public static Coordinate cord(int x, int y) {
        return new Coordinate(x, y);
    }

    // Test, ob zwei Coordinates neben-, über-, oder untereinander sind.
    public boolean isCloseTo(Coordinate c) {
        return (this.x == (c.x - 107) && this.y == c.y)
                || (this.x == (c.x + 107) && this.y == c.y)
                || (this.y == (c.y - 107) && this.x == c.x)
                || (this.y == (c.y + 107) && this.x == c.x);
    }

    // Vergleich von zwei Coordinates.
    public boolean equals(Coordinate coordinate) {
        return this.x == coordinate.x && this.y == coordinate.y;
    }

    // Vergleich von Coordinate mit JButton.
    public boolean equals(JButton button) {
        return this.x == button.getX() && this.y == button.getY();
    }

    // toString() Ausgabe für Coordinates.
    public String toString() {
        return String.format("%s : %s", this.x, this.y);
    }
}
