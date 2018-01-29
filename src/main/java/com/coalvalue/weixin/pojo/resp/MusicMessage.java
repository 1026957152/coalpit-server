package com.coalvalue.weixin.pojo.resp;

/**
 * 响应消息之音乐消息
 * @author sunlight
 *
 */
public class MusicMessage extends BaseMessage {
	/**
	 * 音乐  
	 */
    private com.coalvalue.weixin.pojo.resp.Music Music;

	public com.coalvalue.weixin.pojo.resp.Music getMusic() {
		return Music;
	}

	public void setMusic(com.coalvalue.weixin.pojo.resp.Music music) {
		Music = music;
	}  
    
    
}
