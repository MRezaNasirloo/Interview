package com.mrezanasirloo.data.network.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class LastLikeItem{

	@SerializedName("senderName")
	private String senderName;

	@SerializedName("senderImgSrc")
	private String senderImgSrc;

	@SerializedName("senderUsername")
	private String senderUsername;

	public void setSenderName(String senderName){
		this.senderName = senderName;
	}

	public String getSenderName(){
		return senderName;
	}

	public void setSenderImgSrc(String senderImgSrc){
		this.senderImgSrc = senderImgSrc;
	}

	public String getSenderImgSrc(){
		return senderImgSrc;
	}

	public void setSenderUsername(String senderUsername){
		this.senderUsername = senderUsername;
	}

	public String getSenderUsername(){
		return senderUsername;
	}

	@Override
 	public String toString(){
		return 
			"LastLikeItem{" + 
			"senderName = '" + senderName + '\'' + 
			",senderImgSrc = '" + senderImgSrc + '\'' + 
			",senderUsername = '" + senderUsername + '\'' + 
			"}";
		}
}