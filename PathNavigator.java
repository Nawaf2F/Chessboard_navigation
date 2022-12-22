
/**
 * Class PathNavigator implements algorithms for finding a path using
 a Stack or a Queue
 */
public class PathNavigator {

    private static final Move[] DIRS_TO_EXPLORE = new Move[]{
        Move.LEFT,
        Move.UP,
        Move.DOWN,
        Move.RIGHT
    };

    public DLLPath pathNavigatorUsingStack(Chessboard chessboard) {
        /*  Task #2: Stack Path Finder
         * 
         * - Create an empty Stack to store chessboard positions for future visits.
         * You can use the LinkedStack class already implemented on ADT.
         * - Start at position (0, 0)
         * - Navigate the given chessboard using depth-first search and stack till reach the goal
         * - Return DLLPath
         */
        
        //return null;  // TO DO: modify appropriately

        final ChessboardPosition initPos = new ChessboardPosition(0, 0, null);

        LinkedStack<ChessboardPosition> posToExplore = new LinkedStack<ChessboardPosition>();

        ChessboardPosition pos = initPos;
        ChessboardPosition next;

        // check initial pos is valid

        posToExplore.push(pos);

        while (!posToExplore.isEmpty()) {
                pos = posToExplore.pop();

                switch( chessboard.getPosStatus(pos) ) {

                case GOAL:
                        // target found: build path and finish

                        DLLPath path = new DLLPath();
                        ChessboardPosition p = pos;
                        while (p != null) {
                                /* 
                                 * Notice that cells must be reversed when building the path 
                                 * as we are traversing backwards from the goal towards the initial position
                                 */
                                path.addFirst(p.getCoords()[0], p.getCoords()[1]);
                                p = p.getFrom();
                        }
                        return path;

                        //break;

                case OPEN: 

                        chessboard.setPosStatus(pos, ChessboardStatus.VISITED);	// mark position as visited

                        // get adjacent cells to explore
                        /*
                         * ** IMPORTANT: The exploration order determines the path found
                         * even forcing to traverse every cell in the chessboard 
                         */
                        for (Move mov : DIRS_TO_EXPLORE) {
                                next = chessboard.getNeighbour(pos, mov);
                                if (next != null && (chessboard.getPosStatus(next) == ChessboardStatus.OPEN || chessboard.getPosStatus(next) == ChessboardStatus.GOAL)) {
                                        posToExplore.push(next);
                                }
                        }	

                        break;

                case VISITED:
                    // No position is inserted into stack after visited
                    // but a given position can change its status
                    // AFTER being inserted
                    // It should not need to be revisited but is not an error
                    break;
                case OBSTACLE:
                        // error: should not be in the list of positions to explore
                        return null;
                        //break;
                }


        }

        return null;        
    }

    public DLLPath pathNavigatorUsingQueue(Chessboard chessboard) {
         /*  Task #3: Queue Path Finder
         * 
         * - Create an empty Stack to store chessboard positions for future visits.
         * You can use the LinkedStack class already implemented on ADT.
         * - Start at position (0, 0)
         * - Navigate the given chessboard using breadth-first search and stack till reach the goal
         * - Return DLLPath
         */

        //return null;  // TO DO: modify appropriately
        final ChessboardPosition initPos = new ChessboardPosition(0, 0, null);

        LinkedQueue<ChessboardPosition> posToExplore = new LinkedQueue<ChessboardPosition>();

        ChessboardPosition pos = initPos;
        ChessboardPosition next;

        // check initial pos is valid

        posToExplore.enqueue(pos);

        while (!posToExplore.isEmpty()) {
                pos = posToExplore.dequeue();

                switch( chessboard.getPosStatus(pos) ) {

                case GOAL:
                        // target found: build path and finish
                        DLLPath path = new DLLPath();


                        ChessboardPosition p = pos;
                        while (p != null) {
                                /* 
                                 * Notice that cells must be reversed when building the path 
                                 * as we are traversing backwards from the goal towards the initial position
                                 */
                                path.addFirst(p.getCoords()[0], p.getCoords()[1]);
                                p = p.getFrom();
                        }

                        return path;
                        //break;

                case OPEN: 

                        chessboard.setPosStatus(pos, ChessboardStatus.VISITED);	// mark position as visited

                        // get adjacent cells to explore
                        /*
                         * ** IMPORTANT: The exploration order determines the path found
                         * even forcing to traverse every cell in the chessboard 
                         */
                        for (Move mov : DIRS_TO_EXPLORE) {
                                next = chessboard.getNeighbour(pos, mov);
                                if (next != null && (chessboard.getPosStatus(next) == ChessboardStatus.OPEN || chessboard.getPosStatus(next) == ChessboardStatus.GOAL)) {
                                        // optimization: check if neighbour is already included in the list to explore
                                        if (!posToExplore.contains(next)) {
                                                posToExplore.enqueue(next);
                                        }
                                }
                        }	

                        break;

                case VISITED:
                    // No position is inserted into queue after visited
                    // and a given position cannot change its status
                    // AFTER being inserted 
                    // (because of the FIFO policy and prior checking of repetitions)
                    // This case must be an error

                case OBSTACLE:
                        // error: should not be in the list of positions to explore
                        return null;
                        //break;
                }


        }

        return null;
        
    }

}
