package com.example.herokuappdemo.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CountriesData {

	@SerializedName("result")
	private List<ResultItem> result;

	@SerializedName("success")
	private Boolean success;

	public void setResult(List<ResultItem> result){
		this.result = result;
	}

	public List<ResultItem> getResult(){
		return result;
	}

	public void setSuccess(Boolean success){
		this.success = success;
	}

	public Boolean isSuccess(){
		return success;
	}

	public static class ResultItem{

		@SerializedName("country")
		private String country;

		@SerializedName("totaldeaths")
		private String totaldeaths;

		@SerializedName("newDeaths")
		private String newDeaths;

		@SerializedName("newCases")
		private String newCases;

		@SerializedName("totalRecovered")
		private String totalRecovered;

		@SerializedName("totalcases")
		private String totalcases;

		@SerializedName("activeCases")
		private String activeCases;

		public void setCountry(String country){
			this.country = country;
		}

		public String getCountry(){
			return country;
		}

		public void setTotaldeaths(String totaldeaths){
			this.totaldeaths = totaldeaths;
		}

		public String getTotaldeaths(){
			return totaldeaths;
		}

		public void setNewDeaths(String newDeaths){
			this.newDeaths = newDeaths;
		}

		public String getNewDeaths(){
			return newDeaths;
		}

		public void setNewCases(String newCases){
			this.newCases = newCases;
		}

		public String getNewCases(){
			return newCases;
		}

		public void setTotalRecovered(String totalRecovered){
			this.totalRecovered = totalRecovered;
		}

		public String getTotalRecovered(){
			return totalRecovered;
		}

		public void setTotalcases(String totalcases){
			this.totalcases = totalcases;
		}

		public String getTotalcases(){
			return totalcases;
		}

		public void setActiveCases(String activeCases){
			this.activeCases = activeCases;
		}

		public String getActiveCases(){
			return activeCases;
		}
	}
}