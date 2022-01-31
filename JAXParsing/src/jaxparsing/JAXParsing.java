package jaxparsing;
import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.StringReader;
import org.xml.sax.SAXException;
public class JAXParsing {
    //DOM API
    
    public static void main(String[] args) throws ParserConfigurationException,
            SAXException, IOException{
         String xml = "<?xml version='1.0' encoding='UTF-8'?>"
                 + "<laptop year='2017'>"
                 + "<comp id='1' name='user'>Acer</comp>"
                 + "<comp id='2' name='davron'>Mac</comp>"
                 + "<comp id='3' name='sobir'>HP</comp>"
                 + "<comp id='4' name='digit'>Samsung</comp>"
                 + "<comp id='5' name='clock'>Asus</comp>"
                 + "</laptop>";
         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
         dbf.setNamespaceAware(true);
         DocumentBuilder db = dbf.newDocumentBuilder();
         Document d = db.parse(new InputSource(new StringReader(xml)));
         
         System.out.println("XML document ning ildizi: " + d.getDocumentElement().getLocalName());

         NodeList nodejs = d.getDocumentElement().getChildNodes();
         for(int i = 0; i < nodejs.getLength(); i++){
             Node n = nodejs.item(i);
             System.out.println(n.getTextContent());
         }
         
//         NodeList allbooks = d.getDocumentElement().getElementsByTagName("book");
    }
    
    
    
    /*
    public static void main(String[] args) throws XMLStreamException {
        String xml = "<?xml version='1.0' encoding='UTF-8' ?>"
                + "<library>"
                + "<book id='1'> Java Effective </book>"
                + "<book id='2'> Java Concurretly </book>"
                + "<notAbook id='3'> Bu kitob emas </notAbook>"
                + "</library>";
        XMLInputFactory xmlif = XMLInputFactory.newFactory();
        XMLStreamReader xmlsr = xmlif.createXMLStreamReader(new StringReader(xml));
        
        Map<Integer, String> map = new HashMap<>();
        
        while(xmlsr.hasNext()){
            switch(xmlsr.getEventType()){
                case XMLStreamConstants.START_ELEMENT:
                    System.out.println("XML dokumentda element topildi:\t " + xmlsr.getLocalName());
                    if("book".equals(xmlsr.getLocalName())){
                        int bookId = Integer.parseInt(xmlsr.getAttributeValue("", "id"));
                        String bookTitle = xmlsr.getElementText();
                        map.put(bookId, bookTitle);
                    }
                    break;
                default: break;
            }
            xmlsr.next();
        }
        System.out.println(map);
    }*/
}