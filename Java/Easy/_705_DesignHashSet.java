package Java.Easy;

import java.util.LinkedList;

public class _705_DesignHashSet {
    public static void main(String[] args) {
        System.out.println("#705 - Design HashSet - Easy");

        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(3));
        myHashSet.add(2);
        System.out.println(myHashSet.contains(2));
        myHashSet.remove(2);
        System.out.println(myHashSet.contains(2));

        System.out.println("\n--- Testing Hash Table with Chaining ---");
        MyHashSetChaining hashSetChaining = new MyHashSetChaining();
        hashSetChaining.add(1);
        hashSetChaining.add(2);
        System.out.println(hashSetChaining.contains(1));
        System.out.println(hashSetChaining.contains(3));
        hashSetChaining.add(2);
        System.out.println(hashSetChaining.contains(2));
        hashSetChaining.remove(2);
        System.out.println(hashSetChaining.contains(2));

        return;
    }

    // Simple array-based implementation
    static class MyHashSet {
        private int[] lookupArray;

        public MyHashSet() {
            this.lookupArray = new int[1000001];
        }

        public void add(int key) {
            this.lookupArray[key] = 1;
        }

        public void remove(int key) {
            this.lookupArray[key] = 0;
        }

        public boolean contains(int key) {
            if (this.lookupArray[key] == 1) {
                return true;
            }

            return false;
        }
    }

    // Hash table with chaining implementation
    static class MyHashSetChaining {
        private static final int SIZE = 1000; // Number of buckets
        private LinkedList<Integer>[] buckets;

        public MyHashSetChaining() {
            buckets = new LinkedList[SIZE];
            // Initialize each bucket as an empty LinkedList
            for (int i = 0; i < SIZE; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        // Hash function to map key to bucket index
        private int hash(int key) {
            return key % SIZE;
        }

        public void add(int key) {
            int bucketIndex = hash(key);
            LinkedList<Integer> bucket = buckets[bucketIndex];

            // Only add if the key doesn't already exist
            if (!bucket.contains(key)) {
                bucket.add(key);
            }
        }

        public void remove(int key) {
            int bucketIndex = hash(key);
            LinkedList<Integer> bucket = buckets[bucketIndex];

            // Remove the key if it exists (removes first occurrence)
            bucket.remove(Integer.valueOf(key));
        }

        public boolean contains(int key) {
            int bucketIndex = hash(key);
            LinkedList<Integer> bucket = buckets[bucketIndex];

            return bucket.contains(key);
        }
    }
}
