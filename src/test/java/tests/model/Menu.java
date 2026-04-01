package tests.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Menu{

	@JsonProperty("popup")
	private Popup popup;

	@JsonProperty("id")
	private String id;

	@JsonProperty("value")
	private String value;

	public Popup getPopup(){
		return popup;
	}

	public String getId(){
		return id;
	}

	public String getValue(){
		return value;
	}
}