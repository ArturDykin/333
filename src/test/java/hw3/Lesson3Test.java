package hw3;//package ru.vtb.uip.getpaymentscheduletesting.hw3;
//
//import io.restassured.path.xml.XmlPath;
//import io.restassured.response.Response;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;
//import java.util.function.Supplier;
//
//import static io.restassured.RestAssured.get;
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.CoreMatchers.containsString;
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class Lesson3Test {
//
////    @Test
////    @DisplayName("String")
////    void testPost1() {
////        String response = given()
////                .header("Content-Type", "text/xml")
////                .body("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n" +
////                        "   <soapenv:Header/>\n" +
////                        "   <soapenv:Body>\n" +
////                        "      <tem:Add>\n" +
////                        "         <tem:intA>5</tem:intA>\n" +
////                        "         <tem:intB>10</tem:intB>\n" +
////                        "      </tem:Add>\n" +
////                        "   </soapenv:Body>\n" +
////                        "</soapenv:Envelope>")
////                .when()
////                .post("http://dneonline.com/calculator.asmx")
////                .prettyPeek()
////                .then()
////                .log().all()
////                .statusCode(200)
////                .extract().asString();
////        String[] test = response.split("><");
////        String test2 = "";
////        for (String i : test) {
////            if (i.contains("15")) {
////                test2 = i;
////            }
////        }
////        assertThat("AddResult", test2, containsString("15"));
////    }
//        @Test
//        @DisplayName("XmlPath")
//        void testPost2 () {
//            XmlPath response = given()
//                    .header("Content-Type", "text/xml")
//                    .body("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n" +
//                            "   <soapenv:Header/>\n" +
//                            "   <soapenv:Body>\n" +
//                            "      <tem:Add>\n" +
//                            "         <tem:intA>5</tem:intA>\n" +
//                            "         <tem:intB>10</tem:intB>\n" +
//                            "      </tem:Add>\n" +
//                            "   </soapenv:Body>\n" +
//                            "</soapenv:Envelope>")
//                    .when()
//                    .post("http://dneonline.com/calculator.asmx")
//                    .prettyPeek()
//                    .then()
//                    .log().all()
//                    .statusCode(200)
//                    .extract()
//                    .body()
//                    .xmlPath();
//            assertEquals(response.get("AddResult"), equalTo(15));
//
//
//           //Assert.assertNotNull(TestResponse.getAddResult());
//            //assertEquals(response.getInt("AddResult"), equalTo());
//            // assertEquals(response.get("LazyXmlParser").toString(), equalTo("15"));
//            // assertEquals(response.ge, equalTo(15));
//            //   assertEquals(response.get("LazyXmlParser"), e);
//            //String [] test = response.getString();
//        }
//    }
////    private final String apiKey = "4581b7dbad2945d0af6a6560000a51f2";
//
////
////    @Test
////    void getRecipePositiveTest() {
////        given()
////                .when()
////                .get("https://api.spoonacular.com/recipes/716429/information?" +
////                        "includeNutrition=false&apiKey=" +apiKey)
////                .then()
////                .statusCode(200);
////    }
////
////    @Test
////    void getRecipeWithQueryParametersPositiveTest() {
////        given()
////                .queryParam("apiKey", apiKey)
////                .queryParam("includeNutrition", "false")
////                .when()
////                .get("https://api.spoonacular.com/recipes/716429/information")
////                .then()
////                .statusCode(200);
////    }
////
////    @Test
////    void addMealTest() {
////        String id = given()
////                .queryParam("hash", "a3da66460bfb7e62ea1c96cfa0b7a634a346ccbf")
////                .queryParam("apiKey", apiKey)
////                .body("{\n"
////                        + " \"date\": 1644881179,\n"
////                        + " \"slot\": 1,\n"
////                        + " \"position\": 0,\n"
////                        + " \"type\": \"INGREDIENTS\",\n"
////                        + " \"value\": {\n"
////                        + " \"ingredients\": [\n"
////                        + " {\n"
////                        + " \"name\": \"1 banana\"\n"
////                        + " }\n"
////                        + " ]\n"
////                        + " }\n"
////                        + "}")
////                .when()
////                .post("https://api.spoonacular.com/mealplanner/geekbrains/items")
////                .then()
////                .statusCode(200)
////                .extract()
////                .jsonPath()
////                .get("id")
////                .toString();
////
////        given()
////                .queryParam("hash", "a3da66460bfb7e62ea1c96cfa0b7a634a346ccbf")
////                .queryParam("apiKey", apiKey)
////                .delete("https://api.spoonacular.com/mealplanner/geekbrains/items/" + id)
////                .then()
////                .statusCode(200);
////    }
////
////    @Test
////    void getRecipeWithBodyChecksAfterRequestPositiveTest() {
////        JsonPath response = given()
////                .queryParam("apiKey", apiKey)
////                .queryParam("includeNutrition", "false")
////                .when()
////                .get("https://api.spoonacular.com/recipes/716429/information")
////                .body()
////                .jsonPath();
////        assertThat(response.get("vegetarian"), is(false));
////        assertThat(response.get("vegan"), is(false));
////        assertThat(response.get("license"), equalTo("CC BY-SA 3.0"));
////        assertThat(response.get("pricePerServing"), equalTo(163.15F));
////        assertThat(response.get("extendedIngredients[0].aisle"), equalTo("Milk, Eggs, Other Dairy"));
////        int i = 0;
////    }
////
////    @Test
////    void getRecipeWithBodyChecksInGivenPositiveTest() {
////        given()
////                .queryParam("apiKey", apiKey)
////                .queryParam("includeNutrition", "false")
////                .expect()
////                .body("vegetarian", is(false))
////                .body("vegan", is(false))
////                .body("license", equalTo("CC BY-SA 3.0"))
////                .body("pricePerServing", equalTo(163.15F))
////                .body("extendedIngredients[0].aisle", equalTo("Milk, Eggs, Other Dairy"))
////                .when()
////                .get("https://api.spoonacular.com/recipes/716429/information");
////    }
////}
