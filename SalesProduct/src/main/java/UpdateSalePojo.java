public class UpdateSalePojo  {
	private String id;
	private String sname;
	private String units;
	private String target;
	private String status;
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
	
	public String getUpdatedby() {
		return updatedby;
	}
	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}
	public UpdateSalePojo(String id,String sname, String units, String target, String status, String updatedby) {
		super();
		this.id=id;
		this.sname = sname;
		this.units = units;
		this.target = target;
		this.status = status;
		this.updatedby = updatedby;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}