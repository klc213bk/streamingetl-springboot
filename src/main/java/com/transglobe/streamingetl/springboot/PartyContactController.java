package com.transglobe.streamingetl.springboot;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/partycontact/v1.0")
public class PartyContactController {
	static final Logger logger = LoggerFactory.getLogger(PartyContactController.class);
	
	@Autowired
	private PartyContactService partyContactService;

	@GetMapping(path = "/search", params = { "email" })
	@ResponseBody
	public List<PartyContact> findPartyContacts(@RequestParam("email") String email){
		return partyContactService.getPartyContactsByEmail(email);
	}
	
	@GetMapping(path = "/search", params = { "mobileTel" })
	@ResponseBody
	public List<PartyContact> findPartyContactsByMobileTel(String mobileTel){
		return partyContactService.getPartyContactsByMobileTel(mobileTel);
	}
	
	@GetMapping(path = "/search", params = { "address" })
	@ResponseBody
	public List<PartyContact> findPartyContactsByAddress(String address){
		logger.info(">>>>PartyContactController, search by address={}", address);
		List<PartyContact> contactList =  partyContactService.getPartyContactsByAddress(address);
		logger.info(">>>>contactList, size={}", contactList.size());
		return contactList;
	}

	
}
