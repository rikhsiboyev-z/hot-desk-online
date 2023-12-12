package com.example.hotdesk.security;

import com.example.hotdesk.user.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SessionUser {
    public User getSessionUser() {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();
        if (Objects.isNull(authentication)) {
            return null;
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof User user)
            return (User) principal;
        return null;
    }

    public Integer id(){
        User user = getSessionUser();
        return Objects.isNull(user) ? -1 : user.getId();
    }
}
