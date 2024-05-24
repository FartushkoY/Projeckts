package de.telran.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "vallue=" + vallue +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }


    private TreeNode root = null;


    public void setRoot(int vallue) {
        root = new TreeNode(vallue, null, null);
    }

    public void add(int value) {
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

//    public List<Integer> getLevelElements(int level) {
//       List<Integer> result = new ArrayList<>();
//       if (level == 1)
//
//
//        return result;
//    }

    public int[] getValuesInLeafs() {
        return getValuesInSubtree(this.root);
    }

    private int[] getValuesInSubtree(TreeNode node) {
        if (node == null) {
            return new int[]{};
        }
        if (node.getLeft() == null && node.getRight() == null) {
            return new int[]{node.getVallue()};
        } else {
            int[] left = getValuesInSubtree(node.getLeft());
            int[] right = getValuesInSubtree(node.getRight());
            int[] result = new int[left.length + right.length];

            for (int i = 0; i < left.length; i++) {
                result[i] = left[i];
            }

            for (int i = 0; i < right.length; i++) {
                result[i + left.length] = right[i];
            }


            return result;
        }

    }


    public static void main(String[] args) {
        MyTree myTree = new MyTree();

        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node8 = new TreeNode(8, null, null);

        TreeNode node6 = new TreeNode(6, null, null);

        TreeNode node5 = new TreeNode(5, null, null);

        TreeNode node4 = new TreeNode(4, node7, node8);

        TreeNode node3 = new TreeNode(3, null, node6);

        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode myRoot = new TreeNode(1, node2, node3);
        myTree.setRoot(myRoot.getVallue());

        System.out.println(node2);
        System.out.println(node6);
        System.out.println(myRoot);

        System.out.println(Arrays.toString(myTree.getValuesInLeafs()));


//        System.out.println(myTree);

//        TreeNode myRoot = new TreeNode(10, null, null);
//
//        myTree.setRoot(myRoot.getVallue());
//
//        TreeNode node20 = new TreeNode(20, null, null);
//        TreeNode node30 = new TreeNode(30, null, null);
//
//        myRoot.setLeft(node20);
//        myRoot.setRight(node30);
    }

}


