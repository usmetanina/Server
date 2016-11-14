package server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import server.service.AuthService;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @Column(name = "login", nullable = false, length = 50)
    private String login;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    /*@Column(name = "isModerator", nullable = false)
    private boolean isModerator;*/

    public User() {
    }

    public User(String login, String password, boolean isModerator) {
        this.login = login;
        this.password = password;
        //this.isModerator = isModerator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*public boolean isModerator() {
        return isModerator;
    }

    public void setModerator(boolean moderator) {
        isModerator = moderator;
    }*/
    /*@Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }*/

    public void setLogin(String login) {
        this.login = login;
    }

    /*@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return isModerator ?
                Collections.singleton(AuthService.AUTH_ADMIN) :
                Collections.singleton(AuthService.AUTH_MODERATOR);
    }*/


}
