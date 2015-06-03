import java.awt.EventQueue;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class see 
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new seeFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

/**
����� � ��������� ������ ��� ������ �����������
*/
class seeFrame extends JFrame
{
	public seeFrame()
	{
		setTitle("I'm see you");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		//��� ������ ����������� ������������ �����.
		label = new JLabel();
		add(label);
		
		//���������� ���� ��� ������ ������.
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		
		//�������� ������� ����.
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		
		JMenuItem openItem = new JMenuItem("Open");
		menu.add(openItem);
		openItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				//����������� ����������� ���� ��� ������ �����.
				int result = chooser.showOpenDialog(null);
				
				//���� ���� ������, �� �������� � �������� ����������� ��� �����.
				if (result ==JFileChooser.APPROVE_OPTION)
				{
					String name = chooser.getSelectedFile().getPath();
					label.setIcon(new ImageIcon(name));
				}
			}
		});
	}
	
	private JLabel label;
	private JFileChooser chooser;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 400;
	
}

