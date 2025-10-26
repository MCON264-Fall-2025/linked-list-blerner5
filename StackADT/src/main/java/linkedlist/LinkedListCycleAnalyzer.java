package linkedlist;

import support.LLNode;
import support.CycleInfo;

public class LinkedListCycleAnalyzer {

    public static <T> CycleInfo detectCycleInfo(LLNode<T> head) {
        if (head == null) {
            return new CycleInfo(-1, 0);
        }

        LLNode<T> slow = head;
        LLNode<T> fast = head;
        boolean hasCycle = false;

        // Step 1: Detect cycle
        while (fast != null && fast.getLink() != null) {
            slow = slow.getLink();
            fast = fast.getLink().getLink();

            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) {
            return new CycleInfo(-1, 0);
        }

        // Step 2: Find cycle length
        int cycleLength = 1;
        LLNode<T> current = slow.getLink();
        while (current != slow) {
            cycleLength++;
            current = current.getLink();
        }

        // Step 3: Find entry index
        LLNode<T> ptr1 = head;
        LLNode<T> ptr2 = head;

        for (int i = 0; i < cycleLength; i++) {
            ptr2 = ptr2.getLink();
        }

        int entryIndex = 0;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.getLink();
            ptr2 = ptr2.getLink();
            entryIndex++;
        }

        return new CycleInfo(entryIndex, cycleLength);
    }
}