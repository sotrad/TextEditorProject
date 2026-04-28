package text2speechapis;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class FreeTTSAdapter implements TextToSpeechAPI{
	
	private VoiceManager vm;
	private Voice voice;
	
	public FreeTTSAdapter(){
	    System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		vm = VoiceManager.getInstance();				
		voice = vm.getVoice("kevin");
		voice.allocate();
	}
	
	@Override
	public void play(String s) {	
		voice.speak(s);
	}

	@Override
	public void setVolume(int i) {
		voice.setVolume(i);
	}

	@Override
	public void setPitch(int i) {
		voice.setPitch(i);	
	}

	@Override
	public void setRate(int i) {
		voice.setRate(i);		
	}
	
	public int getVolume() {
		return (int) voice.getVolume();
	}
	
	public int getPitch() {
		return (int) voice.getPitch();	
	}

	public int getRate() {
		return (int) voice.getRate();		
	}

}
