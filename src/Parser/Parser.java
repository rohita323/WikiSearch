package Parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import Parser.WikiPage;
import Parser.StopWordsRemover;

public class Parser {
	static final String PAGE = "page";
	static final String ID = "id";
	static final String TITLE = "title";
	static final String TEXT = "text";
	static final String REVISION = "revision";

	
	@SuppressWarnings({ "unchecked", "null" })
	public List<WikiPage> readConfig(String configFile) {
		List<WikiPage> items = new ArrayList<WikiPage>();
				 
		
		try {
			int flag=0;
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			InputStream in = new FileInputStream(configFile);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			WikiPage page = null;
			StopWordsRemover Stop = new StopWordsRemover();

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();

				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					
					if (startElement.getName().getLocalPart() == (PAGE)) {
						page = new WikiPage();
						flag=1;
					}
					if (startElement.getName().getLocalPart() == (REVISION)) {
						flag=2;
						}
					
					if (event.isStartElement()) {
						if (flag==1 && event.asStartElement().getName().getLocalPart()
								.equals(ID)) {
							event = eventReader.nextEvent();
							page.setId(event.asCharacters().getData());
//							System.out.println("Page Id: "+ page.getId());
							continue;
						}
					}
					
					if (event.isStartElement()) {
						if (flag==2 && event.asStartElement().getName().getLocalPart()
								.equals(TEXT)) {
							String txt = eventReader.getElementText().replaceAll("\\p{P}+|<|>|=|\\|", " ").replaceAll("\\s+"," ");
							page.setText(Stop.Remove(txt));
							event = eventReader.nextEvent();
						
							continue;
						}
					}
					
					if (flag ==1 && event.asStartElement().getName().getLocalPart()
							.equals(TITLE)) {
						event = eventReader.nextEvent();
						page.setTitle(event.asCharacters().getData());
						continue;
					}

				}

				
				// If we reach the end of an item element, we add it to the list
				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart() == (PAGE)) {
						items.add(page); flag=0;
					}
					if (endElement.getName().getLocalPart() == (REVISION)) {
						flag=1;
					}
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		return items;
	}
}