package borrowreturn;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import DB.dbRecord;

import com.opensymphony.xwork2.ActionSupport;

public class LookrecordAction extends ActionSupport{

	private HttpServletRequest request;
    private String message="input";
    
    public String execute() throws Exception {
    	request=ServletActionContext.getRequest();
    	dbRecord DB=new dbRecord();
    	List list=DB.findAllInfo1();
    	request.getSession().setAttribute("count", list.size());
    	request.getSession().setAttribute("allinfo1",list);
    	message="success";
    	return message; 
    }
}
