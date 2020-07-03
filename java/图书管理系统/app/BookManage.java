package bookmanage.app;

import bookmanage.view.UserFrame;

/**
 * 图书信息管理系统启动类
 */
public class BookManage {
	public static void main(String[] args) {
		//实例化登录界面并调用初始化方法init()
		UserFrame bf = new UserFrame();
		bf.init();
	}
}
