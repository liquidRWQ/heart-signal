package com.company.heartbeatsignal.dto.other;

import com.company.heartbeatsignal.entity.User;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author Liquid
 * @version 1.0
 * @date 2019/6/17
 */

@Component
public class UserHolderDTO implements Serializable {

    private static final long serialVersionUID = 5260174718674692482L;

    private ThreadLocal<User> users = new ThreadLocal<>();

    public User getUser() {
        return users.get();
    }

    public void setUser(User user) {
        users.set(user);
    }

    public void clear() {
        users.remove();
    }
}
