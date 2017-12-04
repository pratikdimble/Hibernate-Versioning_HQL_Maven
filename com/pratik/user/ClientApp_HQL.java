package com.pratik.user;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.pratik.domain.Emp;
import com.pratik.utility.HibernateUtil;


public class ClientApp_HQL {
	private static final String hql_query="from Bank_Account where  accno>=? and accno<=?";
	public static void main(String[] args) {
		Session ses=null;
		//Query query=null;
		
		ses=HibernateUtil.getSession();
		Query query=ses.createQuery("from Emp");
		List<Emp> list=query.list();
		for(Emp e:list) {
		System.out.println("\n\t\t***"+e);
		}
    	HibernateUtil.closeSession(ses);
		HibernateUtil.closeFactory();
	System.out.print("\n\t\t ==PROGRAMME BY PRATIK DIMBLE==\n\n\n");
	}//main(-,-)
}//class
