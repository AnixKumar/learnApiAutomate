package org.furlenco.example.restAssuredFunction;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.furlenco.example.helper.CurlHelper;

import java.util.HashMap;
import java.util.Map;

public class BaseOrchestrator {

    CurlHelper curlHelper = new CurlHelper();

    public Response setupRequest(String baseUrl, String endpoint, HashMap<String, String> headers,
                             String requestType) {
        // Set base URI
        RestAssured.baseURI = baseUrl;

        // Create request specification
        RequestSpecification requestSpec = RestAssured.given();

        // Add headers dynamically
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                requestSpec.header(entry.getKey(), entry.getValue());
            }
        }

        // Perform the request based on request type
        Response response;
        switch (requestType.toUpperCase()) {
            case "GET":
                response = requestSpec.get(endpoint);
                break;
            case "POST":
                response = requestSpec.post(endpoint);
                break;
            case "PUT":
                response = requestSpec.put(endpoint);
                break;
            case "DELETE":
                response = requestSpec.delete(endpoint);
                break;
            default:
                throw new IllegalArgumentException("Unsupported request type: " + requestType);
        }
        return response;
    }

    public Response setupRequest(String baseUrl, String endpoint, HashMap<String, String> headers,
                             HashMap<String, String> queryParams,
                             String requestType) {
        // Set base URI
        RestAssured.baseURI = baseUrl;

        // Create request specification
        RequestSpecification requestSpec = RestAssured.given();

        // Add headers dynamically
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                requestSpec.header(entry.getKey(), entry.getValue());
            }
        }

        // Add query parameters dynamically
        if (queryParams != null) {
            for (Map.Entry<String, String> entry : queryParams.entrySet()) {
                requestSpec.queryParam(entry.getKey(), entry.getValue());
            }
        }

        // Perform the request based on request type
        Response response;
        switch (requestType.toUpperCase()) {
            case "GET":
                response = requestSpec.get(endpoint);
                break;
            case "POST":
                response = requestSpec.post(endpoint);
                break;
            case "PUT":
                response = requestSpec.put(endpoint);
                break;
            case "DELETE":
                response = requestSpec.delete(endpoint);
                break;
            default:
                throw new IllegalArgumentException("Unsupported request type: " + requestType);
        }
        curlHelper.printCurlCommand(baseUrl, endpoint, requestType, headers, queryParams);
        return response;
    }
    public Response setupRequest(String baseUrl, String endpoint, HashMap<String, String> headers,
                             HashMap<String, String> queryParams,
                             HashMap<String, String> requestBody,
                             String requestType){
        // Set base URI
        RestAssured.baseURI = baseUrl;

        // Create request specification
        RequestSpecification requestSpec = RestAssured.given();

        // Add headers dynamically
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                requestSpec.header(entry.getKey(), entry.getValue());
            }
        }

        // Add query parameters dynamically
        if (queryParams != null) {
            for (Map.Entry<String, String> entry : queryParams.entrySet()) {
                requestSpec.queryParam(entry.getKey(), entry.getValue());
            }
        }

        // Add request body if present
        if (requestBody != null) {
            requestSpec.body(requestBody);
        }

        // Perform the request based on request type
        Response response;
        switch (requestType.toUpperCase()) {
            case "GET":
                response = requestSpec.get(endpoint);
                break;
            case "POST":
                response = requestSpec.post(endpoint);
                break;
            case "PUT":
                response = requestSpec.put(endpoint);
                break;
            case "DELETE":
                response = requestSpec.delete(endpoint);
                break;
            default:
                throw new IllegalArgumentException("Unsupported request type: " + requestType);
        }
        return response;
    }

}
