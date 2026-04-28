package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.text.BadLocationException;

import model.Document;

public class DocumentToSpeech implements ActionListener, commands.ActionListener {
	
	private Document doc;
	
	public DocumentToSpeech(Document doc) {
		this.doc = doc;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if(s.equals("Document to Speech")) {
			try {
				doc.playContents();
			} catch (BadLocationException e1) {
				
				e1.printStackTrace();
			}
		}else if(s.equals("Reverse Document to Speech")){
			try {
				doc.playReverseContents();
			} catch (BadLocationException e1) {
				
				e1.printStackTrace();
			}
		}				
	}
}
