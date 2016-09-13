package leetcode.medium;

public class LongestAbsoluteFilePath {
	public static void main(String[] args) {
		lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
	}
    public static int lengthLongestPath(String input) {
        int[] ld = new int[input.length() + 1];
        int max = 0;
        String[] str = input.split("\n");
        for(String s : str) {
        	String name = s.replaceAll("\t",""); //ltrim and remove \t
        	int d = s.length() - name.length();
        	if(s.contains(".")) {
        		max = Math.max(max, ld[d] + name.length()); 
        	}
        	else {
        		ld[d + 1] = ld[d] + name.length() + 1; // + 1 for '/'
        	}
        }
       return max; 
    }
}
