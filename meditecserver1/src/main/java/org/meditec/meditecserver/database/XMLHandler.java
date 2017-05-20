package org.meditec.meditecserver.database;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Text;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class XMLHandler {

	public static void main(String[] args) {
		readXML();
	}

	public static void writeXML() {

		try {

			Document document = new Document();

			Element theRoot = new Element("tvShow");
			document.setRootElement(theRoot);

			Element show = new Element("show");
			Element name = new Element("name");

			name.setAttribute("show_id", "show_002");
			name.addContent(new Text("Life on Mars"));

			Element network = new Element("network");
			network.setAttribute("country", "US");
			network.addContent(new Text("ABC"));

			show.addContent(name);
			show.addContent(network);

			theRoot.addContent(show);

			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());

			outputter.output(document,
					new FileOutputStream(new File("./src/main/java/org/meditec/meditecserver/xmlFiles/NewFile.xml")));
			
			System.out.println("Wrote to File");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void readXML() {
		
		SAXBuilder saxBuilder = new SAXBuilder();
		
		try {
			Document readDocument = saxBuilder.build(new File("./src/main/java/org/meditec/meditecserver/xmlFiles/NewFile.xml"));
			
			System.out.println("Root: " + readDocument.getRootElement());
			
			System.out.println("Show: " + readDocument.getRootElement().getChild("show").getChildText("name"));
			
			System.out.println("Show ID: " + readDocument.getRootElement().getChild("show").getChild("name").getAttributeValue("show_id"));
			
			Element root = readDocument.getRootElement();
			
			for (Element curEle : root.getChildren("show")) {
				
				System.out.println("Show Name: " + curEle.getChildText("name"));
				
				System.out.println("Show ID: " + curEle.getChild("name").getAttributeValue("show_id"));
				
				System.out.println("On " + curEle.getChildText("network") + " in the ");	
				
				System.out.println(curEle.getChild("network").getAttributeValue("country"));
			}
			
		} catch (IOException | JDOMException e) {
			e.printStackTrace();
		}
	}

}
