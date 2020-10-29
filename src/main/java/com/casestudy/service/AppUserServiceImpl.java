package com.casestudy.service;

import com.casestudy.model.AppUser;
import com.casestudy.repository.user.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserServiceImpl implements IAppUserService {

    @Autowired
    IUserRepo iUserRepo;

    @Override
    public Iterable<AppUser> findAll() {
        Iterable<AppUser> appUsers = iUserRepo.findAll();
        return appUsers;
    }

    @Override
    public AppUser save(AppUser appUser) {
        iUserRepo.save(appUser);
        return appUser;
    }

    @Override
    public Optional<AppUser> findOne(Long id) {
        Optional<AppUser> appUser = iUserRepo.findById(id);
        return appUser;
    }

    @Override
    public void remove(Long id) {
        iUserRepo.deleteById(id);
    }
}
