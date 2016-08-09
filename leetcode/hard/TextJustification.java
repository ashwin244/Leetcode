package leetcode.hard;
import java.util.*;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
    	
    	List<String> result = new ArrayList<>();
        for(int i=0, w; i<words.length; i = w) {
        	int len = -1;
        	for(w = i; (w < words.length) && (len + words[w].length() + 1 <= maxWidth); w++) {
        		len += words[w].length() + 1; //adding word and a space
        	}
        	
        	StringBuilder builder = new StringBuilder();
        	builder.append(words[i]);
        	int space = 1, extra = 0;
        	if(w != i+1 && w != words.length) { //only one word or reached end  -  false
        		space = (maxWidth - len) / (w - i - 1)   + 1; 
        		extra = (maxWidth - len) % (w - i - 1); //imp.
        	}
        	
        	for(int j = i+1; j < w; j++) {
        		for(int s = space; s > 0; s--)  {
        			builder.append(' ');
        		}
        		if(extra-- > 0) builder.append(' ');
        		builder.append(words[j]);
        	}
        	
        	int strlen = maxWidth - builder.length();
        	while(strlen-- > 0) builder.append(' ');
        	result.add(builder.toString());
        }
        
        return result;
    }
}
