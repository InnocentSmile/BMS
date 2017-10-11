package bookAction;

import org.apache.struts2.ServletActionContext;

import DB.dbBook;;

public class DeletebookAction {

	private String mess="input";
	public String execute() throws Exception {   
 	  String id= ServletActionContext.getRequest().getParameter("id");
	    dbBook db=new dbBook();
	    boolean del=db.deleteInfo(id);
	    if(del){
	    	mess="success";
	    }
		return mess;
	  
   }
}
