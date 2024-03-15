
package com.example.demo.service;

import com.example.demo.domain.SProfile;
import com.example.demo.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements  ProfileService {

   @Autowired
   ProfileRepository profileRepository;

   @Override
   public List<SProfile> findAll() {
      return profileRepository.findAll();
   }
}
