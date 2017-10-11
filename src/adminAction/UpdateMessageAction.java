package adminAction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import DB.dbAdmin;
import PO.adminPO;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateMessageAction extends ActionSupport implements ServletResponseAware{
	private String userName;
    private String password;
    private String type;
    private String mess="input";
    private List list;
    private javax.servlet.http.HttpServletResponse response;
    
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
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
			addFieldError(userName, "账号不能为空！");
			out.print("<script>alert('账号不能为空！')</script>");
			out.print("<script>window.location.href='LookMessageAction'</script>");
			out.flush();
			out.close();
	     }
		
		
		if (this.getPassword()==null||this.getPassword().length()==0) {
			addFieldError("password", "密码不允许为空！");
			out.print("<script>alert('密码不允许为空！')</script>");
			out.print("<script>window.location.href='LookMessageAction'</script>");
			out.flush();
			out.close();
		}
	 }
	
	 @Override
	public String execute() throws Exception {
		 response.setContentType("text/html;charset=UTF-8");
	 		response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码
	 		PrintWriter out = null;
	 		try {
	 			out = response.getWriter();
	 		} catch (IOException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	 		
	 		dbAdmin lr=new dbAdmin();
	    	boolean update=lr.updateAdmin(aPo());
	    	if (update) {
	    		mess="success";
	    		out.print("<script>alert('修改成功！')</script>");
				out.print("<script>window.location.href='LookMessageAction'</script>");
				out.flush();
				out.close();
			}
			return mess;
	}
	 
	 public adminPO aPo(){
    	 adminPO aPo=new adminPO();
    	 aPo.setUserName(this.getUserName());
    	 aPo.setPassword(this.getPassword());
    	 aPo.setType(this.getType());
    	 return aPo;
     }
	 
	// 获得HttpServletResponse对象
	    public void setServletResponse(HttpServletResponse response) {
	          this.response = response;
	    }
	
}
