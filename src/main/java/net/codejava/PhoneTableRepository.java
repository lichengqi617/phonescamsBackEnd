package net.codejava;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*; 
import org.springframework.data.repository.query.*; 

import java.math.BigDecimal;
import java.util.Optional; 

public interface PhoneTableRepository extends JpaRepository<PhoneTable, Integer> {
    @Query(nativeQuery = true, 
        value = "select * from phone_table PhoneTable where PhoneTable.CountryID = :countryID and PhoneTable.PhoneNumber = :phoneNumber")
    Optional<PhoneTable> findByCountryIDAndPhoneNumber(@Param("countryID") String countryID, @Param("phoneNumber") String phoneNumber);
}
