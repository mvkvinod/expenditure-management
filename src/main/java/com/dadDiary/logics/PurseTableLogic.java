/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dadDiary.logics;

import com.dadDiary.crud.PurseCRUD;
import com.dadDiary.modals.PurseTable;
import com.dadDiary.utils.EventStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author HP
 */
public class PurseTableLogic {

    PurseCRUD purse = new PurseCRUD();

    public boolean createPurse(Date dt, int rs2000, int rs500, int rs200, int rs100, int rs50, int rs20, int rs10, int rs5, int rs2, int rs1) throws ParseException {
        SimpleDateFormat frmt = new SimpleDateFormat("dd/mm/yyyy");
        String dtStr = frmt.format(dt);
        Date date = frmt.parse(dtStr);
        EventStatus result = purse.createPurse(date, rs2000, rs500, rs200, rs100, rs50, rs20, rs10, rs5, rs2, rs1);
        return result.isCreateDone();
    }

    public boolean updatePurse(Date dt, int rs2000, int rs500, int rs200, int rs100, int rs50, int rs20, int rs10, int rs5, int rs2, int rs1) throws ParseException {
        SimpleDateFormat frmt = new SimpleDateFormat("dd/mm/yyyy");
        String dtStr = frmt.format(dt);
        Date date = frmt.parse(dtStr);
        EventStatus result = purse.UpdatePurse(date, rs2000, rs500, rs200, rs100, rs50, rs20, rs10, rs5, rs2, rs1);
        return result.isUpdateDone();
    }

    public List<PurseTable> fetchPurseDetails() {
        return purse.fetchPurseDetails();
    }

    public boolean deletePurse(Date dt)throws ParseException {
        SimpleDateFormat frmt = new SimpleDateFormat("dd/mm/yyyy");
        String dtStr = frmt.format(dt);
        Date date = frmt.parse(dtStr);
        EventStatus reslut = purse.deletePurse(date);
        return reslut.isDeleteDone();
    }

}
