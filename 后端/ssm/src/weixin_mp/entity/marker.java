package weixin_mp.entity;

import com.sun.org.apache.bcel.internal.generic.NEW;

//import h.intitem;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

public class marker implements Cloneable{               //地图上的点
	private String id;                 //点id
	private double longitude;       //纬度
	private double latitude;        //经度
	private long content;             //点范围内的人数，对应数据库中的content属性
	private String color;           //点的背景色
	public marker() {}
	public marker(String id,double longitude,double latitude,String color,long content) {
		super();
		this.id=id;
		this.longitude=longitude;
		this.latitude=latitude;
		this.content=content;
		this.color=color;
		if ((color.equals("white") && content != 0) || (!color.equals("white") && content == 0))
            throw new ValueException("白色阵营时人数必须为0");
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude=longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude=latitude;
	}
	public long getContent() {
		return content;
	}
	public void setContent(long content) {
		this.content=content;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color=color;
	}
	
	public void print() {
    	if(color.equals("#ffffff"))
    		System.out.println("id: " + id + ", camp: white" + ", count: " + content);
    	else if(color.equals("#00ffc8"))
    		System.out.println("id: " + id + ", camp: green" + ", count: " + content);
    	else
    		System.out.println("id: " + id + ", camp: blue" + ", count: " + content);
    }
	
	public boolean equals(marker marker) {
		if(this.getContent()==marker.getContent()&&this.getColor().equals(marker.getColor())&&this.getId().equals(marker.getId()))
			return true;
		else
			return false;
	}

	public int hashCode() {
		return (this.id + this.content+this.color).hashCode();
	}
	
	@Override
	protected marker clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return new marker(id, longitude, latitude, color, content);
	}
}
