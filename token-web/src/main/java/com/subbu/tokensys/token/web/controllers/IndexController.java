/**
 * 
 */
package com.subbu.tokensys.token.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author subbu
 *
 */

@Controller
public class IndexController {

	@RequestMapping("/")
	public String indexPage() {
		return "index";
	}
}
