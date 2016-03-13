package leetcode;

import java.util.Iterator;

/**
 * For leetcode problem 284: Peeking Iterator.
 * Created by sunlei on 3/12/16.
 */
public class PeekingIterator implements Iterator<Integer> {

    private boolean hasNextValue;
    private int currentIntValue;
    private Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iteratorValue) {
        // initialize any member here.
        hasNextValue = false;
        currentIntValue = 0;
        iterator = iteratorValue;
        if (iteratorValue.hasNext()) {
            hasNextValue = true;
            currentIntValue = iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!hasNextValue) {
            // Throw Exception?
            return null;
        }
        return currentIntValue;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (!hasNextValue) {
            // Throw Exception?
            return null;
        }

        if (!iterator.hasNext()) {
            hasNextValue = false;
            return currentIntValue;
        } else {
            int returnValue = currentIntValue;
            currentIntValue = iterator.next();
            return returnValue;
        }
    }

    @Override
    public boolean hasNext() {
        return hasNextValue;
    }

    // Place holder, need to implement this for iterator interface.
    @Override
    public void remove() { }
}
