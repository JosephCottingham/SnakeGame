// CSE 205: 11333 | Tue/Thu 4:30 PM
// Assignment: Six Final Project
// Author: Joseph H Cottingham | 1216723703
// Description: Implimentation of stack data strucuture

package Snake.Support;

import java.util.NoSuchElementException;

public class Stack<T extends Object> {
    // add any necessary variables here
    private T[] collection = (T[]) new Object[0];
    private int size = 0;

    // adds item
    public void push(T item) {
        size++;
        T[] tempCollection = (T[]) new Object[size];
        for (int x = 1; x < size; x++) {
            tempCollection[x] = collection[x - 1];
        }
        tempCollection[0] = item;
        collection = tempCollection;
    }

    public T pop() {
        if (isEmpty()) throw new NoSuchElementException();
        size--;
        T[] tempcollection = (T[]) new Object[size];
        for (int x = 0; x < size; x++) tempcollection[x] = collection[x + 1];
        T o = collection[0];
        collection = tempcollection;
        return o;
    }


    public T peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return collection[0];
    }

    public void set(int index, T item) {
        collection[index] = item;
    }

    public int find(T item) {
        for (int x = 0; x < size; x++) if (collection[x].toString().equals(item.toString())) return x;
        return -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        return collection[index];
    }
}
