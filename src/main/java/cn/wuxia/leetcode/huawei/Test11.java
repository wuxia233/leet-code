package cn.wuxia.leetcode.huawei;

import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
}

public class Test11 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 && postorder.length == 0) {
            return null;
        }
        if (inorder.length == 1 && postorder.length == 1) {
            return new TreeNode(inorder[0]);
        }

        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int inorderRootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (root.val == inorder[i]) {
                inorderRootIndex = i;
                break;
            }
        }

        int[] inOrderLeft = Arrays.copyOfRange(inorder, 0, inorderRootIndex);
        int[] inOrderRight = Arrays.copyOfRange(inorder, inorderRootIndex + 1, inorder.length);
        int[] postOrderLeft = Arrays.copyOfRange(postorder, 0, inOrderLeft.length);
        int[] postOrderRight = Arrays.copyOfRange(postorder, inOrderLeft.length, postorder.length - 1);

        TreeNode left = buildTree(inOrderLeft, postOrderLeft);
        TreeNode right = buildTree(inOrderRight, postOrderRight);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        Test11 test11 = new Test11();
        int[] inorder = new int[] {9,3,15,20,7};
        int[] postorder = new int[] {9,15,7,20,3};
        TreeNode root = test11.buildTree(inorder, postorder);
        System.out.println(root);
    }

}
