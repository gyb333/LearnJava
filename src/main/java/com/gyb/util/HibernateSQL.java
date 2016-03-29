package com.gyb.util;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateSQL  {


	
	public static Object FindById(Class clazz,Serializable id,Boolean isClosedSession){			
		
		return HibernateUtil.ExecSearch(
				(session)->{
			return session.load(clazz, id);
		},isClosedSession);
	}
	
	public static Object ExectedUniqueQuery(String hql,String [] params,Boolean isClosedSession){	
		 return HibernateUtil.ExecSearch((session)->{
			 Query query=session.createQuery(hql);
			 SetParams(query,params);
			 return query.uniqueResult();
		 },isClosedSession);			
	}
	
	
	

		public static List executeQueryByPage(String hql,String [] params,int pageSize,int pageNow,Boolean isClosedSession){
			Object obj = HibernateUtil.ExecSearch((session)->{
				 Query query=session.createQuery(hql);
				 SetParams(query,params);
				 query.setFirstResult((pageNow-1)*pageSize).setMaxResults(pageSize);				 
				 return query.list();
			 },isClosedSession);
			return (List) obj;			
		}
	
		private static void SetParams(Query query,String[] params){
			
			if(params!=null&& params.length>0){
				for(int i=0;i<params.length;i++){
					query.setString(i, params[i]);
				}
			}
		}
		
		
	

		public static void ExecuteUpdate(String hql,String[] params,Boolean isClosedSession){
			HibernateUtil.ExecByTrans((session)->{			
				  Query query = session.createQuery(hql);
				  SetParams(query,params);
				  query.executeUpdate();
			},isClosedSession);		
		}
			
		public static void ExectedSave(Object obj,Boolean isClosedSession){
			HibernateUtil.ExecByTrans((session)->{
				session.save(obj);
			},isClosedSession);	 
		}
		
	
	public static void ExecuteUpdateOpenInView(String hql,String[] params,Boolean isClosedSession){
		HibernateUtil.ExecByTrans((session)->{
			Query query=session.createQuery(hql);
			SetParams(query,params);
			query.executeUpdate();
		},isClosedSession);
	}
	
	
}
