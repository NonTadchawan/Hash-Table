package org.example.collection;

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.add("A"); hashTable.add("f");
        hashTable.add("B"); hashTable.add("H");
        hashTable.add("C"); hashTable.add("I");
        hashTable.add("x");
        hashTable.add("Y"); hashTable.add("J");
        hashTable.add("m"); hashTable.add("s");
        hashTable.add("z");
        hashTable.add(new String("N"));
        hashTable.add("Y");

        for (Object item: hashTable.slot) {
            System.out.println(item);
        }
        for (Object item: hashTable) {
            System.out.println(item);
        }
        System.out.println();
     /*   Iterator it = hashTable.iterator();
        while (it.hasNext()){
            Object item = it.next();
            System.out.println(item);
        }*/


        System.out.println("Contain in slot : " + hashTable.contain("O"));
        System.out.println("Contain in slot : " + hashTable.contain("Y"));
    }
}
