package milkman;

import java.sql.Date;

public class billstatus {

	String cnamebc;
	Date strtdt,enddate;
	float amount;
	int status;
	public billstatus(){}
	public billstatus(String cnamebc,Date strtdt,Date enddate,float amount)
	{
		this.cnamebc=cnamebc;
		this.strtdt=strtdt;
		this.enddate=enddate;
		this.amount=amount;
	}
	public String getCnamebc() {
		return cnamebc;
	}
	public void setCnamebc(String cnamebc) {
		this.cnamebc = cnamebc;
	}
	public Date getStrtdt() {
		return strtdt;
	}
	public void setStrtdt(Date strtdt) {
		this.strtdt = strtdt;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	
}
