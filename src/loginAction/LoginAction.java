package loginAction;

import com.opensymphony.xwork2.ActionSupport;

import DB.dbAdmin;
import PO.adminPO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;



public class LoginAction extends ActionSupport implements ServletResponseAware{
   private String userName;
   private String password;
   private String type;
   private String message="error";
   private List list;
   private javax.servlet.http.HttpServletResponse response;
    	   
   public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


public String getUserName() {
	String str = null;
	try {
		str=new String(userName.getBytes("ISO-8859-1"),"UTF-8");
	} catch (Exception e) {
		e.printStackTrace();
	}
	return str;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public void validate(){
	response.setContentType("text/html;charset=UTF-8");
	response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码
	PrintWriter out = null;
	try {
		out = response.getWriter();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	if(this.getUserName()==null||this.getUserName().length()==0){
//		addFieldError("userName","管理员账号不能为空！");
		out.print("<script>alert('管理员账号不能为空！')</script>");
		out.print("<script>window.location.href='http://127.0.0.1:8080/pzl/login/login.jsp'</script>");
		out.flush();
		out.close();
	}else {
		dbAdmin infoAdmin=new dbAdmin();
		list=infoAdmin.queryAdmin("userName",this.getUserName());
		if (list.size()==0) {
//			addFieldError("userName","该账号尚未注册！");	
			out.print("<script>alert('该账号尚未注册！')</script>");
			out.print("<script>window.location.href='http://127.0.0.1:8080/pzl/login/login.jsp'</script>");
			out.flush();
			out.close();
		}else {
			adminPO ui=new adminPO();
			int count=0;
			for (int i = 0; i < list.size(); i++) {
				count++;
				ui=(adminPO)list.get(i);
				if (this.getUserName().equals(ui.getUserName())) {
					if (ui.getPassword().equals(this.getPassword())){
						if (ui.getType().equals("s")) {
							message="SAdmin";
						}else {
							message=SUCCESS;
						}
				
					}else {
//						addFieldError("password","登录密码不正确！");
						out.print("<script>alert('登录密码不正确！')</script>");
						out.print("<script>window.location.href='http://127.0.0.1:8080/pzl/login/login.jsp'</script>");
						out.flush();
						out.close();
					}
				}
			}
		}
	}
}
      public String execute() throws Exception{
	     return message;
    }
   // 获得HttpServletResponse对象
      public void setServletResponse(HttpServletResponse response) {
            this.response = response;
      }

}
