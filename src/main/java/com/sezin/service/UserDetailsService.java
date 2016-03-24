package com.sezin.service;

import com.sezin.model.UserAccount;
import com.sezin.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by sezin on 3/23/16.
 */

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserAccountRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount account = repository.findByUsername(username);
        if(account != null) {
            return new User(account.getUsername(), account.getPassword(), true, true, true, true, AuthorityUtils.createAuthorityList("USER"));
        }else{
            throw new UsernameNotFoundException("could not find the user '"
                    + username + "'");
        }

    }
}
