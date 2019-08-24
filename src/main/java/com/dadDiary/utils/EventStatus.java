/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dadDiary.utils;

/**
 *
 * @author HP
 */
public class EventStatus {

    private boolean createDone = false;
    private boolean updateDone = false;
    private boolean deleteDone = false;
    private String msg;

    public boolean isCreateDone() {
        return createDone;
    }

    public void setCreateDone(boolean createDone) {
        this.createDone = createDone;
        System.out.println("tabel created");
    }

    public boolean isUpdateDone() {
        return updateDone;
    }

    public void setUpdateDone(boolean updateDone) {
        this.updateDone = updateDone;
    }

    public boolean isDeleteDone() {
        return deleteDone;
    }

    public void setDeleteDone(boolean deleteDone) {
        this.deleteDone = deleteDone;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "EventStatus{" + "CreateDone= " + createDone + ",UpdateDone= " + updateDone + ",DeleteDone= " + deleteDone + '}';
    }

}
