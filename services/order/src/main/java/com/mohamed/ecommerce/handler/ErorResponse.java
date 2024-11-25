package com.mohamed.ecommerce.handler;

import java.util.Map;

public record ErorResponse(
        Map<String, String> errors
) {

}
