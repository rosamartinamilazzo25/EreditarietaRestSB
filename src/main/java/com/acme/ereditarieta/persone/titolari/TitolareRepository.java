package com.acme.ereditarieta.persone.titolari;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitolareRepository extends PagingAndSortingRepository<Titolare, Long> {

}
