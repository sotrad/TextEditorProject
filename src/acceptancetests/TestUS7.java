package acceptancetests;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.text.BadLocationException;

import org.junit.jupiter.api.Test;

import text2speechapis.FakeTextToSpeechAPI;
import view.Text2SpeechEditorView;

class TestUS7 {

	@Test
	void test() throws BadLocationException {
		
		Text2SpeechEditorView test = new Text2SpeechEditorView();
		FakeTextToSpeechAPI fake=new FakeTextToSpeechAPI(test.getCurrentDocument().getContent());
		
		test.getCurrentDocument().getT().setText("TestUS7\n"+"Reverse Document To Speech");
		test.getCurrentDocument().playReverseContents();
		
		int size = test.getCurrentDocument().getContent().size();
		
		for(int i=0;i<size;i++) {
			assertEquals(test.getCurrentDocument().getContent().get(size-1-i),fake.getFakeContent().get(i));
		}
		
			
		
	}


}
