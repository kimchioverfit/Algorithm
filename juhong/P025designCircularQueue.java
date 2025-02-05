/**
 * https://leetcode.com/problems/design-circular-queue/submissions/1526249959/
 */

class MyCircularQueue {
    int[] arr = new int[3000];
    int start = 0;
    int end = 0;
    int size = -1;

    public MyCircularQueue(int k) {
        size = k;
        Arrays.fill(arr, -1);
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        arr[end++] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        arr[start++] = -1;
        return true;
    }

    public int Front() {
        return arr[start];
    }

    public int Rear() {
        if (end - 1 >= 0) {
            return arr[end - 1];
        }
        return -1;
    }

    public boolean isEmpty() {
        if (end <= start) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (end - start >= size) {
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */