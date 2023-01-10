package com.example.demo.service;

import com.example.demo.model.user.MyUserDetail;
import com.example.demo.model.user.User;
import com.example.demo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user = iUserRepository.findByUsername(username);

      if (user == null) {
        throw new UsernameNotFoundException("User name: " + username + " not found");
      }

      return new MyUserDetail(user);
    }
}
