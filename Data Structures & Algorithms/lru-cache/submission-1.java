class LRUCache {

    // Doubly linked list node
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;

    // Dummy nodes
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    // Insert a node immediately after head (MRU position)
    private void addToFront(Node node) {
        Node first = head.next;

        node.prev = head;
        node.next = first;

        head.next = node;
        first.prev = node;
    }

    // Remove a node from its current position
    private void removeNode(Node node) {
        Node before = node.prev;
        Node after = node.next;

        before.next = after;
        after.prev = before;
    }

    // Mark an existing node as most recently used
    private void moveToFront(Node node) {
        removeNode(node);
        addToFront(node);
    }

    // Return and remove the least recently used node
    private Node removeLRU() {
        Node lru = tail.prev;
        removeNode(lru);
        return lru;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // Access makes this key recently used
        moveToFront(node);

        return node.value;
    }

    public void put(int key, int value) {

        // Key already exists: update and mark as recently used
        if (map.containsKey(key)) {
            Node node = map.get(key);

            node.value = value;
            moveToFront(node);

            return;
        }

        // New key: create node and add it to the cache
        Node node = new Node(key, value);

        map.put(key, node);
        addToFront(node);

        // Evict the LRU item if capacity is exceeded
        if (map.size() > capacity) {
            Node lru = removeLRU();
            map.remove(lru.key);
        }
    }
}
