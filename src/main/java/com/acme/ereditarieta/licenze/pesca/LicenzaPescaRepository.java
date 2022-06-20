package com.acme.ereditarieta.licenze.pesca;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenzaPescaRepository extends PagingAndSortingRepository<LicenzaPesca, Long> {

}
