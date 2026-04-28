package text2speechapis;

import java.util.ArrayList;



public class FakeTextToSpeechAPI implements TextToSpeechAPI {
	private ArrayList<String> content=new ArrayList<String>();
	
	public FakeTextToSpeechAPI(ArrayList <String> c) {
		content=c;
	}
	
	public FakeTextToSpeechAPI() {		
	}
	
	@Override
	public void play(String s) {
		content.add(s);
	}
	
	public ArrayList<String> getFakeContent(){	
		return this.content;
	}

	@Override
	public void setVolume(int i) {	
		content.add(String.valueOf(i));		
	}

	@Override
	public void setPitch(int i) {		
		content.add(String.valueOf(i));		
	}

	@Override
	public void setRate(int i) {	
		content.add(String.valueOf(i));	
	}
	
	@Override
	public int getVolume() {		
		return Integer.parseInt(content.get(0));
	}
	
	@Override
	public int getPitch() {		
		return Integer.parseInt(content.get(1));
	}
	
	@Override
	public int getRate() {	
		return Integer.parseInt(content.get(2));
	}

}
