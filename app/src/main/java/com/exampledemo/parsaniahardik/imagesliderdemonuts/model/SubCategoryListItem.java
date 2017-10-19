package com.exampledemo.parsaniahardik.imagesliderdemonuts.model;

import com.google.gson.annotations.SerializedName;

public class SubCategoryListItem{

	@SerializedName("subCatKeyWord")
	private Object subCatKeyWord;

	@SerializedName("titleId")
	private Object titleId;

	@SerializedName("name")
	private String name;

	@SerializedName("mainCategory")
	private Object mainCategory;

	@SerializedName("subImagePath")
	private Object subImagePath;

	@SerializedName("mainCatKeyWord")
	private Object mainCatKeyWord;

	@SerializedName("subImage")
	private Object subImage;

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private Object title;

	@SerializedName("categoryId")
	private Object categoryId;

	@SerializedName("keyWord")
	private Object keyWord;

	public void setSubCatKeyWord(Object subCatKeyWord){
		this.subCatKeyWord = subCatKeyWord;
	}

	public Object getSubCatKeyWord(){
		return subCatKeyWord;
	}

	public void setTitleId(Object titleId){
		this.titleId = titleId;
	}

	public Object getTitleId(){
		return titleId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setMainCategory(Object mainCategory){
		this.mainCategory = mainCategory;
	}

	public Object getMainCategory(){
		return mainCategory;
	}

	public void setSubImagePath(Object subImagePath){
		this.subImagePath = subImagePath;
	}

	public Object getSubImagePath(){
		return subImagePath;
	}

	public void setMainCatKeyWord(Object mainCatKeyWord){
		this.mainCatKeyWord = mainCatKeyWord;
	}

	public Object getMainCatKeyWord(){
		return mainCatKeyWord;
	}

	public void setSubImage(Object subImage){
		this.subImage = subImage;
	}

	public Object getSubImage(){
		return subImage;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTitle(Object title){
		this.title = title;
	}

	public Object getTitle(){
		return title;
	}

	public void setCategoryId(Object categoryId){
		this.categoryId = categoryId;
	}

	public Object getCategoryId(){
		return categoryId;
	}

	public void setKeyWord(Object keyWord){
		this.keyWord = keyWord;
	}

	public Object getKeyWord(){
		return keyWord;
	}

	@Override
 	public String toString(){
		return 
			"SubCategoryListItem{" + 
			"subCatKeyWord = '" + subCatKeyWord + '\'' + 
			",titleId = '" + titleId + '\'' + 
			",name = '" + name + '\'' + 
			",mainCategory = '" + mainCategory + '\'' + 
			",subImagePath = '" + subImagePath + '\'' + 
			",mainCatKeyWord = '" + mainCatKeyWord + '\'' + 
			",subImage = '" + subImage + '\'' + 
			",id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			",categoryId = '" + categoryId + '\'' + 
			",keyWord = '" + keyWord + '\'' + 
			"}";
		}
}