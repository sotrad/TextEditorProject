package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Document;

public class EditDocument implements ActionListener, commands.ActionListener {
	
	private Document doc;
	
	public EditDocument(Document doc) {
		this.doc = doc;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if(s.equals("Copy")) {
			doc.copyContent();
		}else if (s.equals("Cut")) {
			doc.cutContent();
		}else if(s.equals("Paste")) {
			doc.pasteContent();
		}
	}
}
