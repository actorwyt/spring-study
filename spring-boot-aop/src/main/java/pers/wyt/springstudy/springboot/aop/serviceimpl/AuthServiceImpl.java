package pers.wyt.springstudy.springboot.aop.serviceimpl;

import org.springframework.stereotype.Service;
import pers.wyt.springstudy.springboot.aop.service.AuthService;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: wanyutong
 * @Date: 2019/1/7
 * @Description:
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public Set<String> currentUserRoles() {
        Set<String> roles = new HashSet<>();
        roles.add("Seller");
        return roles;
    }
}
