package com.practice.acm.ThreeLevel;

import com.practice.acm.IAlgorithm;

import java.util.Random;

/**
 * 单链表反转
 * Author: zhangshupeng
 * Date: 2019-07-24 18:31
 */
public class LinkListReverse implements IAlgorithm<LinkListReverse.Node> {

    @Override
    public void process(Node head) {
        System.out.println("process before:");
        printList(head);
        Node prev=null;Node current=head;Node next=null;
        while(current!=null){
            next=current.next;
            current.next=prev;
            //move to next Node
            prev=current;
            current=next;
        }
        System.out.println("process after:");
        printList(prev);
    }

    private  void printList(Node node){
        String s="";
        while (node!=null){
            s=s+node.value+"  ";
            node=node.next;
        }
        System.out.println(s);
    }

    @Override
    public Node getInput() {
        Random random=new Random();
        Node head=null;
        for (int i=0;i<10;i++) {
            Node node=new Node();
            node.value=random.nextInt(100);
            node.next=head;
            head=node;
        }
        return head;
    }

    static class Node {
        int value;
        Node next;
    }
}
