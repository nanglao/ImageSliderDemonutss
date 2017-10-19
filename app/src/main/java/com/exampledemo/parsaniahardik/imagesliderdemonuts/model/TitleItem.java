package com.exampledemo.parsaniahardik.imagesliderdemonuts.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TitleItem{

	@SerializedName("name")
	private String name;

	@SerializedName("subCategoryList")
	private List<SubCategoryListItem> subCategoryList;

	@SerializedName("id")
	private int id;

	@SerializedName("categoryId")
	private Object categoryId;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSubCategoryList(List<SubCategoryListItem> subCategoryList){
		this.subCategoryList = subCategoryList;
	}

	public List<SubCategoryListItem> getSubCategoryList(){
		return subCategoryList;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCategoryId(Object categoryId){
		this.categoryId = categoryId;
	}

	public Object getCategoryId(){
		return categoryId;
	}

	@Override
 	public String toString(){
		return 
			"TitleItem{" + 
			"name = '" + name + '\'' + 
			",subCategoryList = '" + subCategoryList + '\'' + 
			",id = '" + id + '\'' + 
			",categoryId = '" + categoryId + '\'' + 
			"}";
		}
}