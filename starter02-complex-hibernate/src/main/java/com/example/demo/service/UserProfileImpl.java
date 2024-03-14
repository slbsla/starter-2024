
package com.example.demo.service;

import com.example.demo.domain.SUserProfile;
import com.example.demo.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileImpl implements  UserProfileService {

   @Autowired
   UserProfileRepository userProfileRepository ;

   @Override
   public List<SUserProfile> findAll() {
      return userProfileRepository.findAll();
   }
}
