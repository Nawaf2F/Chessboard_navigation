
/**
 * Possible movements (in 2 dimensional space)
 */
public enum Move {

    /**
     * Each possible movement has as associated data its: text representation,
     * vertical shift, horizontal shift
     */
    LEFT('<', 0, -1), UP('^', -1, 0), RIGHT('>', 0, 1), DOWN('v', 1, 0);

    private char text;
    private int vShift;
    private int hShift;

    Move(char s, int vShift, int hShift) {
        this.text = s;
        this.vShift = vShift;
        this.hShift = hShift;
    }

    public char text() {
        return this.text;
    }

    public int vShift() {
        return this.vShift;
    }

    public int hShift() {
        return this.hShift;
    }

    public Move opposite(Move mov) {
        Move undo = null;
        switch (mov) {
            case UP:
                undo = DOWN;
                break;
            case DOWN:
                undo = UP;
                break;
            case LEFT:
                undo = RIGHT;
                break;
            case RIGHT:
                undo = LEFT;
                break;
        }
        return undo;
    }
}
