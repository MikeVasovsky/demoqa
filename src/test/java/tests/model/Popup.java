package tests.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Popup{

	@JsonProperty("menuitem")
	private List<MenuitemItem> menuitem;

	public List<MenuitemItem> getMenuitem(){
		return menuitem;
	}
}