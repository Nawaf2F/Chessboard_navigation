
/**
 * Class ChessboardPosition encapsulates the coordinates
 * of a given position in a chessboard.
 */
public class ChessboardPosition {

    int[] coords;
    ChessboardPosition from;

    ChessboardPosition(int[] coords) {
        this(coords, null);
    }

    ChessboardPosition(int row, int col) {
        this(row, col, null);
    }

    ChessboardPosition(int[] coords, ChessboardPosition from) {
        setCoords(coords);
        this.from = from;
    }

    ChessboardPosition(int row, int col, ChessboardPosition from) {
        setCoords(new int[]{row, col});
        this.from = from;
    }

    public int[] getCoords() {
        return coords;
    }

    public void setCoords(int[] coords) {
        this.coords = coords;
    }

    public ChessboardPosition getFrom() {
        return from;
    }

    public String toString() {
        return ("(" + coords[0] + ", " + coords[1] + ")");
    }

    public boolean equals(Object o) {

        /* 
    	 * Compares the coordinates, NOT the previous position (from)
         */
        ChessboardPosition opos = (ChessboardPosition) o;
        int[] ocoords = opos.getCoords();

        boolean res = this.coords.length == ocoords.length;
        for (int i = 0; res && i < this.coords.length; i++) {
            if (this.coords[i] != ocoords[i]) {
                res = false;
            }
        }

        return res;

    }

}
