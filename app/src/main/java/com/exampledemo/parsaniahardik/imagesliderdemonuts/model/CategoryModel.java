package com.exampledemo.parsaniahardik.imagesliderdemonuts.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryModel{

	@SerializedName("subTitle")
	private List<Object> subTitle;

	@SerializedName("themesColor")
	private String themesColor;

	@SerializedName("iconImagePath")
	private String iconImagePath;

	@SerializedName("name")
	private String name;

	@SerializedName("iconFile")
	private Object iconFile;

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private List<TitleItem> title;

	@SerializedName("subcategory")
	private List<Object> subcategory;

	@SerializedName("productList")
	private List<Object> productList;

	public void setSubTitle(List<Object> subTitle){
		this.subTitle = subTitle;
	}

	public List<Object> getSubTitle(){
		return subTitle;
	}

	public void setThemesColor(String themesColor){
		this.themesColor = themesColor;
	}

	public String getThemesColor(){
		return themesColor;
	}

	public void setIconImagePath(String iconImagePath){
		this.iconImagePath = iconImagePath;
	}

	public String getIconImagePath(){
		return iconImagePath;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setIconFile(Object iconFile){
		this.iconFile = iconFile;
	}

	public Object getIconFile(){
		return iconFile;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTitle(List<TitleItem> title){
		this.title = title;
	}

	public List<TitleItem> getTitle(){
		return title;
	}

	public void setSubcategory(List<Object> subcategory){
		this.subcategory = subcategory;
	}

	public List<Object> getSubcategory(){
		return subcategory;
	}

	public void setProductList(List<Object> productList){
		this.productList = productList;
	}

	public List<Object> getProductList(){
		return productList;
	}

	@Override
 	public String toString(){
		return 
			"CategoryModel{" + 
			"subTitle = '" + subTitle + '\'' + 
			",themesColor = '" + themesColor + '\'' + 
			",iconImagePath = '" + iconImagePath + '\'' + 
			",name = '" + name + '\'' + 
			",iconFile = '" + iconFile + '\'' + 
			",id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			",subcategory = '" + subcategory + '\'' + 
			",productList = '" + productList + '\'' + 
			"}";
		}
}