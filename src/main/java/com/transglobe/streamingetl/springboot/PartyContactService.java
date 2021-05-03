package com.transglobe.streamingetl.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyContactService {

	@Autowired
	PartyContactRepository partyContactRepository;
	
	public List<PartyContact> getPartyContacts(String email){
		return partyContactRepository.selectPartyContactsByEmail(email);
	}
}
