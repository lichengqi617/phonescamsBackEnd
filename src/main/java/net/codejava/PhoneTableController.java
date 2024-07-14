package net.codejava;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;

@RestController
public class PhoneTableController {
    @Autowired
    private PhoneTableService service;

    // RESTful API methods for Retrieval operations
    @GetMapping("/PhoneTable")
    @CrossOrigin
    public List<PhoneTable> list() {
        return service.listAll();
    }

    // RESTful API methods for Retrieval operations
    @GetMapping("/PhoneTable/{id}")
    @CrossOrigin
    public ResponseEntity<PhoneTable> get(@PathVariable Integer id) {
        try {
            PhoneTable phoneTable = service.get(id);
            return new ResponseEntity<PhoneTable>(phoneTable, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<PhoneTable>(HttpStatus.NOT_FOUND);
        }
    }

    // RESTful API method for get by CountryCode and Phone number operation
    @GetMapping("/PhoneTable/{countryCode}/{phoneNumber}")
    @CrossOrigin
    public ResponseEntity<PhoneTable> getByCountryCodeAndPhoneNumber(@PathVariable String countryCode, @PathVariable String phoneNumber) {
        try {
            PhoneTable phoneTable = service.getByCountryCodeAndPhoneNumber(countryCode, phoneNumber);
            return new ResponseEntity<PhoneTable>(phoneTable, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<PhoneTable>(HttpStatus.NOT_FOUND);
        }
    }

    // RESTful API method for Create or Update by CountryCode and Phone number operation
    @PostMapping("/PhoneTable/{countryCode}/{phoneNumber}")
    @CrossOrigin
    public void addByCountryCodeAndPhoneNumber(@PathVariable String countryCode, @PathVariable String phoneNumber) {
        try {
            PhoneTable existPhone = service.getByCountryCodeAndPhoneNumber(countryCode, phoneNumber);
            existPhone.setVoteCount(existPhone.getVoteCount().add(new BigDecimal(1)));
            service.save(existPhone);
        } catch (NoSuchElementException e) {
            PhoneTable phoneTable = new PhoneTable();
            phoneTable.setCountryCode(new BigDecimal(countryCode));
            phoneTable.setPhoneNumber(new BigDecimal(phoneNumber));
            phoneTable.setVoteCount(new BigDecimal(1));
            service.save(phoneTable);
        }
    }

    // RESTful API method for Create operation
    @PostMapping("/PhoneTable")
    @CrossOrigin
    public void add(@RequestBody PhoneTable phoneTable) {
        service.save(phoneTable);
    }

    // RESTful API method for Update operation
    public ResponseEntity<?> update(@RequestBody PhoneTable phoneTable, @PathVariable Integer id) {
        try {
            PhoneTable existPhone = service.get(id);
            phoneTable.setId(id);
            service.save(phoneTable);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // RESTful API method for Delete operation
    @DeleteMapping("/PhoneTable/{id}")
    @CrossOrigin
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}