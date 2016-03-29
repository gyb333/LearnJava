package com.gyb.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.service.UserService;

public class MyBatisUtil {
	private static final String RESOURCE = "mybatis-config.xml";  
	public static final ThreadLocal<SqlSession> tl_Session = new ThreadLocal<SqlSession>();
	public static final SqlSessionFactory  sqlSessionFactory;

	  static {  
	        Reader reader = null;  
	        try {  
	            reader = Resources.getResourceAsReader(RESOURCE);  
	        } catch (IOException e) {  
	            throw new RuntimeException("Get resource error:"+RESOURCE, e);  
	        }  
	  
	        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
	        
	        
	        // 注解方式查询时需要注册mapper  
	        sqlSessionFactory.getConfiguration().addMapper(UserService.class);  
	    }  
	      
	    
	    public static SqlSessionFactory getSqlSessionFactory(){     
	        return sqlSessionFactory;     
	    }  
	      
	   
	    public static SqlSessionFactory rebuildSqlSessionFactory(){  
	        Reader reader = null;  
	        try {  
	            reader = Resources.getResourceAsReader(RESOURCE);  
	        } catch (IOException e) {  
	            throw new RuntimeException("Get resource error:"+RESOURCE, e);  
	        }  
	  
	        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
	        return sqlSessionFactory;
	    }  
	      
	 
	    public static SqlSession getSession(){  
	        SqlSession session = tl_Session.get();  
	          
	        if(session==null){  
	            if(sqlSessionFactory == null){  
	                rebuildSqlSessionFactory();  
	            }  
	            //如果sqlSessionFactory不为空则获取sqlSession，否则返回null  
	            session = (sqlSessionFactory!=null) ? sqlSessionFactory.openSession(): null;  
	        }  
	          
	        return session;  
	    }  
	      
	   
	    public static void closeSession(){  
	        SqlSession session = tl_Session.get();  
	        tl_Session.set(null);  
	        if(session!=null){  
	            session.close();  
	        }  
	    }  
}
