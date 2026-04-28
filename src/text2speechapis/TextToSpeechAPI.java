package text2speechapis;

public interface TextToSpeechAPI {
	public void play(String s);
	public void setVolume(int i);
	public int getVolume();
	public void setPitch (int i);
	public int getPitch ();
	public void setRate(int i);
	public int getRate();
}
