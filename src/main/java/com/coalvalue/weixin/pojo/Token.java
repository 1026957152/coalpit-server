package com.coalvalue.weixin.pojo;

import java.io.Serializable;

/**
 * ƾ֤
 * 
 * @author liufeng
 * @date 2013-10-17
 */
public class Token implements Serializable {
    private static final long serialVersionUID = -797586847427389162L;
	// �ӿڷ���ƾ֤
	private String accessToken;
	// ƾ֤��Ч�ڣ���λ����
	private int expiresIn;

	public String getAccessToken() {

		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
}