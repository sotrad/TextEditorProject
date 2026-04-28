package acceptancetests;

import static org.junit.jupiter.api.Assertions.*;
import javax.swing.text.BadLocationException;
import org.junit.jupiter.api.Test;
import encodingstrategies.EncodingStrategy;
import encodingstrategies.StrategiesFactory;
import text2speechapis.FakeTextToSpeechAPI;
import view.Text2SpeechEditorView;

class TestUS9 {

	@Test
	void test() throws BadLocationException {
		Text2SpeechEditorView test = new Text2SpeechEditorView();
		FakeTextToSpeechAPI fake=new FakeTextToSpeechAPI(test.getCurrentDocument().getContent());
		String str="A";
		
		StrategiesFactory strfac = new StrategiesFactory();
		EncodingStrategy es = strfac.createStrategy(str);
		test.getCurrentDocument().getT().setText("TestUS9\n"+"Encoded Document To Speech");
		test.getCurrentDocument().tuneEncodingStrategy(es);
		test.getCurrentDocument().playEncodedContents();
			
		assertTrue(test.getCurrentDocument().getContent().equals(fake.getFakeContent()));
		
		
		
		
	}

}
