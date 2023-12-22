package com.solvd.hospitaldb.dao;

import com.solvd.hospitaldb.bin.User;

public interface IMapper {
    User getUserById(long id);
}