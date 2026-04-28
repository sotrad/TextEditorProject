package acceptancetests;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.text.BadLocationException;

import org.junit.jupiter.api.Test;

import text2speechapis.FakeTextToSpeechAPI;
import view.Text2SpeechEditorView;

class TestUS12 {

	@Test
	void test() throws BadLocationException {
		Text2SpeechEditorView test = new Text2SpeechEditorView();
		FakeTextToSpeechAPI fake=new FakeTextToSpeechAPI(test.getCurrentDocument().getContent());		
		test.getCurrentDocument().getAudioManager().setVolume(66);
		test.getVolume();
		assertEquals(test.getCurrentDocument().getAudioManager().getVolume(),fake.getVolume());		
	}
	
	@Test
	void test1() throws BadLocationException {
		Text2SpeechEditorView test = new Text2SpeechEditorView();
		FakeTextToSpeechAPI fake=new FakeTextToSpeechAPI(test.getCurrentDocument().getContent());
		test.getCurrentDocument().getAudioManager().setPitch(300);
		test.getPitch();
		assertEquals(test.getCurrentDocument().getAudioManager().getPitch(),fake.getPitch());
	}
	
	@Test
	void test2() throws BadLocationException {
		Text2SpeechEditorView test = new Text2SpeechEditorView();
		FakeTextToSpeechAPI fake=new FakeTextToSpeechAPI(test.getCurrentDocument().getContent());
		test.getCurrentDocument().getAudioManager().setRate(200);
		test.getRate();
		assertEquals(test.getCurrentDocument().getAudioManager().getRate(),fake.getRate());
	}
	

}
