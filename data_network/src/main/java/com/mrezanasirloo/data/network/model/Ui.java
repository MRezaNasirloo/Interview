package com.mrezanasirloo.data.network.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Ui{

	@SerializedName("pagingForward")
	private String pagingForward;

	public void setPagingForward(String pagingForward){
		this.pagingForward = pagingForward;
	}

	public String getPagingForward(){
		return pagingForward;
	}

	@Override
 	public String toString(){
		return 
			"Ui{" + 
			"pagingForward = '" + pagingForward + '\'' + 
			"}";
		}
}