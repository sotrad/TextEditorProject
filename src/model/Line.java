package model;

import java.util.ArrayList;

import encodingstrategies.EncodingStrategy;
import text2speechapis.FreeTTSAdapter;
import text2speechapis.TextToSpeechAPI;

public class Line {
	
	private ArrayList<String> words = new ArrayList<String>();
	private int theLine;
	private String encodedLine; 
	private TextToSpeechAPI audiomanager;
	private EncodingStrategy encodingStrategy;
	
	public Line(ArrayList<String> words,int l) {
		this.words = words;
		this.theLine = l;
	}
	
	public void  playLine() {
		audiomanager = new FreeTTSAdapter();
		audiomanager.play(words.get(theLine));
	}
	
	public void playReverseLine() {
		audiomanager = new FreeTTSAdapter();
		String[]arrSplit = words.get(theLine).split(" ");
	    for (int j=arrSplit.length-1; j >=0 ; j--)
	    {
	      audiomanager.play(arrSplit[j]);
	    }	
	}
	
	public void playEncodedLine() {
		audiomanager = new FreeTTSAdapter();
		audiomanager.play(encodedLine);
	}
	
	public String getEncodedLine() {
		return encodedLine;
	}
	
	public void tuneEncodingStrategy(EncodingStrategy es) {
		encodingStrategy = es;
		encodedLine = encodingStrategy.encode(words.get(theLine));
	}
}
