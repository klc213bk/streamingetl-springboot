package com.transglobe.streamingetl.springboot.partycontact.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.builder.ToStringBuilder;
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
import com.transglobe.streamingetl.springboot.partycontact.model.StreamingEtlHealth;
import com.transglobe.streamingetl.springboot.partycontact.model.UpTime;
import com.transglobe.streamingetl.springboot.partycontact.service.StreamingEtlHealthService;
import com.transglobe.streamingetl.springboot.partycontact.service.PartyContactService;


@RestController
@RequestMapping("/partycontact/v1.0/search")
public class PartyContactController {
	static final Logger logger = LoggerFactory.getLogger(PartyContactController.class);
	
	@Autowired
	private PartyContactService partyContactService;
	
	@Autowired
	private StreamingEtlHealthService streamingEtlHealthService;

	@GetMapping(value="/email/{email}")
	@ResponseBody
	public List<PartyContact> findPartyContactsByEmail(@PathVariable("email") String email){
		logger.info(">>>>PartyContactController, search by email={}", email);
		List<PartyContact> contactList = partyContactService.getPartyContactsByEmail(email);
		logger.info(">>>>contactList, size={}", contactList.size());
		return contactList;
	}
	
	@GetMapping(value="/mobileTel/{mobileTel}")
	@ResponseBody
	public List<PartyContact> findPartyContactsByMobileTel(@PathVariable("mobileTel") String mobileTel){
		logger.info(">>>>PartyContactController, search by mobileTel={}", mobileTel);
		List<PartyContact> contactList = partyContactService.getPartyContactsByMobileTel(mobileTel);
		logger.info(">>>>contactList, size={}", contactList.size());
		return contactList;
	}
	
	@GetMapping(value="/address1/{address1}")
	@ResponseBody
	public List<PartyContact> findPartyContactsByAddress(@PathVariable("address1") String address1){
		logger.info(">>>>PartyContactController, search by address1={}", address1);
		List<PartyContact> contactList =  partyContactService.getPartyContactsByAddress1(address1);
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
	

	@GetMapping(path = "/etlhealth")
	@ResponseBody
	public List<StreamingEtlHealth> getHealthRecordsAfter(
			@RequestParam(required = false) Integer days,
			@RequestParam(required = false) Integer hours,
			@RequestParam(required = false) Integer mins){
		logger.info(">>>>PartyContactController, findStreamingEtlHealthForLastNDays by days={}, hours:{}, mins:{}", days, hours, mins);
				
		long currMillis = System.currentTimeMillis();
		
		long secs = 0L;
		secs = (days == null)? 0 : days * 86400;
		secs = secs + ((hours == null)? 0 : hours * 3600);
		secs = secs + ((mins == null)? 0 : mins * 60);
		
		long lastMillis = currMillis - secs * 1000;
		System.out.println("lastMillis:" + lastMillis);
		
		List<StreamingEtlHealth> list =  streamingEtlHealthService.getHealthRecordsAfter(lastMillis);
		return list;
	}
	

	@GetMapping(path = "/upTime")
	@ResponseBody
	public UpTime findUpTime(){
		logger.info(">>>>PartyContactController, find up time");
		UpTime upTime = null;
		try {
			upTime = streamingEtlHealthService.getUpTime();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return upTime;
	}
}
