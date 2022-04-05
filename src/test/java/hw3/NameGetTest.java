package hw3;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import utils.LoanSystemCode;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static utils.CommonMethods.*;

public class NameGetTest {

//    ResponseSpecification responseSpecification = null;
//    RequestSpecification requestSpecification = null;
//
//    @BeforeEach
//    void beforeTest() {
//        responseSpecification = new ResponseSpecBuilder()
//                .expectStatusCode(200)
//                .expectStatusLine("HTTP/1.1 200 OK")
//                .expectContentType(ContentType.XML)
//                .expectResponseTime(Matchers.lessThan(5000L))
//                //.expectHeader("Access-Control-Allow-Credentials", "true")
//                .build();
//
//        RestAssured.responseSpecification = responseSpecification;
//        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
//
//        requestSpecification = new RequestSpecBuilder()
//                .addQueryParam("email", "o1k@mail.ru")
//                .setContentType(ContentType.XML)
//                .log(LogDetail.ALL)
//                .build();
//    }

    @Test
    @DisplayName("Тест2")
    void testPost1() throws IOException, SAXException, ParserConfigurationException, XPathExpressionException, TransformerException {

        File etalonRqFile = new File(Objects.requireNonNull(this.getClass()
                .getClassLoader()
                .getResource("456.xml")).getFile());
        Document documentRq = getDocumentFromFile(etalonRqFile);
//        documentRq = getDocumentWithUpdatedNodeValue(documentRq, ".//name", "o1k@mail.ru");
        String response = given()
                .body(getStringFromDocument(documentRq))
                .when()
                .post("http://users.bugred.ru/tasks/soap/WrapperSoapServer.php")
                //   .prettyPeek()
                .then()
                .log().all()
                .statusCode(200)
                .extract().asString();
        Assert.assertEquals(getNodeValue(getDocumentFromString(response),
                ".//name"), "o1kay");
    }
    @Test
    @DisplayName("Из коллекшена в ВАЙ")
    void testPost2() throws IOException, SAXException, ParserConfigurationException, XPathExpressionException, TransformerException {

        File etalonRqFile = new File(Objects.requireNonNull(this.getClass()
                .getClassLoader()
                .getResource("22233.xml")).getFile());
        Document documentRq = getDocumentFromFile(etalonRqFile);
//        documentRq = getDocumentWithUpdatedNodeValue(documentRq, ".//*[local-name()='creditid']",
//                "625/0000-0246284");
////        documentRq = getDocumentWithUpdatedNodeValue(documentRq, ".//name", "o1k@mail.ru");
        String response = given()
                .body(getStringFromDocument(documentRq))
                .when()
                .post("http://users.bugred.ru/tasks/soap/WrapperSoapServer.php")
                //   .prettyPeek()
                .then()
                .log().all()
                .statusCode(200)
                .extract().asString();
        Assert.assertEquals(getNodeValue(getDocumentFromString(response),
                ".//name"), "o1kay");
    }
}
