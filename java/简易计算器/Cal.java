package calcu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class Cal extends JFrame implements ActionListener{
	private JPanel cp;
	private JTextField jtf3;
	private JTextField jtf1;
	private JTextField jtf2;
	
	public Cal() {
		setTitle("简单计算器");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350,320);
		setBounds(60,60,600,400);
		setLocationRelativeTo(null);
		cp=new JPanel();
		cp.setBorder(new EmptyBorder(5,5,5,5));
		cp.setLayout(new GridLayout(3,2));
		setContentPane(cp);
		JPanel jp1 = new JPanel();
		JLabel jl1 = new JLabel("第一操作数：   ");
		JLabel jl2 = new JLabel("第二操作数：   ");
		jtf1 = new JTextField(6);
		jtf2 = new JTextField(6);
		jp1.add(jl1);
		jp1.add(jtf1);
		jp1.add(jl2);
		jp1.add(jtf2);
		JPanel jp2 = new JPanel();
		JButton jb1 = new JButton("+");
		jb1.addActionListener(this);
		JButton jb2 = new JButton("-");
		jb2.addActionListener(this);
		JButton jb3 = new JButton("*");
		jb3.addActionListener(this);
		JButton jb4 = new JButton("/");
		jb4.addActionListener(this);
		JButton jb5 = new JButton("%");
		jb5.addActionListener(this);
		JButton jb6 = new JButton("c");
		jb6.addActionListener(this);
		jp2.add(jb1);
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);
		jp2.add(jb6);
		JPanel jp3 = new JPanel();
		JLabel jl4 = new JLabel("运行结果:  ");
		jtf3 = new JTextField(12);
		jp3.add(jl4);
		jp3.add(jtf3);
		cp.add(jp1);
		cp.add(jp2);
		cp.add(jp3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		String result;
		double d1 = Double.parseDouble(jtf1.getText());
		double d2 = Double.parseDouble(jtf2.getText());
		if(command.equals("+"))
		{		
			result = (d1+d2)+"";
		}
		else if(command.equals("-"))
		{
			result = (d1-d2)+"";
		}
		else if (command.equals("*")) 
		{
			result = (d1*d2)+"";
		} 
		else if(command.equals("/"))
		{
			result = (d1/d2)+"";
		}
		else if (command.equals("%")) 
		{
			result = (d1%d2)+"";
		} 
		
		else 
		{
		     result = "0";
		}
		jtf3.setText(result);	
	}
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Cal frame=new Cal();
					frame.setVisible(true);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
}
