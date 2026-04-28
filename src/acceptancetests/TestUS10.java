package acceptancetests;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.text.BadLocationException;

import org.junit.jupiter.api.Test;

import encodingstrategies.EncodingStrategy;
import encodingstrategies.StrategiesFactory;
import text2speechapis.FakeTextToSpeechAPI;
import view.Text2SpeechEditorView;

class TestUS10 {

	@Test
	void test() throws BadLocationException {
		
		Text2SpeechEditorView test = new Text2SpeechEditorView();
		FakeTextToSpeechAPI fake=new FakeTextToSpeechAPI(test.getCurrentDocument().getContent());
		String str="B";
		
		StrategiesFactory strfac = new StrategiesFactory();
		EncodingStrategy es = strfac.createStrategy(str);
		
		test.getCurrentDocument().getT().setText("TestUS10\n"+"Encoded Line To Speech");
		test.getCurrentDocument().playEncodedLine(1,es);
				
		assertEquals(test.getCurrentDocument().getContent().get(1),fake.getFakeContent().get(0));
		
	}

}
