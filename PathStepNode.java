
/**
 * Class PathStep represents each step in a Path through a Chessboard,
 * with links to the previous and following steps.
 */
public class PathStepNode {

    private int row;
    private int col;

    private PathStepNode next, prev;

    public PathStepNode(int row, int col) {
        this(row, col, null, null);
    }

    public PathStepNode(int row, int col, PathStepNode next, PathStepNode prev) {
        this.row = row;
        this.col = col;
        this.next = next;
        this.prev = prev;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public PathStepNode getNext() {
        return next;
    }

    public PathStepNode getPrev() {
        return prev;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setNext(PathStepNode next) {
        this.next = next;
    }

    public void setPrev(PathStepNode prev) {
        this.prev = prev;
    }

    public String toString() {
        return "(" + this.row + ", " + this.col + ")";
    }

}
