package com.rsotar.backendninja.service.impl;

import com.rsotar.backendninja.entity.UserRole;
import com.rsotar.backendninja.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userService")
public class UserService implements UserDetailsService {

  private UserRepository userRepository;

  @Autowired
  public UserService(@Qualifier("userRepository") UserRepository userRepository) {
	this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    com.rsotar.backendninja.entity.User user = userRepository.findByUsername(username);
    List<GrantedAuthority> grantedAuthorities = buildAuthorities(user.getUserRole());
	return buildUser(user, grantedAuthorities);
  }

  private User buildUser(com.rsotar.backendninja.entity.User user, List<GrantedAuthority> grantedAuthorities) {

	return new User(user.getUsername(), user.getPassword(), user.isEnabled(),
			true,true,true, grantedAuthorities);
  }

  private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles) {
    Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
    for (UserRole role : userRoles) {
      auths.add(new SimpleGrantedAuthority(role.getRole()));
	}
    return new ArrayList<GrantedAuthority>(auths);
  }
}
