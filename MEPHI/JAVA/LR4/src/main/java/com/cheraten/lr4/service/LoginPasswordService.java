package com.cheraten.lr4.service;

import com.cheraten.lr4.model.LoginPassword;
import com.cheraten.lr4.repo.LoginPasswordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginPasswordService")
public class LoginPasswordService {
    private LoginPasswordRepository loginPasswordRepository;

    @Autowired
    public LoginPasswordService(LoginPasswordRepository loginPasswordRepository) {
        this.loginPasswordRepository = loginPasswordRepository;
    }

    public LoginPassword findUserByLogin(String login) {
        return loginPasswordRepository.findByLogin(login);
    }

    public void saveLoginPassword(LoginPassword loginPassword) {
        loginPasswordRepository.save(loginPassword);
    }
}
