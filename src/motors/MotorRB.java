package motors;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;

import general.Run;
import general.Setting;


public class MotorRB implements ActionListener{
	JRadioButton b;
	String s;
	public MotorRB() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		b = (JRadioButton)e.getSource();
		s = b.getText();
		
		if(s.equals("Easy")){
			Setting s = new Setting();
			s.save(8, 8, 10,'E');
			(Run.rstart) = true;
		}
		else if(s.equals("Medium")){
			Setting s = new Setting();
			s.save(16, 16, 40,'M');
			(Run.rstart) = true;
		}
		else if(s.equals("Hard")){
			Setting s = new Setting();
			s.save(32, 16, 99,'H');
			(Run.rstart) = true;
		}
	}

}
