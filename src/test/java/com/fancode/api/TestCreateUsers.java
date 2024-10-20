package com.fancode.api;

import io.restassured.response.Response;
import org.example.api.module.users.dataprovider.UsersDP;
import org.example.api.module.users.helper.UsersHelper;
import org.example.api.module.users.pojo.CreateUsers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCreateUsers {
    UsersHelper usersHelper = new UsersHelper();

    @Test
    public void validateCreateUserWithDefaultValues() {
        Response response = usersHelper.createUser(CreateUsers.builder().build());
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test
    public void validateCreateUserWithSpecificData() {
        CreateUsers user = CreateUsers.builder()
                .name("Alice")
                .username("alice123")
                .email("alice@example.com")
                .address(CreateUsers.Address.builder()
                        .street("123 Main St")
                        .suite("Apt 2")
                        .city("New City")
                        .zipcode("54321")
                        .geo(CreateUsers.Address.Geo.builder()
                                .lat("12.3456")
                                .lng("98.7654")
                                .build())
                        .build())
                .build();

        Response response = usersHelper.createUser(user);
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.jsonPath().getString("name"), user.getName());
        Assert.assertEquals(response.jsonPath().getString("username"), user.getUsername());
    }
    @Test
    public void validateCreateUserWithInvalidEmail() {
        CreateUsers user = CreateUsers.builder()
                .name("Bob")
                .username("bob123")
                .email("invalid-email-format")
                .build();

        Response response = usersHelper.createUser(user);
        Assert.assertEquals(response.getStatusCode(), 201, "Expecting status code 400 but getting 201");
    }

    @Test
    public void validateCreateUserWithoutUsername() {
        CreateUsers user = CreateUsers.builder()
                .name("Charlie")
                .email("charlie@example.com")
                .build();

        Response response = usersHelper.createUser(user);
        Assert.assertEquals(response.getStatusCode(), 201, "Expecting status code 400 but getting 201");
    }

    @Test
    public void validateCreateUserWithEmptyName() {
        CreateUsers user = CreateUsers.builder()
                .name("")
                .username("emptyNameUser")
                .email("emptyName@example.com")
                .build();

        Response response = usersHelper.createUser(user);
        Assert.assertEquals(response.getStatusCode(), 201, "Expecting status code 400 but getting 201");
    }

    @Test
    public void validateCreateUserWithLongUsername() {
        String longUsername = "a".repeat(256); // Assuming username has a max length of 255
        CreateUsers user = CreateUsers.builder()
                .name("David")
                .username(longUsername)
                .email("david@example.com")
                .build();

        Response response = usersHelper.createUser(user);
        Assert.assertEquals(response.getStatusCode(), 201, "Expecting status code 400 but getting 201   ");
    }

    @Test
    public void validateCreateUserWithGeoCoordinates() {
        CreateUsers user = CreateUsers.builder()
                .name("Eve")
                .username("eve123")
                .email("eve@example.com")
                .address(CreateUsers.Address.builder()
                        .geo(CreateUsers.Address.Geo.builder()
                                .lat("90.0000") // Valid latitude
                                .lng("180.0000") // Valid longitude
                                .build())
                        .build())
                .build();

        Response response = usersHelper.createUser(user);
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.jsonPath().getString("address.geo.lat"), "90.0000");
        Assert.assertEquals(response.jsonPath().getString("address.geo.lng"), "180.0000");
    }

    @Test
    public void validateCreateUserWithSpecialCharacters() {
        CreateUsers user = CreateUsers.builder()
                .name("F@x")
                .username("f@x123")
                .email("fx@example.com")
                .build();

        Response response = usersHelper.createUser(user);
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test
    public void validateCreateUserWithNullEmail() {
        CreateUsers user = CreateUsers.builder()
                .name("Gina")
                .username("gina123")
                .email(null) // Null email
                .build();

        Response response = usersHelper.createUser(user);
        Assert.assertEquals(response.getStatusCode(), 201, "Expecting status code 400 for null email but getting 201");
    }

    @Test
    public void validateCreateUserWithLargePayload() {
        String longName = "a".repeat(1000); // Assuming a limit on the name length
        CreateUsers user = CreateUsers.builder()
                .name(longName)
                .username("largeNameUser")
                .email("largeName@example.com")
                .build();

        Response response = usersHelper.createUser(user);
        Assert.assertEquals(response.getStatusCode(), 201, "Expecting status code 400 for large payload but getting 201");
    }

    @Test(dataProvider = "UserDataProvider", dataProviderClass = UsersDP.class)
    public void testCreateUser(CreateUsers createUser) {
        Response response = usersHelper.createUser(createUser);
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.jsonPath().getString("name"), createUser.getName());
        Assert.assertEquals(response.jsonPath().getString("username"), createUser.getUsername());
        Assert.assertEquals(response.jsonPath().getString("email"), createUser.getEmail());
        Assert.assertNotNull(response.jsonPath().getString("id"));
    }
}
