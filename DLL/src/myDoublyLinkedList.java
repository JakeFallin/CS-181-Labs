import java.util.Scanner;

/**
 * Created by JakeFallin on 10/17/2016.
 */
public class myDoublyLinkedList {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /* Creating object of linkedList */
        linkedList list = new linkedList();
        System.out.println("Doubly Linked List Test\n");
        char ch;
        /*  Perform list operations  */
        do {
            System.out.println("\nDoubly Linked List Operations\n");
            System.out.println("1. insert at begining");
            System.out.println("2. insert at end");
            System.out.println("3. insert at position");
            System.out.println("4. delete at position");
            System.out.println("5. check empty");
            System.out.println("6. get size");

            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter integer element to insert");
                    list.insert(scan.nextInt());
                    break;
                case 2:
                    System.out.println("Enter integer element to insert");
                    list.insertAtEnd(scan.nextInt());
                    break;
                case 3:
                    System.out.println("Enter integer element to insert");
                    int num = scan.nextInt();
                    System.out.println("Enter position");
                    int pos = scan.nextInt();
                    if (pos < 1 || pos > list.getCount())
                        System.out.println("Invalid position\n");
                    else
                        list.insertAt(num, pos);
                    break;
                case 4:
                    System.out.println("Enter position");
                    int p = scan.nextInt();
                    if (p < 1 || p > list.getCount())
                        System.out.println("Invalid position\n");
                    else
                        list.deleteAt(p);
                    break;
                case 5:
                    System.out.println("Empty status = " + list.isEmpty());
                    break;
                case 6:
                    System.out.println("Size = " + list.getCount() + " \n");
                    break;
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            /*  Display List  */
            list.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');
    }
}

class linkedList {
    protected Node head;
    protected Node end;
    public int count;

    public linkedList() {

        head = null;
        end = null;
        count = 0;
    }

    public boolean isEmpty() {

        return (head == null);
    }

    public int getCount() {

        return count;
    }

    public void insert(Object data) {

        Node node = new Node(data, null, null);

        if (head == null) {
            head = node;
            end = head;
        } else {
            head.setPrevious(node);
            node.setNext(head);
            head = node;
        }
        count++;
    }

    public void insertAt(Object data, int pos) {
        Node node = new Node(data, null, null);

        if (pos == 1) {
            insert(data);
        } else {
            Node headTemp = head;
            for (int i = 2; i <= count; i++) {
                if (i == pos) {
                    Node tmp = headTemp.getNext();
                    headTemp.setNext(node);
                    node.setPrevious(headTemp);
                    node.setNext(tmp);
                    tmp.setPrevious(node);
                }
                headTemp = headTemp.getNext();
            }
            count++;
        }
    }

    public void insertAtEnd(int val) {
        Node node = new Node(val, null, null);
        if (head == null) {
            head = node;
            end = head;
        } else {
            node.setPrevious(end);
            end.setNext(node);
            end = node;
        }
        count++;
    }

    public void deleteAt(int pos) {
        if (pos == 1) {
            if (count == 1) {
                head = null;
                end = null;
                count = 0;
                return;
            }
            head = head.getNext();
            head.setPrevious(null);
            count--;
            return;
        }
        if (pos == count) {
            end = end.getPrevious();
            end.setNext(null);
            count--;
        }
        Node ptr = head.getNext();
        for (int i = 2; i <= count; i++) {
            if (i == pos) {
                Node p = ptr.getPrevious();
                Node n = ptr.getNext();

                p.setNext(n);
                n.setPrevious(p);
                count--;
                return;
            }
            ptr = ptr.getNext();
        }
    }

 
    /* Function to display status of list */
    public void display() {
        System.out.print("\nDoubly Linked List = ");
        if (count == 0) {
            System.out.print("empty\n");
            return;
        }
        if (head.getNext() == null) {
            System.out.println(head.getData());
            return;
        }
        Node ptr = head;
        System.out.print(head.getData() + " <-> ");
        ptr = head.getNext();
        while (ptr.getNext() != null) {
            System.out.print(ptr.getData() + " <-> ");
            ptr = ptr.getNext();
        }
        System.out.print(ptr.getData() + "\n");
    }
}

class Node {

    protected Object data;
    protected Node next, previous;

    public Node(Object data, Node next, Node previous) {

        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    public Node() {

        next = null;
        previous = null;
        data = 0;
    }

    public void setNext(Node next) {

        this.next = next;
    }

    public void setPrevious(Node previous) {

        this.previous = previous;
    }

    public void setData(int data) {

        this.data = data;
    }

    public Node getNext() {

        return next;
    }

    public Node getPrevious() {

        return previous;
    }

    public Object getData() {

        return data;
    }
}

