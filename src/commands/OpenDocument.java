package commands;

import java.awt.event.ActionEvent;
import model.Document;

public class OpenDocument  implements ActionListener{
	
    private Document doc;  

	public OpenDocument(Document doc) {  
        this.doc = doc;  
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		doc.openTheDocument();
	}		
}
