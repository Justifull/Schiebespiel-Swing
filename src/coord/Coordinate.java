package coord;

public class Coordinate {
    public int x;
    public int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinate cord(int x, int y) {
        return new Coordinate(x, y);
    }

    public boolean close(Coordinate c) {
        return (this.x == (c.x - 107) && this.y == c.y)
                || (this.x == (c.x + 107) && this.y == c.y)
                || (this.y == (c.y - 107) && this.x == c.x)
                || (this.y == (c.y + 107) && this.x == c.x);
    }

    public boolean close(Coordinate... cs) {
        for (Coordinate c : cs) {
            if (this.x != c.x && this.y != c.y) return false;
        }
        return true;
    }

    public boolean equals(Coordinate c) {
        return this.x == c.x && this.y == c.y;
    }

    public String toString() {
        return String.format("%s : %s", this.x, this.y);
    }
}
