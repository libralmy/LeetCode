    /**
     * @param key will represent as a hashkey
     * @param value will be the LRU
     *
     * implement this LRUCache as double linked list with prev, next and intKey,intValue
     *
     * Map<intkey, LRUNode>, head, tail, intcapacity
     * get() get the node, removefromlist() and movetohead(), update map, cuz it is been called recently
     * set() get the node, removefromlist() and movetohead(), update map
     *       not get the node, check the capacity-> over, removefromlist() and update map
     *                                              fit, movetohead() and update map
     *
     **/
/**
* Map<Key, value> as temp storage, doublelinkedlist to store the order of key been input
**/

public class LRUCache {
    class DoubleLinkedList{
        int value;
        int key;
        DoubleLinkedList prev;
        DoubleLinkedList post;
    }
    
    Map<Integer, DoubleLinkedList> map = new HashMap<>();
    DoubleLinkedList head;
    DoubleLinkedList tail;
    int count =0;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DoubleLinkedList();
        head.prev = null;
        
        tail = new DoubleLinkedList();
        tail.post = null;
        head.post = tail;
        tail.prev = head;
    }
    
    public void removeNode(DoubleLinkedList node){
        DoubleLinkedList pre = node.prev;
        DoubleLinkedList pos = node.post;
        pre.post = pos;
        pos.prev = pre;
        
    }
    
    public void addNode(DoubleLinkedList node){
        node.prev = head;
        node.post = head.post;
        
        head.post.prev = node;
        head.post = node;
        
    }
    
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        DoubleLinkedList node = map.get(key);
        removeNode(node);
        addNode(node);
        return node.value;
    }
    
    public void set(int key, int value) {
        
        if(map.containsKey(key)){
            DoubleLinkedList node = map.get(key);
            node.value = value;
            removeNode(node);
            addNode(node);
        }else{
            
            DoubleLinkedList newNode = new DoubleLinkedList();
            newNode.key = key;
            newNode.value = value;
            
            map.put(key, newNode);
            addNode(newNode);
            count++;
            if(count > capacity){
                DoubleLinkedList temp = tail.prev;
                removeNode(temp);
                map.remove(temp.key);
                count--;
            }
        }
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////
public class LRUCache {
    
        public LRUNode head = null, tail= null;
        public Map<Integer, LRUNode> map = new HashMap<>();
        public int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            int value = -1;
            if(map.containsKey(key)){
                LRUNode tempNode = map.get(key);
                value = tempNode.value;
                removefromlist(tempNode);
                movetohead(tempNode);
            }

            return value;
        }

        public void set(int key, int value) {
            if(map.containsKey(key)){
                LRUNode tempNode = map.get(key);
                tempNode.value = value;
                map.put(key, tempNode);
                removefromlist(tempNode);
                movetohead(tempNode);
            }else{
                if(map.size() >= capacity){
                    map.remove(tail.key);
                    removefromlist(tail);
                }

                LRUNode newNode = new LRUNode(key, value);
                map.put(key, newNode);
                movetohead(newNode);
                
            }
        }

        public void removefromlist(LRUNode node){
            if(node.prev == null){
                head = node.next;
            }else{
                node.prev.next = node.next;
            }

            if(node.next == null){
                tail = node.prev;
            }else{
                node.next.prev = node.prev;
            }
        }

        public void movetohead(LRUNode node){
            node.next = head;
            node.prev = null;

            if(head != null){
                head.prev = node;
            }
            head = node;

            if(tail == null){
                tail = head;
            }
        }
}


    class LRUNode{
        int key;
        int value;
        LRUNode prev;
        LRUNode next;
        LRUNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
