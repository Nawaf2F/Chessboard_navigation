
public class LinkedQueue<T> {

    private Node<T> front;    // Reference to front queue node
    private Node<T> last;     // Reference to last queue node
    private int size;		            // Number of elements in queue

    /**
     * Constructors
     */
    public LinkedQueue() {
        front = last = null;
        size = 0;
    }

    public LinkedQueue(Node node) {
        front = last = node;
        size = 0;
    }

    /**
     * @return Queue size
     */
    public int length() {
        return size;
    }
    
    /**
     * Clear
     */
    public void clear() {
        front = last = null;
        size = 0;
    }

    /**
     * Put element on last
     */
    public void enqueue(T data) {
        Node<T> temp = new Node<T>(data, null);
        if (size == 0) {
            front = last = temp;
        } else {
            last = last.next = temp;
        }
        size++;
    }


    /**
     * Remove and return element from front
     */
    public T dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return null;
        }
        T data = front.data;  // Store dequeued value
        front = front.next;  // Advance front
        if (front == null) {
            last = front; // Last Object
        }
        size--;
        return data;                      // Return Object
    }

    /**
     * @return Front data
     */
    public T frontValue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return null;
        }
        return front.data;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean contains(T dataNode) {
        if(isEmpty())
            return false;
        
        Node<T> current = front;
        while(current != null){
            if(current.data.equals(dataNode))
                return true;
            current = current.next;
        }
        
        return false;
    }
}
