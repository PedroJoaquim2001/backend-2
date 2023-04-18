package com.backend.BackendSecurity.configs;

import com.backend.BackendSecurity.models.ProductModel;
import com.backend.BackendSecurity.models.UserModel;
import com.backend.BackendSecurity.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*UserModel userModel = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));*/
        UserModel userModel = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return new User(userModel.getUsername(), userModel.getPassword(), true, true, true,true, userModel.getAuthorities());

    }

    ///////// User Service /////////
    @Transactional
    public UserModel save(UserModel userModel){
        return userRepository.save(userModel);
    }

    public Page<UserModel> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public Optional<UserModel> findById(UUID id){
        return userRepository.findById(id);
    }

    @Transactional
    public void delete(UserModel userModel) {
        userRepository.delete(userModel);
    }
}
