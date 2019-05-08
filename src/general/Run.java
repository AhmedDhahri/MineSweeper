package general;

import java.awt.Color;

import graficUserInterface.But;
import graficUserInterface.MainScreen;
import motors.MotorBut;

public class Run {
	public static boolean rstart;
	public static boolean win;
	public static boolean solve;
	public MainScreen m;
	
	public Run(){
		rstart = false;
		win = false;
		solve = false;
	}
	public void reset(){
		solve = false;
		But.marked = 0;
		But.clicked = 0;
		MainScreen.game_over = false;
		win = false;
		rstart = false;
		MotorBut.start = false;
	}
	
	public void lanch(MainScreen ma){
		MainScreen m = new MainScreen();
		ma.dispose();
		while(MotorBut.start == false){
			System.out.print("");
			if(rstart == true){
				MainScreen.game_over = true;
				break;
			}
		}
		
		MainScreen.tab = m.spreadMines(m.x,m.y,m.k,MotorBut.start_pos);
		MainScreen.start = true;
		
		int t = 0;
		while(!MainScreen.game_over){
			if(solve == true)
				m.solve();
			if(rstart == true){
				break;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			t++;
			if(t<100)
				m.la.setText("Time: 00"+t/10 );
			else if(t<100)
				m.la.setText("Time: 0"+t/10 );
			else
				m.la.setText("Time: "+t/10 );
			m.lc.setText("Mines: "+(m.k - But.marked));
			if((m.k == But.marked) || ((But.clicked) == m.x*m.y-m.k)){
				MainScreen.game_over = true;
				win = true;
			}
		}		
		if(win){
			m.lb.setText("You   Win");
			m.lb.setForeground(MainScreen.background);
			m.stat.setBackground(new Color(150,200,150));
		}
		else{
			m.lb.setText("You   lose");
			m.lb.setForeground(MainScreen.background);
			m.stat.setBackground(new Color(240,90,90));
		}
		while(!rstart)
			System.out.print("");
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			m.rstart();
			reset();
			lanch(m);
		
	}
	public static void main(String[] args) {
		Run r = new Run();
		r.m = new MainScreen();
		r.lanch(r.m);
	}
}
