package com.team4project.config.auth;

import lombok.Data;
import com.team4project.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;


@Data
public class PrincipalDetails implements UserDetails {
    private User user; //composition

    public PrincipalDetails(User user) {
        this.user = user;
    } //User를 받아서 PrincipalDetails를 생성

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(() -> {return user.getRole();});
        return authorities;
    } //계정이 갖고 있는 권한 목록을 리턴

    @Override
    public String getPassword() {
        return user.getPwd();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

    @Override
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
    }
}
