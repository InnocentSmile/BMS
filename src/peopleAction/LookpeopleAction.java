package peopleAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import DB.dbPeople;

import com.opensymphony.xwork2.ActionSupport;

public class LookpeopleAction extends ActionSupport{
	private HttpServletRequest request;
    private String message="input";
    
    public String execute() throws Exception {
    	request=ServletActionContext.getRequest();
    	dbPeople DB=new dbPeople();
    	List list=DB.findAllInfo();
    	request.getSession().setAttribute("count", list.size());
    	request.getSession().setAttribute("allinfo",list);
    	message="success";
    	return message; 
    }
}
