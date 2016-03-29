package com.mybatis.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gyb.util.MyBatisUtil;
import com.mybatis.entity.User;
import com.mybatis.service.UserService;

public class UserDao {
	@SuppressWarnings("static-access")  
    public void add(String id, String username, String password)  
    {  
        SqlSession session = MyBatisUtil.getSession();  
        try  
        {  
            session.getMapper(UserService.class).add(id, username, password);  
            session.commit();// 提交事务  
        } catch (Exception e)  
        {  
            e.printStackTrace();  
        } finally  
        {  
            session.close();  
        }  
    }  
  
    @SuppressWarnings("static-access")  
    public void delete(String id)  
    {  
        SqlSession session = MyBatisUtil.getSession(); 
        try  
        {  
            session.getMapper(UserService.class).delete(id);  
            session.commit();// 提交事务  
        } catch (Exception e)  
        {  
            e.printStackTrace();  
        } finally  
        {  
            session.close();  
        }  
    }  
  
    @SuppressWarnings("static-access")  
    public int update(String username, String password, String id)  
    {  
        int count = 0;  
        SqlSession session = MyBatisUtil.getSession();  
        try  
        {  
            // Map<String, Object> map=new HashMap<String, Object>();  
            // map.put("username", user.getUsername());  
            // map.put("password", user.getPassword());  
            // session.update("updateUser", map);  
            count = session.getMapper(UserService.class).update(username, password, id);  
            session.commit();// 提交事务  
        } catch (Exception e)  
        {  
            count = 0;  
            e.printStackTrace();  
        } finally  
        {  
            session.close();  
        }  
        return count;  
    }  
    
    public User getUser(String id){
    	User user =null;
    	SqlSession session = MyBatisUtil.getSession(); 
        try  
        {  
        	user = session.getMapper(UserService.class).getUser(id);
        } catch (Exception e)  
        {  
            e.printStackTrace();  
        } finally  
        {  
            session.close();  
        }  
        return user;
    }
    
    public List<User> getUsers(){
    	List<User> users =null;
    	SqlSession session = MyBatisUtil.getSession(); 
        try  
        {  
        	users = session.getMapper(UserService.class).getUsers();
        } catch (Exception e)  
        {  
            e.printStackTrace();  
        } finally  
        {  
            session.close();  
        }  
        return users;
    }
  
    @SuppressWarnings("static-access")  
    public List<User> getUsers(int offset, int pageSize)  
    {  
        List<User> users = new ArrayList<User>();  
        SqlSession session = MyBatisUtil.getSession(); 
        try  
        {  
            // users=session.selectList("user_list_page", new User(),new  
            // RowBounds(offset,pageSize));//未测试过  
            // 注解方式查询  
            users = session.getMapper(UserService.class).getUsersByPage(offset, pageSize);  
        } catch (Exception e)  
        {  
            e.printStackTrace();  
        } finally  
        {  
            session.close();  
        }  
        return users;  
    }  
}
