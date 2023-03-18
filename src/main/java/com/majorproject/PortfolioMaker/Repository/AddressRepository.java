package com.majorproject.PortfolioMaker.Repository;

import com.majorproject.PortfolioMaker.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    boolean existsByUser_UserId(Long userId);

}
