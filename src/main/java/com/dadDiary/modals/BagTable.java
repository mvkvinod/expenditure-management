/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dadDiary.modals;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author HP
 */
@Entity
public class BagTable {

    @Column(name = "date")
    private Date date;

    @Column(name = "denom2000")
    private int rs2000;

    @Column(name = "denom500")
    private int rs500;

    @Column(name = "denom200")
    private int rs200;

    @Column(name = "denom100")
    private int rs100;

    @Column(name = "denom50")
    private int rs50;

    @Column(name = "denom20")
    private int rs20;

    @Column(name = "denom10")
    private int rs10;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false)
    private Long Serial;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRs2000() {
        return rs2000;
    }

    public void setRs2000(int rs2000) {
        this.rs2000 = rs2000;
    }

    public int getRs500() {
        return rs500;
    }

    public void setRs500(int rs500) {
        this.rs500 = rs500;
    }

    public int getRs200() {
        return rs200;
    }

    public void setRs200(int rs200) {
        this.rs200 = rs200;
    }

    public int getRs100() {
        return rs100;
    }

    public void setRs100(int rs100) {
        this.rs100 = rs100;
    }

    public int getRs50() {
        return rs50;
    }

    public void setRs50(int rs50) {
        this.rs50 = rs50;
    }

    public int getRs20() {
        return rs20;
    }

    public void setRs20(int rs20) {
        this.rs20 = rs20;
    }

    public int getRs10() {
        return rs10;
    }

    public void setRs10(int rs10) {
        this.rs10 = rs10;
    }

    public Long getSerial() {
        return Serial;
    }

    public void setSerial(Long Serial) {
        this.Serial = Serial;
    }

}
