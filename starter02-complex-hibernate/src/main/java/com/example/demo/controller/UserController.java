
package com.example.demo.controller;

import com.example.demo.domain.SUser;
import com.example.demo.service.UserService;
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
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(description = "Retrieves all users")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")})
    @GetMapping(value = "/users-with-informations")
    public List<SUser> findAll() {
        return userService.findAll();
    }

}

/**
 *
 *  {
 *     "id": 1,
 *     "name": "samir",
 *     "login": "samir_01",
 *     "password": "samir_01",
 *     "suserInfo": {
 *       "id": 1,
 *       "name": "samir",
 *       "lastname": "lachiheb",
 *       "idUser": 1
 *     }
 *   },
 *   {
 *     "id": 2,
 *     "name": "ahmed",
 *     "login": "ahmed_01",
 *     "password": "ahmed_01",
 *     "suserInfo": {
 *       "id": 2,
 *       "name": "ahmed",
 *       "lastname": "ouderni",
 *       "idUser": 2
 *     }
 */