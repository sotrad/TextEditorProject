package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;

import encodingstrategies.EncodingStrategy;
import encodingstrategies.StrategiesFactory;
import model.Document;

public class TuneEncoding implements ActionListener, commands.ActionListener {
	
	private Document doc ;
	
	public TuneEncoding(Document doc) {
		this.doc = doc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String str=JOptionPane.showInputDialog(null,"Type A for At Bash Encoding or B for Rot13 Encoding");
		StrategiesFactory strfac = new StrategiesFactory();		
		String strC=JOptionPane.showInputDialog(null,"Type A to encode the whole content or B to select a line to encode");
		
		if(strC.equals("A")) {
			
			EncodingStrategy es = strfac.createStrategy(str);
			try {
				doc.tuneEncodingStrategy(es);
			} catch (BadLocationException e1) {
				
				e1.printStackTrace();
			}
			doc.playEncodedContents();
		}else if(strC.equals("B")) {
			
			String  ic=JOptionPane.showInputDialog(null,"Which line do you want to encode?");			
			try {
				EncodingStrategy es = strfac.createStrategy(str);
				doc.playEncodedLine(Integer.parseInt(ic),es);
			} catch (NumberFormatException e1) {
				
				e1.printStackTrace();
			} catch (BadLocationException e1) {
				
				e1.printStackTrace();
			}
		}
		

	}

}
