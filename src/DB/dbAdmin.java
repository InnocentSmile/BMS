package DB;

import java.util.List;
import addHibernateFile.HibernateSessionFactory;
import PO.adminPO;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class dbAdmin {
   private Session session;
   private Transaction transaction;
   private Query query;
   HibernateSessionFactory getSession;
   public dbAdmin(){
   }
   
   //添加
   public String saveAdmin(adminPO aPo){
	   String mess="error";
	   getSession=new HibernateSessionFactory();
	   session=getSession.getSession();
	   try {
		    transaction=session.beginTransaction();
		    session.save(aPo);
		    transaction.commit();
		    mess="success";
		    return mess;
	} catch (Exception e) {
		    message("Register.error"+e);
		    e.printStackTrace();
		    return null;
	}
}
   
  
   //查询返回list集合（登录）
   public List queryAdmin(String type,Object value){
	   getSession=new HibernateSessionFactory();
	   session=getSession.getSession();
	   try {
		     String hqlsql="from adminPO as u where u.userName=?";
		     query=session.createQuery(hqlsql);
		     query.setParameter(0, value);
		     List list=query.list();
		     transaction=session.beginTransaction();
		     transaction.commit();
		     return list;
	       } catch (Exception e) {
		     message("LoginAdmin类中有异常类，异常为："+e);
		     e.printStackTrace();
		     return null;
	       }
   }
	//按条件type查询
   public List findAdmin(String type,Object value){
	   getSession=new HibernateSessionFactory();
	   session=getSession.getSession();
	   try {		   
		transaction=session.beginTransaction();
		//HQL语句
		String queryString="from adminPO as model where model."+type+"=?";
		 query=session.createQuery(queryString);
	     query.setParameter(0, value);
	     List list=query.list();
	     transaction.commit();
	     session.close();
	     return list;
	} catch (Exception e) {
		message("findAdmin.error:"+e);
	     e.printStackTrace();
	     return null;
	}
}
   
   //查找整个表的信息
   public List findAllAdmin(){
	   getSession=new HibernateSessionFactory();
	   session=getSession.getSession();
	   try {
		transaction=session.beginTransaction();
		String queryString="from adminPO";
		query=session.createQuery(queryString); 
	    List list=query.list();
	    transaction.commit();
	    session.close();
	    return list;
	} catch (Exception e) {
		message("findAllAdmin.error:"+e);
	    e.printStackTrace();
	    return null;
	}
}
   
   
   
   //修改管理员信息
   public boolean updateAdmin(adminPO apPo){
	   getSession=new HibernateSessionFactory();
	   session=getSession.getSession();
	   try {
		     transaction=session.beginTransaction();
		     session.update(apPo);
		     transaction.commit();
		     session.close();
		     return true;
	       } catch (Exception e) {
	    	message("updateAdmin.error:"+e);
	   	    e.printStackTrace();
	   	    return false;
	      }
   }
   
   //删除管理员
    public boolean deleteAdmin(int id) {
       getSession=new HibernateSessionFactory();
  	   session=getSession.getSession();
  	   try {
		      transaction=session.beginTransaction();
		      adminPO infoAdminPO=new adminPO();
		      infoAdminPO=(adminPO)session.get(adminPO.class,id);
		      session.delete(infoAdminPO);
		      transaction.commit();
		      session.close();
		      return true;
	       } catch (Exception e) {
	    	   message("deleteAdmin.error:"+e);
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
