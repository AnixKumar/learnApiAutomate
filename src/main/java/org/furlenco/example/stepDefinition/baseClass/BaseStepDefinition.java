package org.furlenco.example.stepDefinition.baseClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BaseStepDefinition {
    private HashMap<String, String> queryParams;
    private HashMap<String, String> headers;
    private HashMap<String, String> body;
    private String baseUrl;
    private String requestType;
}
