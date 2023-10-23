/**
 * A classe DoubleLinkedListOfInteger representa uma lista de inteiros duplamente encadeada.
 * Dentro dessa classe nós temos a classe Node que representa um nodo que irá fazer parte da lista duplamente encadeada.
 * A classe Node tem como atributos o valor(int) que será armazenado dentro do nodo e as referências para o nodo anterior e próximo.
 * 
 * @author 4gu1rr3 (Yasmin Aguirre)
 * @version 1.0
*/
public class DoubleLinkedListOfInteger {
    public class Node{
        private int item;
        private Node next;
        private Node prev;
        /**
         * Construtor da classe Node.
         * @param item
        */
        public Node(int item){
            this.item = item;
        }
    }

    private Node head;
    private Node tail;
    /**
     * Construtor da classe DoubleLinkedListOfInteger.
    */
    public DoubleLinkedListOfInteger(){
        head = null;
        tail = null;
    }
    /**
     * Adiciona um nodo a lista.
     * @param item a ser adicionado na lista
    */
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
    /**
     * Remove o último nodo da lista.
     * @return true se o nodo foi removido, false se não.
    */
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
    /**
     * Remove o primeiro nodo da lista.
     * @return true se o nodo foi removido, false se não.
     */
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
    /**
     * Remove um nodo da lista.
     * @param item a ser removido da lista. 
     * @return true se foi removido, false se não.
     */
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
