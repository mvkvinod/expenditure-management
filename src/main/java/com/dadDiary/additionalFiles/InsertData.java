/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dadDiary.additionalFiles;

import com.dadDiary.logics.BagTableLogic;
import com.dadDiary.logics.PurseTableLogic;
import com.dadDiary.logics.TotalBalanceLogic;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class InsertData {

    public static void main(String[] args) {
        TotalBalanceLogic tb = new TotalBalanceLogic();
        tb.fetchTotalBalanceDetails();

//        insertNewBag();
//        insertNewPurse();
//        insertNewTotBal();

    }

    public static void insertNewBag() {

        try {
            BagTableLogic bg = new BagTableLogic();
            Date dt = new Date();
            SimpleDateFormat frmt = new SimpleDateFormat("dd/mm/yyyy");
            String dtStr = frmt.format(dt);
            Date date = frmt.parse(dtStr);
            int rs2000 = 0;
            int rs500 = 0;
            int rs200 = 0;
            int rs100 = 0;
            int rs50 = 0;
            int rs20 = 0;
            int rs10 = 0;
            bg.createBag(date, rs2000, rs500, rs200, rs100, rs50, rs20, rs10);
        } catch (ParseException ex) {
            Logger.getLogger(InsertData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void insertNewPurse() {

        try {
            PurseTableLogic purs = new PurseTableLogic();
            Date dt = new Date();
            SimpleDateFormat frmt = new SimpleDateFormat("dd/mm/yyyy");
            String dtStr = frmt.format(dt);
            Date date = frmt.parse(dtStr);
            int rs2000 = 0;
            int rs500 = 0;
            int rs200 = 0;
            int rs100 = 0;
            int rs50 = 0;
            int rs20 = 0;
            int rs10 = 0;
            int rs5 = 0;
            int rs2 = 0;
            int rs1 = 0;
            purs.createPurse(date, rs2000, rs500, rs200, rs100, rs50, rs20, rs10, rs5, rs2, rs1);
        } catch (ParseException ex) {
            Logger.getLogger(InsertData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void insertNewTotBal(){
        try {
            System.out.println("start..........");
            TotalBalanceLogic totbal = new TotalBalanceLogic();
            Date dt = new Date();
            SimpleDateFormat frmt = new SimpleDateFormat("dd/mm/yyyy");
            String dtStr = frmt.format(dt);
            Date date = frmt.parse(dtStr);
            long NewPurseTotal = 0;
            long NewBagTotal = 0;
            long NewBankTotal = 0;
            totbal.createTotalBalTable(date ,NewBagTotal, NewBankTotal, NewPurseTotal);
            System.out.println("end.........");
        } catch (ParseException ex) {
            Logger.getLogger(InsertData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
