public class DoubleLinkedListOfInteger {
    public class Node{
        private int item;
        private Node next;
        private Node prev;
        public Node(int item){
            this.item = item;
        }
    }

    private Node head;
    private Node tail;
    
    public DoubleLinkedListOfInteger(){
        head = null;
        tail = null;
    }

    public void add(int item){
        Node newNode = new Node(item);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    public boolean removeLastNode(){
        if(head == null){
            return false;
        }
        if(head == tail){
            head = null;
            tail = null;
            return true;
        }
        tail = tail.prev;
        tail.next = null;
        return true;
    }
    public boolean removeFirstNode(){
        if(head == null){
            return false;
        }
        if(head == tail){
            head = null;
            tail = null;
            return true;
        }
        head = head.next;
        head.prev = null;
        return true;
    }
    public boolean removeNode(int item){
        if(head == null){
            return false;
        }
        if(head == tail){
            if(head.item == item){
                head = null;
                tail = null;
                return true;
            }else{
                return false;
            }
        }
        if(head.item == item){
            removeFirstNode();
        }
        if(tail.item == item){
            removeLastNode();
        }
        Node current = head.next;
        while(current!= null){
            if(current.item == item){
                current.prev.next = current.next;
                current.next.prev = current.prev;
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
