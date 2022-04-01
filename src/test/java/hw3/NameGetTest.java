package hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import static io.restassured.RestAssured.given;
import static utils.CommonMethods.getDocumentFromString;
import static utils.CommonMethods.getNodeValue;

public class NameGetTest {

    @Test
    @DisplayName("Тест1")
    void testPost1() throws IOException, SAXException, ParserConfigurationException, XPathExpressionException {
        String response = given()
                .body("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:wrap=\"http://foo.bar/wrappersoapserver\">\n" +
                        "   <soapenv:Header/>\n" +
                        "   <soapenv:Body>\n" +
                        "      <wrap:getUserFull>\n" +
                        "         <email>ddd25312@gmail.com</email>\n" +
                        "      </wrap:getUserFull>\n" +
                        "   </soapenv:Body>\n" +
                        "</soapenv:Envelope>")
                .when()
                .post("http://users.bugred.ru/tasks/soap/WrapperSoapServer.php")
                .prettyPeek()
                .then()
                .log().all()
                .statusCode(200)
                .extract().asString();
        int i =0;
        Assert.assertEquals(getNodeValue(getDocumentFromString(response),
                ".//name"), " Igor52");
    }
}
