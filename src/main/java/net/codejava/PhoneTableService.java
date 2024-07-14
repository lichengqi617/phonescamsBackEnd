package net.codejava;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PhoneTableService {

    @Autowired
    private PhoneTableRepository repo;

    public List<PhoneTable> listAll() {
        return repo.findAll();
    }

    public void save(PhoneTable phoneNumber) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        phoneNumber.setUpdateTime(timestamp);
        repo.save(phoneNumber);
    }

    public PhoneTable get(Integer id) {
        return repo.findById(id).get();
    }

    public PhoneTable getByCountryIDAndPhoneNumber(String countryID, String phoneNumber) {
        return repo.findByCountryIDAndPhoneNumber(countryID, phoneNumber).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}