package com.rey70n.demo.web.domain;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User, Long> {
    @Cacheable
    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

    @Query("from User u where u.username=:username")
    User findUser(@Param("username") String username);
}
