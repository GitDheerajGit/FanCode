package org.example.api.core.processor;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public interface HttpRequest {
    /**
     * Method to send request
     * @param baseUri
     * @param endPoint
     * @param requestSpecification
     * @return
     */
    Response sendRequest(String baseUri, String endPoint, RequestSpecification requestSpecification);
}
