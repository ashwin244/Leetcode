package leetcode.medium;

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class CountCompleteTreeNodes {
    public int height(TreeNode root) {
    if(root == null) {
        return -1;
    }
    
   return 1 + height(root.left);
}
   public int countNodes(TreeNode root) {
       if(root == null) {
           return 0;
       }
       
       int h = height(root);
       if(h < 0) {
           return 0;
       }
       else if(height(root.right) == h-1) {
           return (1<<h) + countNodes(root.right);
       }
       else {
        return (1<<(h-1)) + countNodes(root.left);
       }
   }
}
