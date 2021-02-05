package com.example.cabinet.service;

import com.example.cabinet.db.User;
import com.example.cabinet.db.UserRepository;
import com.example.cabinet.utils.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = repo.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException("No user with the name " + s + "was found in the database"));
        return new CustomUserDetails(user);
    }
}
