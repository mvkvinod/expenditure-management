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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author HP
 */
@Entity
@NamedQueries(
        {
            @NamedQuery(
            name = "findTotalBalance",
            query = "from TotalBalanceTable bl where bl.date= :date"
                    )
        })
public class TotalBalanceTable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false)
    private Long serial;

    @Column(name = "date")
    private Date date;

    @Column(name = "BagBalance")
    private long bagBal;

    @Column(name = "BankBalance")
    private long bankBal;

    @Column(name = "PurseBalance")
    private long purseBal;

    public Long getSerial() {
        return serial;
    }

    public void setSerial(Long serial) {
        this.serial = serial;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getBagBal() {
        return bagBal;
    }

    public void setBagBal(long bagBal) {
        this.bagBal = bagBal;
    }

    public long getBankBal() {
        return bankBal;
    }

    public void setBankBal(long bankBal) {
        this.bankBal = bankBal;
    }

    public long getPurseBal() {
        return purseBal;
    }

    public void setPurseBal(long purseBal) {
        this.purseBal = purseBal;
    }

}
