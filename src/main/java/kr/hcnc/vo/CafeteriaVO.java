package kr.hcnc.vo;

public class CafeteriaVO {
	
	private String cafeteriaId;
	private String mealDate;
	private String mealType;
	private String menu;
	private String mealClosed;
	
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
}
