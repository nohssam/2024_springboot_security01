package com.ict.edu2.common;

import lombok.Data;

@Data
public class TokenVO {
    private String accessToken;
	private String refreshToken;
	private long accessTokenExpiresIn;
	private long refreshTokenExpiresIn;
}
