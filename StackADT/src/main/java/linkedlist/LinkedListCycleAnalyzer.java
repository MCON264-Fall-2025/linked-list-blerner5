}

// Step 2: Find cycle length
int cycleLength = 1;
        LLNode<T> current = slow.next;
        while (current != slow) {
        cycleLength++;
        current = current.next;
        }

        // Step 3: Find entry index
        LLNode<T> ptr1 = head;
        LLNode<T> ptr2 = head;

        // Move ptr2 ahead by cycleLength steps
        for (int i = 0; i < cycleLength; i++) {
        ptr2 = ptr2.next;
        }

        int entryIndex = 0;
        while (ptr1 != ptr2) {
        ptr1 = ptr1.next;
        ptr2 = ptr2.next;
        entryIndex++;
        }

        return new CycleInfo(entryIndex, cycleLength);
    }
            }
            }