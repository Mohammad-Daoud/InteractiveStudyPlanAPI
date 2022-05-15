package com.university.studyplanapi.doi;

public interface UsersMethods<T> {
   T geInfo (String username, String password, String tableName);
   void add(T user);
}
