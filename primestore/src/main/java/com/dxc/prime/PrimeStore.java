package com.dxc.prime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimeStore extends JpaRepository<StoredPrime, Integer> {

}
