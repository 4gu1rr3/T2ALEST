/**
 * A classe DoubleLinkedListOfInteger representa uma lista de inteiros duplamente encadeada.
 * Dentro dessa classe nós temos a classe Node que representa um nodo que irá fazer parte da lista duplamente encadeada.
 * A classe Node tem como atributos o valor(int) que será armazenado dentro do nodo e as referências para o nodo anterior e próximo.
 * 
 * @author 4gu1rr3 (Yasmin Aguirre)
 * @version 1.0
*/
public class DoubleLinkedListOfInteger {
    private Node header;
    private Node trailer;
    private Node current;
    private Integer count;

    /**
     * Classe Node representa um nodo que irá fazer parte da lista duplamente encadeada.
     * A classe Node tem como atributos o valor(int) que será armazenado dentro do nodo e as referências para o nodo anterior e próximo.
    */
    public class Node{
        private Integer item;
        private Node next;
        private Node prev;
        /**
         * Construtor da classe Node.
         * @param item item que vai ser guardado no nodo
        */
        public Node(Integer item){
            this.item = item;
            this.next = null;
            this.prev = null;
        }
    }

    /**
     * Construtor da classe DoubleLinkedListOfInteger.
    */
    public DoubleLinkedListOfInteger(){
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /**
     * Adiciona um nodo ao final da lista.
     * @param item item a ser adicionado na lista
    */
    public void add(Integer item){
        Node newNode = new Node(item);
        newNode.prev = trailer.prev;
        newNode.next = trailer;
        trailer.prev.next = newNode;
        trailer.prev = newNode;
        count++;
    }

    /**
     * Remove o último nodo da lista.
     * @return true se o nodo foi removido, false se não.
    */
    public boolean removeLastNode(){
        if(count == 0){
            return false;
        }
        trailer.prev.prev.next = trailer;
        trailer.prev = trailer.prev.prev;
        count--;
        return true;
    }

    /**
     * Remove o primeiro nodo da lista.
     * @return true se o nodo foi removido, false se não.
     */
    public boolean removeFirstNode(){
        if(count == 0){
            return false;
        }
        header.next.next.prev = header;
        header.next = header.next.next;
        count--;
        return true;
    }

    /**
     * Remove um nodo da lista.
     * @param item item a ser removido da lista. 
     * @return true se foi removido, false se não.
     */
    public boolean removeNode(Integer item){
        if(count > 0){
            current = header.next;
            while(current.item!= null){
                if(current.item.equals(item)){
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    count--;
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }
}
