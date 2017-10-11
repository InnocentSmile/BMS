package adminAction;



import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;


import DB.dbAdmin;


import com.opensymphony.xwork2.ActionSupport;
public class DeleteMessageAction extends ActionSupport implements ServletResponseAware{
	 int id;
	 private String mess="input";
	 private javax.servlet.http.HttpServletResponse response;
	
	 
	
	 
	

 
       public String execute() throws Exception {   
    	   id= Integer.valueOf(ServletActionContext.getRequest().getParameter("id"));
	    dbAdmin db=new dbAdmin();
	    boolean del=db.deleteAdmin(id);
	    if(del){
	    	mess=SUCCESS;
	    }
	    return mess;
      }


	// 获得HttpServletResponse对象
    public void setServletResponse(HttpServletResponse response) {
          this.response = response;
    }
}
