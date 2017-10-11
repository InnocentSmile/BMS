package adminAction;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import DB.dbAdmin;

import com.opensymphony.xwork2.ActionSupport;

public class LookMessageAction extends ActionSupport{
     private HttpServletRequest request;
     private String message="input";
     @Override
    public String execute() throws Exception {
    	request=ServletActionContext.getRequest();
    	dbAdmin DB=new dbAdmin();
    	List list=DB.findAllAdmin();
    	request.getSession().setAttribute("count", list.size());
    	request.getSession().setAttribute("allinfo",list);
    	message="success";
    	return message; 
    }
}
