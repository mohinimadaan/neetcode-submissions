public class Node{
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {

    private int cap;
    private HashMap<Integer,Node> cache;
    private Node left;  //LRU
    private Node right; //MRU

    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new HashMap<>();
        this.left = new Node(-1,-1);
        this.right = new Node(-1,-1);
        this.left.next = this.right;
        this.right.prev = this.left;  
    }

    private void remove(Node node){
        Node prev = node.prev;
        Node nxt = node.next;
        prev.next = nxt;
        nxt.prev = prev;
    }

    private void insert(Node node){ //at right side
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;

    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            insert(node); //to make it MRU
            return node.val;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }

        Node newNode = new Node(key,value);
        cache.put(key, newNode);
        insert(newNode);

        if(cache.size() > cap){
            //remove left node
            Node leftNode = this.left.next;
            remove(leftNode);
            cache.remove(leftNode.key);
        }
        
    }
}
