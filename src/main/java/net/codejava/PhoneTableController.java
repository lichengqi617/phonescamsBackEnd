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
    @CrossOrigin(origins = {"http://localhost:8081", "http://localhost:3000"})
    public List<PhoneTable> list() {
        return service.listAll();
    }

    // RESTful API methods for Retrieval operations
    @GetMapping("/PhoneTable/{id}")
    @CrossOrigin(origins = {"http://localhost:8081", "http://localhost:3000"})
    public ResponseEntity<PhoneTable> get(@PathVariable Integer id) {
        try {
            PhoneTable phoneTable = service.get(id);
            return new ResponseEntity<PhoneTable>(phoneTable, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<PhoneTable>(HttpStatus.NOT_FOUND);
        }
    }

    // RESTful API method for Create operation
    @PostMapping("/PhoneTable")
    @CrossOrigin(origins = {"http://localhost:8081", "http://localhost:3000"})
    public void add(@RequestBody PhoneTable phoneTable) {
        service.save(phoneTable);
    }

    // RESTful API method for Update operation
    public ResponseEntity<?> update(@RequestBody PhoneTable phoneTable, @PathVariable Integer id) {
        try {
            PhoneTable existProduct = service.get(id);
            service.save(phoneTable);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // RESTful API method for Delete operation
    @DeleteMapping("/PhoneTable/{id}")
    @CrossOrigin(origins = {"http://localhost:8081", "http://localhost:3000"})
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}