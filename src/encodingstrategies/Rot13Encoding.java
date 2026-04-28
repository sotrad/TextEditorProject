package encodingstrategies;

public class Rot13Encoding extends TemplateEncoding {

	public String encode(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			char c1 = mapCharacter(c);
			sb.append(c1);	           
	     }
		 return sb.toString();
	}
	
	protected char mapCharacter(char c) {
		if(c >= 'a' && c <= 'm') c += 13;
        else if(c >= 'A' && c <= 'M') c += 13;
        else if(c >= 'n' && c <= 'z') c -= 13;
        else if(c >= 'N' && c <= 'Z') c -= 13;
		return c;	
	}

}
