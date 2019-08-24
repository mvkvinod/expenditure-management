/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dadDiary.crud;

import com.dadDiary.modals.TotalBalanceTable;
import com.dadDiary.utils.EventStatus;
import com.dadDiary.utils.HibernateUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;

/**
 *
 * @author HP
 */
public class TotalBalanceCRUD {

    private static final SessionFactory FACTORY = HibernateUtil.getSessionFactory();

    public EventStatus createTotBalTable(Date dt, long bagBal, long bankBal, long purseBal) {
        EventStatus createTotBalTable = new EventStatus();
        Session session = FACTORY.openSession();

        try {

            session.beginTransaction();
            SimpleDateFormat frmt = new SimpleDateFormat("dd/mm/yyyy");
            String dtStr = frmt.format(dt);
            Date date = frmt.parse(dtStr);
            TotalBalanceTable totBal = new TotalBalanceTable();
            totBal.setDate(date);
            totBal.setBankBal(bankBal);
            totBal.setBagBal(bagBal);
            totBal.setPurseBal(purseBal);
            session.save(totBal);
            session.getTransaction().commit();
            createTotBalTable.setCreateDone(true);

        } catch (Exception ex) {
            if (session.getTransaction().getStatus() == TransactionStatus.ACTIVE || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                session.getTransaction().rollback();
            }
            ex.printStackTrace();
            System.out.println("totbal crud error");

        } finally {
            session.close();

            return createTotBalTable;
        }
    }

    public EventStatus UpdateTotBalTable(Date dt, long bagBal, long bankBal, long purseBal) {
        EventStatus UpdateTotBalTable = new EventStatus();
        Session session = FACTORY.openSession();

        try {

            session.beginTransaction();
            SimpleDateFormat frmt = new SimpleDateFormat("dd/mm/yyyy");
            String dtStr = frmt.format(dt);
            Date date = frmt.parse(dtStr);
            TotalBalanceTable TotBalTab = (TotalBalanceTable) session.get(TotalBalanceTable.class, date);
            TotBalTab.setBagBal(bagBal);
            TotBalTab.setBankBal(bankBal);
            TotBalTab.setPurseBal(purseBal);
            session.save(TotBalTab);
            session.getTransaction().commit();
            UpdateTotBalTable.setUpdateDone(true);
            session.close();

            return UpdateTotBalTable;
        } catch (HibernateException hx) {
            if (session.getTransaction().getStatus() == TransactionStatus.ACTIVE || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                session.getTransaction().rollback();
            }

        } finally {
            session.close();
            return UpdateTotBalTable;
        }

    }

    public TotalBalanceTable fetchTotalBalanceDetails() {
            
        TotalBalanceTable details = null;
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            Date dt = new Date();
            SimpleDateFormat frmt = new SimpleDateFormat("dd/mm/yyyy");
            String dtStr = frmt.format(dt);
            Date date = frmt.parse(dtStr);
            Query getTotBal = session.getNamedQuery("findTotalBalance");
            getTotBal.setParameter("date", dt);
            details =(TotalBalanceTable) getTotBal.getSingleResult();
            System.out.println(details.getBagBal());
            session.getTransaction().commit();
            session.close();
        } catch (ParseException ex) {
            Logger.getLogger(TotalBalanceCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return details;
    }

    public EventStatus deleteTotalBalTable(Date dt) {
        EventStatus deleteTotalBalTable = new EventStatus();
        Session session = FACTORY.openSession();
        try {

            session.beginTransaction();
            SimpleDateFormat frmt = new SimpleDateFormat("dd/mm/yyyy");
            String dtStr = frmt.format(dt);
            Date date = frmt.parse(dtStr);
            TotalBalanceTable totbaltbl = new TotalBalanceTable();
            totbaltbl.setDate(date);

            session.delete(totbaltbl);
            session.getTransaction().commit();
            deleteTotalBalTable.setDeleteDone(true);
            return deleteTotalBalTable;
        } catch (HibernateException ex) {
            if (session.getTransaction().getStatus() == TransactionStatus.ACTIVE
                    || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                session.getTransaction().rollback();
            }

        } finally {
            session.close();
            return deleteTotalBalTable;
        }
    }
}
