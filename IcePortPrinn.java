import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class IcePortPrinn extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JMenuBar menuBar;
	protected JMenu file,about;
	protected JMenuItem exitItem,helpItem,aboutItem,customizationItem;
	protected JPanel DesktopPanel;

	//Prinn start

	private		JPanel		panel1;
	private		JPanel		panel2;
	private		JPanel		panel3;
	//Prinn end
	Font font = new Font("TimesRoman",Font.BOLD,36);
	public IcePortPrinn(String s){
		super(s);
		setGui();
		setJMenuBar(setBarGUI());
		addListeners();
	}
	private void setGui(){
		this.setLayout(new BorderLayout());
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // get screen size
		Dimension screensize = toolkit.getScreenSize(); // get screen size
		this.setPreferredSize(new Dimension(screensize.width,((int)(screensize.height*0.95))));
		DesktopPanel = new JPanel();
		this.add(DesktopPanel,BorderLayout.CENTER);
		DesktopPanel.setBackground(Color.CYAN);
	}
	protected JMenuBar setBarGUI()
	{
		menuBar = new JMenuBar();

		file = new JMenu("File");
		about = new JMenu("Help");

		exitItem = new JMenuItem("Exit");
		helpItem = new JMenuItem("View Help");
		aboutItem = new JMenuItem("About");
		customizationItem = new JMenuItem("IceTizen Customization");

		file.add(exitItem);
		about.add(helpItem);
		about.add(aboutItem);

		menuBar.add(file);
		menuBar.add(about);
		about.add(customizationItem);

		return menuBar;
	}

	//Prinn start
	public void createPage1()
	{
		panel1 = new JPanel();
		panel1.setLayout( null );

		JLabel label1 = new JLabel( "Username:" );
		label1.setBounds( 10, 15, 150, 20 );
		panel1.add( label1 );

		JTextField field = new JTextField();
		field.setBounds( 10, 35, 150, 20 );
		panel1.add( field );

		JLabel label2 = new JLabel( "Password:" );
		label2.setBounds( 10, 60, 150, 20 );
		panel1.add( label2 );

		JPasswordField fieldPass = new JPasswordField();
		fieldPass.setBounds( 10, 80, 150, 20 );
		panel1.add( fieldPass );
	}

	public void createPage2()
	{
		panel2 = new JPanel();
		panel2.setLayout( new BorderLayout() );

		panel2.add( new JButton( "North" ), BorderLayout.NORTH );
		panel2.add( new JButton( "South" ), BorderLayout.SOUTH );
		panel2.add( new JButton( "East" ), BorderLayout.EAST );
		panel2.add( new JButton( "West" ), BorderLayout.WEST );
		panel2.add( new JButton( "Center" ), BorderLayout.CENTER );
	}

	public void createPage3()
	{
		panel3 = new JPanel();
		panel3.setLayout( new GridLayout( 3, 2 ) );

		panel3.add( new JLabel( "Field 1:" ) );
		panel3.add( new TextArea() );
		panel3.add( new JLabel( "Field 2:" ) );
		panel3.add( new TextArea() );
		panel3.add( new JLabel( "Field 3:" ) );
		panel3.add( new TextArea() );
	}
	//prinn end

	private void addListeners(){
		exitItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		helpItem.setMnemonic(KeyEvent.VK_F1);
		helpItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,0));
		helpItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				final JFrame helpJFrame = new JFrame("Help");

				//exit when press escape key
				/*
				help.addKeyListener(new KeyAdapter(){
					public void keyPressed(KeyEvent ke) {
						int key = ke.getKeyCode();
						if(key == KeyEvent.VK_ESCAPE){
							//System.out.println("escape pressed on about");
							help.setVisible(false);
							help.dispose();
						}
					}
				});
				 */



				JTabbedPane helpTab = new JTabbedPane();
				JPanel helpPanel = new JPanel();
				
				//help.add(helpPanel, BorderLayout.CENTER);
				//helpPanel.setBackground(Color.BLUE);
				//helpPanel.add(helpTab);
				helpJFrame.setLayout(new BorderLayout());
				helpPanel.add(helpTab, BorderLayout.CENTER);
				//helpTab.addTab(title, component)
				
				// Create the tab pages
				createPage1();
				createPage2();
				createPage3();
				
				// Create a tabbed pane
				helpTab.addTab( "Page 1", panel1 );
				helpTab.addTab( "Page 2", panel2 );
				helpTab.addTab( "Page 3", panel3 );
				
				
				/*
				JPanel helpPanel = new JPanel();
				help.add(helpPanel, BorderLayout.CENTER);
				JTabbedPane helpTab = new JTabbedPane();

				JPanel helpPage1 = new JPanel();
				JPanel helpPage2 = new JPanel();
				JPanel helpPage3 = new JPanel();

				ImageIcon icon = new ImageIcon("mog.JPG");
				helpPage1.setBackground(Color.BLACK);

				helpTab.addTab("page1", icon, helpPage1, "Tab1" );

				helpPanel.add(helpTab, BorderLayout.CENTER);

				helpTab.addTab( "Page 1", helpPage1 );
				helpTab.addTab( "Page 2", helpPage2 );
				helpTab.addTab( "Page 3", helpPage3 );

				//JPanel panel = new JPanel();
				//JLabel help_text = new JLabel();
				//help_text.setFont(font);
				//help_text.setText("I can't help u");
				help.setLayout(new BorderLayout());
				//panel.add(help_text);
				//help_text.setAlignmentX(JComponent.CENTER_ALIGNMENT);
				//help.add(panel);
				 */

				helpJFrame.add(helpPanel,BorderLayout.CENTER);
				helpJFrame.setPreferredSize(new Dimension(1000,600));
				helpJFrame.pack();
				helpJFrame.setVisible(true);

			}

		});
		aboutItem.setMnemonic(KeyEvent.VK_F2);
		aboutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2,0));
		aboutItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				final JFrame aboutJFrame = new JFrame("About");
				aboutJFrame.addKeyListener(new KeyAdapter(){
					public void keyPressed(KeyEvent ke) {
						int key = ke.getKeyCode();
						if(key == KeyEvent.VK_ESCAPE){
							//System.out.println("escape pressed on about");
							aboutJFrame.setVisible(false);
							aboutJFrame.dispose();
						}
					}
				});
				JPanel panel = new JPanel();
				JLabel author_text = new JLabel("This is IcePort Beta");
				aboutJFrame.setLayout(new BorderLayout());
				panel.add(author_text);
				author_text.setAlignmentX(JComponent.CENTER_ALIGNMENT);
				author_text.setFont(font);
				aboutJFrame.add(panel,BorderLayout.CENTER);
				aboutJFrame.setPreferredSize(new Dimension(600,300));
				aboutJFrame.pack();
				aboutJFrame.setVisible(true);
			}		
		}
		);
		customizationItem.setMnemonic(KeyEvent.VK_F3);
		customizationItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3,0));
		customizationItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				final JFrame customization = new JFrame("IceTizen Customization");
				customization.addKeyListener(new KeyAdapter(){
					public void keyPressed(KeyEvent ke) {
						int key = ke.getKeyCode();
						if(key == KeyEvent.VK_ESCAPE){
							//System.out.println("escape pressed on about");
							customization.setVisible(false);
							customization.dispose();
						}
					}
				});
				customization.setLayout(new BorderLayout());
				JPanel customPanel = new JPanel();

				customization.add(customPanel, BorderLayout.CENTER);
				JPanel customControl = new JPanel();
				customPanel.setBackground(Color.WHITE);

				customization.add(customControl, BorderLayout.EAST);
				customControl.setLayout(new GridLayout(4,1,2,2));
				customControl.setBackground(Color.GRAY);

				JPanel lowerButtonPanel = new JPanel();
				customization.add(lowerButtonPanel, BorderLayout.SOUTH);
				JButton saveIceTizen = new JButton("Save");
				JButton cancelCustomization = new JButton("Cancel");
				lowerButtonPanel.add(saveIceTizen);
				lowerButtonPanel.add(cancelCustomization);
				lowerButtonPanel.setBackground(Color.GRAY);

				//saveIceTizen
				cancelCustomization.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						customization.setVisible(false);
						customization.dispose();
					}
				});

				JPanel Body = new JPanel();
				Body.setLayout(new GridLayout(2,1,1,1));
				JPanel Shirt = new JPanel();
				Shirt.setLayout(new GridLayout(2,1,1,1));
				JPanel Headgear = new JPanel();
				Headgear.setLayout(new GridLayout(2,1,1,1));
				JPanel Weapon = new JPanel();
				Weapon.setLayout(new GridLayout(2,1,1,1));
				JPanel BodyTextPanel = new JPanel();
				JPanel ShirtTextPanel = new JPanel();
				JPanel HeadgearTextPanel = new JPanel();
				JPanel WeaponTextPanel = new JPanel();
				JPanel BodyButtonPanel = new JPanel();
				BodyButtonPanel.setLayout(new GridLayout(1,2));
				JPanel ShirtButtonPanel = new JPanel();
				ShirtButtonPanel.setLayout(new GridLayout(1,2));
				JPanel HeadgearButtonPanel = new JPanel();
				HeadgearButtonPanel.setLayout(new GridLayout(1,2));
				JPanel WeaponButtonPanel = new JPanel();
				WeaponButtonPanel.setLayout(new GridLayout(1,2));
				JPanel BodyButtonPanelNext = new JPanel();
				JPanel BodyButtonPanelPrev = new JPanel();
				JPanel ShirtButtonPanelNext = new JPanel();
				JPanel ShirtButtonPanelPrev = new JPanel();
				JPanel HeadgearButtonPanelNext = new JPanel();
				JPanel HeadgearButtonPanelPrev = new JPanel();
				JPanel WeaponButtonPanelNext = new JPanel();
				JPanel WeaponButtonPanelPrev = new JPanel();
				customControl.add(Body);
				customControl.add(Shirt);
				customControl.add(Headgear);
				customControl.add(Weapon);
				Body.add(BodyTextPanel);
				Body.add(BodyButtonPanel);
				Shirt.add(ShirtTextPanel);
				Shirt.add(ShirtButtonPanel);
				Headgear.add(HeadgearTextPanel);
				Headgear.add(HeadgearButtonPanel);
				Weapon.add(WeaponTextPanel);
				Weapon.add(WeaponButtonPanel);

				JLabel BodyLabel = new JLabel("Body Type");
				BodyLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
				JLabel ShirtLabel = new JLabel("Shirt Type");
				ShirtLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
				JLabel HeadgearLabel = new JLabel("Headgear Type");
				HeadgearLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
				JLabel WeaponLabel = new JLabel("Weapon Type");
				WeaponLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);

				BodyTextPanel.add(BodyLabel);
				ShirtTextPanel.add(ShirtLabel);
				HeadgearTextPanel.add(HeadgearLabel);
				WeaponTextPanel.add(WeaponLabel);

				BodyButtonPanel.add(BodyButtonPanelPrev);
				BodyButtonPanel.add(BodyButtonPanelNext);
				ShirtButtonPanel.add(ShirtButtonPanelPrev);
				ShirtButtonPanel.add(ShirtButtonPanelNext);
				HeadgearButtonPanel.add(HeadgearButtonPanelPrev);
				HeadgearButtonPanel.add(HeadgearButtonPanelNext);
				WeaponButtonPanel.add(WeaponButtonPanelPrev);
				WeaponButtonPanel.add(WeaponButtonPanelNext);

				JButton BodyNext = new JButton(">>");
				JButton BodyPrev = new JButton("<<");
				JButton ShirtNext = new JButton(">>");
				JButton ShirtPrev = new JButton("<<");
				JButton HeadgearNext = new JButton(">>");
				JButton HeadgearPrev = new JButton("<<");
				JButton WeaponNext = new JButton(">>");
				JButton WeaponPrev = new JButton("<<");

				BodyButtonPanelNext.add(BodyNext);
				BodyButtonPanelPrev.add(BodyPrev);
				ShirtButtonPanelNext.add(ShirtNext);
				ShirtButtonPanelPrev.add(ShirtPrev);
				HeadgearButtonPanelNext.add(HeadgearNext);
				HeadgearButtonPanelPrev.add(HeadgearPrev);
				WeaponButtonPanelNext.add(WeaponNext);
				WeaponButtonPanelPrev.add(WeaponPrev);

				customization.setPreferredSize(new Dimension(600,600));
				customization.pack();
				customization.setVisible(true);
			}
		});
	}
	private static void createAndShowGUI() {
		IcePortPrinn mainFrame = new IcePortPrinn("IcePort Beta");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
/*
class helpFrame extends JDialog{
	public helpFrame(){
		super(new JFrame(),"Help",true);
		JLabel n = new JLabel("No one can help you, but yourself!");
		n.setFont(new Font("Serif", Font.BOLD, 45));
		this.add(n,BorderLayout.CENTER);
		this.setSize(700, 200);
	}
}
 */