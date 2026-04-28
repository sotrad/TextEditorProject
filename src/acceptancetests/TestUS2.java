package acceptancetests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import javax.swing.text.BadLocationException;

import org.junit.jupiter.api.Test;
import view.Text2SpeechEditorView;

class TestUS2 {

	@Test
	void test() throws BadLocationException {
		
		Text2SpeechEditorView test = new Text2SpeechEditorView();
		
		ArrayList<String> input1 = new ArrayList<String>();
		ArrayList<String> input2 = new ArrayList<String>();
		
		input1 = test.getCurrentDocument().getChangedContent();
		
		test.getCurrentDocument().pasteContent();
		
		input2 = test.getCurrentDocument().getChangedContent();
		
		assertTrue(input2.get(0).contains("TestUS2"));	
		assertTrue(input1!=input2);
	}

}
