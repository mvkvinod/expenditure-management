/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dadDiary.logics;

import com.dadDiary.crud.TotalBalanceCRUD;
import com.dadDiary.modals.TotalBalanceTable;
import com.dadDiary.utils.EventStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author HP
 */
public class TotalBalanceLogic {
    TotalBalanceCRUD totBal = new TotalBalanceCRUD();
    
    public boolean createTotalBalTable(Date dt, long NewBagTotal,  long NewBankTotal, long NewPurseTotal) throws ParseException{
        SimpleDateFormat frmt = new SimpleDateFormat("dd/mm/yyyy");
        String dtStr = frmt.format(dt);
        Date date = frmt.parse(dtStr);
        EventStatus result = totBal.createTotBalTable(date ,NewBagTotal, NewBankTotal, NewPurseTotal);
        return result.isCreateDone();
    }
    
    public boolean UpdateTotBalTable(Date dt, long NewBagTotal,  long NewBankTotal, long NewPurseTotal) throws ParseException{
        SimpleDateFormat frmt = new SimpleDateFormat("dd/mm/yyyy");
        String dtStr = frmt.format(dt);
        Date date = frmt.parse(dtStr);
        EventStatus result = totBal.UpdateTotBalTable(date, NewBagTotal, NewBankTotal, NewPurseTotal);
        return result.isUpdateDone();
    }
    
    public TotalBalanceTable fetchTotalBalanceDetails() {
        return totBal.fetchTotalBalanceDetails();
    }

    public boolean deleteTotalBalTable(Date dt) throws ParseException {
        SimpleDateFormat frmt = new SimpleDateFormat("dd/mm/yyyy");
        String dtStr = frmt.format(dt);
        Date date = frmt.parse(dtStr);
        EventStatus reslut = totBal.deleteTotalBalTable(date);
        return reslut.isDeleteDone();
    }
}
