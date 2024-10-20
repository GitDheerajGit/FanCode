package org.example.api.module.users.dataprovider;

import lombok.Builder;
import org.example.api.module.users.pojo.CreateUsers;
import org.testng.annotations.DataProvider;

@Builder
public class UsersDP {
    @DataProvider(name = "UserDataProvider")
    public static Object[][] getUserData() {
        return new Object[][]{
                {
                        CreateUsers.builder()
                                .name("John Doe")
                                .username("johnny")
                                .email("john.doe@example.com")
                                .address(CreateUsers.Address.builder()
                                        .street("123 Elm St")
                                        .suite("Apt 1")
                                        .city("Springfield")
                                        .zipcode("12345")
                                        .geo(CreateUsers.Address.Geo.builder()
                                                .lat("37.1234")
                                                .lng("-93.1234")
                                                .build())
                                        .build())
                                .build()
                },
                {
                        CreateUsers.builder()
                                .name("Jane Smith")
                                .username("janey")
                                .email("jane.smith@example.com")
                                .address(CreateUsers.Address.builder()
                                        .street("456 Oak St")
                                        .suite("Suite 2B")
                                        .city("Metropolis")
                                        .zipcode("67890")
                                        .geo(CreateUsers.Address.Geo.builder()
                                                .lat("40.5678")
                                                .lng("-74.5678")
                                                .build())
                                        .build())
                                .build()
                },
                // Add more test data as needed
        };
    }
}
