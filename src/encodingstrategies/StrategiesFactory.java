package encodingstrategies;


public class StrategiesFactory {
	
	private EncodingStrategy ret;
	private String code;
	
	public EncodingStrategy createStrategy(String s) {
		if(s.equals("A")) {
			ret= new AtBashEncoding();
			code="A";
			return  ret;
		}else if(s.equals("B")) {
			ret = new Rot13Encoding();
			code="B";
			return ret;
		}	
		return null;
	}
	
	public String getESCode() {
		return code;
	}

}

