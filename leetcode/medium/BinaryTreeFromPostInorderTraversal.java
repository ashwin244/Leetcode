package leetcode.medium;

public class BinaryTreeFromPostInorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, inorder.length -1, 0, postorder.length - 1);
    }
    
    public TreeNode build(int[] inorder, int[] postorder, int iStart, int iEnd, int pStart, int  pEnd) {
    	if(iStart > iEnd || pStart > pEnd) {
    		return null;
    	}
		TreeNode root = new TreeNode(postorder[pEnd]);
		int index = 0;
    	for(int i=0; i < inorder.length; i++) {
    		if(inorder[i] == root.val) {
    			index = i;
    			break;
    		}
    	}
    	
    	root.left = build(inorder, postorder, iStart, index - 1, pStart, pEnd - (index - iStart) - 1);
    	root.right = build(inorder, postorder, index + 1, iEnd, pStart + index - iStart, pEnd - 1);
    	
    	return root;
    }
}
