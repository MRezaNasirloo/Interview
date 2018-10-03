package com.mrezanasirloo.data.network.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class PhotolistbytopItem{

	@SerializedName("photocoverLink")
	private Object photocoverLink;

	@SerializedName("sdate")
	private int sdate;

	@SerializedName("senderImgSrc")
	private String senderImgSrc;

	@SerializedName("likeLink")
	private Object likeLink;

	@SerializedName("albumid")
	private String albumid;

	@SerializedName("official")
	private boolean official;

	@SerializedName("imgSrcL")
	private String imgSrcL;

	@SerializedName("title")
	private String title;

	@SerializedName("imgSrcM")
	private String imgSrcM;

	@SerializedName("comment_cnt")
	private String commentCnt;

	@SerializedName("photodelLink")
	private Object photodelLink;

	@SerializedName("uid")
	private String uid;

	@SerializedName("senderName")
	private String senderName;

	@SerializedName("lastLike")
	private List<LastLikeItem> lastLike;

	@SerializedName("imgSrcS")
	private String imgSrcS;

	@SerializedName("size")
	private String size;

	@SerializedName("reportLink")
	private String reportLink;

	@SerializedName("lastComment")
	private List<LastCommentItem> lastComment;

	@SerializedName("likeStatus")
	private String likeStatus;

	@SerializedName("userType")
	private String userType;

	@SerializedName("like_cnt")
	private String likeCnt;

	@SerializedName("senderUsername")
	private String senderUsername;

	@SerializedName("album_title")
	private String albumTitle;

	public void setPhotocoverLink(Object photocoverLink){
		this.photocoverLink = photocoverLink;
	}

	public Object getPhotocoverLink(){
		return photocoverLink;
	}

	public void setSdate(int sdate){
		this.sdate = sdate;
	}

	public int getSdate(){
		return sdate;
	}

	public void setSenderImgSrc(String senderImgSrc){
		this.senderImgSrc = senderImgSrc;
	}

	public String getSenderImgSrc(){
		return senderImgSrc;
	}

	public void setLikeLink(Object likeLink){
		this.likeLink = likeLink;
	}

	public Object getLikeLink(){
		return likeLink;
	}

	public void setAlbumid(String albumid){
		this.albumid = albumid;
	}

	public String getAlbumid(){
		return albumid;
	}

	public void setOfficial(boolean official){
		this.official = official;
	}

	public boolean isOfficial(){
		return official;
	}

	public void setImgSrcL(String imgSrcL){
		this.imgSrcL = imgSrcL;
	}

	public String getImgSrcL(){
		return imgSrcL;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setImgSrcM(String imgSrcM){
		this.imgSrcM = imgSrcM;
	}

	public String getImgSrcM(){
		return imgSrcM;
	}

	public void setCommentCnt(String commentCnt){
		this.commentCnt = commentCnt;
	}

	public String getCommentCnt(){
		return commentCnt;
	}

	public void setPhotodelLink(Object photodelLink){
		this.photodelLink = photodelLink;
	}

	public Object getPhotodelLink(){
		return photodelLink;
	}

	public void setUid(String uid){
		this.uid = uid;
	}

	public String getUid(){
		return uid;
	}

	public void setSenderName(String senderName){
		this.senderName = senderName;
	}

	public String getSenderName(){
		return senderName;
	}

	public void setLastLike(List<LastLikeItem> lastLike){
		this.lastLike = lastLike;
	}

	public List<LastLikeItem> getLastLike(){
		return lastLike;
	}

	public void setImgSrcS(String imgSrcS){
		this.imgSrcS = imgSrcS;
	}

	public String getImgSrcS(){
		return imgSrcS;
	}

	public void setSize(String size){
		this.size = size;
	}

	public String getSize(){
		return size;
	}

	public void setReportLink(String reportLink){
		this.reportLink = reportLink;
	}

	public String getReportLink(){
		return reportLink;
	}

	public void setLastComment(List<LastCommentItem> lastComment){
		this.lastComment = lastComment;
	}

	public List<LastCommentItem> getLastComment(){
		return lastComment;
	}

	public void setLikeStatus(String likeStatus){
		this.likeStatus = likeStatus;
	}

	public String getLikeStatus(){
		return likeStatus;
	}

	public void setUserType(String userType){
		this.userType = userType;
	}

	public String getUserType(){
		return userType;
	}

	public void setLikeCnt(String likeCnt){
		this.likeCnt = likeCnt;
	}

	public String getLikeCnt(){
		return likeCnt;
	}

	public void setSenderUsername(String senderUsername){
		this.senderUsername = senderUsername;
	}

	public String getSenderUsername(){
		return senderUsername;
	}

	public void setAlbumTitle(String albumTitle){
		this.albumTitle = albumTitle;
	}

	public String getAlbumTitle(){
		return albumTitle;
	}

	@Override
 	public String toString(){
		return 
			"PhotolistbytopItem{" + 
			"photocoverLink = '" + photocoverLink + '\'' + 
			",sdate = '" + sdate + '\'' + 
			",senderImgSrc = '" + senderImgSrc + '\'' + 
			",likeLink = '" + likeLink + '\'' + 
			",albumid = '" + albumid + '\'' + 
			",official = '" + official + '\'' + 
			",imgSrcL = '" + imgSrcL + '\'' + 
			",title = '" + title + '\'' + 
			",imgSrcM = '" + imgSrcM + '\'' + 
			",comment_cnt = '" + commentCnt + '\'' + 
			",photodelLink = '" + photodelLink + '\'' + 
			",uid = '" + uid + '\'' + 
			",senderName = '" + senderName + '\'' + 
			",lastLike = '" + lastLike + '\'' + 
			",imgSrcS = '" + imgSrcS + '\'' + 
			",size = '" + size + '\'' + 
			",reportLink = '" + reportLink + '\'' + 
			",lastComment = '" + lastComment + '\'' + 
			",likeStatus = '" + likeStatus + '\'' + 
			",userType = '" + userType + '\'' + 
			",like_cnt = '" + likeCnt + '\'' + 
			",senderUsername = '" + senderUsername + '\'' + 
			",album_title = '" + albumTitle + '\'' + 
			"}";
		}
}