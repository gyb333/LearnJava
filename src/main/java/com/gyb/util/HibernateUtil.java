package com.gyb.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;




public class HibernateUtil {

	public static final ThreadLocal<Session> tl_Session = new ThreadLocal<Session>();
	public static final SessionFactory sessionFactory;

	
	static {
		
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();

//		Metadata metadata = new MetadataSources( standardRegistry )
//				.addAnnotatedClass( MyEntity.class )
//				.addAnnotatedClassName( "org.hibernate.example.Customer" )
//				.addResource( "org/hibernate/example/Order.hbm.xml" )
//				.addResource( "org/hibernate/example/Product.orm.xml" )
//				.getMetadataBuilder()
//				.applyImplicitNamingStrategy( ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )
//				.build();

//		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder()
//				.applyBeanManager( getBeanManagerFromSomewhere() )
//				.build();
		
		
		
		
	
		try{						
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
			
			//ansessionFactory= new AnnotationConfiguration().addPackage("models").addAnnotatedClass(MSISDN.class).buildSessionFactory();
		}catch(Exception ex){
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
						// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
			throw new ExceptionInInitializerError(ex);
		}
	}
	

	
	
	
	
	
	public static Session getCurrentSession() throws HibernateException{
		Session session = tl_Session.get();
		if(session ==null){
			session = sessionFactory.openSession();
			tl_Session.set(session);
			
		}
		return session;
	}
	
	public static void closeCurrentSession() throws HibernateException{		
		Session s =   tl_Session.get();  
		tl_Session.set(null);  
        if (s != null)  
            s.close();  
	}
	
		//获取全新的全新的sesession
		public static Session openSession(){
			return sessionFactory.openSession();
		}

		
		public static Object ExecSearch(ICallbackResult callback,Boolean isClosedSession){
			Session session = null;
			 
			Object obj = null;
			try{
				session = openSession();			 
				obj= callback.ExecResult(session);	 			 
			}catch(Exception e){			 
				throw new RuntimeException(e);
			}finally{
				if(isClosedSession&&session!=null&&session.isOpen()){
					session.close();
				}
			}
			return obj;
		}
						
		
		public static void ExecByTrans(ICallback callback,Boolean isClosedSession){
			Session session = null;
			Transaction transaction =null;
			 
			try{
				session = openSession();
				transaction = session.beginTransaction();
				callback.Exec(session);			 
				transaction.commit();
			}catch(Exception e){
				transaction.rollback();
				throw new RuntimeException(e);
			}finally{
				if(isClosedSession&&session!=null&&session.isOpen()){
					session.close();
				}
			}
			
		}
				
		
		public static Object ExectedByTransResult(ICallbackResult callback,Boolean isClosedSession){
			Session session = null;
			Transaction transaction =null;
			Object obj = null;
			try{
				session = openSession();
				transaction = session.beginTransaction();
				 obj= callback.ExecResult(session);			 
				transaction.commit();
			}catch(Exception e){
				transaction.rollback();
				throw new RuntimeException(e);
			}finally{
				if(isClosedSession&&session!=null&&session.isOpen()){
					session.close();
				}
			}
			return obj;
		}
		
	
		

//		public static void Exec(ICallback callback){
//			Session session = getCurrentSession();
//			callback.Exec(session); 
//		}
//		
//		public static Object ExecResult(ICallbackResult callback){
//			Session session = getCurrentSession();
//			return callback.ExecResult(session);
//		}
}
