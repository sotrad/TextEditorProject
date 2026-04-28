package commands;


import java.awt.event.ActionEvent;
//import java.util.LinkedList;

import view.Text2SpeechEditorView;

public class ReplayManager extends Text2SpeechEditorView{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8995945762083720968L;

	public void replay() {		
		for(int i = 0;i < getSequence().size();i++) {
			actionPerformed((ActionEvent) getSequence().get(i));
		}				
	}  
}
