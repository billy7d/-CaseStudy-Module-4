package com.casestudy.service.user;

import com.casestudy.model.AppUser;
import com.casestudy.repository.user.UserRepo;
import com.casestudy.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserServiceImpl implements IAppUserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public Iterable<AppUser> findAll() {
        Iterable<AppUser> appUsers = userRepo.findAll();
        return appUsers;
    }

    @Override
    public AppUser save(AppUser appUser) {
        userRepo.save(appUser);
        return appUser;
    }

    @Override
    public Optional<AppUser> findOne(Long id) {
        Optional<AppUser> appUser = userRepo.findById(id);
        return appUser;
    }

    @Override
    public void remove(Long id) {
        userRepo.deleteById(id);
    }
}
