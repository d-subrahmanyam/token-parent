/**
 * 
 */
package com.subbu.tokensys.token.core.services;

import com.subbu.tokensys.token.core.entities.Customer;

/**
 * @author subbu
 *
 */
public interface ICustomerService {
	
	/**
	 * This method is used to retrieve the Customer details from the Customer REST Service
	 * @param accountId
	 * @return
	 */
	public Customer retrieveCustomerDetails(String accountId);
}
