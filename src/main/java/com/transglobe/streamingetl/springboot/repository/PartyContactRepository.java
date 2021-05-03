package com.transglobe.streamingetl.springboot.repository;

import java.util.List;

import org.apache.ignite.springdata22.repository.IgniteRepository;
import org.apache.ignite.springdata22.repository.config.Query;
import org.apache.ignite.springdata22.repository.config.RepositoryConfig;

import com.transglobe.streamingetl.springboot.PartyContact;

public interface PartyContactRepository {

    List<PartyContact> findByEmail(String email);
    
    List<PartyContact> findByMobileTel(String mobileTel);
    
    List<PartyContact> findByAddress(String address);
    
}