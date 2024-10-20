    package org.example.api.module.users.pojo;

    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor

    public class CreateUsers {
        @Builder.Default
        private String name = "Clementina DuBuque";  // Default value
        @Builder.Default
        private String username = "Moriah.Stanton";  // Default value
        @Builder.Default
        private String email = "Rey.Padberg@karina.biz";  // Default value
        @Builder.Default
        private Address address = new Address();  // Default nested object
        @Builder.Default
        private String phone = "024-648-3804";  // Default value
        @Builder.Default
        private String website = "ambrose.net";  // Default value
        @Builder.Default
        private Company company = new Company();  // Default nested object

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Address {
            @Builder.Default
            private String street = "Kattie Turnpike";  // Default value
            @Builder.Default
            private String suite = "Suite 198";  // Default value
            @Builder.Default
            private String city = "Lebsackbury";  // Default value
            @Builder.Default
            private String zipcode = "31428-2261";  // Default value
            @Builder.Default
            private Geo geo = new Geo();  // Default nested object

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Geo {
                @Builder.Default
                private String lat = "-38.2386";  // Default value
                @Builder.Default
                private String lng = "57.2232";  // Default value
            }
        }

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Company {
            @Builder.Default
            private String name = "Hoeger LLC";  // Default value
            @Builder.Default
            private String catchPhrase = "Centralized empowering task-force";  // Default value
            @Builder.Default
            private String bs = "target end-to-end models";  // Default value
        }
    }

