package com.acme.ereditarieta.citta;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CittaRepository extends PagingAndSortingRepository<Citta, Long> {

}
