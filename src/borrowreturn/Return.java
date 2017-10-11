package borrowreturn;

import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import DB.dbBook;
import DB.dbRecord;
import PO.bookPO;
import PO.recordPO;
public class Return extends ActionSupport implements ServletResponseAware{
	private String id;
	private String picture;
	private String name;
	private String author;
	private	String number;
	private	String place;
	private	String price;	
	private	String pid;
	private	String num;
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
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
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
		
		if(this.getNum()==null||this.getNum().length()==0){
			addFieldError("num", "借书数量不能为空！");			
			out.print("<script>alert('借书数量不能为空！')</script>");
			out.print("<script>window.location.href='LookBookAction'</script>");
			out.flush();
			out.close();
		}
		if (Integer.valueOf(this.getNum())>3) {
            addFieldError("num", "借书数量不能超过3！");			
			out.print("<script>alert('借书数量不能超过3！')</script>");
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
    	
    	dbRecord pzl=new dbRecord();
    	boolean save=pzl.saveInfo1(recordinfo());
    	
    	if (update&&save) {
    		mess="success";
    		out.print("<script>alert('归还成功！')</script>");
			out.print("<script>window.location.href='LookBookAction'</script>");
			out.flush();
			out.close();
		}
		return mess;
    }
	
	public recordPO recordinfo(){
		recordPO recordinfo=new recordPO();
		recordinfo.setId(this.getId());
		recordinfo.setName(this.getName());
		recordinfo.setNum(this.getNum());
		recordinfo.setPeople(this.getPid());
		
		Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //System.out.println("当前时间：" + sdf.format(d));
//		Calendar now = Calendar.getInstance();
//        System.out.println("年：" + now.get(Calendar.YEAR));
//        System.out.println("月：" + (now.get(Calendar.MONTH) + 1));
//        System.out.println("日：" + now.get(Calendar.DAY_OF_MONTH));
//        System.out.println("时：" + now.get(Calendar.HOUR_OF_DAY));
//        System.out.println("分：" + now.get(Calendar.MINUTE));
//        System.out.println("秒：" + now.get(Calendar.SECOND));
//        time=now.get(Calendar.YEAR)+"年"+(now.get(Calendar.MONTH) + 1)+"月"+
//        now.get(Calendar.DAY_OF_MONTH)+"日"+now.get(Calendar.HOUR_OF_DAY)+"时"+
//        now.get(Calendar.MINUTE)+"分"+now.get(Calendar.SECOND)+"秒";                			
		recordinfo.setTime("还书时间"+sdf.format(d));
		return recordinfo;
	}
	
	public bookPO info(){
    	bookPO info=new bookPO();
    	info.setId(this.getId());
    	info.setPicture(this.getPicture());
    	info.setName(this.getName());
    	info.setAuthor(this.getAuthor());
    	
    	int b=Integer.valueOf(this.getNumber())+Integer.valueOf(this.getNum());
    	
        String booknum=String.valueOf(b);
    	
    	info.setNumber(booknum);
    	info.setPlace(this.getPlace());
    	info.setPrice(this.getPrice());
    	return info;
    }
	// 获得HttpServletResponse对象
    public void setServletResponse(HttpServletResponse response) {
          this.response = response;
    }
	
}
