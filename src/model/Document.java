package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import encodingstrategies.EncodingStrategy;
import text2speechapis.FakeTextToSpeechAPI;
import text2speechapis.FreeTTSAdapter;
import text2speechapis.TextToSpeechAPI;
import view.Text2SpeechEditorView;

public class Document extends Text2SpeechEditorView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7014818317902487395L;
	
	private String author;
	private String title;
	private String date;
	private String lastsavedate;
	private ArrayList<String> content;
	private String encodedText;
	private TextToSpeechAPI audiomanager;
	private EncodingStrategy encodingStrategy;
	private Line contents;
	private FakeTextToSpeechAPI fake;
	
	public Document() {
		this.author = "";
		this.title = "";
		this.date = "";
		this.lastsavedate ="";
		this.encodedText = "";
		this.audiomanager = new FreeTTSAdapter();
		this.content = new ArrayList<String>();
		this.fake= new FakeTextToSpeechAPI(content);
	}
	
	//Plays the contents 
	public void playContents() throws BadLocationException {
		
		content = new ArrayList<String>();
		int lines = getT().getLineCount();
		for(int i = 0; i < lines; i ++){
			int start = getT().getLineStartOffset(i);
            int end = getT().getLineEndOffset(i);
            String theLine = getT().getText(start, end-start);
            content.add(theLine);
            fake.play(theLine);
		}
		String Text;
		Text = getT().getText();
		audiomanager.play(Text);		
	}
	
	//Reverses the contents and plays them
	public void playReverseContents() throws BadLocationException {
		content = new ArrayList<String>();
		int lines = getT().getLineCount();
		for(int i = 0; i < lines; i ++){
			int start = getT().getLineStartOffset(i);
            int end = getT().getLineEndOffset(i);
            String theLine = getT().getText(start, end-start);
            content.add(theLine);         
		}
		String[] arrSplit;
		for(int i=content.size()-1; i>=0; i--){				
			arrSplit = content.get(i).split(" ");
			fake.play(content.get(i));
		    for (int j=arrSplit.length-1; j >=0 ; j--)
		    {
		      audiomanager.play(arrSplit[j]);	      
		    }			
        }		
	}	
	
	//Plays the encoded contents
	public void playEncodedContents() {	
		for(int i = 0;i<content.size();i++) {
			audiomanager.play(content.get(i));
			fake.play(content.get(i));
		}		
	}
	
	//A line encoded and gets played
	public void playEncodedLine(int l, EncodingStrategy es) throws BadLocationException {
		content = new ArrayList<String>();
		int lines = getT().getLineCount();	
		for(int i = 0; i < lines; i ++){
			int start = getT().getLineStartOffset(i);
            int end = getT().getLineEndOffset(i);
            String theLine = getT().getText(start, end-start);
            content.add(theLine);            
		}	
		contents= new Line(content,l);
		contents.tuneEncodingStrategy(es);
		contents.playEncodedLine();
		content.set(l,contents.getEncodedLine());
		fake.play(contents.getEncodedLine());
	}
	
	//The content encoded
	public void tuneEncodingStrategy(EncodingStrategy es) throws BadLocationException {
		encodingStrategy = es;		
		content = new ArrayList<String>();
		int lines = getT().getLineCount();
		for(int i = 0; i < lines; i ++){
			int start = getT().getLineStartOffset(i);
            int end = getT().getLineEndOffset(i);
            String theLine = getT().getText(start, end-start);
            encodedText = encodingStrategy.encode(theLine);
            content.add(encodedText);
		}
	}
	
	//A given line gets played
	public void playLine(int l) throws BadLocationException {			
		content = new ArrayList<String>();
		int lines = getT().getLineCount();
		for(int i = 0; i < lines; i ++){
			int start = getT().getLineStartOffset(i);
            int end = getT().getLineEndOffset(i);
            String theLine = getT().getText(start, end-start);
            content.add(theLine);
            fake.play(theLine);
		}		
		contents= new Line(content,l);
		contents.playLine();	
	}
	
	// A given line gets reversed and then played 
	public void playReverseLine(int l) throws BadLocationException {
		content = new ArrayList<String>();
		int lines = getT().getLineCount();
		for(int i = 0; i < lines; i ++){
			int start = getT().getLineStartOffset(i);
            int end = getT().getLineEndOffset(i);
            String theLine = getT().getText(start, end-start);
            content.add(theLine);
            fake.play(theLine);
		}
		contents= new Line(content,l);
		contents.playReverseLine();
	}
	
	//Creates a new document
	public void createNewDocument() {
		content = new ArrayList<String>();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  	   
		LocalDateTime now = LocalDateTime.now();
		date = dtf.format(now); 
		author=JOptionPane.showInputDialog(null,"What's your name?");
		title=JOptionPane.showInputDialog(null,"What's the document's title?");
		//date=now.toString();
		getF().setTitle("Title: "+ title + " by "+ author+" created on " + date);		
	}
	
	//Closes the editor
	public void exitTheDocument() {
		getF().setVisible(false);	
	}
	
	//Opens a document from the hard drive
	public void openTheDocument() {
		JFileChooser j = new JFileChooser("c:"); 
		BufferedReader br;
		
		// Invoke the showsOpenDialog function to show the save dialog 
		int r = j.showOpenDialog(null); 

		// If the user selects a file 
		if (r == JFileChooser.APPROVE_OPTION) { 
			// Set the label to the path of the selected directory 
			File fi = new File(j.getSelectedFile().getAbsolutePath()); 

			try { 
				// String 
				String s1 = "", sl = ""; 

				// File reader 
				FileReader fr = new FileReader(fi); 

				br = new BufferedReader(fr); 

				// Initilize sl 
				sl = br.readLine(); 

				// Take the input from the file 
				while ((s1 = br.readLine()) != null) { 
					sl = sl + "\n" + s1; 
				} 

				// Set the text 
				getT().setText(sl); 
				content = new ArrayList<String>();
				int lines = getT().getLineCount();
				for(int i = 0; i < lines; i ++){
					int start = getT().getLineStartOffset(i);
		            int end = getT().getLineEndOffset(i);
		            String theLine = getT().getText(start, end-start);
		            content.add(theLine);
				}
			} 
			catch (Exception evt) { 
				JOptionPane.showMessageDialog(getF(), evt.getMessage()); 
			} 
		} 
		// If the user cancelled the operation 
		else
			JOptionPane.showMessageDialog(getF(), "The user cancelled the operation"); 
	} 
	
	//Saves the current document to the hard drive
	public void saveTheDocument() {
		JFileChooser j = new JFileChooser("f:"); 		

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  	   
		LocalDateTime now = LocalDateTime.now();
		lastsavedate = dtf.format(now); 
		
		// Invoke the showsSaveDialog function to show the save dialog 
		int r = j.showSaveDialog(null); 

		if (r == JFileChooser.APPROVE_OPTION) { 

			// Set the label to the path of the selected directory 
			File fi = new File(j.getSelectedFile().getAbsolutePath()); 

			try { 
				// Create a file writer 
				FileWriter wr = new FileWriter(fi, false); 

				// Create buffered writer to write 
				BufferedWriter w = new BufferedWriter(wr); 

				// Write
				content = new ArrayList<String>();
				int lines = getT().getLineCount();
				for(int i = 0; i < lines; i ++){
					int start = getT().getLineStartOffset(i);
		            int end = getT().getLineEndOffset(i);
		            String theLine = getT().getText(start, end-start);
		            content.add(theLine);
		            w.write(theLine);
				}
				getF().setTitle("Title: "+ title + " by "+ author+" created on " + date+" saved on "+lastsavedate);
				w.flush(); 
				w.close(); 
			} 
			catch (Exception evt) { 
				JOptionPane.showMessageDialog(getF(), evt.getMessage()); 
			} 
		} 
		// If the user cancelled the operation 
		else
			JOptionPane.showMessageDialog(getF(), "You cancelled the operation"); 
	}
	
	//Cuts the selected contents from the editor
	public void cutContent(){
		getT().cut();
	}
	
	//Pastes the selected contents from the clipboard
	public void pasteContent() {
		getT().paste();		
	}
	
	//Copies the selected content from the editor
	public void copyContent() {
		getT().copy();	
	}
	
	public TextToSpeechAPI getAudioManager() {
		return audiomanager;
	}
	
	//Sets FreeTTSAdapter's audiomanager
	public void setAudioManager(TextToSpeechAPI am) {
		audiomanager = am;
	}
	
	//When the user edits the text this methods updates the contents
	public ArrayList<String> getChangedContent() throws BadLocationException { 
		
		content = new ArrayList<String>();
		int lines = getT().getLineCount();
		for(int i = 0; i < lines; i ++){
			int start = getT().getLineStartOffset(i);
		    int end = getT().getLineEndOffset(i);
		    String theLine = getT().getText(start, end-start);
		    content.add(theLine);
		}
		return content;
	}
	
	public ArrayList<String> getContent() throws BadLocationException {
		return content;
	}

	public FakeTextToSpeechAPI getFake() {
		return fake;
	}		
}
