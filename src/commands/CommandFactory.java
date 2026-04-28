package commands;


import model.Document;

public class CommandFactory  {
	
	private Document currentdoc;
	private ReplayManager replayManager;
	private NewDocument newDocument;
	private ExitDocument exitDocument;
	private OpenDocument openDocument;
	private SaveDocument saveDocumen;
	private EditDocument editDocument;
	private LineToSpeech lineToSpeech;
	private DocumentToSpeech documentToSpeech;
	private TuneEncoding tuneEncoding;
	private TuneAudio tuneAudio;
	private ReplayCommand replayCommand;
	
	public CommandFactory(Document doc){
		this.currentdoc = doc;	
	}
	
	public CommandFactory() {
	}

	public ActionListener createCommand(String commandKey) {
		String s =commandKey;
		
		if(s.equals("New")) {
			newDocument = new NewDocument(currentdoc);
			return 	newDocument;
		}else if(s.equals("Exit")) {
			exitDocument =  new ExitDocument(currentdoc);
			return exitDocument;
		}else if(s.equals("Open")) {
			openDocument = new OpenDocument(currentdoc);
			return openDocument;
		}else if(s.equals("Save")) {
			saveDocumen = new SaveDocument(currentdoc);
			return saveDocumen;
		}else if(s.equals("Cut")||s.equals("Paste")||s.equals("Copy")) {
			editDocument = new EditDocument(currentdoc);
			return editDocument;
		}else if(s.equals("Line to Speech")) {
			 lineToSpeech = new LineToSpeech(currentdoc);
			return lineToSpeech;
		}else if(s.equals("Document to Speech")) {
			 documentToSpeech = new DocumentToSpeech(currentdoc);
			return documentToSpeech;
		}else if(s.equals("Reverse Document to Speech")) {
			documentToSpeech = new DocumentToSpeech(currentdoc);
			return documentToSpeech;
		}else if(s.equals("Reverse Line to Speech")) {
			lineToSpeech = new LineToSpeech(currentdoc);
			return lineToSpeech;
		}else if(s.equals("Tune Encoding")) {
			tuneEncoding = new TuneEncoding(currentdoc);
			return  tuneEncoding;
		}else if(s.equals("Audio Encoding")) {
			tuneAudio = new TuneAudio(currentdoc);
			return tuneAudio;
		}else if(s.equals("Replay Command")) {
			replayCommand =  new ReplayCommand(replayManager);
			return replayCommand;
		}
				
		return null;
	}
}
