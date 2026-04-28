package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ReplayCommand implements ActionListener, commands.ActionListener {
		
	private ReplayManager  replayManager ;
	
	public ReplayCommand(ReplayManager replayManager) {
		this.replayManager = replayManager;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		replayManager.replay();
	}
}
