package general;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Setting {
	public static int horizontal;
	public static int vertical;
	public int mines;
	public static char level;
	File save,f;
	DataOutputStream dout;
	DataInputStream din;
	
	public Setting(){
		
		save = new File("save");
		f = new File("save/set");
		if(!save.exists()){
			save.mkdir();
			if(!f.exists()){
				dout = makefile(f);
				try {
					dout.writeInt(8);
					dout.writeInt(8);
					dout.writeInt(10);
					dout.writeChar('E');
					dout.close();
				} catch (IOException e) {}
			}
				
		}
		if((save.exists()) && (f.exists())){
			din = openfile(f);
			try {
				horizontal = din.readInt();
				vertical = din.readInt();
				mines = din.readInt();
				level = din.readChar();
			} catch (IOException e) {}
			
		}
	}

	DataInputStream openfile(File f) {
		try {
			DataInputStream t = new DataInputStream(new BufferedInputStream(new FileInputStream(f)));
			return t;
		} catch (FileNotFoundException e) {return null;}
	}

	DataOutputStream makefile(File f) {
		try {
			DataOutputStream t = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			return t;
		} catch (FileNotFoundException e) {return null;}
	}
	public void save(int h,int v,int m,char c){
		dout = makefile(f);
		try {
			dout.writeInt(h);
			dout.writeInt(v);
			dout.writeInt(m);
			dout.writeChar(c);
			dout.close();
		} catch (IOException e) {}
	}
}
