package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * For leetcode problem #341: Flatten Nested List Iterator
 */
public class NestedIterator implements Iterator<Integer> {

    private interface NestedInteger {
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
    }

    ArrayList<List<NestedInteger>> listStack;
    ArrayList<Integer> positionStack;
    boolean hasNext;

    public NestedIterator(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            hasNext = false;
        }

        listStack = new ArrayList<>();
        positionStack = new ArrayList<>();
        listStack.add(nestedList);
        positionStack.add(-1);
        hasNext = true;
        GoToNextPosition();
    }

    @Override
    public Integer next() {
        List<NestedInteger> currentList = listStack.get(listStack.size() - 1);
        int currentPosition = positionStack.get(positionStack.size() - 1);
        Integer retInteger = currentList.get(currentPosition).getInteger();
        GoToNextPosition();
        return retInteger;
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    private void GoToNextPosition() {
        positionStack.set(positionStack.size() - 1, positionStack.get(positionStack.size() - 1) + 1);

        while (true) {
            if (listStack.size() == 0) {
                hasNext = false;
                return;
            }

            List<NestedInteger> currentList = listStack.get(listStack.size() - 1);
            int currentPosition = positionStack.get(positionStack.size() - 1);

            if (currentPosition >= currentList.size()) {
                listStack.remove(listStack.size() - 1);
                positionStack.remove(positionStack.size() - 1);
                positionStack.set(positionStack.size() - 1, positionStack.get(positionStack.size() - 1) + 1);

            } else if (currentList.get(currentPosition) == null) {
                positionStack.set(positionStack.size() - 1, positionStack.get(positionStack.size() - 1) + 1);

            } else if (currentList.get(currentPosition).isInteger()) {
                return;

            } else {
                listStack.add(currentList.get(currentPosition).getList());
                positionStack.add(0);
            }
        }
    }

    @Override
    public void remove() {

    }
}
