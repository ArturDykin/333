package utils;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
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
}
