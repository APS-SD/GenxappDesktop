package helpers;

import model.RefreshRequestModel;
import model.TokenModel;

public class RefreshRequestFactory {
	public static RefreshRequestModel getRefreshRequest(TokenModel token) {
		return new RefreshRequest(token);
	}
}
