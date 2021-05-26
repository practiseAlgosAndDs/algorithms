package com.solve.java.day3;

import java.util.LinkedList;
import java.util.Queue;
// To ImplementStackUsingQueue

public class ImplementStackUsingQueue {

    Queue<Integer> queue = new LinkedList<Integer>();
    Queue<Integer> temp = new LinkedList<Integer>();

//Approach 1 to make poll O(1)
//Approach 2 to make push O(1)
    public void push(int element){
       if(queue.isEmpty()){
           queue.add(element);
       }
       else{
           // 1.Move all the elements from main Queue to temp queue
           while(!queue.isEmpty()){
               temp.add(queue.poll());
           }
           // 2.main Queue is empty so add the element here
           queue.add(element);
           // 3.after that add remaining elements
           while(!temp.isEmpty())
           {
               queue.add(temp.poll());
           }
       }
    }

    public void pop(int element){
      if(!queue.isEmpty())
      {
          if(queue.peek()==element){
              queue.poll();
          }

      }
    }

    public int top(){
       return queue.peek();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueue stack = new ImplementStackUsingQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("peek :"+stack.top());
        stack.pop(3);
        System.out.println("peek :"+stack.top());
        stack.push(4);
        System.out.println("peek :"+stack.top());
    }
}
