package com.wrpys.sb.dao;

import com.wrpys.sb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wrp
 * @Date 2017/9/23
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
