package com.pratik.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pratik.domain.Emp;
import com.pratik.utility.HibernateUtil;

public class ClientApp_withdraw {

	public static void main(String[] args) {

		Session ses = null;			//creating the session object
		Transaction tx = null;		//creating transaction object
		Scanner sc=new Scanner(System.in);		//creating scanner for user input

		ses = HibernateUtil.getSession();			//get the cgf,factory,session
		
				//creating the domain class object
			System.out.print("\n\t\tEnter the Account Holder Number:");
			int no=sc.nextInt();
			float bal = 0;
			boolean flag=false;
				
				Object ob=ses.get(Emp.class.getName(),no);
				Emp e=(Emp)ob;
				if(ob!=null)
				{
					flag=true;
				System.out.println("\n\t\t"+e);
				System.out.println("\n\t\tTransactions Left: "+e.getVersion());
		try {
			tx = ses.beginTransaction();

				
			if (e.getVersion()>5)
			{
				System.out.println("\n\t\tNo Free Transactions");
			}
			
				System.out.print("\n\t\tEnter the Amount to Withdraw: ");
				int amt1=sc.nextInt();
				bal=e.getBalance()-(amt1);
			
			e.setBalance(bal);
			ses.update(e);
			tx.commit();
			System.out.println("\n\t\tWithdrawn Money: "+amt1);
			System.out.println("\n\t\tBalance: "+e.getBalance());
			if((5-e.getVersion())!=0)
			{			System.out.println("\n\t\tTransactions Left: "+(5-e.getVersion()));
			}else
			System.out.println("\t\tNo Free Transactions Available");
				

			} //try
			catch (HibernateException he) {
			System.out.println("\t\tRECORD NOT FOUND");
			tx.rollback();
			he.printStackTrace();
			flag=false;
		}//catch
		catch (Exception e3) {
			tx.rollback();
			e3.printStackTrace();
			flag=false;
		}//catch
		finally
		{
			try {
				
				ses.close();
				HibernateUtil.closeFactory();
				flag=false;
			}//catch
			catch (Exception e2) {
				e2.printStackTrace();
				flag=false;
			}//catch
		}//finally
		
				System.out.print("\n\t\t ==PROGRAMME BY PRATIK DIMBLE==\n\n\n");
	}//main
}//class
