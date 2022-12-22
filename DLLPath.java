
/**
 * Class DLLPath represents a path through a chessboard composed of a
 * doubly-linked list of ChessboardSteps (positions)
 */
public class DLLPath {

    private PathStepNode head;
    private PathStepNode tail;
    private int size;

    public DLLPath() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(int row, int col) {
        PathStepNode n = new PathStepNode(row, col);
        if (this.head == null) {  // empty list
            this.head = n;
            this.tail = n;
        } else {  // non-empty list
            n.setNext(head);
            head.setPrev(n);
            head = n;
        }
        size++;
    }

    public void addLast(int row, int col) {
        PathStepNode n = new PathStepNode(row, col);
        if (this.tail == null) {  // empty list
            this.head = n;
            this.tail = n;
        } else {  // non-empty list
            tail.setNext(n);
            n.setPrev(tail);
            tail = n;
        }
        size++;
    }

    public int[] removeFirst() {
        int[] coords = null;
        if (head != null) {
            coords = new int[]{head.getRow(), head.getCol()};
            head = head.getNext();
            if (head != null) {
                head.setPrev(null);
            } else {
                tail = null;
            }
        }
        size--;
        return coords;
    }

    public int[] removeLast() {
        int[] coords = null;
        if (tail != null) {
            coords = new int[]{tail.getRow(), tail.getCol()};
            tail = tail.getPrev();
            if (tail != null) {
                tail.setNext(null);
            } else {
                head = null;
            }
        }
        size--;
        return coords;
    }

    /**
     * Text-based representation of DLLPath.
     * with the format: (row1, col1), (row2, col2), ..., (rowN, colN)
     */
    public String toString() {

        String sPath = "";
        PathStepNode s = null;

        if (head != null) {
            sPath = "(" + head.getRow() + ", " + head.getCol() + ")";
            s = head.getNext();
        }
        while (s != null) {
            sPath = sPath + ", " + "(" + s.getRow() + ", " + s.getCol() + ")";
            s = s.getNext();
        }

        return sPath;
    }


    /* 
	 * Compares two DLLPaths.
	 * Two DLLPaths are equals if they containing the same sequence of steps. 
     */
    public boolean equals(Object o) {

        DLLPath otherPath = (DLLPath) o;

        if (this.size != otherPath.size) {
            return false;
        }

        PathStepNode s = head;
        PathStepNode os = otherPath.head;

        while ((s != null) && (os != null)) {
            if ((s.getRow() != os.getRow()) || (s.getCol() != os.getCol())) {
                return false;
            }
            s = s.getNext();
            os = os.getNext();
        }

        return s == os;

    }

}
