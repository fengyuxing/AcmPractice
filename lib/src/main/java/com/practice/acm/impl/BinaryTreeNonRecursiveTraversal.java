package com.practice.acm.impl;

import com.practice.acm.IAlgorithm;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class BinaryTreeNonRecursiveTraversal implements IAlgorithm<BinaryTreeNonRecursiveTraversal.Node>
{
    @Override
    public void process(Node root) {
        System.out.println("中序：");
        push(root);
        Node top=null;
        Node popNode=null;
        while(!stack.isEmpty()){
            top=stack.peek();
            if(isPush){//栈顶元素是新push进入的
                if(top.left!=null){
                    push(top.left);
                }else{
                    printNode(top);
                    if(top.right!=null){
                        push(top.right);
                    }else{
                        popNode=pop();
                    }
                }
            }else{//栈顶是弹出
                if(popNode==top.left){//左子树已遍历
                    //中序
                    printNode(top);
                    if(top.right!=null){
                        push(top.right);
                    }else{
                        popNode=pop();
                    }
                }else if(popNode==top.right){//右子树已遍历
                    popNode=pop();
//                    printNode(popNode);
                }
            }
        }
    }

    Stack<Node> stack=new Stack<Node>();
    boolean isPush=true;//栈顶

    private void push(Node node){
        stack.push(node);
        // 前序
//        System.out.print("push: ");
//         printNode(node);
        isPush=true;
    }
    private void printNode(Node node){
        System.out.print(node.val+"  ");
    }

    private Node pop(){
        isPush=false;
        Node node= stack.pop();
//      后序
//        System.out.print("pop: ");
//        printNode(node);
        return node;
    }

    /**
     *
     * @param sortedArray
     * @param start include
     * @param end exclude
     * @return
     */
    private Node transform(int[] sortedArray,int start,int end){
        if(start>=end)
            return null;
        Node root=new Node();
        int mid=(start+end)/2;
        root.val=sortedArray[mid];
        root.left=transform(sortedArray,start,mid);
        root.right=transform(sortedArray,mid+1,end);
        return root;
    }
    @Override
    public Node getInput() {
        int[] values=new int[(int) Math.pow(2,4)-1];
        Random r=new Random();
        for(int i=0;i<values.length;i++){
            values[i]=i;
//            values[i]=r.nextInt(1000);
        }
        Arrays.sort(values);
        System.out.println("原始数组: ");
        for( int i:values){
            System.out.print(i+"  ");
        }
        Node root=transform(values,0,values.length);
        return root;
    }

    static class Node{
        int val;
        Node left;
        Node right;
    }
}
