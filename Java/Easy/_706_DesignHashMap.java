package Java.Easy;

import java.util.Arrays;

public class _706_DesignHashMap {
    public static void main(String[] args) {
        System.out.println("#706 - Design HashMap - Easy");

        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(3));
        myHashMap.put(2, 1);
        System.out.println(myHashMap.get(2));
        myHashMap.remove(2);
        System.out.println(myHashMap.get(2));

        System.out.println("\n --- Testing with Chaining Method ---");
        SeparateChainingMap chainingMap = new SeparateChainingMap();
        chainingMap.put(1, 1);
        chainingMap.put(2, 2);
        System.out.println(chainingMap.get(1));
        System.out.println(chainingMap.get(3));
        chainingMap.put(2, 1);
        System.out.println(chainingMap.get(2));
        chainingMap.remove(2);
        System.out.println(chainingMap.get(2));

        return;
    }

    static class MyHashMap {
        private int[] lookupArray;

        public MyHashMap() {
            this.lookupArray = new int[1000001];
            Arrays.fill(lookupArray, -1);
        }

        public void put(int key, int value) {
            this.lookupArray[key] = value;
        }

        public int get(int key) {
            return this.lookupArray[key];
        }

        public void remove(int key) {
            this.lookupArray[key] = -1;
        }
    }

    static class SeparateChainingMap {
        private static final int SIZE = 1000;
        private Node[] buckets;

        static class Node {
            int key;
            int value;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
                this.next = null;
            }
        }

        public SeparateChainingMap() {
            this.buckets = new Node[SIZE];
        }

        private int hash(int key) {
            return key % SIZE;
        }

        public void put(int key, int value) {
            int index = hash(key);

            if (this.buckets[index] == null) {
                this.buckets[index] = new Node(key, value);
                return;
            }

            Node current = this.buckets[index];
            while (true) {
                if (current.key == key) {
                    current.value = value;
                    return;
                }

                if (current.next == null) {
                    current.next = new Node(key, value);
                    return;
                }

                current = current.next;
            }
        }

        public int get(int key) {
            int index = hash(key);
            Node current = this.buckets[index];

            while (current != null) {
                if (current.key == key) {
                    return current.value;
                }

                current = current.next;
            }

            return -1;
        }

        public void remove(int key) {
            int index = hash(key);
            Node current = this.buckets[index];

            if (current == null) {
                return;
            }

            if (current.key == key) {
                this.buckets[index] = current.next;
                return;
            }

            while (current.next != null) {
                if (current.next.key == key) {
                    current.next = current.next.next;
                    return;
                }

                current = current.next;
            }
        }
    }
}
