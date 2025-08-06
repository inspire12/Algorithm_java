package com.inspire12.algorithm.solve.beakjoon.p1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void traverseFront(Tree tree) {
        if (null != tree) {
            System.out.print(tree.node);
            traverseFront(tree.left);
            traverseFront(tree.right);
        }
    }

    public static void traverseMid(Tree tree) {
        if (null != tree) {
            traverseMid(tree.left);
            System.out.print(tree.node);
            traverseMid(tree.right);
        }
    }


    public static void traverseLast(Tree tree) {
        if (null != tree) {
            traverseLast(tree.left);
            traverseLast(tree.right);
            System.out.print(tree.node);
        }
    }

    public static void main(String[] args) throws IOException {
        Map<String, Tree> map = new HashMap<>();

        String line = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lineNumber = Integer.parseInt(reader.readLine());

        while (null != (line = reader.readLine())) {
            String[] input = line.split(" ");
            String node = input[0];
            String left = input[1];
            String right = input[2];
            Tree nodeTree = map.getOrDefault(node, new Tree(node));

            if (!left.equals(".")) {
                Tree nodeLeft = map.getOrDefault(left, new Tree(left));
                map.put(left, nodeLeft);
                nodeTree.setLeft(nodeLeft);
            }

            if (!right.equals(".")) {
                Tree nodeRight = map.getOrDefault(right, new Tree(right));
                map.put(right, nodeRight);
                nodeTree.setRight(nodeRight);
            }
            map.put(node, nodeTree);
        }

        traverseFront(map.get("A"));
        System.out.println();
        traverseMid(map.get("A"));
        System.out.println();
        traverseLast(map.get("A"));
    }

    private static class Tree {
        String node;
        Tree left;
        Tree right;

        public Tree(String node) {
            this.node = node;
        }

        public void setLeft(Tree left) {
            this.left = left;
        }

        public void setRight(Tree right) {
            this.right = right;
        }
    }
}
