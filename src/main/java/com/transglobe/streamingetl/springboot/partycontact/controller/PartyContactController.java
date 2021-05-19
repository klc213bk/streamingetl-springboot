package com.transglobe.streamingetl.springboot.partycontact.controller;

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

import com.transglobe.streamingetl.springboot.partycontact.model.PartyContact;
import com.transglobe.streamingetl.springboot.partycontact.service.PartyContactService;


@RestController
@RequestMapping("/partycontact/v1.0")
public class PartyContactController {
	static final Logger logger = LoggerFactory.getLogger(PartyContactController.class);
	
	@Autowired
	private PartyContactService partyContactService;

	@GetMapping(path = "/search", params = { "email" })
	@ResponseBody
	public List<PartyContact> findPartyContacts(@RequestParam("email") String email){
		logger.info(">>>>PartyContactController, search by email={}", email);
		List<PartyContact> contactList = partyContactService.getPartyContactsByEmail(email);
		logger.info(">>>>contactList, size={}", contactList.size());
		return contactList;
	}
	
	@GetMapping(path = "/search", params = { "mobileTel" })
	@ResponseBody
	public List<PartyContact> findPartyContactsByMobileTel(String mobileTel){
		logger.info(">>>>PartyContactController, search by mobileTel={}", mobileTel);
		List<PartyContact> contactList = partyContactService.getPartyContactsByMobileTel(mobileTel);
		logger.info(">>>>contactList, size={}", contactList.size());
		return contactList;
	}
	
	@GetMapping(path = "/search", params = { "address" })
	@ResponseBody
	public List<PartyContact> findPartyContactsByAddress(String address){
		logger.info(">>>>PartyContactController, search by address={}", address);
		List<PartyContact> contactList =  partyContactService.getPartyContactsByAddress(address);
		logger.info(">>>>contactList, size={}", contactList.size());
		return contactList;
	}

	@GetMapping(path = "/search", params = { "listId" })
	@ResponseBody
	public List<PartyContact> findPartyContactsByListId(Long listId){
		logger.info(">>>>PartyContactController, search by listId={}", listId);
		List<PartyContact> contactList =  partyContactService.getPartyContactsByListId(listId);
		logger.info(">>>>contactList, size={}", contactList.size());
		return contactList;
	}
	
	@GetMapping(path = "/search", params = { "certiCode" })
	@ResponseBody
	public List<PartyContact> findPartyContactsByCertiCode(String certiCode){
		logger.info(">>>>PartyContactController, search by certiCode={}", certiCode);
		List<PartyContact> contactList =  partyContactService.getPartyContactsByCertiCode(certiCode);
		logger.info(">>>>contactList, size={}", contactList.size());
		return contactList;
	}
	
	@GetMapping(path = "/search", params = { "addressId" })
	@ResponseBody
	public List<PartyContact> findPartyContactsByAddressId(Long addressId){
		logger.info(">>>>PartyContactController, search by addressId={}", addressId);
		List<PartyContact> contactList =  partyContactService.getPartyContactsByAddressId(addressId);
		logger.info(">>>>contactList, size={}", contactList.size());
		return contactList;
	}
}
