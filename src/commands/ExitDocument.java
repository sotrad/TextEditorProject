package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Document;

public class ExitDocument implements ActionListener, commands.ActionListener {
	
	private Document doc;

	public ExitDocument(Document doc) {
		this.doc = doc;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		doc.exitTheDocument();		
	}
}
