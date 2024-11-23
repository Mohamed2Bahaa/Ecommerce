package com.mohamed.ecommerce.product;

import com.mohamed.ecommerce.exception.BusinessException;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


//import java.net.http.HttpHeaders;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import static org.springframework.http.HttpMethod.POST;

@Service
@RequiredArgsConstructor
public class ProductClient {

    @Value("${application.config.product-url}")
    private String productUrl;
    private final RestTemplate restTemplate;

    public List<PurchaseResponse> purchaseProducts(List<PurchaseRequest> requestBody)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<List<PurchaseRequest>> requestEntity = new HttpEntity<>(requestBody, headers);

        ParameterizedTypeReference<List<PurchaseResponse>> responseType =
                new ParameterizedTypeReference<>(){};

        ResponseEntity<List<PurchaseResponse>> responseEntity = restTemplate.exchange(
                productUrl + "/purchase",
                POST,
                requestEntity,
                responseType
        );
        if(responseEntity.getStatusCode().isError())
        {throw new BusinessException("erroe happened while processing the products purchase: " + responseEntity.getStatusCode());
        }
        return responseEntity.getBody();
    }
}

