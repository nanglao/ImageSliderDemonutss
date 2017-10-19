package com.exampledemo.parsaniahardik.imagesliderdemonuts.model;

import com.google.gson.annotations.SerializedName;

public class SliderImageModel{

	@SerializedName("image")
	private Object image;

	@SerializedName("supplierId")
	private Object supplierId;

	@SerializedName("totalPrice")
	private Object totalPrice;

	@SerializedName("imagePath")
	private String imagePath;

	@SerializedName("startTimeDate")
	private Object startTimeDate;

	@SerializedName("supplierNo")
	private Object supplierNo;

	@SerializedName("pageName")
	private Object pageName;

	@SerializedName("advertisementUploadTypeId")
	private Object advertisementUploadTypeId;

	@SerializedName("endTimeDate")
	private Object endTimeDate;

	@SerializedName("price")
	private Object price;

	@SerializedName("adminMessage")
	private Object adminMessage;

	@SerializedName("startTime")
	private Object startTime;

	@SerializedName("id")
	private int id;

	@SerializedName("endTime")
	private Object endTime;

	@SerializedName("status")
	private Object status;

	public void setImage(Object image){
		this.image = image;
	}

	public Object getImage(){
		return image;
	}

	public void setSupplierId(Object supplierId){
		this.supplierId = supplierId;
	}

	public Object getSupplierId(){
		return supplierId;
	}

	public void setTotalPrice(Object totalPrice){
		this.totalPrice = totalPrice;
	}

	public Object getTotalPrice(){
		return totalPrice;
	}

	public void setImagePath(String imagePath){
		this.imagePath = imagePath;
	}

	public String getImagePath(){
		return imagePath;
	}

	public void setStartTimeDate(Object startTimeDate){
		this.startTimeDate = startTimeDate;
	}

	public Object getStartTimeDate(){
		return startTimeDate;
	}

	public void setSupplierNo(Object supplierNo){
		this.supplierNo = supplierNo;
	}

	public Object getSupplierNo(){
		return supplierNo;
	}

	public void setPageName(Object pageName){
		this.pageName = pageName;
	}

	public Object getPageName(){
		return pageName;
	}

	public void setAdvertisementUploadTypeId(Object advertisementUploadTypeId){
		this.advertisementUploadTypeId = advertisementUploadTypeId;
	}

	public Object getAdvertisementUploadTypeId(){
		return advertisementUploadTypeId;
	}

	public void setEndTimeDate(Object endTimeDate){
		this.endTimeDate = endTimeDate;
	}

	public Object getEndTimeDate(){
		return endTimeDate;
	}

	public void setPrice(Object price){
		this.price = price;
	}

	public Object getPrice(){
		return price;
	}

	public void setAdminMessage(Object adminMessage){
		this.adminMessage = adminMessage;
	}

	public Object getAdminMessage(){
		return adminMessage;
	}

	public void setStartTime(Object startTime){
		this.startTime = startTime;
	}

	public Object getStartTime(){
		return startTime;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setEndTime(Object endTime){
		this.endTime = endTime;
	}

	public Object getEndTime(){
		return endTime;
	}

	public void setStatus(Object status){
		this.status = status;
	}

	public Object getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"SliderImageModel{" + 
			"image = '" + image + '\'' + 
			",supplierId = '" + supplierId + '\'' + 
			",totalPrice = '" + totalPrice + '\'' + 
			",imagePath = '" + imagePath + '\'' + 
			",startTimeDate = '" + startTimeDate + '\'' + 
			",supplierNo = '" + supplierNo + '\'' + 
			",pageName = '" + pageName + '\'' + 
			",advertisementUploadTypeId = '" + advertisementUploadTypeId + '\'' + 
			",endTimeDate = '" + endTimeDate + '\'' + 
			",price = '" + price + '\'' + 
			",adminMessage = '" + adminMessage + '\'' + 
			",startTime = '" + startTime + '\'' + 
			",id = '" + id + '\'' + 
			",endTime = '" + endTime + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}