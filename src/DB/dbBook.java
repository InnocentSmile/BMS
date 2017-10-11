package DB;

import java.util.List;
import addHibernateFile.HibernateSessionFactory;
import PO.bookPO;


import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import com.sun.org.apache.commons.collections.FastArrayList;
public class dbBook {
	private Transaction transaction;
    private Session session;
    private Query query;
    HibernateSessionFactory getSession;
    public dbBook() {
		
	}
    
  //添加book信息操作
    public boolean saveInfo(bookPO bPO){
       getSession=new HibernateSessionFactory();
 	   session=getSession.getSession();
    	try {
			 transaction=session.beginTransaction();
			  session.save(bPO);
			  transaction.commit();
			  session.close();
			  return true;
		} catch (Exception e) {
			message("saveInfo.error:"+e);
			e.printStackTrace();
			return false;			
		}
    }
  //people条件查找操作
    public List findInfo(String type,Object value){
    	getSession=new HibernateSessionFactory();
  	   session=getSession.getSession();               
  	   try {
		transaction=session.beginTransaction();
		String queryString="from bookPO as model where model."+type+"=?";
		query=session.createQuery(queryString);
		query.setParameter(0, value);
		List list=query.list();
		transaction.commit();
		session.close();
		return list;
		
	} catch (Exception e) {
		message("findInfo.error:"+e);
		e.printStackTrace();
		return null;
	}
    }
    //people查找全部的操作
    public List findAllInfo(){
    	getSession=new HibernateSessionFactory();
  	   session=getSession.getSession();
  	   try {
		transaction=session.beginTransaction();
		String queryString="from bookPO";
		query=session.createQuery(queryString);		
		List list=query.list();
		transaction.commit();
		session.close();
		return list;
		
	} catch (Exception e) {
		message("findAllInfo.error:"+e);
		e.printStackTrace();
		return null;
	}
    }
    //删除people的操作
    public boolean deleteInfo(String id) {
    	 getSession=new HibernateSessionFactory();
    	   session=getSession.getSession();
    	   try {
  		      transaction=session.beginTransaction();
  		    bookPO infoPeoplePO=new bookPO();
  		    infoPeoplePO=(bookPO)session.get(bookPO.class,id);
  		      session.delete(infoPeoplePO);
  		      transaction.commit();
  		      session.close();
  		      return true;
  	       } catch (Exception e) {
  	    	   message("deleteAdmin.error:"+e);
  		   	   e.printStackTrace();
  		   	   return false;
  	   }
	}
    
    //修改people信息
    public boolean updateInfo(bookPO bPo){
 	   getSession=new HibernateSessionFactory();
 	   session=getSession.getSession();
 	   try {
 		     transaction=session.beginTransaction();
 		     session.update(bPo);
 		     transaction.commit();
 		     session.close();
 		     return true;
 	       } catch (Exception e) {
 	    	message("updateAdmin.error:"+e);
 	   	    e.printStackTrace();
 	   	    return false;
 	      }
    }
    public void message(String mess) {
		int type=JOptionPane.YES_NO_OPTION;
		String title="提示消息";
		JOptionPane.showMessageDialog(null, mess,title,type);
	}
}
