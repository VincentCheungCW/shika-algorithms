package com.shika;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：重建二叉树
 * 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的
 * 数字。
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * <p>
 * 思路：前序遍历的第一个值为根节点的值，使用这个值将中序遍历结果分成两部分，左部分为树的左子树中序遍历结果，右
 * 部分为树的右子树中序遍历的结果。
 */
public class ReconstructBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static Map<Integer, Integer> inOrderIndex = new HashMap<>();

    public static TreeNode reconstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            inOrderIndex.put(in[i], i);
        }
        return reconstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private static TreeNode reconstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        Integer inIndex = inOrderIndex.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reconstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reconstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }
}
