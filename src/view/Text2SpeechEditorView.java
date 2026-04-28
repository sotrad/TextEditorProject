package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import commands.CommandFactory;

import model.Document;

public class Text2SpeechEditorView extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextArea t = new JTextArea();
	private JFrame f = new JFrame();
	private static Text2SpeechEditorView t2sev = null;	
	private static Document currentdoc = new Document(); 
	private static CommandFactory commandFactory = new CommandFactory(currentdoc);
	private ArrayList<ActionEvent> sequence = new ArrayList <ActionEvent>();
	
    @SuppressWarnings("deprecation")
	public Text2SpeechEditorView(){ 
        // Create a frame 
        setF(new JFrame("Text 2 Speech Editor")); 
        
        try {  
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");             
        } 
        catch (Exception e) { 
        } 
  
        // Text component 
        setT(new JTextArea()); 
  
        // Create the  menu bar 
        JMenuBar mb = new JMenuBar(); 
  
        // Create menu for document 
        JMenu m1 = new JMenu("File"); 
        

        // Create document items 
        JMenuItem mi1 = new JMenuItem("New"); 
        JMenuItem mi2 = new JMenuItem("Open"); 
        JMenuItem mi3 = new JMenuItem("Save"); 
         
        // Add action listener 
        mi1.addActionListener(this); 
        mi2.addActionListener(this); 
        mi3.addActionListener(this); 
          
        m1.add(mi1); 
        m1.add(mi2); 
        m1.add(mi3); 
        
        
        
        // Create a menu for editing documents 
        JMenu m2 = new JMenu("Edit"); 
  
        // Create editing items 
        JMenuItem mi4 = new JMenuItem("Cut"); 
        JMenuItem mi5 = new JMenuItem("Copy"); 
        JMenuItem mi6 = new JMenuItem("Paste"); 
  
        // Add action listener 
        mi4.addActionListener(this); 
        mi5.addActionListener(this); 
        mi6.addActionListener(this); 
  
        m2.add(mi4); 
        m2.add(mi5); 
        m2.add(mi6); 
        
        // Create a menu for transforming text document to speech 
        JMenu m3 = new JMenu("Text2Speech"); 
  
        // Create text document to speech  items 
        JMenuItem mi7 = new JMenuItem("Document to Speech"); 
        JMenuItem mi11 = new JMenuItem("Reverse Document to Speech");
        JMenuItem mi8 = new JMenuItem("Line to Speech"); 
        JMenuItem mi12 = new JMenuItem("Reverse Line to Speech"); 
               
        // Add action listener 
        mi7.addActionListener(this); 
        mi8.addActionListener(this);  
        mi11.addActionListener(this); 
        mi12.addActionListener(this); 
        m3.add(mi7); 
        m3.add(mi8); 
        m3.add(mi11); 
        m3.add(mi12); 

        // Create a menu for tuning text document
        JMenu m4 = new JMenu("Tune"); 
        
        // Create menu encoding items 
        JMenuItem mi9 = new JMenuItem("Tune Encoding"); 
        JMenuItem mi10 = new JMenuItem("Audio Encoding"); 
         
        // Add action listener 
        mi9.addActionListener(this); 
        mi10.addActionListener(this); 
        
        m4.add(mi9); 
        m4.add(mi10); 
        
        // Create a menu item for replaying commands
        JMenuItem m5 = new JMenuItem("Replay Command");
        
        // Add action listener 
        m5.addActionListener(this); 
        
        // Create a menu item for exit from the editor
        JMenuItem mc = new JMenuItem("Exit"); 
        
        // ToolTips
        mi1.setToolTipText("Create a new document");
        mi2.setToolTipText("Open a document");
        mi3.setToolTipText("Save a document");
        mi4.setToolTipText("Cut highlighted content");
        mi5.setToolTipText("Copy highlighted content");
        mi6.setToolTipText("Paste from clipboard");
        mi7.setToolTipText("Transform document to speech");
        mi11.setToolTipText("Reverse & transform document to speech");
        mi9.setToolTipText("Encode and play the document");
        mi10.setToolTipText("Choose audio parameters");
        mi8.setToolTipText("Transform desired line to speech");
        mi12.setToolTipText("Reverse & transform desired line to speech");
        m5.setToolTipText("Currently not functioned");
        mc.setToolTipText("Close editor window");
        
        mc.addActionListener(this); 
  
        mb.add(m1); 
        mb.add(m2); 
        mb.add(m3);
        mb.add(m4);
        mb.add(m5);
        mb.add(mc); 
        
        getF().setJMenuBar(mb); 
        getF().add(getT()); 
        getF().setSize(500,500); 
        getF().show(); 
    } 
       
	public boolean isReversed() {
		return false;		
	}
	
	public boolean isEncoded() {
		return false;		
	}
	
	public int getVolume() { // Returns the current volume of the audio manager and sets its for the Fake API
		currentdoc.getFake().setVolume(currentdoc.getAudioManager().getVolume());
		return currentdoc.getAudioManager().getVolume();	
	}
	
	public int getRate() { // Returns the current rate of the audio manager and sets its for the Fake API
		currentdoc.getFake().setRate(currentdoc.getAudioManager().getRate());
		return currentdoc.getAudioManager().getRate();	
	}
	
	public int getPitch() { // Returns the pitch volume of the audio manager and sets its for the Fake API
		currentdoc.getFake().setPitch(currentdoc.getAudioManager().getPitch());
		return currentdoc.getAudioManager().getPitch();		
	}
	
	public Document getCurrentDocument() {
		return currentdoc;		
	}
	
	public static void setCurrentDocument(Document doc) {
		currentdoc = doc;		
	} 
			
	public static Text2SpeechEditorView getSingletonView() {
		if(t2sev == null) {
			t2sev = new Text2SpeechEditorView();
		}
		return t2sev;		
	}
	
	public JTextArea getT() {
		return t;
	}

	public void setT(JTextArea t) {
		this.t = t;
	}
	
	public JFrame getF() {
		return f;
	}
	
	public void setF(JFrame f) {
		this.f = f;
	}
	
	//List of commands given so far by the user
	public ArrayList <ActionEvent> getSequence() {
		return sequence;
	}
	
	//Creates a command factory to process the commands given by the user
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if(s.equals("New")) {
			//Document ndoc = new Document();
			commandFactory = new CommandFactory(currentdoc);
			setCurrentDocument(currentdoc);
			commandFactory.createCommand(s).actionPerformed(e);		
		}else {
			commandFactory.createCommand(s).actionPerformed(e);	
		}
		sequence.add(e);
	}
	
	public static void main(String[] args) {								
	}
}