package com.pratik.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pratik.domain.Emp;
import com.pratik.utility.HibernateUtil;

public class ClientApp {

	public static void main(String[] args) {

		Session ses = null;			//creating the session object
		Emp em = null;				
		Transaction tx = null;		//creating transaction object
		Scanner sc=new Scanner(System.in);		//creating scanner for user input

		ses = HibernateUtil.getSession();			//get the cgf,factory,session
		
			em = new Emp();		//creating the domain class object
			System.out.print("\n\t\tEnter the Account Holder Name: ");
			String name=sc.nextLine();
			System.out.print("\n\t\tEnter the Account Type: ");
			String type=sc.nextLine();
			System.out.print("\n\t\tEnter the Account Holder Balance: ");
			float bal=sc.nextFloat();
				
				em.setHoldername(name);
				em.setAcctype(type);
				em.setBalance(bal);
		try {
			tx = ses.beginTransaction();
			ses.save(em);
			tx.commit();
			System.out.println("object is saved  with account number: "+em.getAccno());
			//System.out.print("\n\t\tEnter the Account Holder Name: ");
		} catch (Exception e) {
			tx.rollback();

		}
		HibernateUtil.closeSession(ses);
    HibernateUtil.closeFactory();

		System.out.print("\n\t\t ==PROGRAMME BY PRATIK DIMBLE==\n\n\n");

	}

}
