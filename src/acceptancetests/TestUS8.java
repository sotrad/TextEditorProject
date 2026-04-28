package acceptancetests;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.text.BadLocationException;

import org.junit.jupiter.api.Test;

import text2speechapis.FakeTextToSpeechAPI;
import view.Text2SpeechEditorView;

class TestUS8 {

	@Test
	void test() throws BadLocationException {
		
		Text2SpeechEditorView test = new Text2SpeechEditorView();
		FakeTextToSpeechAPI fake=new FakeTextToSpeechAPI(test.getCurrentDocument().getContent());
		
		test.getCurrentDocument().getT().setText("TestUS8\n"+"Reverse Line To Speech");
		test.getCurrentDocument().playReverseLine(1);
		
		assertTrue(test.getCurrentDocument().getContent().equals(fake.getFakeContent()));
	}

}
