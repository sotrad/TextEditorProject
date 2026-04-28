package encodingstrategies;

public class AtBashEncoding extends TemplateEncoding {

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
		if (Character.isLetter(c) && c >= 'A' && c <= 'Z' ) {
            int newChar = ('Z' - c) + 'A';
            return (char) newChar;
        }else if(Character.isLetter(c) && c >= 'a' && c <= 'z')	{
        	int newChar = ('z' - c) + 'a';
            return (char) newChar;
        }
		return c;	
	}
}
