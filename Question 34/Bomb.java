/*Question 34:

Complete the classes using the Specifications given below. Consider default visibility of classes, data fields, and methods unless mentioned otherwise.
Specifications
class definitions:
 class Bomb:
    data members: 
        int time
        String color
    Bomb(int time, String color): constructor with public visibility

class Suicide:
 data members:
     Bomb bomb

     Suicide(Bomb bb): constructor with public visibility

 method definitions:
     diffuseIt(int time, String color) throws Exception:     
        return type: String
        visibility: public     

     checkSafety(int time, String color) throws Exception:
        return type: String
        visibility: public   

 class SuicideException extends Exception:
   method definition:
      SuicideException(String msg)
         visibility: public  
Task
Class Bomb
- define the int variable time.
-define String variable color
-define a constructor according to the above specifications.
Class Suicide
-define the bomb variable with null;
-define a constructor according to the above specifications and initialize the bomb variable with the object passed in the argument.
Implement the below methods for this class:
-String diffuseIt(int time, String color) throws Exception:
•	Write a code to validate the criteria for getting the award.
•	throw a SuicideException if time is greater than the time of the bomb with the message "Time exceeded".
•	throw a SuicideException if the color of the bomb is different from the color passed as an argument with the message "Wrong color".
•	If no above exception is found then return a string message "Hope is there".
-String checkSafety(int time, String color) throws Exception:
•	Write a code to send an invite to the nominee.
•	If diffuseIt() method throws a SuicideException then returns a message "Bomb exploded".(Use try-catch block)
•	If it throws any other exception then return a message "Other exception".
•	If no exception is found then return a message "Take a bow".
Sample Input
Bomb b=new Bomb(10,"red");
Suicide sc=new Suicide(b);
String s = sc.diffuseIt(5,"red");
String t = sc.checkSafety(8,"blue");
s.toLowerCase();
t.toLowerCase();
Sample Output
hope is there
bomb exploded
NOTE:
•	You can make suitable function calls and use the RUN CODE button to check your main() method output.
ALLOWED TECHNOLOGIES
•	Java 8
*/


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
