package org.meditec.meditecserver.database;

import java.util.List;
import java.io.File;
import java.io.FileOutputStream;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Text;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import org.meditec.meditecserver.model.MedicalTest;

/**
 * 
 * @author Emmanuelle
 *
 */
public class XMLHandler {	

	
	/**
	 * Get a list of objects and write them into the XML File
	 * @param medicalTests list of objects 
	 */
	
	public static void writeXML(List<MedicalTest> medicalTests) {

		try {

			Document document = new Document();

			Element theRoot = new Element("BinaryTree");
			document.setRootElement(theRoot);
			
			for (MedicalTest medicalTest : medicalTests) {
				Element node = new Element("Node");
				
				
				Element cost = new Element("cost");
				cost.addContent(new Text(medicalTest.getCost() + ""));
				Element patientName = new Element("patientName");
				patientName.addContent(new Text(medicalTest.getPatientName()));
				Element type = new Element("type");
				type.addContent(new Text(medicalTest.getType()));
				Element result = new Element("result");
				result.addContent(new Text(medicalTest.getResult()));
				
				node.addContent(cost);
				node.addContent(patientName);
				node.addContent(type);
				node.addContent(result);
				
				theRoot.addContent(node);			
				
			}

			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());

			outputter.output(document,
					new FileOutputStream(new File("./src/main/java/org/meditec/meditecserver/xmlFiles/NewFile1.xml")));
			
			System.out.println("Wrote to File");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
