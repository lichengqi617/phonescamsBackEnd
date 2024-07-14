package net.codejava;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "phone_table")
public class PhoneTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Integer Id;

    @Column(name = "Country_Code")
    private BigDecimal CountryCode;

    @Column(name = "Phone_Number")
    private java.math.BigDecimal PhoneNumber;

    @Column(name = "Vote_Count")
    private java.math.BigDecimal VoteCount;

    @Column(name = "Update_Time")
    private java.sql.Timestamp UpdateTime;

    @Column(name = "Status")
    private java.math.BigDecimal Status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public BigDecimal getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(BigDecimal countryCode) {
        this.CountryCode = countryCode;
    }

    public BigDecimal getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(BigDecimal phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }

    public BigDecimal getVoteCount() {
        return VoteCount;
    }

    public void setVoteCount(BigDecimal voteCount) {
        this.VoteCount = voteCount;
    }

    public Timestamp getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.UpdateTime = updateTime;
    }

    public BigDecimal getStatus() {
        return Status;
    }

    public void setStatus(BigDecimal status) {
        this.Status = status;
    }

    public PhoneTable() {
    }

    public PhoneTable(Integer Id, BigDecimal CountryCode, BigDecimal PhoneNumber, java.sql.Timestamp UpdateTime, BigDecimal VoteCount, java.math.BigDecimal Status) {
        this.Id = Id;
        this.PhoneNumber = PhoneNumber;
        this.CountryCode = CountryCode;
        this.UpdateTime = UpdateTime;
        this.VoteCount = VoteCount;
        this.Status = Status;
    }
}