package com.solve.java.linkedlist;

// LC med : 426  https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
public class ConvertBSTDoublyLinkedList {
    Node head = null;
    Node prev = null;
    Node root=null;
    public Node treeToDoublyList(Node root) { // working solution in LC 
        inOrderTraversal(root);
        if(head==null) return null;
        head.left = prev;
        prev.right =head;
        return head;
    }

    private void inOrderTraversal(Node root) {
        if(root ==null) return;
        inOrderTraversal(root.left);
         System.out.print(root.val+ " -> ");
        if(head ==null) {
            head =root;
        }
        else {
            prev.right =root; // pointing prev node's right to next node
            root.left=prev;  // pointing current Node's left to previous
        }
        prev =root; // marking current node as previous
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
      int [] array={4,2,5,1,3};
      ConvertBSTDoublyLinkedList  convertBST = new ConvertBSTDoublyLinkedList();
        convertBST.root = new Node(8);
        convertBST.root.left = new Node(6);
        convertBST.root.right = new Node(10);
        convertBST.root.left.left = new Node(5);
        convertBST.root.left.right = new Node(7);
        convertBST.root.right.left= new Node(9);
        convertBST.root.right.right= new Node(11);

       convertBST.treeToDoublyList(convertBST.root);
    }
}
