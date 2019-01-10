package pers.wyt.springstudy.springboot.aop.service;

import java.util.Set;

/**
 * @Author: wanyutong
 * @Date: 2019/1/7
 * @Description:
 */
public interface AuthService {
    /**
     * 获取用户所有角色
     *
     * @return
     */
    Set<String> currentUserRoles();
}
