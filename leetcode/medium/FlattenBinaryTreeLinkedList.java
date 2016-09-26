package leetcode.medium;

/*
 * 
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6 
 
 */
public class FlattenBinaryTreeLinkedList {
	
	TreeNode prev = null;
    public void flatten(TreeNode root) {
    	if(root == null) {
    		return;
    	}
        if(root.right != null) {
        	flatten(root.right);
        }
        if(root.left != null) {
        	flatten(root.left);
        }
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
