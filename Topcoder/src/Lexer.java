import java.util.ArrayList;


public class Lexer {
	public String[] tokenize(String[] tokens, String line) {
		ArrayList<String> ans = new ArrayList<String>();
		while(!line.equals("")) {
			int max = Integer.MIN_VALUE;
			String found = "";
			for(String token : tokens) {
				if(line.startsWith(token) && max<token.length()) {
					max = token.length();
					found = token;
				}
			}
			if(!found.equals("")) {
				line.replaceFirst(found, "");
				
				ans.add(found);
			} else {
				line.substring(1);
			}
		}
		return (String[]) ans.toArray();
	}
}
