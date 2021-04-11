package com.engeto.examples;

public class BinaryTree {

    public TreeNode rootNode;  // prvni element

    public BinaryTree() {

    }

    public void addNode(int value) {
        rootNode = addTreeNode(rootNode, value);
    }
    public void delete(int value) {
        rootNode = deleteTreeNode(rootNode, value);
    }
    public boolean containsNode(int value) {
        return containsTreeNode(rootNode, value);
    }

    // rekurzivni private metody
    //------------------------------
    private TreeNode addTreeNode(TreeNode currentNode, int value){
        // pokud je aktualni uzel listem (posledni)
        if (currentNode == null) { return new TreeNode(value, true);}
        // pokud je uzel, pak jit dal na uzel vlevo nebo vpravo
        if (value < currentNode.value) {
            currentNode.left = addTreeNode(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = addTreeNode(currentNode.right, value);
        } else { // hodnota uz existuje
            currentNode.newNode = false;
            return currentNode;
        }
        currentNode.newNode = true;
        return currentNode;   // uzel byl vytvoren a uspesne zapsan
    }

    private TreeNode deleteTreeNode(TreeNode currentNode, int value) {
        if (currentNode == null) { return null;
        }
        if (value == currentNode.value) {
            // nalezen uzel k vymazani
            // osetrit tři možnosti
            //  uzel nema potomka - koncovy uzel -> rovnou vymaz
            if (currentNode.left == null && currentNode.right == null) { return null; }
            //  uzel má pouze jednoho potomka - ten nahradi ten mazany
            if (currentNode.right == null) {  return currentNode.left; }
            if (currentNode.left == null) { return currentNode.right; }
            //  uzel ma dva potomky
            int smallestValue = findSmallestValue(currentNode.right);
            currentNode.value = smallestValue;
            currentNode.right = deleteTreeNode(currentNode.right, smallestValue);
            return currentNode;

        }
        if (value < currentNode.value) {
            currentNode.left = deleteTreeNode(currentNode.left, value);
            return currentNode;
        }
        currentNode.right = deleteTreeNode(currentNode.right, value);
        return currentNode;
    }


    private boolean containsTreeNode(TreeNode currentNode, int value) {
        if (currentNode == null) { return false;
        }
        if (value == currentNode.value) { return true;
        }
        return value < currentNode.value ? containsTreeNode(currentNode.left, value) : containsTreeNode(currentNode.right, value);
    }

    private int findSmallestValue(TreeNode rootNode) {
        return rootNode.left == null ? rootNode.value : findSmallestValue(rootNode.left);
    }
}
