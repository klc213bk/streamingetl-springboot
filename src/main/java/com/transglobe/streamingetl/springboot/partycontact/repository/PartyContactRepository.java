package com.transglobe.streamingetl.springboot.partycontact.repository;

import java.util.List;

import com.transglobe.streamingetl.springboot.partycontact.model.PartyContact;

public interface PartyContactRepository {

    List<PartyContact> findByEmail(String email);
    
    List<PartyContact> findByMobileTel(String mobileTel);
    
    List<PartyContact> findByAddress(String address);
    
    List<PartyContact> findByListId(Long listId);
    
    List<PartyContact> findByCertiCode(String certiCode);
    
    List<PartyContact> findByAddressId(Long addressId);
    
}