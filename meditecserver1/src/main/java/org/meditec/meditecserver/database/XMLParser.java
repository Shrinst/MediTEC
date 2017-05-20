package org.meditec.meditecserver.database;

import org.xml.sax.*;
import org.w3c.dom.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.*;

import org.meditec.meditecserver.model.*;

/**
 * 
 * @author Emmanuelle
 *
 */
public class XMLParser {
	
	
	/**
	 * Read a XML File and save them into new objects
	 * @return the list of read objects
	 */
	public static List<MedicalTest> getNodes() {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		List<MedicalTest> medicalTests = new ArrayList<>();
		MedicalTest medicalTest;
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("./src/main/java/org/meditec/meditecserver/xmlFiles/NewFile1.xml");
			NodeList nodeList = doc.getElementsByTagName("Node");
			
			for (int i = 0; i < nodeList.getLength(); i++) {
				
				medicalTest = new MedicalTest();
				
				Node node = nodeList.item(i);
				
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					NodeList children = element.getChildNodes();
					
					for (int j = 0; j < children.getLength(); j++) {
						Node n = children.item(j);
						
						if (n.getNodeType() == Node.ELEMENT_NODE) {
							Element name = (Element) n;
							
							switch (name.getTagName()) {
							case "cost":
								medicalTest.setCost(Long.parseLong(name.getTextContent()));
								break;
							case "patientName":
								medicalTest.setPatientName(name.getTextContent());
								break;
							case "type":
								medicalTest.setType(name.getTextContent());
								break;
							case "result":
								medicalTest.setResult(name.getTextContent());
								break;
							}				
						}
					}
					
					medicalTests.add(medicalTest);
				}
			}
			
			return medicalTests;
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		return null;
		
	}

}
