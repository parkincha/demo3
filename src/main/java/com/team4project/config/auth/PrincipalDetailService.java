package com.team4project.config.auth;

import com.team4project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import com.team4project.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {
    private final UserRepository userRepository; // 인증처리할때 userdetailservice를 통해서 username이 DB에 있는지만 확인하면 됨

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        log.info("loadUserByUsername");
        User user = userRepository.findByUserId(userId);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with userId: " + userId);
        }
        PrincipalDetails principalDetails = new PrincipalDetails(user); // 시큐리티 세션에 유저 정보가 저장됨
        log.info(principalDetails);
        return principalDetails;
    }
}