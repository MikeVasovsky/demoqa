package tests.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuJson{

	@JsonProperty("menu")
	private Menu menu;

	public Menu getMenu(){
		return menu;
	}
}