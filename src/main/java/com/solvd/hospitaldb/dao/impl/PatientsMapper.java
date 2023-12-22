package com.solvd.hospitaldb.dao.impl;

import com.solvd.hospitaldb.bin.User;
import com.solvd.hospitaldb.dao.IMapper;

public class PatientsMapper implements IMapper {

    @Override
    public User getUserById(long id) {
        User user = new User();
        // after some mapping from database
        return user;
    }
}