package com.casestudy.repository.user;

import com.casestudy.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<AppUser,Long> {
}
