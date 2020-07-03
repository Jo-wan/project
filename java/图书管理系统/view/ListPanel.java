package bookmanage.view;

import java.util.*;
import javax.swing.*;

import bookmanage.dao.BookDao;
import bookmanage.model.Book;

/**
 * 自定义图书列表面板
 */
public class ListPanel extends JPanel {
	private static final Object CENTER = null;
	
	/**
	 * 从数据库中取出信息
	 * rowData用来存放行数据
	 * dialogPane存放列名
	 */
	Vector rowData, dialogPane;
	JTable jt = null;
	JScrollPane jsp = null;

	// 构造函数
	public ListPanel() {
		ArrayList<Book> books = new BookDao().getBookList();
		dialogPane = new Vector();
		
		// 设置列名
		dialogPane.add("图书编号");
		dialogPane.add("图书名称");
		dialogPane.add("图书价格");
		dialogPane.add("图书数量");
		
		rowData = new Vector();
		for (int i = 0; i < books.size(); i++) {
			//实例化每一行数据
			Vector v = new Vector();
			v.add(books.get(i).getId());
			v.add(books.get(i).getName());
			v.add(books.get(i).getPrice());
			v.add(books.get(i).getNum());
			
			rowData.add(v);					// 加入到rowData中
		}
		
		jt = new JTable(rowData, dialogPane);		// 初始化Jtable
		
		jsp = new JScrollPane(jt);					// 初始化 jsp
		this.add(jsp);
	}
}
