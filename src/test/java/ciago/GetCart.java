package ciago;

import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import org.furlenco.example.stepDefinition.ciago.GetCartFunction;

import java.util.HashMap;

public class GetCart {

    GetCartFunction getCartFunc = new GetCartFunction();
    private static final Logger logger = LogManager.getLogger(GetCart.class);

    @Test(description = "Test GET request to API and verify response")
    @Description("Send a GET request to the API endpoint and verify the response content")
    public void testForGetCart(){
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("cityId", "1");
        queryParams.put("pincode", "560114");

        HashMap<String, String> headersI = new HashMap<>();
        headersI.put("x-panem-token", "qAj3K7tvcE2MMz4kwecZCeK");

        String endpoint = "/api/v1/carts";

        String reqType = "get";
        Response response = getCartFunc.mutateRequestForGetCart(endpoint, headersI, queryParams, reqType);
        logApiResponse(response);
    }

    private void logApiResponse(Response response) {
        // Log response details in the test description
        logger.info("API Response:");
        logger.info("Status Code: " + response.getStatusCode());
        logger.info("Response Body: " + response.getBody().asString());
        // Log more response details as needed
    }
}
