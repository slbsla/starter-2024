
package com.example.demo.controller;

import com.example.demo.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "/personal-information/v1", description = "ContactController Endpoint for managing contacts")
@RestController
@RequestMapping(value = "/personal-information/v1")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @Operation(description = "Retrieves all contacts.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")})
    @GetMapping(value = "/contacts")
    public DTOCache findAll(@RequestParam String myToken) throws InterruptedException {
        return contactService.findAllCached(myToken);
    }

    @Operation(description = "Retrieves all contacts. Cache2")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")})
    @GetMapping(value = "/contacts-cache-without-token")
    public DTOCache findAllv3(HttpServletRequest request) throws InterruptedException {
        return contactService.findAllCached(request.getRemoteHost());
    }


    @Operation(description = "Finds a contact by {id}.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")})

    @GetMapping(value = "/contact/{id}")
    public com.example.demo.domain.Contact findContact(@PathVariable("id") Long id) {
        return contactService.findByIdUsingCache(id);
    }

    @Operation(description = "Adds a new contact. It is necessary to fill in the attributes as shown in the 'Example Value'.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")})
    @PostMapping(value = "/contact")
    public com.example.demo.domain.Contact createContact(@RequestBody com.example.demo.domain.Contact contact) {
        return contactService.save(contact);
    }

    @Operation(description = "Deletes an existing contact by {id}.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred") })
    @DeleteMapping(value = "/contact/{id}")
    public void deleteContact(@PathVariable("id") Long id) {
        contactService.delete(id);
    }

    @Operation(description = "Updates an existing contact by {id}.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred") })
    @PutMapping(value = "/contact/{id}")
    public com.example.demo.domain.Contact updateContact(@PathVariable("id") Long id, @RequestBody com.example.demo.domain.Contact contact){
                    return contactService.update(id, contact);
    }


}
