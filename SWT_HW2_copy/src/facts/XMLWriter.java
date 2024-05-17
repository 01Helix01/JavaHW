import java.io.File;
import java.io.FileWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


public class XMLWriter {
    public void addFactToXML(Fact fact, String fileName) {
        try {
            File xmlFile = new File(fileName);

            // Create a new XML document or load the existing one
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc;

            if (xmlFile.exists()) {
                doc = dBuilder.parse(xmlFile);
            } else {
                doc = dBuilder.newDocument();
                Element rootElement = doc.createElement("fact-list");
                doc.appendChild(rootElement);
            }

            // Create a new fact element
            Element factElement = doc.createElement("fact");

            // Create author, type, and text elements
            Element authorElement = doc.createElement("author");
            authorElement.appendChild(doc.createTextNode(fact.getAuthor()));
            Element typeElement = doc.createElement("fact-type");
            typeElement.appendChild(doc.createTextNode(fact.getType()));
            Element textElement = doc.createElement("fact-text");
            textElement.appendChild(doc.createTextNode(fact.getText()));

            // Add author, type, and text elements to the fact element
            factElement.appendChild(authorElement);
            factElement.appendChild(typeElement);
            factElement.appendChild(textElement);

            // Add the new fact element to the root element
            doc.getDocumentElement().appendChild(factElement);

            // Write the updated document back to the XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new FileWriter(xmlFile));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
