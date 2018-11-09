public class Queue {
    public QueueNode head;
    public QueueNode tail;
    public int size;

    public void enqueue(Vertex vertex) {
        QueueNode queueNode = new QueueNode(vertex);

        if (head == null && tail == null) {
            head = queueNode;
            tail = queueNode;
        } else {
            tail.nextQueueNode = queueNode;
            tail = queueNode;
        }
        ++size;
    }

    public Vertex dequeue() {
        QueueNode temp = head;
        head = head.nextQueueNode;
        temp.nextQueueNode = null;
        --size;

        System.out.print(temp.vertex.key + ", ");

        return temp.vertex;
    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }
}
