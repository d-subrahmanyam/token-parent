/**
 * 
 */
package com.subbu.tokensys.teller.core.repos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.subbu.tokensys.teller.core.entities.Teller;

/**
 * @author subbu
 *
 */

@RepositoryRestResource(collectionResourceRel = "tellers", path = "tellers")
public interface TellerRepo extends PagingAndSortingRepository<Teller, Long>{
	
	public Teller findByTellerId(@Param("tellerId") String tellerId);

}
