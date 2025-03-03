package weixin_mp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.json.JSONException;

import weixin_mp.entity.userInfo;


public interface userService {
	//删除玩家信息
	String deleteUserInfo(String sessionId);
	
	//设置玩家阵营
	void setUserChoice(String sessionId,String userChoice);
	
	//将新玩家信息插入数据库，并返回用户sessionId和userChoice
	String insertUserInfo(String code) throws JSONException;
	
	
	//把用户的sessionId和userChoice转化为json串
	String userInfoJson(String sessionId,String userChoice) throws JSONException;
}
