package adminAction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import DB.dbAdmin;
import PO.adminPO;

import com.opensymphony.xwork2.ActionSupport;

public class AddAdminAction extends ActionSupport implements ServletResponseAware{
    private String userName;
    private String password1;
    private String password2;
    private String type;
    private String mess="error";
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



	public String getPassword1() {
		return password1;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public void setPassword1(String password1) {
		this.password1 = password1;
	}



	public String getPassword2() {
		return password2;
	}



	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	

	@Override
	public void validate() {
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
			out.print("<script>window.location.href='http://127.0.0.1:8080/pzl/admin/addAdmin.jsp'</script>");
			out.flush();
			out.close();
		}else {
			dbAdmin infoAdmin=new dbAdmin();
			list=infoAdmin.queryAdmin("userName",this.getUserName());
			adminPO ui=new adminPO();
			for (int i= 0;i<list.size();i++) {
				ui=(adminPO)list.get(i);
				if (ui.getUserName().equals(this.getUserName())) {
					addFieldError(userName, "账号已存在！");
					out.print("<script>alert('账号已存在！')</script>");
					out.print("<script>window.location.href='http://127.0.0.1:8080/pzl/admin/addAdmin.jsp'</script>");
					out.flush();
					out.close();
				}
			}
		}
		if (this.getPassword1()==null||this.getPassword1().length()==0) {
			addFieldError("password", "密码不允许为空！");
			out.print("<script>alert('密码不允许为空！')</script>");
			out.print("<script>window.location.href='http://127.0.0.1:8080/pzl/admin/addAdmin.jsp'</script>");
			out.flush();
			out.close();
		}else if(this.getPassword2()==null||this.getPassword2().length()==0){
			addFieldError(userName, "重复密码不允许为空！");
			out.print("<script>alert('重复密码不允许为空！')</script>");
			out.print("<script>window.location.href='http://127.0.0.1:8080/pzl/admin/addAdmin.jsp'</script>");
			out.flush();
			out.close();
		}else if (!this.getPassword1().equals(this.getPassword2())) {
			addFieldError(userName, "两次密码不一致！");
			out.print("<script>alert('两次密码不一致！')</script>");
			out.print("<script>window.location.href='http://127.0.0.1:8080/pzl/admin/addAdmin.jsp'</script>");
			out.flush();
			out.close();
		}
  }
     public adminPO aPo(){
    	 adminPO aPo=new adminPO();
    	 aPo.setUserName(this.getUserName());
    	 aPo.setPassword(this.getPassword1());
    	 aPo.setType(this.getType());
    	 return aPo;
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
    	String ri=lr.saveAdmin(aPo());
    	if (ri.equals("success")) {
    		mess="success";
    		out.print("<script>alert('添加成功！')</script>");
			out.print("<script>window.location.href='LookMessageAction'</script>");
			out.flush();
			out.close();
		}
		return mess;
    	
    }
	// 获得HttpServletResponse对象
    public void setServletResponse(HttpServletResponse response) {
          this.response = response;
    }
	
}
