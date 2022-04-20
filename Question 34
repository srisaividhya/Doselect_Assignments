package doselect34;

public class Bomb {

	int time;
	String color;

	Bomb() {

	}

	Bomb(int time, String color) {
		this.time = time;
		this.color = color;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getTime() {
		return this.time;
	}

	public String getColor() {
		return this.color;
	}



class Suicide {

		Bomb bomb=null;
		public Suicide(Bomb bb) {
			bomb=bb;
		}
		public String diffuseIt(int time , String color) throws Exception{
			int bombtime = bomb.getTime();
			String bombcolor = bomb.getColor();
			
			if(time  > bombtime)
				throw new SuicideException("Time exceeded");
			if(color != bombcolor)
				throw new SuicideException("Wrong color");
			else
				return "Hope is there";
			
		
			
		}
		
		public String checkSafety(int time , String color) throws Exception{
			
			try {
				diffuseIt(time , color);
					
			}
			catch(SuicideException e) {
				return "Bomb exploded";
			}
			catch(Exception e) {
				return "Other Exception";
			}
			return "take a bow";
		}
	}


	@SuppressWarnings("serial")
public class SuicideException extends Exception {

	public SuicideException(String msg) {
		super(msg);
		}
}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Bomb b = new Bomb(10, "red");
		Suicide sc = b.new Suicide(b);
		
		 try {
			 System.out.println(sc.diffuseIt(5,"red").toLowerCase());
			
		 }
		 catch(SuicideException e){
			 System.out.println(e.getMessage().toLowerCase());
		 }
		 String t = sc.checkSafety(8,"blue");
			 System.out.println(t.toLowerCase());
	}

}
