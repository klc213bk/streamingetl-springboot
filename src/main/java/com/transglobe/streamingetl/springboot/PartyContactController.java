package com.transglobe.streamingetl.springboot;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PartyContactController {

	@Autowired
	private PartyContactService partyContactService;

	/*
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
*/
	@GetMapping("/search")
	@ResponseBody
	public List<PartyContact> findPartyContacts(@RequestParam(required = true) String email){
		return partyContactService.getPartyContacts(email);
	}

	/*
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	 */
}
