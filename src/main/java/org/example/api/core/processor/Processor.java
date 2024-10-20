package org.example.api.core.processor;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class Processor {

    /**
     * buildRequest for http methods types
     *
     * @param httpMethods
     * @param baseUri
     * @param endPoint
     * @param requestSpecification
     * @return
     */
    public Response buildRequest(HttpMethods httpMethods, String baseUri, String endPoint, RequestSpecification requestSpecification) {
        Response response = null;
        try {
            switch (httpMethods) {
                case GET:
                    response = new GetMethod().sendRequest(baseUri, endPoint, requestSpecification);
                    break;
                case POST:
                    response = new PostMethod().sendRequest(baseUri, endPoint, requestSpecification);
                    break;
                default:
                    throw new IllegalStateException("HTTP Method " + httpMethods + " is not supported!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * send request final call for api
     * @param httpMethods
     * @param baseUri
     * @param endPoint
     * @param rSpec
     * @return
     */
    public Response sendRequest(HttpMethods httpMethods, String baseUri, String endPoint, Map<Object, Object> rSpec) {
        RequestSpecificationBuilder requestSpecificationBuilder = new RequestSpecificationBuilder();
        RequestSpecification requestSpecification = requestSpecificationBuilder.getRequestSpecificationDetails(rSpec);
        return buildRequest(httpMethods, baseUri, endPoint, requestSpecification);
    }
}
