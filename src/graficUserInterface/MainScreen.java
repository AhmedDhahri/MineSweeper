package graficUserInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.KeyStroke;

import general.Setting;
import motors.MotorBut;
import motors.MotorMenu;
import motors.MotorMouse;
import motors.MotorRB;

@SuppressWarnings("serial")
public class MainScreen extends JFrame {
	
	
	
	public int x;
	public int y;
	public int k;
	public JLabel la;
	public JLabel lb;
	public JLabel lc;

	JPanel top;
	public JPanel stat;
	ImageIcon icon;
	JMenuBar mbar;
	
	public JMenuItem New;
	public JMenuItem open;
	public JMenuItem save;
	public JMenuItem close;
	public JMenuItem rstart;
	public JMenuItem score;
	public JMenuItem solve;
	public JMenuItem welcome;
	public JMenuItem how;
	public JMenuItem ad;
	public JMenuItem as;
	public JMenuItem custom;
	
	public JRadioButton easy;
	public JRadioButton medium;
	public JRadioButton hard;
	
	
	ButtonGroup lvl;
	
	public static Color background;
	public static But[][] but;
	public static Mystery[][] tab;
	public static boolean game_over;
	public static boolean start;

	public MainScreen(){

		Setting s = new Setting();
		x = Setting.horizontal;
		y = Setting.vertical;
		k = s.mines;
		
		start = false;
		game_over = false;
		background = new Color(240,240,255);
		icon = new ImageIcon("icon.png");
		
		MotorBut.x = x;
		MotorBut.y = y;
		
		mbar = createMB();
		stat = createst();
		top = createtop();
		
		la = new JLabel("Time: 000");
		lb = new JLabel("",JLabel.CENTER);
		lc = new JLabel("Mines: "+k);
		
		la.setFont(new Font("Arial",Font.BOLD, 20));
		lb.setFont(new Font("Algerian",Font.BOLD, 17));
		lc.setFont(new Font("Arial",Font.BOLD, 20));
		
		stat.add(la,BorderLayout.WEST);
		stat.add(lb,BorderLayout.CENTER);
		stat.add(lc,BorderLayout.EAST);
		
		config();

	}
	public void config(){
		add(top,BorderLayout.CENTER);
		add(stat,BorderLayout.SOUTH);
		setTitle("Mines Sweeper");
		setJMenuBar(mbar);
		Toolkit t = getToolkit();
		Dimension d = t.getScreenSize();
		int w = (int) (0.5*(d.getWidth()- 30*x));
		int h = (int) (0.5*(d.getHeight()- (30*y)));
		setLocation(w,h-40);
		setIconImage(icon.getImage());
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}
	public JPanel createst(){

		
		stat = new JPanel();
		stat.setBackground(Color.GRAY.brighter());
		stat.setLayout(new BorderLayout());

		return stat;
	}
 	public JPanel createtop(){
 		but = new But[x][y];
 		MotorBut al = new MotorBut();
 		MotorMouse ml = new MotorMouse();
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(y,x,0,0));
		top.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		top.setBackground(background);
		//top.setSize(new Dimension(x*30,y*30));
		for(int j = 0;j<y;j++){
			for(int i = 0;i < x;i++){
				but[i][j] = new But(new Position(i,j));
				but[i][j].setName(i+"+"+j);
				but[i][j].addActionListener(al);
				but[i][j].addMouseListener(ml);
				top.add(but[i][j]);
			}
		}
		return top;
	}
	public JMenuBar createMB(){
		
		JMenuBar mbar = new JMenuBar();
		
		JMenu file = new JMenu("File");
		JMenu game = new JMenu("Game");
		JMenu about = new JMenu("About");
		JMenu help= new JMenu("Help");

		New = new JMenuItem("New");
		open = new JMenuItem("Open");
		save = new JMenuItem("Save");
		close = new JMenuItem("Close");
		
		New.addActionListener(new MotorMenu());
		open.addActionListener(new MotorMenu());
		save.addActionListener(new MotorMenu());
		close.addActionListener(new MotorMenu());
		
		rstart = new JMenuItem("Restart");
		JMenu diff = new JMenu("Difficulty");
		score = new JMenuItem("High Score");
		solve = new JMenuItem("Solution");
		
		rstart.addActionListener(new MotorMenu());
		score.addActionListener(new MotorMenu());
		solve.addActionListener(new MotorMenu());
		
		welcome = new JMenuItem("Welcome");
		how = new JMenuItem("How to");
		
		welcome.addActionListener(new MotorMenu());
		how.addActionListener(new MotorMenu());
		
		ad = new JMenuItem("About Developer");
		as = new JMenuItem("About Software");
		
		ad.addActionListener(new MotorMenu());
		as.addActionListener(new MotorMenu());
		
		close.setAccelerator(KeyStroke.
				getKeyStroke(KeyEvent.VK_Q,ActionEvent.CTRL_MASK));
		New.setAccelerator(KeyStroke.
				getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		save.setAccelerator(KeyStroke.
				getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		open.setAccelerator(KeyStroke.
				getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
		
		easy = new JRadioButton("Easy");
		medium = new JRadioButton("Medium");
		hard = new JRadioButton("Hard");
		
		lvl = new ButtonGroup();
		
		if(Setting.level == 'E')
			easy.setSelected(true);
		else if(Setting.level == 'M')
			medium.setSelected(true);
		else if(Setting.level == 'H')
			hard.setSelected(true);
		
		lvl.add(easy);
		lvl.add(medium);
		lvl.add(hard);
		
		JMenuItem custom = new JMenuItem("Custom");
		

		easy.addActionListener(new MotorRB());
		medium.addActionListener(new MotorRB());
		hard.addActionListener(new MotorRB());
		custom.addActionListener(new MotorMenu());
		
		diff.add(easy);
		diff.add(medium);
		diff.add(hard);
		diff.addSeparator();
		diff.add(custom);
		
		file.add(New);
		file.add(open);
		
		file.add(save);
		file.addSeparator();
		file.add(close);
		
		game.add(rstart);
		game.add(diff);
		game.add(solve);
		game.add(score);
		
		about.add(ad);
		about.add(as);
		
		help.add(welcome);
		help.add(how);
		help.add(about);
		
		mbar.add(file);
		mbar.add(game);
		mbar.add(help);
		
		return mbar;
	}
 	public Mystery[][] spreadMines(int x,int y,int k,Position p){
		int n = 0;
		Mystery[][] t = new Mystery[x][y];
		char [] tab1 = new char[x*y];

		for(int i=0;i < x;i++)
			for(int j=0;j < y;j++){
				Mystery m = new Mystery();
				t[i][j] = m;
			}
		for(int w=0;w < x*y;w++)
				tab1[w]= 'n';
		if((p.X!=0) && (p.X!=x-1) && (p.Y!=y-1) && (p.Y!=0)){
			tab1[(p.X-1)*y+p.Y-1] = 's';
			tab1[(p.X-1)*y+p.Y] = 's';
			tab1[(p.X-1)*y+p.Y+1] = 's';
			tab1[(p.X)*y+p.Y-1] = 's';
			tab1[(p.X)*y+p.Y] = 's';
			tab1[(p.X)*y+p.Y+1] = 's';
			tab1[(p.X+1)*y+p.Y-1] = 's';
			tab1[(p.X+1)*y+p.Y] = 's';
			tab1[(p.X+1)*y+p.Y+1] = 's';
		}else if((p.X==0) && (p.Y!=0) && (p.Y!=y-1)){
			tab1[p.Y-1] = 's';
			tab1[(p.X)*y+p.Y] = 's';
			tab1[p.Y+1] = 's';
			tab1[y+p.Y-1] = 's';
			tab1[y+p.Y] = 's';
			tab1[y+p.Y+1] = 's';
		}else if((p.X==x-1) && (p.Y!=0) && (p.Y!=y-1)){
			tab1[(p.X-1)*y+p.Y-1] = 's';
			tab1[(p.X)*y+p.Y] = 's';
			tab1[(p.X-1)*y+p.Y] = 's';
			tab1[(p.X-1)*y+p.Y+1] = 's';
			tab1[(p.X)*y+p.Y-1] = 's';
			tab1[(p.X)*y+p.Y+1] = 's';
		}else if((p.X!=0) && (p.X!=x-1) && (p.Y==0)){
			tab1[(p.X-1)*y+p.Y+1] = 's';
			tab1[(p.X)*y+p.Y] = 's';
			tab1[(p.X)*y+p.Y+1] = 's';
			tab1[(p.X+1)*y+p.Y+1] = 's';
			tab1[(p.X+1)*y+p.Y] = 's';
			tab1[(p.X-1)*y+p.Y] = 's';
		}else if((p.X!=0) && (p.X!=x-1) && (p.Y==y-1)){
			tab1[(p.X-1)*y+p.Y-1] = 's';
			tab1[(p.X)*y+p.Y] = 's';
			tab1[(p.X)*y+p.Y-1] = 's';
			tab1[(p.X+1)*y+p.Y-1] = 's';
			tab1[(p.X-1)*y+p.Y] = 's';
			tab1[(p.X+1)*y+p.Y] = 's';
		}else if((p.X==0) && (p.Y==0)){
			tab1[(p.X+1)*y+p.Y+1] = 's';
			tab1[(p.X)*y+p.Y] = 's';
			tab1[(p.X+1)*y+p.Y] = 's';
			tab1[(p.X)*y+p.Y+1] = 's';
		}else if((p.X==0) && (p.Y==y-1)){ 
			tab1[(p.X)*y+p.Y-1] = 's';
			tab1[(p.X)*y+p.Y] = 's';
			tab1[(p.X+1)*y+p.Y-1] = 's';
			tab1[(p.X+1)*y+p.Y] = 's';
		}else if((p.X==x-1) && (p.Y==0)){
			tab1[(p.X-1)*y+p.Y] = 's';
			tab1[(p.X)*y+p.Y] = 's';
			tab1[(p.X-1)*y+p.Y+1] = 's';
			tab1[(p.X)*y+p.Y+1] = 's';
		}else if((p.X==x-1) && (p.Y==y-1)){
			tab1[(p.X-1)*y+p.Y] = 's';
			tab1[(p.X)*y+p.Y] = 's';
			tab1[(p.X-1)*y+p.Y-1] = 's';
			tab1[(p.X)*y+p.Y-1] = 's';
		}

		while(n < k){
			int z =(int) ((Math.random())*(x*y-1));
			if(tab1[z] != 's')
				tab1[z] = 'b';
			n =0;
			for(int i = 0;i<tab1.length;i++){
				if(tab1[i] == 'b'){
					n++;
				}
			}
		}
		for(int a=0;a<x;a++)
			for(int b=0;b<y;b++)
				if(tab1[a*y+b] == 'b'){
					t[a][b].c = 'b';
					if((a!=0) && (a!=x-1) && (b!=y-1) && (b!=0)){
						t[a-1][b-1].x++;
						t[a-1][b].x++;
						t[a-1][b+1].x++;
						t[a][b-1].x++;
						t[a][b+1].x++;
						t[a+1][b-1].x++;
						t[a+1][b].x++;
						t[a+1][b+1].x++;
					}else if((a==0) && (b!=0) && (b!=y-1)){
						t[0][b-1].x++;
						t[0][b+1].x++;
						t[1][b-1].x++;
						t[1][b].x++;
						t[1][b+1].x++;
					}else if((a==x-1) && (b!=0) && (b!=y-1)){
						t[a-1][b-1].x++;
						t[a-1][b].x++;
						t[a-1][b+1].x++;
						t[a][b-1].x++;
						t[a][b+1].x++;
					}else if((a!=0) && (a!=x-1) && (b==0)){
						t[a-1][b+1].x++;
						t[a][b+1].x++;
						t[a+1][b+1].x++;
						t[a+1][b].x++;
						t[a-1][b].x++;
					}else if((a!=0) && (a!=x-1) && (b==y-1)){
						t[a-1][b-1].x++;
						t[a][b-1].x++;
						t[a+1][b-1].x++;
						t[a-1][b].x++;
						t[a+1][b].x++;
					}else if((a==0) && (b==0)){
						t[a+1][b+1].x++;
						t[a+1][b].x++;
						t[a][b+1].x++;
					}else if((a==0) && (b==y-1)){ 
						t[a][b-1].x++;
						t[a+1][b-1].x++;
						t[a+1][b].x++;
					}else if((a==x-1) && (b==0)){
						t[a-1][b].x++;
						t[a-1][b+1].x++;
						t[a][b+1].x++;
					}else if((a==x-1) && (b==y-1)){
						t[a-1][b].x++;
						t[a-1][b-1].x++;
						t[a][b-1].x++;
					}
					
				}
		return t;
	}
 	public void rstart(){
 		dispose();
 	}
 	public void solve(){
 		for(int i=0;i<x;i++)
			for(int j=0;j<y;j++){
				if(tab[i][j].c == 'b')
					but[i][j].lose();
				else
					but[i][j].Click();
			}
 	}
}
