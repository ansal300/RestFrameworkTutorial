package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import report.ExtentReportManager;

import java.util.Map;
import java.util.Objects;

public class RestUtils {

    private static RequestSpecification getRequestSpecification(String endPoint, Object payLoad, Map<String, String> headers) {
        return RestAssured.given()
                .baseUri(endPoint)
                .contentType(ContentType.JSON)
                .body(payLoad);
    }

    private static void printRequestLogInReport(RequestSpecification requestSpecification) {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfo("Base Uri is " + queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfo("Method is " + queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfo("Request Headers are ");
        ExtentReportManager.logHeaders(queryableRequestSpecification.getHeaders().asList());
        ExtentReportManager.logInfo("Request Body is");
        ExtentReportManager.logJson(queryableRequestSpecification.getBody());
    }

    private static void printResponseLogInReport(Response response) {
        ExtentReportManager.logInfo("Response status is " + response.getStatusCode());
        ExtentReportManager.logInfo("Response Headers are ");
        ExtentReportManager.logHeaders(response.getHeaders().asList());
        ExtentReportManager.logInfo("Response Body is");
        ExtentReportManager.logJson(response.getBody().prettyPrint());
    }

    public static Response performPost(String endPoint, String payLoad, Map<String, String> headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, payLoad, headers);
        Response response = requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;

    }

    public static Response performPost(String endPoint, Map<String, Object> payLoad, Map<String, String> headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, payLoad, headers);
        Response response = requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }

    public static Response performPost(String endPoint, Object payLoad, Map<String, String> headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, payLoad, headers);
        Response response = requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }

}
