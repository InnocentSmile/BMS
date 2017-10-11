package bookAction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;

import DB.dbBook;
import PO.bookPO;

import com.opensymphony.xwork2.ActionSupport;

public class AddbookAction extends ActionSupport implements ServletResponseAware{
	private String id;
	private String uploadFileName;
	private String name;
	private String author;
	private	String number;
	private	String place;
	private	String price;
	private File upload;	
	private String savePath;
	private String mess="input";
    private javax.servlet.http.HttpServletResponse response;
	
	
    
	
	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getUploadFileName() {
		return uploadFileName;
	}




	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}




	public String getName() {
		
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getAuthor() {
		
		return author;
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
		
		return place;
	}




	public void setPlace(String place) {
		this.place = place;
	}




	public String getPrice() {
		
		return price;
	}




	public void setPrice(String price) {
		this.price = price;
	}




	public File getUpload() {
		return upload;
	}




	public void setUpload(File upload) {
		this.upload = upload;
	}




	public String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}




	public void setSavePath(String savePath) {
		this.savePath = savePath;
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
			out.print("<script>window.location.href='http://127.0.0.1:8080/pzl/book/addBook.jsp'</script>");
			out.flush();
			out.close();
		}else {
			dbBook infoPeople=new dbBook();
			List list=infoPeople.findInfo("id",this.getId());										
		    if (!list.isEmpty()) {
					addFieldError("id", "编号已存在！");
					out.print("<script>alert('编号已存在！')</script>");
					out.print("<script>window.location.href='http://127.0.0.1:8080/pzl/book/addBook.jsp'</script>");
					out.flush();
					out.close();
				}
			}
		
		if (this.getName()==null||this.getName().length()==0) {
			addFieldError("name", "书名不能为空！");
			out.print("<script>alert('书名不能为空！')</script>");
			out.print("<script>window.location.href='http://127.0.0.1:8080/pzl/book/addBook.jsp'</script>");
			out.flush();
			out.close();
		}
		if (this.getAuthor()==null||this.getAuthor().length()==0) {
			addFieldError("author", "作者不能为空！");
			out.print("<script>alert('作者不能为空！')</script>");
			out.print("<script>window.location.href='http://127.0.0.1:8080/pzl/book/addBook.jsp'</script>");
			out.flush();
			out.close();
		}
		if (this.getNumber()==null||this.getNumber().length()==0) {
			addFieldError("number", "数量不能为空！");
			out.print("<script>alert('数量不能为空！')</script>");
			out.print("<script>window.location.href='http://127.0.0.1:8080/pzl/book/addBook.jsp'</script>");
			out.flush();
			out.close();
			
		}
		
		if (this.getPlace()==null||this.getPlace().length()==0) {
			addFieldError("number", "位置不能为空！");
			out.print("<script>alert('位置不能为空！')</script>");
			out.print("<script>window.location.href='http://127.0.0.1:8080/pzl/book/addBook.jsp'</script>");
			out.flush();
			out.close();
		}
		if (this.getPrice()==null||this.getPrice().length()==0) {
			addFieldError("number", "价格不能为空！");
			out.print("<script>alert('价格不能为空！')</script>");
			out.print("<script>window.location.href='http://127.0.0.1:8080/pzl/book/addBook.jsp'</script>");
			out.flush();
			out.close();
		}
  }

	 @Override
	    public String execute() throws Exception {
		 
		 FileOutputStream fos = new FileOutputStream(getSavePath()
					+"\\"+getUploadFileName());
			FileInputStream fis = new FileInputStream(getUpload());
			byte[] buffer = new byte [1024];
			int len=0;
			while ((len=fis.read(buffer))>0){
				fos.write(buffer,0,len);
			}
			fos.close();
			
			
	    	dbBook dao=new dbBook();
	    	boolean save=dao.saveInfo(info());
	    	if (save) {
				mess=SUCCESS;
			}
	    	return mess;
	    }
	 
	public bookPO info(){
    	bookPO info=new bookPO();
    	info.setId(this.getId());
    	info.setPicture(this.getUploadFileName());
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
