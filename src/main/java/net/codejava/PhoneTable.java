package net.codejava;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "phone_table")
public class PhoneTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Integer ID;

    @Column(name = "Country_ID")
    private BigDecimal CountryID;

    @Column(name = "Phone_Number")
    private java.math.BigDecimal PhoneNumber;

    @Column(name = "Vote_Count")
    private java.math.BigDecimal VoteCount;

    @Column(name = "Update_Time")
    private java.sql.Timestamp UpdateTime;

    @Column(name = "Status")
    private java.math.BigDecimal Status;

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public BigDecimal getCountryID() {
        return CountryID;
    }

    public void setCountryID(BigDecimal countryID) {
        CountryID = countryID;
    }

    public BigDecimal getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(BigDecimal phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public BigDecimal getVoteCount() {
        return VoteCount;
    }

    public void setVoteCount(BigDecimal voteCount) {
        VoteCount = voteCount;
    }

    public Timestamp getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        UpdateTime = updateTime;
    }

    public BigDecimal getStatus() {
        return Status;
    }

    public void setStatus(BigDecimal status) {
        Status = status;
    }

    public PhoneTable() {
    }

    public PhoneTable(Integer ID, BigDecimal CountryID, BigDecimal PhoneNumber, java.sql.Timestamp UpdateTime, BigDecimal VoteCount, java.math.BigDecimal Status) {
        this.ID = ID;
        this.PhoneNumber = PhoneNumber;
        this.CountryID = CountryID;
        this.UpdateTime = UpdateTime;
        this.VoteCount = VoteCount;
        this.Status = Status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getID() {
        return ID;
    }
}