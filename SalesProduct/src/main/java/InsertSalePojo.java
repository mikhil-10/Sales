
public class InsertSalePojo{
	private String id;
	private String sname;
	private String units;
	private String target;
	private String status;
	private String addedby;
	private String updatedby;
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddedby() {
		return addedby;
	}
	public void setAddedby(String addedby) {
		this.addedby = addedby;
	}
	public String getUpdatedby() {
		return updatedby;
	}
	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}
	public InsertSalePojo(String id,String sname, String units, String target, String status, String addedby, String updatedby) {
		super();
		this.id=id;
		this.sname = sname;
		this.units = units;
		this.target = target;
		this.status = status;
		this.addedby = addedby;
		this.updatedby = updatedby;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}