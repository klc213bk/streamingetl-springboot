package com.transglobe.streamingetl.springboot;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PartyContactController {

	@Autowired
	private PartyContactService partyContactService;

	@GetMapping("/search")
	@ResponseBody
	public List<PartyContact> findPartyContacts(@RequestParam("email") String email){
		return partyContactService.getPartyContactsByEmail(email);
	}
	
	@GetMapping("/search")
	@ResponseBody
	public List<PartyContact> findPartyContactsByMobileTel(@RequestParam("mobileTel") String mobileTel){
		return partyContactService.getPartyContactsByMobileTel(mobileTel);
	}
	
	@GetMapping("/search")
	@ResponseBody
	public List<PartyContact> findPartyContactsByAddress(@RequestParam("address") String address){
		return partyContactService.getPartyContactsByAddress(address);
	}

	
}
