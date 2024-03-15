
package com.example.demo.controller;

import com.example.demo.domain.SUser;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

//    @Operation(description = "Adds User with information")
//    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
//            @ApiResponse(responseCode = "400", description = "Bad Request"),
//            @ApiResponse(responseCode = "404", description = "Not Found"),
//            @ApiResponse(responseCode = "500", description = "Internal server error occurred")})
//    @PostMapping(value = "/add-user-with-info")
//    public SUser addUser(@RequestBody SUser user ) {
//        return userService.addUser(user);
//    }

}