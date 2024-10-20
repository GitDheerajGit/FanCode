package org.example.api.core.processor;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostMethod implements HttpRequest {
    /**
     * Send request implementation for post method
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
                .post()
                .then()
                .log().status().log().body()
                .extract().response();
        return response;
    }
}
