package acceptancetests;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.text.BadLocationException;

import org.junit.jupiter.api.Test;

import view.Text2SpeechEditorView;

class TestUS3 {

	@Test
	void test() throws BadLocationException, InterruptedException {
		
		Text2SpeechEditorView test = new Text2SpeechEditorView();
		test.getCurrentDocument().getT().setText("TestUS3");
		
		test.getCurrentDocument().saveTheDocument();
		test.getCurrentDocument().openTheDocument();
		
		assertEquals("TestUS3",test.getCurrentDocument().getContent().get(0));
	}

}
