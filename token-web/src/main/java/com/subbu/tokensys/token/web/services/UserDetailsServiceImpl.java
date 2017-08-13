/**
 * 
 */
package com.subbu.tokensys.token.web.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.subbu.tokensys.token.core.entities.Customer;
import com.subbu.tokensys.token.core.services.ICustomerService;

/**
 * @author subbu
 *
 */
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private ICustomerService customerService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer = customerService.retrieveCustomerDetails(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
		return new User(customer.getUsername(),customer.getpassword(),grantedAuthorities);
	}

}
