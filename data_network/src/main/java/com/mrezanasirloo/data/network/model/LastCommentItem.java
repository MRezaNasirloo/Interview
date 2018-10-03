package com.mrezanasirloo.data.network.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class LastCommentItem{

	@SerializedName("senderName")
	private String senderName;

	@SerializedName("senderImgSrc")
	private String senderImgSrc;

	@SerializedName("commentBody")
	private String commentBody;

	@SerializedName("commentSdate")
	private int commentSdate;

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

	public void setCommentBody(String commentBody){
		this.commentBody = commentBody;
	}

	public String getCommentBody(){
		return commentBody;
	}

	public void setCommentSdate(int commentSdate){
		this.commentSdate = commentSdate;
	}

	public int getCommentSdate(){
		return commentSdate;
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
			"LastCommentItem{" + 
			"senderName = '" + senderName + '\'' + 
			",senderImgSrc = '" + senderImgSrc + '\'' + 
			",commentBody = '" + commentBody + '\'' + 
			",commentSdate = '" + commentSdate + '\'' + 
			",senderUsername = '" + senderUsername + '\'' + 
			"}";
		}
}