package acceptancetests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import javax.swing.text.BadLocationException;

import org.junit.jupiter.api.Test;
import view.Text2SpeechEditorView;



class TestUS1 {

	@Test
	void test() throws BadLocationException {
		Text2SpeechEditorView test = new Text2SpeechEditorView();
		test.getCurrentDocument().createNewDocument();
		ArrayList<String> input = new ArrayList<String>();
		input = test.getCurrentDocument().getContent();
		assertTrue(input.isEmpty());
	}

}
