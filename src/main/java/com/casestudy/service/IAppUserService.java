package com.casestudy.service;

import com.casestudy.model.AppUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IAppUserService {

    Iterable<AppUser> findAll();

    AppUser save(AppUser appUser);

    Optional<AppUser> findOne(Long id);

    void remove(Long id);

}
