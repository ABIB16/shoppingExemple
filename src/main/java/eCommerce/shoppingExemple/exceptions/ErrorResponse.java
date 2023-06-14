package eCommerce.shoppingExemple.exceptions;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ErrorResponse {
	
	private Boolean success;
	private String message;
	private List<String> details;

	public ErrorResponse() {
	}

	public ErrorResponse(String message, List<String> details) {
		super();
		this.message = message;
		this.details = details;
		this.success = Boolean.FALSE;
	}

}
