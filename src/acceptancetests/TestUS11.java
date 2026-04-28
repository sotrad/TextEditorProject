package acceptancetests;

import static org.junit.jupiter.api.Assertions.*;
import javax.swing.text.BadLocationException;
import org.junit.jupiter.api.Test;
import encodingstrategies.EncodingStrategy;
import encodingstrategies.StrategiesFactory;
//import text2speechapis.FakeTextToSpeechAPI;
import view.Text2SpeechEditorView;

class TestUS11 {

	@Test
	void test() throws BadLocationException {
		Text2SpeechEditorView test = new Text2SpeechEditorView();
		//FakeTextToSpeechAPI fake=new FakeTextToSpeechAPI(test.getCurrentDocument().getContent());
		String str="A";
		
		StrategiesFactory strfac = new StrategiesFactory();
		EncodingStrategy es = strfac.createStrategy(str);
		
		test.getCurrentDocument().getT().setText("TestUS11\n"+"Tune Encoding");
		test.getCurrentDocument().tuneEncodingStrategy(es);
		test.getCurrentDocument().playEncodedContents();
				
		assertTrue(strfac.getESCode().equals("A"));
		
	}

}
