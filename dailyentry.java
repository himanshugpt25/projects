package milkman;

import java.sql.Date;

public class dailyentry {

	Date tdate;
	String custn;
	float cmq,bmq;
	public dailyentry(Date tdate,String custn,float cmq,float bmq)
	{
		this.tdate=tdate;
		this.custn=custn;
		this.cmq=cmq;
		this.bmq=bmq;
	}
	public Date getTdate() {
		return tdate;
	}
	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}
	public String getCustn() {
		return custn;
	}
	public void setCustn(String custn) {
		this.custn = custn;
	}
	public float getCmq() {
		return cmq;
	}
	public void setCmq(float cmq) {
		this.cmq = cmq;
	}
	public float getBmq() {
		return bmq;
	}
	public void setBmq(float bmq) {
		this.bmq = bmq;
	}
	
}
