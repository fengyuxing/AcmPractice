package com.practice.acm.impl;


import java.util.ArrayList;
import java.util.List;

public   class LangZhiTest {
    public static void main(String[] args) {
        int n=4;
        Node root=genFullTree(n,1);
        System.out.println("done");
    }

    private static Node genFullTree(int n,int rootValue) {
        if (n==1){
            Node root=new Node(rootValue);
            return root;
        }
        Node root=new Node(rootValue);
        Node left=genFullTree(n-1,rootValue*2);
        Node right=genFullTree(n-1,rootValue*2+1);
        root.left=left;
        root.right=right;
        left.parent=root;
        right.parent=root;
        return root;
    }

    public static class Node<T> {
        T data;

        public Node(T data) {
            this.data = data;
        }

        Node<T> parent;
        Node<T> left;
        Node<T> right;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getParent() {
            return parent;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }
    }

}