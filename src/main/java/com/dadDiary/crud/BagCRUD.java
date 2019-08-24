/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dadDiary.crud;

import com.dadDiary.modals.BagTable;
import com.dadDiary.utils.EventStatus;
import com.dadDiary.utils.HibernateUtil;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.resource.transaction.spi.TransactionStatus;

/**
 *
 * @author HP
 */
public class BagCRUD {

    private static final SessionFactory FACTORY = HibernateUtil.getSessionFactory();

    public EventStatus createBag(Date dt, int rs2000, int rs500, int rs200, int rs100, int rs50, int rs20, int rs10) {
        EventStatus createBag = new EventStatus();
        Session session = FACTORY.openSession();

        try {
            session.beginTransaction();
            SimpleDateFormat frmt = new SimpleDateFormat("dd/mm/yyyy");
            String dtStr = frmt.format(dt);
            Date date = frmt.parse(dtStr);    
            BagTable bag = new BagTable();
            bag.setDate(date);
            bag.setRs10(rs10);
            bag.setRs20(rs20);
            bag.setRs50(rs50);
            bag.setRs100(rs100);
            bag.setRs200(rs200);
            bag.setRs500(rs500);
            bag.setRs2000(rs2000);
            session.save(bag);
            session.getTransaction().commit();
            createBag.setCreateDone(true);

            return createBag;
        } catch (Exception hx) {
            if (session.getTransaction().getStatus() == TransactionStatus.ACTIVE || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                session.getTransaction().rollback();
            }
            hx.printStackTrace();
            System.out.println("bagCrud error");
        } finally {
            session.close();

            return createBag;
        }

    }

    public EventStatus UpdateBag(Date dt, int rs2000, int rs500, int rs200, int rs100, int rs50, int rs20, int rs10) {
        EventStatus UpdateBag = new EventStatus();
        Session session = FACTORY.openSession();

        try {

            session.beginTransaction();
            SimpleDateFormat frmt = new SimpleDateFormat("dd/mm/yyyy");
            String dtStr = frmt.format(dt);
            Date date = frmt.parse(dtStr);
            BagTable bagtable = (BagTable) session.get(BagTable.class, date);
            bagtable.setRs10(rs10);
            bagtable.setRs20(rs20);
            bagtable.setRs50(rs50);
            bagtable.setRs100(rs100);
            bagtable.setRs200(rs200);
            bagtable.setRs500(rs500);
            bagtable.setRs2000(rs2000);
            session.save(bagtable);
            session.getTransaction().commit();
            UpdateBag.setUpdateDone(true);
            session.close();

            return UpdateBag;
        } catch (HibernateException hx) {
            if (session.getTransaction().getStatus() == TransactionStatus.ACTIVE || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
            return UpdateBag;
        }
    }

    /**
     *
     * @return
     */
    public List<BagTable> fetchBagDetails() {
        List<BagTable> details = null;
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            details = session.createQuery("from BagTabel").list();
            session.getTransaction().commit();
            session.close();
        }

        return details;
    }

    public EventStatus deleteBag(Date dt) {
        EventStatus deleteBag = new EventStatus();
        Session session = FACTORY.openSession();
        try {

            session.beginTransaction();
            SimpleDateFormat frmt = new SimpleDateFormat("dd/mm/yyyy");
            String dtStr = frmt.format(dt);
            Date date = frmt.parse(dtStr);
            BagTable bagtable = new BagTable();
            bagtable.setDate(date);

            session.delete(bagtable);

            session.getTransaction().commit();
            deleteBag.setDeleteDone(true);
            return deleteBag;
        } catch (HibernateException hx) {
            if (session.getTransaction().getStatus() == TransactionStatus.ACTIVE
                    || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                session.getTransaction().rollback();
            }

        } finally {

            session.close();
            return deleteBag;
        }
    }

}
