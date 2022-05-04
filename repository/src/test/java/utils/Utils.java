package utils;

import refrigerator.entity.*;

import static constants.Constant.*;

public class Utils {
    public static Client createClient() {
        return Client.builder()
                .name(CLIENT_NAME_1)
                .surname(CLIENT_SURNAME_1)
                .address(CLIENT_ADDRESS_1)
                .phone(CLIENT_PHONE_1)
                .comment(CLIENT_COMMENT_1)
                .build();
    }

    public static Detail createDetail() {
        return Detail.builder()
                .name(DETAIL_NAME_1)
                .price(DETAIL_PRICE_1)
                .build();
    }

    public static Operation createOperation() {
        return Operation.builder()
                .date(OPERATION_DATE_1)
                .comment(null)
                .build();
    }

    public static Refrigerator createRefrigerator() {
        return Refrigerator.builder()
                .brand(REFRIGERATOR_BRAND_1)
                .model(REFRIGERATOR_MODEL_1)
                .build();
    }

    public static Request createRequest() {
        return Request.builder()
                .date(REQUEST_DATE_1)
                .requestType(REQUEST_TYPE_1)
                .comment(REQUEST_COMMENT_1)
                .build();
    }
}
