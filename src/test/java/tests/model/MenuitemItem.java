package tests.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuitemItem{

	@JsonProperty("onclick")
	private String onclick;

	@JsonProperty("value")
	private String value;

	public String getOnclick(){
		return onclick;
	}

	public String getValue(){
		return value;
	}
}