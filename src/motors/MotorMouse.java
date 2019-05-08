package motors;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;

import graficUserInterface.But;
import graficUserInterface.MainScreen;

public class MotorMouse implements MouseListener{

	But b;
	public MotorMouse() {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		b = (But) e.getComponent();
		b.isHovered = true;
		b.hover();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		b = (But) e.getComponent();
		b.isHovered = false;
		b.hover();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		b = (But) e.getComponent();
		b.setBorder(BorderFactory.createLineBorder(MainScreen.background, 2,true));
		if(e.getButton() == MouseEvent.BUTTON3){
		b.mark();
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}

}
