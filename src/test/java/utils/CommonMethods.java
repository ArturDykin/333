package utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

public class CommonMethods {
    public static String getNodeValue(Document document, String xpathExpression) throws XPathExpressionException {
        XPath xPath = XPathFactory.newInstance().newXPath();
        return (String) xPath.compile(xpathExpression).evaluate(document, XPathConstants.STRING);
    }
    public static Document getDocumentFromString(String string) throws ParserConfigurationException, SAXException, IOException {
        return getDocumentFromByteArray(string.getBytes(StandardCharsets.UTF_8));
    }
    public static Document getDocumentFromByteArray(byte[] byteArray) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
        return documentBuilder.parse(byteArrayInputStream);
    }
    public static Document getDocumentFromFile(File etalonRqFile) throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        return dbf.newDocumentBuilder().parse(etalonRqFile);
    }
//    public static Document getDocumentWithUpdatedNodeValue(Document document, String xpathExpression, String newValue) throws XPathExpressionException {
//        XPath xPath = XPathFactory.newInstance().newXPath();
//        Element node = (Element) xPath.evaluate(xpathExpression, document, XPathConstants.NODE);
//        node.setTextContent(newValue);
//        return node.getOwnerDocument();
//    }
    public static Document getDocumentWithUpdatedNodeValue(Document document, String xpathExpression, String newValue) throws XPathExpressionException {
        XPath xPath = XPathFactory.newInstance().newXPath();
        Element node = (Element) xPath.evaluate(xpathExpression, document, XPathConstants.NODE);
        node.setTextContent(newValue);
        return node.getOwnerDocument();
    }
    public static String getStringFromDocument(Document document) throws TransformerException {
        DOMSource domSource = new DOMSource(document);
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.transform(domSource, result);
        return writer.toString();
    }
//    public static String getUpdatedRequest(String fieldName, String json, GetScheduleRest requestDTOd,
//                                           String value) {
//        String jsonUpdated;
//        switch (fieldName) {
//            case ("rqUID"):
//                jsonUpdated = json.replace(requestDTOd.getHeaderInfo().getRqUID(), value);
//                break;
//            case ("iPAddress"):
//                jsonUpdated = json.replace(requestDTOd.getHeaderInfo().getIpAddress(), value);
//                break;
//            case ("sessionId"):
//                jsonUpdated = json.replace(requestDTOd.getHeaderInfo().getSessionId(), value);
//                break;
//            case ("contextId"):
//                jsonUpdated = json.replace(requestDTOd.getHeaderInfo().getContextId(), value);
//                break;
//            case ("contextUserInfo"):
//                jsonUpdated = json.replace(requestDTOd.getHeaderInfo().getContextUserInfo(), value);
//                break;
//            case ("rqType"):
//                jsonUpdated = json.replace(requestDTOd.getHeaderInfo().getRqType(), value);
//                break;
//            case ("rqTm"):
//                jsonUpdated = json.replace(requestDTOd.getHeaderInfo().getRqTm(), value);
//                break;
//            case ("systemFrom"):
//                jsonUpdated = json.replace(requestDTOd.getHeaderInfo().getSystemFrom(), value);
//                break;
//            case ("systemTo"):
//                jsonUpdated = json.replace(requestDTOd.getHeaderInfo().getSystemTo(), value);
//                break;
//            case ("agreementNumber"):
//                jsonUpdated = json.replace(requestDTOd.getPaymentSchedule().getAgreementNumber(), value);
//                break;
//            case ("divisionID"):
//                jsonUpdated = json.replace(requestDTOd.getPaymentSchedule().getDivisionID(), value);
//                break;
//            case ("loanSystemCode"):
//                jsonUpdated = json.replace(requestDTOd.getPaymentSchedule().getLoanSystemCode(), value);
//                break;
//            case ("agreementType"):
//                jsonUpdated = json.replace(requestDTOd.getPaymentSchedule().getAgreementType(), value);
//                break;
//            case ("createDate"):
//                jsonUpdated = json.replace(requestDTOd.getPaymentSchedule().getCreateDate(), value);
//                break;
//            case ("requestType"):
//                jsonUpdated = json.replace(String.valueOf(requestDTOd.getPaymentSchedule().getRequestType()), value);
//                break;
//            default:
//                throw new IllegalStateException("Unexpected value: " + fieldName);
//        }
//        return jsonUpdated;
//    }
}
