
/**
 * Possible states for each position of a chessboard
 */
public enum ChessboardStatus {

    OPEN(' '), OBSTACLE('#'), GOAL('G'), VISITED('.');

    private char text;

    ChessboardStatus(char s) {
        this.text = s;
    }

    public char text() {
        return this.text;
    }

}
