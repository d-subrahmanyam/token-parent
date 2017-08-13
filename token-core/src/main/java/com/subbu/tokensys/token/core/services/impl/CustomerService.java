/**
 * 
 */
package com.subbu.tokensys.token.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.TypeConstrainedMappingJackson2HttpMessageConverter;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.subbu.tokensys.token.core.entities.Customer;
import com.subbu.tokensys.token.core.services.ICustomerService;

/**
 * @author subbu
 *
 */

@Service
public class CustomerService implements ICustomerService {
	
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
	
	@Autowired
    private ObjectMapper objectMapper;

    @Autowired
    @Qualifier("halJacksonHttpMessageConverter")
    private TypeConstrainedMappingJackson2HttpMessageConverter halJacksonHttpMessageConverter;

	/**
	 * This method is used to retrieve the Customer details from the Customer REST Service
	 * @param accountId
	 * @return
	 */
	public Customer retrieveCustomerDetails(String accountId) {
		RestTemplate restTemplate = getRestTemplateWithHalMessageConverter();
		String customersUri = String.format("http://localhost:18080/customers/search/findByAccountId?accountId=%s", accountId);
		ResponseEntity<Resource<Customer>> customerEntity = restTemplate.exchange(customersUri, HttpMethod.GET,null,new ParameterizedTypeReference<Resource<Customer>>() {});
		Customer customer = customerEntity.getBody().getContent();
		return customer;
	}

	private RestTemplate getRestTemplateWithHalMessageConverter() {
		RestTemplate restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> existingConverters = restTemplate.getMessageConverters();
		List<HttpMessageConverter<?>> newConverters = new ArrayList<>();
		newConverters.add(halJacksonHttpMessageConverter);
		newConverters.addAll(existingConverters);
		restTemplate.setMessageConverters(newConverters);
		return restTemplate;
	}
}
