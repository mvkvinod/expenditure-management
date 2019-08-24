/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dadDiary.logics;

import com.dadDiary.crud.BagCRUD;
import com.dadDiary.modals.BagTable;
import com.dadDiary.utils.EventStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author HP
 */
public class BagTableLogic {

    BagCRUD bag = new BagCRUD();

    public boolean createBag(Date dt, int rs2000, int rs500, int rs200, int rs100, int rs50, int rs20, int rs10) throws ParseException {
            SimpleDateFormat frmt = new SimpleDateFormat("dd/mm/yyyy");
            String dtStr = frmt.format(dt);
            Date date = frmt.parse(dtStr);
        EventStatus result = bag.createBag(date, rs2000, rs500, rs200, rs100, rs50, rs20, rs10);
        return result.isCreateDone();
    }

    public boolean updateBag(Date dt, int rs2000, int rs500, int rs200, int rs100, int rs50, int rs20, int rs10) throws ParseException {
            SimpleDateFormat frmt = new SimpleDateFormat("dd/mm/yyyy");
            String dtStr = frmt.format(dt);
            Date date = frmt.parse(dtStr);
        EventStatus result = bag.UpdateBag(date, rs2000, rs500, rs200, rs100, rs50, rs20, rs10);
        return result.isUpdateDone();
    }

    public List<BagTable> fetchBagDetails() {
        return bag.fetchBagDetails();
    }

    public boolean deleteBag(Date dt) throws ParseException {
            SimpleDateFormat frmt = new SimpleDateFormat("dd/mm/yyyy");
            String dtStr = frmt.format(dt);
            Date date = frmt.parse(dtStr);
        EventStatus reslut = bag.deleteBag(date);
        return reslut.isDeleteDone();
    }

}
