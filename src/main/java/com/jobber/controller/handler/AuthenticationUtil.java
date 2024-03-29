package com.jobber.controller.handler;

import com.jobber.service.security.SecurityUser;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class AuthenticationUtil {

    public static List<String> retrieveAuthorities(SecurityUser user){
        if (user != null) {
            return user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public static String retrieveAuthorityInLowercase(SecurityUser user){
        return retrieveAuthorities(user).get(0).toLowerCase(Locale.ROOT);
    }

    public static Long retrieveUserId(SecurityUser user){
        if (user == null) {
            throw new RuntimeException("User is not authenticated");
        }
        return user.getId();
    }
}
