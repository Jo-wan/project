package bookmanage.view;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import bookmanage.dao.BookDao;

/**
 * 图书管理界面类
 */

//定义窗体类BookFrame继承JFrame，实现ActionListener接口
public class BookFrame extends JFrame implements ActionListener {
	
	private JMenuBar menuBar;						// 定义顶部菜单栏
	private JMenu menuManage, menuAbout;			// 定义顶部菜单 首页图书管理、关于系统两个菜单
	private JMenuItem itemList, itemBook, itemAbout, itemExit;			// 定义菜单项 图书列表 、关于、以及退出
	private Container container;					//定义容器
	private CardLayout cardlayout;					//定义卡片布局
	private CrudBookPanel crudBookPanel;			//定义首页、图书更新、图书列表三个面板
	private ListPanel listPanel;
	private IndexPanel indexPanel;
	private BookDao bookDao = new BookDao();		// 定义图书操作对象并实例化

	/**
	 * 初始化窗体
	 */
	public void init() {
		
		initFrame();							// 调用用于初始化内容窗体的方法
		this.setTitle("图书信息管理系统");			// 窗口标题
		this.setSize(472, 400);					// 窗体大小
		this.setIconImage((new ImageIcon("images/login.jpg")).getImage());		// 设置图标
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);					// 设置可关闭进程
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;			// 获得屏幕宽度
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;		// 获得屏幕高度
		this.setLocation((width - 500) / 2, (height - 400) / 2);				// 居中显示
		this.setVisible(true);					// 设置窗体可见
		this.setResizable(false);				// 不可改变窗体大小
	}

	/**
	 * 初始化窗体内容
	 */
	public void initFrame() {
		
		// 实例化菜单栏
		menuBar = new JMenuBar();
		menuManage = new JMenu("选项");
		menuAbout = new JMenu("关于系统");
		
		// 实例化菜单项图书列表、退出、关于并添加事件监听
		itemBook = new JMenuItem("图书更新");
		itemBook.addActionListener(this);         // 设置监听
		itemBook.setActionCommand("itembook");
		itemList = new JMenuItem("图书列表");
		itemList.addActionListener(this);         // 设置监听
		itemList.setActionCommand("listbook");
		itemExit = new JMenuItem("退出");
		itemExit.addActionListener(this);         // 设置监听
		itemExit.setActionCommand("exit");
		itemAbout = new JMenuItem("关于");
		itemAbout.addActionListener(this);        // 设置监听
		itemAbout.setActionCommand("about");
		
		// 菜单图书管理添加图书列表和退出项目
		menuManage.add(itemList);
		menuManage.add(itemBook);
		menuManage.add(itemExit);
		
		menuAbout.add(itemAbout);            // 关于系统添加关于菜单项
		
		// 菜单栏添加菜单那图书管理以及关于系统
		menuBar.add(menuManage);
		menuBar.add(menuAbout);
		
		this.setJMenuBar(menuBar);          // 把菜单栏添加到窗体
		
		indexPanel = new IndexPanel();		// 实例化增删改查面板
		
		cardlayout = new CardLayout();		// 实例化卡片布局
		
		// 窗口容器中添加組件（使用边界布局）
		container = getContentPane();
		container.setLayout(cardlayout);
		
		container.add(indexPanel, "indexPanel");	// 将首页面板放进内容面板
	}

	/*
	 * 监听按钮的事件方法
	 */
	public void actionPerformed(ActionEvent e) {
		// 事件监听
		if (e.getActionCommand().equals("about")) {						// 关于
			JOptionPane.showMessageDialog(BookFrame.this, "有问题请联系 wx:h2315195366!");
		}  
		else if (e.getActionCommand().equals("exit")) {				// 退出
			System.exit(0);
		} 
		else if (e.getActionCommand().equals("listbook")) {
			listPanel = new ListPanel();			//实例化列表面板，将其放进容器使用卡片布局展示
			container.add(listPanel, "listPanel");
			cardlayout.show(container, "listPanel");
		} 
		else if (e.getActionCommand().equals("itembook")) {
			crudBookPanel = new CrudBookPanel();		//实例化增删改查面板，将其放进容器使用卡片布局展示
			container.add(crudBookPanel, "crudBookPanel");
			cardlayout.show(container, "crudBookPanel");
		}
	}
}
