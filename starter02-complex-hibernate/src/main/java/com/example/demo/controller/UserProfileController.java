
package com.example.demo.controller;

import com.example.demo.domain.SUserProfile;
import com.example.demo.service.UserProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v1")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @Operation(description = "Retrieves all profiles")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")})
    @GetMapping(value = "/all-user-with-profiles-with-details")
    public List<SUserProfile> findAll() {
        return userProfileService.findAll();
    }

}


/***
 *
 *   {
 *     "id": 1,
 *     "sprofile": {
 *       "id": 1,
 *       "name": "ADMIN",
 *       "description": "Administrator"
 *     },
 *     "suser": {
 *       "id": 1,
 *       "name": "samir",
 *       "login": "samir_01",
 *       "password": "samir_01",
 *       "suserInfo": {
 *         "id": 1,
 *         "name": "samir",
 *         "lastname": "lachiheb",
 *         "idUser": 1
 *       }
 *     }
 *   },
 *   {
 *     "id": 2,
 *     "sprofile": {
 *       "id": 2,
 *       "name": "CUSTOM",
 *       "description": "Client/Agent"
 *     },
 *     "suser": {
 *       "id": 2,
 *       "name": "ahmed",
 *       "login": "ahmed_01",
 *       "password": "ahmed_01",
 *       "suserInfo": {
 *         "id": 2,
 *         "name": "ahmed",
 *         "lastname": "ouderni",
 *         "idUser": 2
 *       }
 *     }
 *   }
 */