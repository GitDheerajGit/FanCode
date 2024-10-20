package org.example.api.module.users.helper;

import io.restassured.response.Response;
import org.example.api.core.processor.HttpMethods;
import org.example.api.core.processor.Processor;
import org.example.api.core.processor.RspecEnum;
import org.example.api.core.utils.Utils;
import org.example.api.module.common.Constants;
import org.example.api.module.users.common.Endpoints;
import org.example.api.module.users.pojo.CreateUsers;

import java.util.HashMap;
import java.util.Map;

public class UsersHelper {
    Processor processor = new Processor();
    Map<Object, Object> rSpec;

    /**
     * Create users : POST call
     *
     * @param createUser POJO containing user data
     * @return API Response
     */
    public Response createUser(CreateUsers createUser) {
        rSpec = new HashMap<>();

        Map<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        rSpec.put(RspecEnum.HEADERS, headers);
        rSpec.put(RspecEnum.BODY, Utils.convertObjectToJson(createUser));

        return processor.sendRequest(HttpMethods.POST, Constants.base_uri, Endpoints.list_or_create_users, rSpec);
    }
}
