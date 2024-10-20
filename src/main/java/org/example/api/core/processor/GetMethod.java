package org.example.api.core.processor;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetMethod implements HttpRequest{

    /**
     * Send request implementation for get method
     * @param baseUri
     * @param endPoint
     * @param requestSpecification
     * @return
     */
    @Override
    public Response sendRequest(String baseUri, String endPoint, RequestSpecification requestSpecification) {
        Response response = requestSpecification.when()
                .baseUri(baseUri)
                .basePath(endPoint)
                .log()
                .all()
                .get()
                .then()
                .log().status().log().body()
                .extract().response();
        return response;
    }
}
