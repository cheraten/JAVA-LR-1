package com.cheraten.lr4.repo;

import com.cheraten.lr4.model.LoginPassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("loginPasswordRepository")
public interface LoginPasswordRepository extends JpaRepository<LoginPassword, Long> {
    LoginPassword findByLogin(String login);
    boolean existsByLogin(String login);
}
