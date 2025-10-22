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
        HashTableSet hashSetChaining = new HashTableSet();
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
            return this.lookupArray[key] == 1;
        }
    }

    // Hash Table with Linked List (Chaining) Implementation
    static class HashTableSet {
        private static final int SIZE = 1000;
        private LinkedList<Integer>[] buckets;

        public HashTableSet() {
            this.buckets = new LinkedList[SIZE];
            for (int i = 0; i < SIZE; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hash(int key) {
            return key % SIZE;
        }

        public void add(int key) {
            int bucketIndex = hash(key);
            LinkedList<Integer> bucket = this.buckets[bucketIndex];

            if (!bucket.contains(key)) {
                bucket.add(key);
            }
        }

        public void remove(int key) {
            int bucketIndex = hash(key);
            LinkedList<Integer> bucket = this.buckets[bucketIndex];

            bucket.remove(Integer.valueOf(key));
        }

        public boolean contains(int key) {
            int bucketIndex = hash(key);
            LinkedList<Integer> bucket = this.buckets[bucketIndex];

            return bucket.contains(key);
        }
    }
}
