package com.myride.common.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GenericRestTemplate<T> {
	@Autowired
	private RestTemplate restTemplate;
	
	public ResponseEntity<T> getForEntity(String url, Class<T> responseType, Object... uriVariables){
		return restTemplate.getForEntity(url, responseType, uriVariables);
	}
	public ResponseEntity<T> post(String url, T request, Class<T> responseType){
		return restTemplate.postForEntity(url, request, responseType);
	}
}
