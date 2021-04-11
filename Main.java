package com.engeto.examples;

public class Main {

    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();
        treeFill(bt);
        treePrintOut(bt.rootNode);

        if(bt.containsNode(9)) System.out.println("Uzel 9 existuje");
        else System.out.println("Uzel 9 NEEXISTUJE");

        bt.delete(6);   // vymaz root uzlu
        treePrintOut(bt.rootNode);

    }

    public static void treeFill(BinaryTree treeToFill)
    {   treeToFill.addNode(6);
        treeToFill.addNode(4);
        treeToFill.addNode(8);
        treeToFill.addNode(3);
        treeToFill.addNode(5);
        treeToFill.addNode(4);
        treeToFill.addNode(9);
    }

    public static void treePrintOut(TreeNode treeNodeToPrint)
    {   // vypise nejdriv levou vetev, pak root uzel a pak tu pravou
        if (treeNodeToPrint != null) {
            treePrintOut(treeNodeToPrint.left);
            System.out.println(" " + treeNodeToPrint.value);
            treePrintOut(treeNodeToPrint.right);
        }
    }
}
