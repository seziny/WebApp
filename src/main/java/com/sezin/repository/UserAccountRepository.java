package com.sezin.repository;

import com.sezin.model.UserAccount;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by sezin on 3/23/16.
 * Copyright © 2016 Logitech. All rights reserved.
 */
public interface UserAccountRepository extends MongoRepository<UserAccount, String> {

    public UserAccount findByUsername(String username);
}
