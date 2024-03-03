package org.furlenco.example.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class CurlHelper {

    public void printCurlCommand(String baseUrl, String endpoint, String requestType,
                                 Map<String, String> headers, Map<String, String> queryParams) {
        StringBuilder curlCommand = new StringBuilder("curl");

        // Append headers
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                curlCommand.append(" -H '").append(entry.getKey()).append(": ").append(entry.getValue()).append("'");
            }
        }

        // Append query parameters to the URL
        if (queryParams != null && !queryParams.isEmpty()) {
            StringBuilder queryString = new StringBuilder();
            for (Map.Entry<String, String> entry : queryParams.entrySet()) {
                queryString.append("&").append(entry.getKey()).append("=").append(entry.getValue());
            }
            endpoint += "?" + queryString.substring(1); // Remove the leading "&"
        }

        // Append request type
        curlCommand.append(" -X ").append(requestType.toUpperCase());

        // Append base URL and endpoint
        curlCommand.append(" '").append(baseUrl).append(endpoint).append("'");

        // Print the cURL command
        System.out.println("Equivalent cURL command:");
        System.out.println(curlCommand.toString());
    }
    public void printCurlCommand(String baseUrl, String endpoint, String requestType,
                                        Map<String, String> headers,
                                        Map<String, String> queryParams,
                                        Map<String, String> requestBody) {
        StringBuilder curlCommand = new StringBuilder("curl");

        // Append headers
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                curlCommand.append(" -H '").append(entry.getKey()).append(": ").append(entry.getValue()).append("'");
            }
        }

        // Append query parameters
        if (queryParams != null) {
            for (Map.Entry<String, String> entry : queryParams.entrySet()) {
                curlCommand.append(" --data-urlencode '").append(entry.getKey()).append("=").append(entry.getValue()).append("'");
            }
        }

        // Append request type
        curlCommand.append(" -X ").append(requestType.toUpperCase());

        // Append base URL and endpoint
        curlCommand.append(" '").append(baseUrl).append(endpoint).append("'");

        // Append raw JSON request body if present
        if (requestBody != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                String requestBodyJson = objectMapper.writeValueAsString(requestBody);
                curlCommand.append(" -d '").append(requestBodyJson).append("'");
            } catch (JsonProcessingException e) {
                System.err.println("Error processing request body to JSON: " + e.getMessage());
            }
        }

        // Print the cURL command
        System.out.println("Equivalent cURL command:");
        System.out.println(curlCommand.toString());
    }
}
