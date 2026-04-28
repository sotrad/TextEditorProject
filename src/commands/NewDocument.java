package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Document;


public class NewDocument implements ActionListener, commands.ActionListener {

	private Document doc ;
	
	public NewDocument(Document doc) {
		this.doc = doc;
	}

	@Override
	
	public void actionPerformed(ActionEvent e) {
		doc.createNewDocument();
	}	
}
