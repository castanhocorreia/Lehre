package com.lehre.authuser.services.impl;

import com.lehre.authuser.models.UserModel;
import com.lehre.authuser.repositories.UserRepository;
import com.lehre.authuser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Page<UserModel> findAll(Pageable pageable) {
    return userRepository.findAll(pageable);
  }

  @Override
  public Optional<UserModel> findById(UUID id) {
    return userRepository.findById(id);
  }

  @Override
  public void delete(UserModel userModel) {
    userRepository.delete(userModel);
  }

  @Override
  public void save(UserModel userModel) {
    userRepository.save(userModel);
  }

  @Override
  public boolean existsByEmail(String email) {
    return userRepository.existsByEmail(email);
  }

  @Override
  public boolean existsByUsername(String username) {
    return userRepository.existsByUsername(username);
  }
}
