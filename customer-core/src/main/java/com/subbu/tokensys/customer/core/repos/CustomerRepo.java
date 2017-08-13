/**
 * 
 */
package com.subbu.tokensys.customer.core.repos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.subbu.tokensys.customer.core.entities.Customer;

/**
 * @author subbu
 *
 */

@RepositoryRestResource(collectionResourceRel = "customers", path = "customers")
public interface CustomerRepo extends PagingAndSortingRepository<Customer, Long>{
	
	public Customer findByAccountId(@Param("accountId") Long accountId);

}
