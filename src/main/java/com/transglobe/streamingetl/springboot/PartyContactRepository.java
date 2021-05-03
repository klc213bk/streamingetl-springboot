package com.transglobe.streamingetl.springboot;

import java.util.List;

import org.apache.ignite.springdata22.repository.IgniteRepository;
import org.apache.ignite.springdata22.repository.config.Query;
import org.apache.ignite.springdata22.repository.config.RepositoryConfig;

@RepositoryConfig(cacheName = "PartyContactCache")
public interface PartyContactRepository extends IgniteRepository<PartyContact, Long> {

    /**
     * Gets all the persons with the given name.
     * @param name Person name.
     * @return A list of Persons with the given first name.
     */
    List<PartyContact> findByFirstNameLike(String name);
    
    /**
     * Getting ids of all the Person satisfying the custom query from {@link Query} annotation.
     *
     * @param age Query parameter.
     * @return A list of Persons' .
     */
    @Query("SELECT p.* FROM T_PartyContact p WHERE email = ?")
    List<PartyContact> selectPartyContactsByEmail(String email);
}