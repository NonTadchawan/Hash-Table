package org.example.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HashTable implements Iterable {
    Object[] slot = new Object[10];

    public HashTable() {
        for (int i = 0; i < slot.length; i++) {
            slot[i] = new ArrayList();
        }
    }

    public void add(Object item) {
        int hashCode = item.hashCode();
        int index = hashCode % 10;
        List list = (List) slot[index];
        if (list.isEmpty()) {
            list.add(item);
        } else {
            boolean found = false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(item)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                list.add(item);
            }
        }
    }

    public boolean contain(Object item) {
        int hasCode = item.hashCode();
        int index = hasCode % 10;
        List list = (List) slot[index];
        System.out.println("Input : " + item);
        System.out.println("index : " + index);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null && list.get(i).equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int currentIndex;
            int currentSubIndex;

            @Override
            public boolean hasNext() {
                return currentIndex < slot.length;
            }

            @Override
            public Object next() {
                List currentSlot = (List) slot[currentIndex];
                while (currentSlot.isEmpty()) {
                    currentIndex++;
                    currentSubIndex = 0;
                    currentSlot = (List) slot[currentIndex];
                    return null;
                }
                if (currentIndex < slot.length) {
                    if (currentSubIndex < currentSlot.size()) {
                        if (currentSubIndex == currentSlot.size() - 1) {
                            currentIndex++;
                        }
                        return currentSlot.get(currentSubIndex++);
                    } else {
                        currentIndex++;
                        currentSubIndex = 0;
                        if (currentIndex >= slot.length) {
                            return null;
                        }
                        currentSlot = (List) slot[currentIndex];
                        return currentSlot.get(currentSubIndex++);
                    }
                }
                return null;
            }
        };
    }
}
