/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dadDiary.crud;

import com.dadDiary.modals.PurseTable;
import com.dadDiary.utils.EventStatus;
import com.dadDiary.utils.HibernateUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.resource.transaction.spi.TransactionStatus;

/**
 *
 * @author HP
 */
public class PurseCRUD {

    private static final SessionFactory FACTORY = HibernateUtil.getSessionFactory();

    public EventStatus createPurse(Date dt, int rs2000, int rs500, int rs200, int rs100, int rs50, int rs20, int rs10, int rs5, int rs2, int rs1) {

        EventStatus createPurse = new EventStatus();
        Session session = FACTORY.openSession();

        try {

            session.beginTransaction();
            SimpleDateFormat frmt = new SimpleDateFormat("dd/mm/yyyy");
            String dtStr = frmt.format(dt);
            Date date = frmt.parse(dtStr);
            PurseTable purse = new PurseTable();
            purse.setDate(date);
            purse.setRs1(rs1);
            purse.setRs2(rs2);
            purse.setRs5(rs5);
            purse.setRs10(rs10);
            purse.setRs20(rs20);
            purse.setRs50(rs50);
            purse.setRs100(rs100);
            purse.setRs200(rs200);
            purse.setRs500(rs500);
            purse.setRs2000(rs2000);
            session.save(purse);
            session.getTransaction().commit();
            createPurse.setCreateDone(true);

            return createPurse;

        } catch (Exception ex) {
            if (session.getTransaction().getStatus() == TransactionStatus.ACTIVE || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                session.getTransaction().rollback();
            }
            ex.printStackTrace();
            System.out.println("purse crud error");
        } finally {
            session.close();

            return createPurse;
        }
    }

    public EventStatus UpdatePurse(Date dt, int rs2000, int rs500, int rs200, int rs100, int rs50, int rs20, int rs10, int rs5, int rs2, int rs1) {
        EventStatus UpdatePurse = new EventStatus();
        Session session = FACTORY.openSession();

        try {

            session.beginTransaction();
            SimpleDateFormat frmt = new SimpleDateFormat("dd/mm/yyyy");
            String dtStr = frmt.format(dt);
            Date date = frmt.parse(dtStr);
            PurseTable pursetable = (PurseTable) session.get(PurseTable.class, date);
            pursetable.setRs1(rs1);
            pursetable.setRs2(rs2);
            pursetable.setRs5(rs5);
            pursetable.setRs10(rs10);
            pursetable.setRs20(rs20);
            pursetable.setRs50(rs50);
            pursetable.setRs100(rs100);
            pursetable.setRs200(rs200);
            pursetable.setRs500(rs500);
            pursetable.setRs2000(rs2000);
            session.save(pursetable);
            session.getTransaction().commit();
            UpdatePurse.setUpdateDone(true);
            session.close();

            return UpdatePurse;
        } catch (HibernateException hx) {
            if (session.getTransaction().getStatus() == TransactionStatus.ACTIVE || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
            return UpdatePurse;
        }
    }

    public List<PurseTable> fetchPurseDetails() {
        List<PurseTable> details = null;
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            details = session.createQuery("from PurseTabel").list();
            session.getTransaction().commit();
            session.close();
        }

        return details;
    }

    public EventStatus deletePurse(Date dt) {
        EventStatus deletePurse = new EventStatus();
        Session session = FACTORY.openSession();
        try {

            session.beginTransaction();
            SimpleDateFormat frmt = new SimpleDateFormat("dd/mm/yyyy");
            String dtStr = frmt.format(dt);
            Date date = frmt.parse(dtStr);
            PurseTable pursetable = new PurseTable();
            pursetable.setDate(date);

            session.delete(pursetable);

            session.getTransaction().commit();
            deletePurse.setDeleteDone(true);
            return deletePurse;
        } catch (HibernateException hx) {
            if (session.getTransaction().getStatus() == TransactionStatus.ACTIVE
                    || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                session.getTransaction().rollback();
            }

        } finally {

            session.close();
            return deletePurse;
        }
    }
}
