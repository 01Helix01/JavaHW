package facts;

import java.io.*;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;

public class Parser{
	private Handler handler;

	public Parser (String fileName){
		try{
			File file = new File(fileName);
			handler = new Handler();
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser =  factory.newSAXParser();
			saxParser.parse (file, handler);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public FactList getFactList(){
		return handler.getList();
	}

	public void addFactToXML(Fact fact, String fileName) {
        // Create a new instance of a class to handle XML writing (not provided here)
        XMLWriter xmlWriter = new XMLWriter();
        xmlWriter.addFactToXML(fact, fileName);
    }
}
