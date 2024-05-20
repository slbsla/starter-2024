
package com.example.demo.controller;

import com.example.demo.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "/personal-information/v1", description = "ContactController Endpoint for managing contacts")
@RestController
@RequestMapping(value = "/personal-information/v1")
public class ContactController {

    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);


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
    public List<com.example.demo.domain.Contact> findAll() {
        logger.info("INFO : call to ContactController - findAll");
        return contactService.findAll();
    }

    @Operation(description = "Finds a contact by {id}.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")})

    @Parameter(name = "Contact's {id}", required = true)
    @GetMapping(value = "/contact/{id}")
    public com.example.demo.domain.Contact findContact(@PathVariable("id") Long id) {
        logger.info("INFO : call to ContactController - findContact >> ", id);

        return contactService.find(id);
    }

    @Operation(description = "Adds a new contact. It is necessary to fill in the attributes as shown in the 'Example Value'.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")})
    @PostMapping(value = "/contact")
    public com.example.demo.domain.Contact createContact(@RequestBody com.example.demo.domain.Contact contact) {

        logger.info("INFO : call to ContactController - createContact >> ", contact.toString());

        return contactService.save(contact);
    }

    @Operation(description = "Deletes an existing contact by {id}.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred") })
    @DeleteMapping(value = "/contact/{id}")
    public void deleteContact(@PathVariable("id") Long id) {

        logger.info("INFO : call to ContactController - deleteContact >> ", id);

        contactService.delete(id);
    }

    @Operation(description = "Updates an existing contact by {id}.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred") })
    @PutMapping(value = "/contact/{id}")
    public com.example.demo.domain.Contact updateContact(@PathVariable("id") Long id, @RequestBody com.example.demo.domain.Contact contact) {

        logger.info("INFO : call to ContactController - updateContact >> ", contact.toString());

        return contactService.update(id, contact);
    }


}
