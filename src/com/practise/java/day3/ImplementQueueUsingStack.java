package com.practise.java.day3;

import java.util.Stack;

public class ImplementQueueUsingStack {

    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> temp = new Stack<Integer>();

    public void add(int element) {
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
    public void poll(){
      // removed First element from Queue
        stack.pop();
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
