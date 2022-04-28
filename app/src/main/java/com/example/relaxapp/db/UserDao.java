package com.example.relaxapp.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {
    @Insert
    void insert(User user);

    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
    User getByEmailAndPassword(String email, String password);
}
