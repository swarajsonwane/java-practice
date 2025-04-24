package LD.hashmap;

public class MyHashMap<K, V>{

    private static final int INITIAL_SIZE = 16;
    private static final int MaXIMUM_SIZE = 1 << 30;

    public Entry[] hashTable;

    //First constructor with default size

    public MyHashMap() {
        hashTable = new Entry[INITIAL_SIZE];
    }

    //Second constructor with custom size

    public MyHashMap(int size) {
        hashTable = new Entry[tableSize(size)];
    }

    class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    final int tableSize(int cap){
        cap = cap - 1;
        cap |= cap >>> 1;
        cap |= cap >>> 2;
        cap |= cap >>> 4;
        cap |= cap >>> 8;
        cap |= cap >>> 16;
        return cap < 0 ? 1 : (cap >= MaXIMUM_SIZE) ? MaXIMUM_SIZE : cap + 1;
    }

    public void put(K key, V value) {
        if (key == null) {
            return;
        }
        int hash = key.hashCode();
        int index = hash % hashTable.length;
        Entry<K, V> entry = new Entry<>(key, value);
        if (hashTable[index] == null) {
            hashTable[index] = entry;
        } else {
            Entry<K, V> current = hashTable[index];
            while (current.next != null)  {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            current.next = entry;
        }
    }

    public V key(K key){
        if(key == null) {
            return null;
        }
        int hash = key.hashCode();
        int index = hash % hashTable.length;
        Entry<K, V> current = hashTable[index];
        while (current != null) {
            if (current.key.equals(key)) {

                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public static void main(String[] args) {

        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put("1", "Done");
        myHashMap.put("2", "2");
        myHashMap.put("3", "3");
        myHashMap.put("4", "4");
        myHashMap.put("5", "5");
        myHashMap.put("6", "6");
        String value = myHashMap.key("1");
        System.out.println(value);
    }
}
