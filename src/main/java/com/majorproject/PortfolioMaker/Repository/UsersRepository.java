package com.majorproject.PortfolioMaker.Repository;

import com.majorproject.PortfolioMaker.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    boolean existsByEmail(String email);

    Users findByEmail(String email);
}
