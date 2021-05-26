package com.solve.java.day3;

//https://www.geeksforgeeks.org/reverse-stack-without-using-extra-space/
// O(1) space (without using stack)
//i/p : 1>2>3>4
//0/p: 4>3>2>1
class Node {
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next=null;
    }
}
public class ReverseStackWithoutUsingExtraSpace {
    Node root;
    public void push(int data){
        if(root==null) {
            root = new Node(data);
            return;
        }
        Node current = root;
        while(current.next!=null){
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void print(){
        System.out.println("printing stack");
        Node temp = root;
        while (temp != null) {
            System.out.println(temp.data+"->");
            temp = temp.next;
        }
    }
    public void reverseStack() {
       Node current = root;
       Node prev=null;
       while(current!=null) {
           Node fut= current.next;
           current.next=prev;
           prev = current;
           current=fut;
       }
       root=prev;
    }
    public static void main(String[] args){
        ReverseStackWithoutUsingExtraSpace rs =new ReverseStackWithoutUsingExtraSpace();
        rs.push(1);
        rs.push(2);
        rs.push(3);
        rs.push(4);
        rs.print();
        rs.reverseStack();;
        rs.print();


    }
}
