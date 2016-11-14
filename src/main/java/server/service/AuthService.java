package server.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public static final String ROLE_ANONYMOUS = "ROLE_ANONYMOUS";
    public static final String ROLE_MODERATOR = "ROLE_MODERATOR";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final GrantedAuthority AUTH_ANONYMOUS = new SimpleGrantedAuthority(ROLE_ANONYMOUS);
    public static final GrantedAuthority AUTH_MODERATOR = new SimpleGrantedAuthority(ROLE_MODERATOR);
    public static final GrantedAuthority AUTH_ADMIN = new SimpleGrantedAuthority(ROLE_ADMIN);

    public String getUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        return auth.getName();
    }

    public boolean hasRole(String role) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return role.equals(ROLE_ANONYMOUS);
        }
        for (GrantedAuthority authority : auth.getAuthorities()) {
            if (authority.getAuthority().equals(role)) {
                return true;
            }
        }
        return false;
    }


}
