package com.shika;

import java.util.LinkedList;

public class QueueMadeOf2Stack {
    LinkedList<Integer> stack1 = new LinkedList<>();
    LinkedList<Integer> stack2 = new LinkedList<>();

    public void enqueue(int a) {
        stack1.push(a);
    }

    public int dequeue() throws Exception {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new Exception("Empty Queue");
            } else {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
        }
        return stack2.pop();
    }
    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) throws Exception{
        QueueMadeOf2Stack queue = new QueueMadeOf2Stack();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        while (!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }
    }
}
