/*
 * @lc app=leetcode.cn id=641 lang=csharp
 *
 * [641] 设计循环双端队列
 */

// @lc code=start
public class MyCircularDeque {

    public DoubleListNode head; //head node
    public DoubleListNode tail; //tail node
    private int capacity;       //the deque's capcity
    private int currentLength;  //the deque's current length

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int capacity) {
        head = new DoubleListNode(-1); 
        tail = new DoubleListNode(-1); 

        head.pre = tail;
        tail.next = head;
        this.capacity = capacity;
        currentLength = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public bool InsertFront(int value) {
        if(IsFull()) return false;

        DoubleListNode node = new DoubleListNode(value);
        node.next = head;
        node.pre = head.pre;
        head.pre.next = node;
        head.pre = node;
        // node.next = head;
        // head.next.pre = node;
        // node.pre = head.next;
        // head.next.next = node;
        currentLength++;
        
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public bool InsertLast(int value) {
        if(IsFull()) return false;

        DoubleListNode node = new DoubleListNode(value);
        node.next = tail.next;
        node.pre = tail;
        tail.next.pre = node;
        tail.next = node;

        currentLength++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public bool DeleteFront() {
        if(IsEmpty()) return false;

        head.next.next.pre = head;
        head.next = head.next.next;

        currentLength--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public bool DeleteLast() {
        if(IsEmpty()) return false;

        tail.next.next.pre = tail;
        tail.next = tail.next.next; 

        currentLength--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int GetFront() {
        return head.pre.val;
    }
    
    /** Get the last item from the deque. */
    public int GetRear() {
        return tail.next.val;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public bool IsEmpty() {
        return currentLength == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public bool IsFull() {
        return currentLength == capacity;
    }
}

public class DoubleListNode {
    public DoubleListNode pre;
    public DoubleListNode next;
    public int val;

    public DoubleListNode(int value)
    {
        this.val = value;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * bool param_1 = obj.InsertFront(value);
 * bool param_2 = obj.InsertLast(value);
 * bool param_3 = obj.DeleteFront();
 * bool param_4 = obj.DeleteLast();
 * int param_5 = obj.GetFront();
 * int param_6 = obj.GetRear();
 * bool param_7 = obj.IsEmpty();
 * bool param_8 = obj.IsFull();
 */
// @lc code=end

