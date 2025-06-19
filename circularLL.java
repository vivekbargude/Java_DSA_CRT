class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLL {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = head;  // Make it circular initially

        head = insertAtStart(head, 20);
        head = insertAtStart(head, 30);
        printCL(head);
    }

    public static Node insertAtStart(Node head, int data) {
        Node newNode = new Node(data);

        // If only one node (head points to itself)
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node tail = head;
        // Find the last node (tail)
        while (tail.next != head) {
            tail = tail.next;
        }

        // Insert newNode at start
        newNode.next = head;
        tail.next = newNode;  // Make it circular
        return newNode;       // New node becomes the head
    }

    public static void printCL(Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
}
