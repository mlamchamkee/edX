package datastructures;
import java.util.NoSuchElementException;

/**
 * Your implementation of an ArrayList.
 */
public class ArrayList<T> {

    /*
     * The initial capacity of the ArrayList.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 9;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * If no empty nodes exist in array, resizes the backingArray
     *
     * @param None
     *
     */
    private void resize () {
        if (size > 0 && size % INITIAL_CAPACITY == 0) {
            // Create new backing array
            T[] newBackingArray = (T[]) new Object[size * 2];
            // Copy elements to new backingArray
            for (int i = 0; i < size; i += 1) {
                newBackingArray[i] = backingArray[i];
            }
            // reassign backingArray
            backingArray = newBackingArray;
        }
    }

    /**
     * This is the constructor that constructs a new ArrayList.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayList() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the front of the list.
     *
     * This add may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        // check if element is null
        if (data == null) {
            throw new IllegalArgumentException("Error: data element is null");
        }
        // check if array needs to be resized
        resize();
        // shift elements to the right
        for (int i = size; i > 0; i -= 1) {
            backingArray[i] = backingArray[i-1];
        }
        // mutate element at index 0
        backingArray[0] = data;
        // update size attribute
        size += 1;
    }

    /**
     * Adds the data to the back of the list.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        // check if element is null
        if (data == null) {
            throw new IllegalArgumentException("Error: data element is null");
        }
        // check if array needs to be resized
        resize();
        // adds the data to the back of the list
        backingArray[size] = data;
        // update size attribute
        size += 1;

    }

    /**
     * Removes and returns the first data of the list.
     *
     * Do not shrink the backing array.
     *
     * This remove may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (size == 0){
            throw new NoSuchElementException("Error: list is empty");
        }
        T deletedData = backingArray[0];
        // shift elements to the left
        for (int i = 0; i < size - 1; i += 1) {
            backingArray[i] = backingArray[i+1];
        }
        backingArray[size - 1] = null;
        size -= 1;
        return deletedData;
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Do not shrink the backing array.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (size == 0){
            throw new NoSuchElementException("Error: list is empty");
        }
        T deletedData = backingArray[size - 1];
        backingArray[size - 1] = null;
        size -= 1;
        return deletedData;
    }

    /**
     * Returns the backing array of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    public static void main(String[] args) {
        System.out.println("Hey there");
    }
}