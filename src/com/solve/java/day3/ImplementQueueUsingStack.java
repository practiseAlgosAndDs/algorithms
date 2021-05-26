package com.solve.java.day3;

import java.util.Stack;
//Approach 1 to make deQueue O(1)
//Approach 2 to make enQueue O(1)
public class ImplementQueueUsingStack {

    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> temp = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void add(int element) { //Approach1
      if(stack.isEmpty())
      {
          stack.add(element);
          return;
      }

      while(!stack.isEmpty()){
          temp.add(stack.pop());
      }
      stack.add(element);
      while(!temp.isEmpty()){
          stack.add(temp.pop());
      }
    }

    private int top(){
       return stack.peek();
    }

    private int size()
    {
        return stack.size();
    }
    public void poll(){ //Approach1
      // removed First element from Queue
        stack.pop();
    }

    public void addToQueue(int element) { //Approach2
        //stack.push();//
    }

    public static void main(String[] args){
        ImplementQueueUsingStack queue = new ImplementQueueUsingStack();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("top :"+queue.top());
        System.out.println("size :"+queue.size());
        queue.poll();
        System.out.println("top :"+queue.top());
        System.out.println("size :"+queue.size());
        queue.add(4);
        System.out.println("added 4");
        System.out.println("size :"+queue.size());
    }
}
