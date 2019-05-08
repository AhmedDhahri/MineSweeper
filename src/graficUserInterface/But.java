package graficUserInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class But extends JButton {

	Color background;
	Color clicked_background;
	Color marked_background;
	Color hovered_border;
	Color normal_background;
	Color lose_background;
	Color hover_background;
	Color col;
	public Position p;
	public boolean isClicked;
	public boolean cleaned;
	public boolean isMarked;
	public boolean isHovered;
	public static int marked;
	public static int clicked;
	public But(Position p) {
		clicked =0;
		marked = 0;
		isHovered = false;
		isMarked = false;
		cleaned = false;
		isClicked = false;
		hover_background = new Color(180,180,255);
		clicked_background = new Color(220,220,220);
		marked_background = new Color(150,200,150);
		hovered_border = new Color(100,150,200);
		normal_background = new Color(180,180,200);
		lose_background = new Color(240,90,90);
		col = normal_background;
		this.p = p;
		background = MainScreen.background;
		setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		this.setBorder(BorderFactory.createLineBorder(background, 2,true));
		setBackground(normal_background);
		setForeground(new Color(50,50,50));
		setFocusPainted(false);
		setFont(new Font("Serif",Font.BOLD, 20));
		setPreferredSize(new Dimension(30,30));

				
	}
	
	public void Click(){
		if((isClicked == false) && (isMarked == false)){
			clicked++;
			isClicked = true;
			setBackground(clicked_background);
			col = clicked_background;
			if(MainScreen.tab[p.X][p.Y].x != 0)
				setText(""+MainScreen.tab[p.X][p.Y].x);
			else if(MainScreen.tab[p.X][p.Y].x == 0){
				
			}
		}
	}
	public void mark(){
		if((isMarked == false) && (isClicked == false) && (!MainScreen.game_over)){
			isMarked = true;
			isClicked = true;
			setBackground(marked_background);
			col = marked_background;
			marked++;
		}
		else if((isMarked == true) && (isClicked == true) && (!MainScreen.game_over)){
			isMarked = false;
			isClicked = false;
			setBackground(normal_background);
			col = normal_background;
			marked--;
			
		}
	}
	public void lose(){
		
		setBackground(lose_background);
		col = lose_background;
	}
	public void hover(){
		if(isHovered && !isClicked){
			setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, hovered_border));

		}
		else if(!isHovered){
			setBackground(col);
			setBorder(BorderFactory.createLineBorder(background, 2,true));
		}
	}

}
