package com.practice.acm.impl;

/**
 * 25. K 个一组翻转链表
 */
public class LinkListKReverse {
    public static void main(String[] args) {
        int[] head ={1,2,3,4,5};
        int k=3;
        ListNode headNode=null;
        ListNode tailNode=null;
        for (int i = 0; i <head.length ; i++) {
            ListNode node= new ListNode(head[i],null);
            if (headNode==null){
                headNode=node;
            }
            if (tailNode==null){
                tailNode=headNode;
            }else{
                tailNode.next=node;
                tailNode=node;
            }
        }
        new Solution().reverseKGroup(headNode,k);
    }
}


class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    ListNode bHead=null,bTail=null;
    int step;

    /**设目标node为ListNode c,cHead保存c的头，cTail保存c的尾
     * 1、原链表为ListNode a，判断a的a的长度是否大于等于k，
     * 2、翻转前k个node,生成新链表ListNode b
     * 3、如果不足k个，再次翻转b;
     * 4、将c的尾部node指向b的head
     * 5、重复1和2，直到a为空
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cHead=null,cTail=null;
        ListNode a=head;

        while(a!=null){
            //1、
//            ListNode b=reverseKnode(a,k);
            a = reverseFirstKNode(k, a);
            if (step<k){ //最后一次翻转不足k的时候，需要反转回来
                reverseFirstKNode(k, bHead);
            }
            //2、
            if (cTail!=null){
                cTail.next=bHead;
            }else{
                cHead=bHead;
            }
            cTail=bTail;
        }
        return cHead;
    }

    private ListNode reverseFirstKNode(int k, ListNode a) {
        bHead=null;
        bTail=null;
        step=0;
        while(step< k && a !=null){
            ListNode tmp= a;
            a = a.next;
            tmp.next=bHead;
            bHead=tmp;
            if (bTail==null){//第一个值是尾部
                bTail=tmp;
            }
            step++;
        }
        return a;
    }

}
