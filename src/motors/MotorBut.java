package motors;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

import graficUserInterface.But;
import graficUserInterface.MainScreen;
import graficUserInterface.Position;

public class MotorBut implements ActionListener{
	/**
	 * 
	 */
	public static int x;
	public static int y;
	public static boolean start = false;
	String text;
	But b;
	ImageIcon icon;
	public static Position start_pos;
	public MotorBut(){
		start_pos = new Position(0,0);
		icon = new ImageIcon("icon.png");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		b =(But) e.getSource();
		if(start == false){
			start_pos = b.p;
			start = true;
			while(MainScreen.start == false)
				System.out.print("");
			start(b);
		}
		else if(!b.isClicked && !b.isMarked && !MainScreen.game_over){
			if((MainScreen.tab[b.p.X][b.p.Y].c) == 'b'){
				b.lose();
				MainScreen.game_over = true;
			}
			else{
				b.Click();
				if(MainScreen.tab[b.p.X][b.p.Y].x == 0)
					clean(b.p.X,b.p.Y);
			}
		}
	}
	void start(But b){
		b.Click();
		if(MainScreen.tab[b.p.X][b.p.Y].x == 0)
			clean(b.p.X,b.p.Y);
	}
	void clean(int u, int v){
		if(MainScreen.tab[u][v].x == 0){
			if((u!=0) && (u!=x-1) && (v!=y-1) && (v!=0)){
				MainScreen.but[u-1][v-1].Click();
				MainScreen.but[u-1][v].Click();
				MainScreen.but[u-1][v+1].Click();
				MainScreen.but[u][v-1].Click();
				MainScreen.but[u][v+1].Click();
				MainScreen.but[u+1][v-1].Click();
				MainScreen.but[u+1][v].Click();
				MainScreen.but[u+1][v+1].Click();
				if(MainScreen.but[u][v].cleaned == false){
					MainScreen.but[u][v].cleaned = true;
					clean(u-1,v-1);
					clean(u-1,v);
					clean(u-1,v+1);
					clean(u,v-1);
					clean(u,v+1);
					clean(u+1,v-1);
					clean(u+1,v);
					clean(u+1,v+1);
				}

			}else if((u==0) && (v!=0) && (v!=y-1)){
				MainScreen.but[0][v-1].Click();
				MainScreen.but[0][v+1].Click();
				MainScreen.but[1][v-1].Click();
				MainScreen.but[1][v].Click();
				MainScreen.but[1][v+1].Click();
				
				if(MainScreen.but[u][v].cleaned == false){
					MainScreen.but[u][v].cleaned = true;
					clean(0,v-1);
					clean(0,v+1);
					clean(1,v-1);
					clean(1,v);
					clean(1,v+1);
				}
				
			}else if((u==x-1) && (v!=0) && (v!=y-1)){
				MainScreen.but[u-1][v-1].Click();
				MainScreen.but[u-1][v].Click();
				MainScreen.but[u-1][v+1].Click();
				MainScreen.but[u][v-1].Click();
				MainScreen.but[u][v+1].Click();
				
				if(MainScreen.but[u][v].cleaned == false){
					MainScreen.but[u][v].cleaned = true;
					clean(u,v+1);
					clean(u,v-1);
					clean(u-1,v+1);
					clean(u-1,v);
					clean(u-1,v-1);
				}
				
			}else if((u!=0) && (u!=x-1) && (v==0)){
				MainScreen.but[u-1][1].Click();
				MainScreen.but[u][1].Click();
				MainScreen.but[u+1][1].Click();
				MainScreen.but[u+1][0].Click();
				MainScreen.but[u-1][0].Click();
				
				if(MainScreen.but[u][v].cleaned == false){
					MainScreen.but[u][v].cleaned = true;
					clean(u-1,1);
					clean(u+1,1);
					clean(u,1);
					clean(u-1,0);
					clean(u+1,0);
				}
				
			}else if((u!=0) && (u!=x-1) && (v==y-1)){
				MainScreen.but[u-1][v-1].Click();
				MainScreen.but[u][v-1].Click();
				MainScreen.but[u+1][v-1].Click();
				MainScreen.but[u-1][v].Click();
				MainScreen.but[u+1][v].Click();
				
				if(MainScreen.but[u][v].cleaned == false){
					MainScreen.but[u][v].cleaned = true;
					clean(u-1,v-1);
					clean(u-1,v);
					clean(u,v-1);
					clean(u+1,v);
					clean(u+1,v-1);
				}
				
			}else if((u==0) && (v==0)){
				MainScreen.but[1][1].Click();
				MainScreen.but[1][0].Click();
				MainScreen.but[0][1].Click();
				
				if(MainScreen.but[u][v].cleaned == false){
					MainScreen.but[u][v].cleaned = true;
					clean(0,1);
					clean(1,0);
					clean(1,1);
				}
				
			}else if((u==0) && (v==y-1)){ 
				MainScreen.but[0][v-1].Click();
				MainScreen.but[1][v-1].Click();
				MainScreen.but[1][v].Click();
				
				if(MainScreen.but[u][v].cleaned == false){
					MainScreen.but[u][v].cleaned = true;
					clean(0,v-1);
					clean(1,v-1);
					clean(1,v);
				}
				
			}else if((u==x-1) && (v==0)){
				MainScreen.but[u-1][0].Click();
				MainScreen.but[u-1][1].Click();
				MainScreen.but[u][1].Click();
				
				if(MainScreen.but[u][v].cleaned == false){
					MainScreen.but[u][v].cleaned = true;
					clean(u-1,0);
					clean(u-1,1);
					clean(u,1);
				}
				
			}else if((u==x-1) && (v==y-1)){
				MainScreen.but[u-1][v].Click();
				MainScreen.but[u][v-1].Click();
				MainScreen.but[u-1][v-1].Click();
				
				if(MainScreen.but[u][v].cleaned == false){
					MainScreen.but[u][v].cleaned = true;
					clean(u-1,v-1);
					clean(u-1,v);
					clean(u,v-1);
				}
				
			}
		}
	}
}
