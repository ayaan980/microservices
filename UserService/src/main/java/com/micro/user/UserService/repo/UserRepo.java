package com.micro.user.UserService.repo;

import com.micro.user.UserService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {

}
