
package com.example.demo.controller;

import com.example.demo.service.CacheUtility;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(name = "/empty-cache/v1", description = "EMPTY CACHE")
@RestController
@RequestMapping(value = "/empty-cache/v1")
public class CacheController {

    @Autowired
    private CacheUtility cacheUtility;

    @Operation(description = "Empty Cache")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")})
    @GetMapping
    public ResponseEntity<HttpStatus> findAll() {
        cacheUtility.invalidateCache();
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }


}
