package milkman;

import java.sql.Date;

public class custdetails {

	String custname,mobno,address;
	float cmilkq,bmilkq;
	Date dateen,datele;
	public custdetails(String custname,String mobno,String address,float cmilkq,float bmilkq,Date dateen,Date datele)
	{
		this.custname=custname;
		this.mobno=mobno;
		this.address=address;
		this.cmilkq=cmilkq;
		this.bmilkq=bmilkq;
		this.dateen=dateen;
		this.datele=datele;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getCmilkq() {
		return cmilkq;
	}
	public void setCmilkq(float cmilkq) {
		this.cmilkq = cmilkq;
	}
	public float getBmilkq() {
		return bmilkq;
	}
	public void setBmilkq(float bmilkq) {
		this.bmilkq = bmilkq;
	}
	public Date getDateen() {
		return dateen;
	}
	public void setDateen(Date dateen) {
		this.dateen = dateen;
	}
	public Date getDatele() {
		return datele;
	}
	public void setDatele(Date datele) {
		this.datele = datele;
	}
	
}
