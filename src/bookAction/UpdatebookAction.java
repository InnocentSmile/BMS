package bookAction;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import DB.dbBook;
import PO.bookPO;

public class UpdatebookAction extends ActionSupport implements ServletResponseAware{
	private String id;
	private String picture;
	private String name;
	private String author;
	private	String number;
	private	String place;
	private	String price;	
	private String mess="input";
    private javax.servlet.http.HttpServletResponse response; 
	
	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPicture() {
		return picture;
	}



	public void setPicture(String picture) {
		this.picture = picture;
	}



	public String getName() {
		String str = null;
		try {
			str=new String(name.getBytes("ISO-8859-1"),"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAuthor() {
		String str = null;
		try {
			str=new String(author.getBytes("ISO-8859-1"),"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public String getNumber() {
		return number;
	}



	public void setNumber(String number) {
		this.number = number;
	}



	public String getPlace() {
		String str = null;
		try {
			str=new String(place.getBytes("ISO-8859-1"),"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}



	public void setPlace(String place) {
		this.place = place;
	}



	public String getPrice() {
		String str = null;
		try {
			str=new String(price.getBytes("ISO-8859-1"),"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}



	public void setPrice(String price) {
		this.price = price;
	}


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
		
		if(this.getId()==null||this.getId().length()==0){
			addFieldError("id", "编号不能为空！");
			out.print("<script>alert('编号不能为空！')</script>");
			out.print("<script>window.location.href='LookBookAction'</script>");
			out.flush();
			out.close();
		}
		
		if (this.getName()==null||this.getName().length()==0) {
			addFieldError("name", "书名不能为空！");
			out.print("<script>alert('书名不能为空！')</script>");
			out.print("<script>window.location.href='LookBookAction'</script>");
			out.flush();
			out.close();
		}
		if (this.getAuthor()==null||this.getAuthor().length()==0) {
			addFieldError("author", "作者不能为空！");
			out.print("<script>alert('作者不能为空！')</script>");
			out.print("<script>window.location.href='LookBookAction'</script>");
			out.flush();
			out.close();
		}
		if (this.getNumber()==null||this.getNumber().length()==0) {
			addFieldError("number", "数量不能为空！");
			out.print("<script>alert('数量不能为空！')</script>");
			out.print("<script>window.location.href='LookBookAction'</script>");
			out.flush();
			out.close();
			
		}
		
		if (this.getPlace()==null||this.getPlace().length()==0) {
			addFieldError("number", "位置不能为空！");
			out.print("<script>alert('位置不能为空！')</script>");
			out.print("<script>window.location.href='LookBookAction'</script>");
			out.flush();
			out.close();
		}
		if (this.getPrice()==null||this.getPrice().length()==0) {
			addFieldError("number", "价格不能为空！");
			out.print("<script>alert('价格不能为空！')</script>");
			out.print("<script>window.location.href='LookBookAction'</script>");
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
	 		
	 		dbBook lr=new dbBook();
	    	boolean update=lr.updateInfo(info());
	    	if (update) {
	    		mess="success";
	    		out.print("<script>alert('修改成功！')</script>");
				out.print("<script>window.location.href='LookBookAction'</script>");
				out.flush();
				out.close();
			}
			return mess;
	    }
	
	public bookPO info(){
    	bookPO info=new bookPO();
    	info.setId(this.getId());
    	info.setPicture(this.getPicture());
    	info.setName(this.getName());
    	info.setAuthor(this.getAuthor());
    	info.setNumber(this.getNumber());
    	info.setPlace(this.getPlace());
    	info.setPrice(this.getPrice());
    	return info;
    }

	// 获得HttpServletResponse对象
    public void setServletResponse(HttpServletResponse response) {
          this.response = response;
    }
}
