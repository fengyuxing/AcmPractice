package com.practice.acm.impl;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        Node node1=generateNode(1);
        node1.print();
        Node node2=generateNode(2);
        node2.print();
        Node mergeode=new MergeTwoSortedArray().merge(node1,node2);
        mergeode.print();
    }

    private static Node generateNode(int n) {
        Node first=new Node(1,null);
        Node end=first;
        for( int i=3;i<10;i++){
            Node node1=new Node(i*n,null);
            end.next=node1;
            end=node1;
        }
        return first;
    }

    static class Node{
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
        public void print(){
            Node node=this;
            while(node!=null){
                System.out.print(node.value+",");
                node=node.next;
            }
            System.out.println();
        }
    }
    /*两个升序的有序列表合并成一个
    * */
    Node mergeNodeStart=null;
    Node mergeNodeEnd=null;
    public Node merge(Node node1,Node node2){
        //1、比较node1和node2,取较小值，插入mergeNode尾部，原始链表移动一位
        //2、重复第一步
        while(node1!=null&&node2!=null){
            if(node1.value<node2.value){
                node1=addSubNode(node1);
            }else{
                node2=addSubNode(node2);
            }
        }
        //3、如果node1或node2有一个已经为空，直接插入mergeNode尾部
        if (node1!=null){
            mergeNodeEnd.next=node1;
        }
        if (node2!=null){
            mergeNodeEnd.next=node2;
        }
        return mergeNodeStart;
    }

    private Node addSubNode(Node node) {
        if (mergeNodeEnd ==null){
            mergeNodeStart= node;
            mergeNodeEnd = node;
        }else{
            mergeNodeEnd.next= node;
            mergeNodeEnd=node;
        }
        node=node.next;
        return node;
    }

}
