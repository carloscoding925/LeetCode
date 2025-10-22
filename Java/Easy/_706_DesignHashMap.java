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
}
