package com.shika;

import org.junit.Test;

public class ReconstructBinaryTreeTest {
    @Test
    public void reconstructBinaryTree() throws Exception {
         int[] preorder = {3,9,20,15,7};
         int[] inorder = {9,3,15,20,7};

        ReconstructBinaryTree.TreeNode treeNode = ReconstructBinaryTree.reconstructBinaryTree(preorder, inorder);

    }

}