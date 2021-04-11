package com.engeto.examples;

public class TreeNode {  //kazdy uzel ma svoji hodnotu, predchudce a nasledovnika
                         int value;
                         TreeNode left;
                         TreeNode right;
                         boolean newNode;


    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.newNode = false;
     }
    public TreeNode(int value,boolean newNode) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.newNode = newNode;
    }

}
