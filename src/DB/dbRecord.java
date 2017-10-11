package DB;


import java.util.List;
import addHibernateFile.HibernateSessionFactory;
import PO.recordPO;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import com.sun.org.apache.commons.collections.FastArrayList;

public class dbRecord {
	private Transaction transaction;
    private Session session;
    private Query query;
    HibernateSessionFactory getSession;
    public dbRecord() {
		
	}
    
  //添加record信息操作
    public boolean saveInfo1(recordPO rPO){
       getSession=new HibernateSessionFactory();
 	   session=getSession.getSession();
    	try {
			 transaction=session.beginTransaction();
			  session.save(rPO);
			  transaction.commit();
			  session.close();
			  return true;
		} catch (Exception e) {
			message("saveInfo.error:"+e);
			e.printStackTrace();
			return false;			
		}
    }
    
    //record查找全部的操作
    public List findAllInfo1(){
    	getSession=new HibernateSessionFactory();
  	   session=getSession.getSession();
  	   try {
		transaction=session.beginTransaction();
		String queryString="from recordPO";
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
    
    public void message(String mess) {
		int type=JOptionPane.YES_NO_OPTION;
		String title="提示消息";
		JOptionPane.showMessageDialog(null, mess,title,type);
	}
}
