package com.gwen.mall.redis.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 配置session监听器
 */
public class ShiroSessionListener implements SessionListener {

	private final AtomicInteger sessionCount = new AtomicInteger(0);

	/**
	 * 回话创建触发
	 */
	@Override
	public void onStart(Session session) {
		sessionCount.incrementAndGet();
	}

	/**
	 * 退出会话时触发
	 */
	@Override
	public void onStop(Session session) {
		sessionCount.decrementAndGet();
	}

	/**
	 * 会话过期时触发
	 */
	@Override
	public void onExpiration(Session session) {
		sessionCount.decrementAndGet();

	}

	public int getSessionCount() {
		return sessionCount.get();
	}

}
