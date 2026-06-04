package kr.hcnc.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CafeteriaVO {
	
	private String cafeteriaId;
	private String mealDate;
	private String mealType;
	private String menu;
	private String mealClosed;
	private String createdAt;
	private String updatedAt;
	private String delYn;
	private String breakfast;
	private String lunch;
	private String dinner;
	
	public CafeteriaVO() {}

	public String getCafeteriaId() {
		return cafeteriaId;
	}

	public void setCafeteriaId(String cafeteriaId) {
		this.cafeteriaId = cafeteriaId;
	}

	public String getMealDate() {
		return mealDate;
	}

	public void setMealDate(String mealDate) {
		this.mealDate = mealDate;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public String getMenu() {
	    return menu;
	}
	public void setMenu(String menu) {
	    this.menu = menu;
	}

	public String getMealClosed() {
		return mealClosed;
	}

	public void setMealClosed(String mealClosed) {
		this.mealClosed = mealClosed;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	public String getLunch() {
		return lunch;
	}

	public void setLunch(String lunch) {
		this.lunch = lunch;
	}

	public String getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}

	public String getDinner() {
		return dinner;
	}

	public void setDinner(String dinner) {
		this.dinner = dinner;
	}
}
