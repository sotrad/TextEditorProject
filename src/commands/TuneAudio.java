package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Document;
import text2speechapis.FreeTTSAdapter;
import text2speechapis.TextToSpeechAPI;

public class TuneAudio implements ActionListener, commands.ActionListener {
	private Document doc ;
	
	public TuneAudio(Document doc) {
		this.doc = doc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TextToSpeechAPI audiomanager = new FreeTTSAdapter();
		String  j=JOptionPane.showInputDialog("Type A to adjust the volume, type B to adjust the voice rate or type C to adjust pitch ");
		if(j.equals("A")) {
			String  i=JOptionPane.showInputDialog(null,"Please type the desired volume level. Current volume is: "+doc.getAudioManager().getVolume());
			doc.setAudioManager(audiomanager);
			doc.getAudioManager().setVolume(Integer.parseInt(i));
		}else if(j.equals("B")){
			String  i=JOptionPane.showInputDialog(null,"Please type the desired amount of words per minute. Current rate is: "+doc.getAudioManager().getRate());
			doc.getAudioManager().setRate(Integer.parseInt(i));
		}else if(j.equals("C")) {
			String  i=JOptionPane.showInputDialog(null,"Please type the desired frequency of the voice pitch in Hz. Current pitch is: "+doc.getAudioManager().getPitch());
			doc.getAudioManager().setPitch(Integer.parseInt(i));
		}
	}

}
