package com.cheraten.lr4.service;

import com.cheraten.lr4.model.LoginPassword;
import com.cheraten.lr4.repo.LoginPasswordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("loginPasswordService")
public class LoginPasswordService {

    private LoginPasswordRepository loginPasswordRepository;

    @Autowired
    public LoginPasswordService(@Qualifier("loginPasswordRepository") LoginPasswordRepository loginPasswordRepository) {
        this.loginPasswordRepository = loginPasswordRepository;
    }

    public LoginPassword findUserByLogin(String login) {
        return loginPasswordRepository.findByLogin(login);
    }

    public void saveLoginPassword(LoginPassword loginPassword) {
        loginPasswordRepository.save(loginPassword);
    }

    public List<LoginPassword> findAll() {
        return loginPasswordRepository.findAll();
    }
}
