package motors;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import general.Run;
import general.Setting;
import graficUserInterface.But;
import graficUserInterface.MainScreen;
import graficUserInterface.Mystery;

public class MotorMenu implements ActionListener {
	JMenuItem b;
	String s;
	public MotorMenu(){
		s = "";
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem b = (JMenuItem) e.getSource();
		if(b.getText().equals("How to"))
			System.out.println("fuck");
		s = b.getText();
		if(s.equals("Restart")){
			(Run.rstart) = true;
		}else if(s.equals("Solution")){
			Run.solve = true;
			System.out.print(true);
		}else if(s.equals("Close")){
			System.exit(0);
			
		}else if(s.equals("Save")){
			save(MainScreen.but,MainScreen.tab);
		}
	}
	private void save(But[][] but, Mystery[][] tab) {
		int x = Setting.vertical;
		int y = Setting.horizontal;
		boolean[][] b = new boolean[x][y];
		
		for(int i=0;i<x;i++)
			for(int j=0;j<y;j++){
				b[i][j] = but[i][j].isClicked;
			
			}
		
	}

}
