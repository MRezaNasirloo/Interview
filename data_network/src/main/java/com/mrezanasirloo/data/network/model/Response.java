package com.mrezanasirloo.data.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Response{

	@SerializedName("ui")
	private Ui ui;

	@SerializedName("photolistbytop")
	private List<PhotoItem> photolistbytop;

	public void setUi(Ui ui){
		this.ui = ui;
	}

	public Ui getUi(){
		return ui;
	}

	public void setPhotolistbytop(List<PhotoItem> photolistbytop){
		this.photolistbytop = photolistbytop;
	}

	public List<PhotoItem> getPhotolistbytop(){
		return photolistbytop;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"ui = '" + ui + '\'' + 
			",photolistbytop = '" + photolistbytop + '\'' + 
			"}";
		}
}