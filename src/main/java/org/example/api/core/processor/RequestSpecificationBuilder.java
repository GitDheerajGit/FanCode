package org.example.api.core.processor;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.specification.MultiPartSpecification;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RequestSpecificationBuilder {

    /**
     * Builder for request Specification
     *
     * @param rSpec
     * @return
     */
    public RequestSpecification getRequestSpecificationDetails(Map<Object, Object> rSpec) {
        RequestSpecification requestSpecification = RestAssured.given().filter(new AllureRestAssured());
        if (rSpec.containsKey(RspecEnum.HEADERS)) {
            requestSpecification.headers((Map<String, ?>) rSpec.get(RspecEnum.HEADERS));
        }
        if (rSpec.containsKey(RspecEnum.QUERY_PARAMS)) {
            requestSpecification.queryParams((Map<String, ?>) rSpec.get(RspecEnum.QUERY_PARAMS));
        }
        if (rSpec.containsKey(RspecEnum.PATH_PARAMS)) {
            requestSpecification.queryParams((Map<String, ?>) rSpec.get(RspecEnum.PATH_PARAMS));
        }
        if (rSpec.containsKey(RspecEnum.BODY)) {
            requestSpecification.body((String) rSpec.get(RspecEnum.BODY));
        }
        return requestSpecification;
    }
}
