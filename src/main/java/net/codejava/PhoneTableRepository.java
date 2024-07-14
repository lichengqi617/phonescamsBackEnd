package net.codejava;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface PhoneTableRepository extends JpaRepository<PhoneTable, Integer> {
    @Query("select p from PhoneTable where PhoneTable.CountryID = ?1 and PhoneTable.PhoneNumber = ?2")
    PhoneTable findByCountryIDAndPhoneNumber(String countryID, String phoneNumber);
}
