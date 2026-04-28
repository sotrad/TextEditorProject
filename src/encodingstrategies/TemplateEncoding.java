package encodingstrategies;

public abstract class TemplateEncoding implements EncodingStrategy {
	
	public TemplateEncoding() {		
	}

	@Override
	public String encode(String s) {		
		return null;
	}
	
	protected abstract char mapCharacter(char c);
}
