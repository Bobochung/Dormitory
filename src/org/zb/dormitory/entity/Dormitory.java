package org.zb.dormitory.entity;

//寝室
public class Dormitory {
	private int domitory_id;
    private String domitory_name;
    private String domitory_type;
    private String domitory_number;
    private String domitory_tel;
    private String building_name;
	public String getBuilding_name() {
		return building_name;
	}
	public void setBuilding_name(String building_name) {
		this.building_name = building_name;
	}
	public int getDomitory_id() {
		return domitory_id;
	}
	public void setDomitory_id(int domitory_id) {
		this.domitory_id = domitory_id;
	}
	public String getDomitory_name() {
		return domitory_name;
	}
	public void setDomitory_name(String domitory_name) {
		this.domitory_name = domitory_name;
	}
	public String getDomitory_type() {
		return domitory_type;
	}
	public void setDomitory_type(String domitory_type) {
		this.domitory_type = domitory_type;
	}
	public String getDomitory_number() {
		return domitory_number;
	}
	public void setDomitory_number(String domitory_number) {
		this.domitory_number = domitory_number;
	}
	public String getDomitory_tel() {
		return domitory_tel;
	}
	public void setDomitory_tel(String domitory_tel) {
		this.domitory_tel = domitory_tel;
	}
	@Override
	public String toString() {
		return "Dormitory [domitory_id=" + domitory_id +", domitory_name=" + domitory_name + ", domitory_type=" + domitory_type + ", domitory_number="
				+ domitory_number + ", domitory_tel=" + domitory_tel + ", building_name=" + building_name
				+ ", toString()=" + super.toString() + "]";
	}
	
    

}
