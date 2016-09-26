package leetcode.medium;
import java.util.*;
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
    	List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root == null) {
        	return result;
        }
        q.add(root);
        
        while(!q.isEmpty()) {
        	int size = q.size();
        	for(int i=0; i<size; i++) {
        		TreeNode node = q.poll();
        		if(i==0) {
        			result.add(node.val);
        		}
        		if(node.right != null) {
        			q.add(node.right);
        		}
        		if(node.left != null) {
        			q.add(node.left);
        		}
        	}
        }
        return result;
    }
}
