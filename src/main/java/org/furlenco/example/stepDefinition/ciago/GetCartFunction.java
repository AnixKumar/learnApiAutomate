package org.furlenco.example.stepDefinition.ciago;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.furlenco.example.pojo.response.ciago.error.CiaGoErrorResponse;
import org.furlenco.example.restAssuredFunction.BaseOrchestrator;
import org.furlenco.example.stepDefinition.baseClass.BaseStepDefinition;

import java.util.HashMap;

public class GetCartFunction extends BaseStepDefinition {
    BaseOrchestrator request = new BaseOrchestrator();
    private static final Logger logger = LogManager.getLogger(GetCartFunction.class);
    @Attachment(value = "API Response", type = "application/json")
    public Response mutateRequestForGetCart(String endpoint, HashMap<String, String> headersI,
                                        HashMap<String, String> queryParamsI,
                                        String requestType){
        setBaseUrl("https://st-ciago.furlenco.com");
        Response response = request.setupRequest(getBaseUrl(), endpoint, headersI, queryParamsI, requestType.toUpperCase());
        Allure.attachment("data.txt", response.asPrettyString());
        if(response.getStatusCode() != 200){
            try{
                ObjectMapper om = new ObjectMapper();
                CiaGoErrorResponse root = om.readValue(response.getBody().asPrettyString(), CiaGoErrorResponse.class);
                logger.error("Error Message for server: " + root.getError().getResolutionMessage());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return response;
    }
    public void mutateRequestForGetCart(HashMap<String, String> queryParamsI, HashMap<String, String> headersI){

    }
}
