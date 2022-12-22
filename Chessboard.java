
/**
 * Class Chessboard represents a 2 dimensional chessboard
 * to traverse and find a path through
 */
public class Chessboard {

    private ChessboardStatus[][] chessboard;

    /**
     * Creates an square Chessboard of given size
     */
    public Chessboard(int size) {
        this(size, size);
    }

    /**
     * Creates a 2 dimensional Chessboard of given height and size, with all
     * positions initially open
     */
    public Chessboard(int width, int height) {
        chessboard = new ChessboardStatus[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                chessboard[row][col] = ChessboardStatus.OPEN;
            }
        }
    }

    /**
     * Initializes a Chessboard from the given textual representation
     */
    public Chessboard(String sChessboard) {
        this.chessboard = stringToChessboard(sChessboard);
    }

    /**
     * Returns the ChessboardStatus value corresponding to the given cell,
     * specified by its row and column
     */
    public ChessboardStatus getPosStatus(int row, int col) {
        return chessboard[row][col];
    }

    /**
     * Returns the ChessboardStatus value corresponding to the given position
     */
    public ChessboardStatus getPosStatus(ChessboardPosition pos) {
        return chessboard[pos.getCoords()[0]][pos.getCoords()[1]];
    }

    /**
     * Sets the cell corresponding to the specified row and column to the given
     * status value
     */
    public void setPosStatus(int row, int col, ChessboardStatus newStatus) {
        chessboard[row][col] = newStatus;
    }

    /**
     * Sets the cell corresponding to the specified position to the given status
     * value
     */
    public void setPosStatus(ChessboardPosition pos, ChessboardStatus newStatus) {
        chessboard[pos.getCoords()[0]][pos.getCoords()[1]] = newStatus;
    }

    /**
     * String representation of the given Chessboard
     */
    public String toString() {
        String s = null;
        if (chessboard != null && chessboard[0] != null) {
            s = "";
            for (int r = 0; r < chessboard.length; r++) {
                for (int c = 0; c < chessboard[0].length; c++) {
                    s = s.concat(String.valueOf(chessboard[r][c].text()));
                }
                s = s.concat(System.lineSeparator());
            }
        }
        return s;
    }

    /**
     * Converts string to array chessboard and assign to each of its cells
     * the corresponding status value based on the given string
     */
    private ChessboardStatus[][] stringToChessboard(String sChessboard) {
        ChessboardStatus[][] chessboard = null;

        if (sChessboard != null) {
            String[] sChessboardRows = sChessboard.split("\n");
            char[] cChessboardCols;

            chessboard = new ChessboardStatus[sChessboardRows.length][];

            for (int row = 0; row < sChessboardRows.length; row++) {
                if (sChessboardRows[row] == null) {
                    chessboard[row] = null;
                } else {
                    chessboard[row] = new ChessboardStatus[sChessboardRows[row].length()];
                    cChessboardCols = sChessboardRows[row].toCharArray();

                    for (int col = 0; col < cChessboardCols.length; col++) {
                        if (cChessboardCols[col] == ChessboardStatus.GOAL.text()) {
                            chessboard[row][col] = ChessboardStatus.GOAL;
                        } else if (cChessboardCols[col] == ChessboardStatus.OPEN.text()) {
                            chessboard[row][col] = ChessboardStatus.OPEN;
                        } else if (cChessboardCols[col] == ChessboardStatus.OBSTACLE.text()) {
                            chessboard[row][col] = ChessboardStatus.OBSTACLE;
                        } else if (cChessboardCols[col] == ChessboardStatus.VISITED.text()) {
                            chessboard[row][col] = ChessboardStatus.VISITED;
                        }
                    }
                }

            }
        }

        return chessboard;
    }

    /**
     * Returns the ChessboardPosition of the next position, if its is a valid position. 
     * Returns null if the destination position is outside the limits of the array.
     */
    public ChessboardPosition getNeighbour(ChessboardPosition pos, Move mov) {
        ChessboardPosition newPos = null;

        int[] newCoords = getNeighbourCoords(pos.getCoords()[0], pos.getCoords()[1], mov);
        if (newCoords != null) {
            // Create new ChessboardPosition object with the new coordinates and the received position pos as previous one (from)
            newPos = new ChessboardPosition(newCoords, pos);
        }
        return newPos;
    }

    /**
     * Returns the coordinates of the next position, if its is a valid position. 
     * Returns null if the destination position is outside the limits of the array.
     */
    public int[] getNeighbourCoords(int row, int col, Move mov) {
        int[] currentCoords = new int[]{row, col};

        int[] newCoords = new int[]{
            currentCoords[0] + mov.vShift(),
            currentCoords[1] + mov.hShift()
        };
        if (newCoords[0] < 0 || newCoords[0] >= chessboard.length
                || newCoords[1] < 0 || newCoords[1] >= chessboard[0].length) {
            // invalid position
            newCoords = null;
        }
        return newCoords;
    }

    /**
     * Updates the state of the chessboard positions following a given DLLPath.
     * If the position to visit is OPEN or VISITED change it to VISITED. 
     * If the position to visit is GOAL, does not change it so that the goal keeps displaying in the chessboard. 
     * If the position to visit is OBSTACLE or the position is outside the limits of the
     * chessboard, it is an invalid move, stop and finish.
     *
     */
    public void followPath(DLLPath path) {

        if (path != null) {

            int[] coords = path.removeFirst();

            while (coords != null) {
                switch (this.getPosStatus(coords[0], coords[1])) {
                    case OPEN:
                    case VISITED:
                        this.setPosStatus(coords[0], coords[1], ChessboardStatus.VISITED);
                        coords = path.removeFirst();
                        break;
                    case OBSTACLE:
                        // invalid move: stop here
                        return;
                    case GOAL:
                        // does not change status to keep showing GOAL
                        coords = path.removeFirst();
                        break;
                }
            }
        }

    }

}
