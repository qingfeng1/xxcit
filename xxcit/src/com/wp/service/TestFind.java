package com.wp.service;

import org.hibernate.Session;

import com.wp.model.Message;
import com.wp.model.Revert;
import com.wp.util.HibernateUtil;

public class TestFind {

    public static void main(String[] args) {

        // 持久化
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        
        Message message =(Message) session.get(Message.class, 1);
        System.out.println("班级名称:"+message.getContent());
        System.out.println("班级地址:"+message.getId());
        System.out.println("班级人数:"+message.getRevert());
        
        for(Revert revert:message.getRevert())
        {
            System.out.println(revert.getContent()+":"+revert.getRevertTime());
        }

        session.getTransaction().commit();
    }

}