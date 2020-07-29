package A1;

public class Star_hold {
	int x=0;
	int y=0;
	int mintotalpath;
	boolean vis = false ;
	boolean bfsvis = false;
	
	char  ch;
	Star_hold(char ch,int x,int y){
		set_ch(ch);
		this.x=x;
		this.y=y;
		mintotalpath=0;
	}

	public Star_hold() {
		// TODO Auto-generated constructor stub
	}

	public void set_ch(char ch) {
	this.ch=ch;
	}
	public char get_ch () {
		return ch;
	}
}