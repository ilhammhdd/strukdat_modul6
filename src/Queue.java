public class Queue {
    public QueueNode head;
    public QueueNode tail;

    public boolean enqueue(Vertex vertex) {
        QueueNode queueNode = new QueueNode(vertex);

        if (head == null && tail == null) {
            head = queueNode;
            tail = queueNode;
            return true;
        } else {
            tail.nextQueueNode = queueNode;
            tail = queueNode;
            return true;
        }
    }

    public Vertex dequeue() {
        QueueNode temp = head;
        head = head.nextQueueNode;
        temp.nextQueueNode = null;
        return temp.vertex;
    }
}
