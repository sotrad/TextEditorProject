package acceptancetests;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.text.BadLocationException;

import org.junit.jupiter.api.Test;

import view.Text2SpeechEditorView;

class TestUS4 {

	@Test
	void test() throws BadLocationException {
		
		Text2SpeechEditorView test = new Text2SpeechEditorView();
		
		test.getCurrentDocument().openTheDocument();
		
		assertEquals("TestUS4",test.getCurrentDocument().getContent().get(0));
	}

}
