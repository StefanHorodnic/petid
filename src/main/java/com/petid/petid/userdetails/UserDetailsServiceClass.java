package com.petid.petid.userdetails;

import com.petid.petid.model.User;
import com.petid.petid.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceClass implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String stampNumber) throws UsernameNotFoundException {

        User user = userRepository.getUserByStampNumber(stampNumber);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user with that email");
        }

        return new UserDetailsClass(user);
    }
}
