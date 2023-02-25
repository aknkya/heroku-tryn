package com.example.herokuappdemo.service;

import com.example.herokuappdemo.model.CountriesData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;


@Service
public class MovieRequestService {


    public List<CountriesData.ResultItem> getList() throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("authorization", "apikey 77Xqd7wTraJqpFncWg1t8G:65efVAjd1bbZYDq03vvL64");
        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        HttpEntity<CountriesData> stringHttpEntity = restTemplate.exchange("https://api.collectapi.com/corona/countriesData", HttpMethod.POST, entity, CountriesData.class);
        List<CountriesData.ResultItem> listCountriesData = stringHttpEntity.getBody().getResult();
        System.out.println(23);

        return listCountriesData;

    }
}