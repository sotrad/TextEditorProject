package text2speechapis;



public class TextToSpeechAPIFactory {
	
	private TextToSpeechAPI ttsAPI;
	
	public TextToSpeechAPI createTTSAP(String s) {
		if(s.equals("A")) {
			ttsAPI= new FreeTTSAdapter();
			return  ttsAPI;
		}else if(s.equals("B")) {
			ttsAPI = new FakeTextToSpeechAPI();
			return ttsAPI;
		}	
		return null;		
	}
}
