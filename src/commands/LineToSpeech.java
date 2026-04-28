package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;

import model.Document;


public class LineToSpeech implements ActionListener, commands.ActionListener {
	
	private Document doc;
	
	public LineToSpeech(Document doc) {
		this.doc = doc;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String i=JOptionPane.showInputDialog(null,"Give the line number ?");
		
		String s = e.getActionCommand();
		if(s.equals("Reverse Line to Speech")) {
			try {
				doc.playReverseLine(Integer.parseInt(i)-1);
			} catch (NumberFormatException | BadLocationException e1) {
				
				e1.printStackTrace();
			}
		}else {
			try {
				doc.playLine(Integer.parseInt(i)-1);
			} catch (NumberFormatException e1) {
				
				e1.printStackTrace();
			} catch (BadLocationException e1) {
				
				e1.printStackTrace();
			}
		}	
	}
}
