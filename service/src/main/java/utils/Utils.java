package utils;

import refrigerator.entity.*;

import static constants.Constant.*;

public class Utils {
    public static Request createRequest1() {
        return Request.builder()
                .date(REQUEST_DATE_1)
                .requestType(REQUEST_TYPE_1)
                .build();
    }

    public static Request createRequest2() {
        return Request.builder()
                .date(REQUEST_DATE_2)
                .requestType(REQUEST_TYPE_2)
                .build();
    }

    public static Request createRequest3() {
        return Request.builder()
                .date(REQUEST_DATE_3)
                .requestType(REQUEST_TYPE_3)
                .build();
    }

    public static Client createClient1() {
        return Client.builder()
                .name(CLIENT_NAME_1)
                .surname(CLIENT_SURNAME_1)
                .address(CLIENT_ADDRESS_1)
                .phone(CLIENT_PHONE_1)
                .comment(CLIENT_COMMENT_1)
                .build();
    }

    public static Client createClient2() {
        return Client.builder()
                .name(CLIENT_NAME_2)
                .surname(CLIENT_SURNAME_2)
                .address(CLIENT_ADDRESS_2)
                .phone(CLIENT_PHONE_2)
                .comment(null)
                .build();
    }

    public static Detail createDetail1() {
        return Detail.builder()
                .name(DETAIL_NAME_1)
                .price(DETAIL_PRICE_1)
                .build();
    }

    public static Detail createDetail2() {
        return Detail.builder()
                .name(DETAIL_NAME_2)
                .price(DETAIL_PRICE_2)
                .build();
    }

    public static Detail createDetail3() {
        return Detail.builder()
                .name(DETAIL_NAME_3)
                .price(DETAIL_PRICE_3)
                .build();
    }

    public static Operation createOperation1() {
        return Operation.builder()
                .date(OPERATION_DATE_1)
                .comment(null)
                .build();
    }

    public static Operation createOperation2() {
        return Operation.builder()
                .date(OPERATION_DATE_2)
                .comment(OPERATION_COMMENT_2)
                .build();
    }

    public static Operation createOperation3() {
        return Operation.builder()
                .date(OPERATION_DATE_3)
                .comment(null)
                .build();
    }

    public static Refrigerator createRefrigerator1() {
        return Refrigerator.builder()
                .brand(REFRIGERATOR_BRAND_1)
                .model(REFRIGERATOR_MODEL_1)
                .comment(REFRIGERATOR_COMMENT_1)
                .build();
    }

    public static Refrigerator createRefrigerator2() {
        return Refrigerator.builder()
                .brand(REFRIGERATOR_BRAND_2)
                .model(REFRIGERATOR_MODEL_2)
                .build();
    }

    public static Refrigerator createRefrigerator3() {
        return Refrigerator.builder()
                .brand(REFRIGERATOR_BRAND_3)
                .model(REFRIGERATOR_MODEL_3)
                .build();
    }
}
