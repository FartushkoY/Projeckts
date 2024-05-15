package de.telran.Algorithms;

import java.util.Comparator;
import java.util.stream.Collector;

public class MyTree {

    private static class TreeNode {
        private int vallue;
        private TreeNode left = null;
        private TreeNode right = null;

        public TreeNode(int vallue, TreeNode left, TreeNode right) {
            this.vallue = vallue;
            this.left = left;
            this.right = right;
        }

        public int getVallue() {
            return vallue;
        }

        public void setVallue(int vallue) {
            this.vallue = vallue;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }


    private TreeNode root = null;


    public void setRoot (int vallue) {
        root = new TreeNode(vallue, null, null);
    }

    public void add(int value){
        if (root == null) {
            root = new TreeNode(value, null, null);
        } else {
            addSubTree(root, value);
        }
    }

    public void addSubTree(TreeNode node, int value) {
        if (node.getVallue() == (value)) {
            if (node.getLeft() == null) {
                node.setLeft(new TreeNode(value, null, null));
            } else {
                addSubTree(node.getLeft(), value);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new TreeNode(value, null, null));
            } else {
                addSubTree(node.getRight(), value);
            }
        }
    }

    public boolean find(int value) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.getVallue() == (value)) {
                return true;
            } else if (cur.getVallue() < value) {

            }
        }
        return false;
    }




    public static void main(String[] args) {
        MyTree myTree = new MyTree();
        TreeNode myRoot = new TreeNode(10, null, null);

        myTree.setRoot(myRoot.getVallue());

        TreeNode node20 = new TreeNode(20, null, null);
        TreeNode node30 = new TreeNode(30, null, null);

        myRoot.setLeft(node20);
        myRoot.setRight(node30);




    }

}


