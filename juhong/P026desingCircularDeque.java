/**
 * https://leetcode.com/problems/design-circular-deque/submissions/1526444423/
 */

class MyCircularDeque {
    int capacity = -1;
    int cnt = 0;
    Node front = null;
    Node last = null;

    public MyCircularDeque(int k) {
        capacity = k;
    }

    public boolean insertFront(int value) {

        if (isFull()) {
            return false;
        }

        Node add = new Node(value, last, front);

        add.next = front;
        add.prev = last;

        if (front == null && last == null) {
            front = add;
            last = add;
        }
        else {
            last.next = add;
            front.prev = add;
            front = add;
        }

        cnt += 1;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        Node add = new Node(value, last, front);

        add.next = front;
        add.prev = last;

        if (front == null && last == null) {
            front = add;
            last = add;
        }
        else {
            last.next = add;
            front.prev = add;
            last = add;
        }

        cnt += 1;
        return true;
    }

    public boolean deleteFront() {

        if (isEmpty()) {
            return false;
        }

        if (front == last) {
            front = null;
            last = null;
        }
        else {
            front.prev.next = front.next;
            front.next.prev = front.prev;
            front = front.next;
            last = front.prev;
        }

        cnt -= 1;
        return true;

    }

    public boolean deleteLast() {

        if (isEmpty()) {
            return false;
        }

        if (front == last) {
            front = null;
            last = null;

        }
        else {
            last.prev.next = last.next;
            last.next.prev = last.prev;

            last = last.prev;
            front = last.next;
        }


        cnt -= 1;
        return true;
    }

    public int getFront() {

        if (isEmpty()) {
            return -1;
        }

        return front.val;

    }

    public int getRear() {

        if (isEmpty()) {
            return -1;
        }

        return last.val;
    }

    public boolean isEmpty() {

        return (cnt <= 0);
    }

    public boolean isFull() {

        return (cnt >= capacity);
    }
}

class Node {
    int val;
    Node prev;
    Node next;

    public Node(int val, Node prev, Node next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */