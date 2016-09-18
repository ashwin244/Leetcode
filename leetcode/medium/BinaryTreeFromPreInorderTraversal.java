package leetcode.medium;

/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
 */
public class BinaryTreeFromPreInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	return build(preorder, inorder, 0, inorder.length, 0);
    }
    
    public TreeNode build(int[] preorder, int[] inorder, int iStart, int iEnd, int pStart) {
    	if(pStart > preorder.length-1 || iStart > iEnd) {
    		return null;
    	}
    	TreeNode root = new TreeNode(preorder[pStart]);
    	int index = 0;
    	for(int i=0; i< inorder.length; i++) {
    		if(inorder[i] == root.val) {
    			index = i;
    			break;
    		}
    	}
    	
    	root.left = build(preorder, inorder, iStart, index - 1, pStart + 1);
    	root.right = build(preorder, inorder, index + 1, iEnd, pStart + index + 1 - iStart); 
    	return root;
    }
}
