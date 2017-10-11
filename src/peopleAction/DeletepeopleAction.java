package peopleAction;

import org.apache.struts2.ServletActionContext;

import com.sun.net.httpserver.Authenticator.Success;

import DB.dbPeople;

public class DeletepeopleAction {
	private String mess="input";
	public String execute() throws Exception {   
 	  String id= ServletActionContext.getRequest().getParameter("id");
	    dbPeople db=new dbPeople();
	    boolean del=db.deleteInfo(id);
	    if(del){
	    	mess="success";
	    }
		return mess;
	  
   }
}
