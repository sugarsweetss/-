package weixin_mp.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import weixin_mp.entity.marker;
import weixin_mp.methods.Beat;

public interface mapService {
	
	//获取所有marker信息
	String getAllMarkers()throws JSONException;
	
	//获取用户攻击点附近的marker信息
	String getNearMarkers(double nelatitude,double swlatitude,double nelongitude,double swlongitude) throws JSONException;
	
	//更新地图,返回更新后的所有marker的结果(传给前端)
	String getUpdateResult(ArrayList<marker> markerList) throws JSONException;
	
	//处理传入的marker数组，返回markerJsonString
	String markerArrayToString(ArrayList<marker> markerList) throws JSONException;
	
	//更新marker数据库(作用于数据库)
	void markerUpdate(ArrayList<marker> markerList);
	
	//对应calcMarkers的功能，返回改变后的所有的markers
	ArrayList<marker> calcAllMarkers(double longitude,double latitude,String sessionId);
	
	//计算攻击点附近的markers变化情况，返回攻击点附近的markers
	ArrayList<marker> calcNearMarkers(String sessionId,double longitude,double nelongitude,double swlongitude,double latitude,double nelatitude,double swlatitude);
	
	//获取攻击者的color
	String getAttackerColor(String sessionId);
	
	//返回攻击点附近的markers信息
	ArrayList<marker> getNearMarkersArray(double nelatitude,double swlatitude,double nelongitude,double swlongitude);
	
	//返回需要传给前端的攻击点附近的markers信息
	ArrayList<marker> getNearMarkersForFrontEnd(ArrayList<marker> nearMarkersBeforeCalc,ArrayList<marker> nearMarkersAfterCalc);    //参数分别表示计算前和计算后攻击点附近的markers，二者进行对照
}
