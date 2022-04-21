/*Q58
Complete the classes using the Specifications given below. Consider default visibility of classes, data fields, and methods unless mentioned otherwise.
Specifications
class definitions:
 class Laptop:
   data members:
     String name 
     String model
     String date

 Laptop(String name, String model, String date): constructor with public visibility

 class Purchase:
   data members:
    laptop laptop     
  method definitions:
   purchaseLaptop(String name, String model,String date):    
    return type: String
    visibility: public

  findGeneration(String processor)
    return type : String
    visibility : public
class Laptop
- define all the variables according to the above specifications.
- define a constructor according to the above specifications.
Class Purchase
- define all the variables according to the above specifications.
Implement the below methods for this class:
-String purchaseLaptop(String name, String model, String date):
•	Check the following conditions -
1.	The name must be of two words. The first word denotes the name of the brand ["Dell", "Acer", "HP"] and the second word is the number of processors ["Single", "Double", "Quad", "Octa"]. If the company name is not among the mentioned then return "Invalid brand name". If the processor is any other than the mentioned then return "Invalid processor".
2.	model name length must be equal to 9 with 3 uppercase letters, 3 lowercase letters, 2 digits, and 2 special characters. If this condition is not fulfilled return "Invalid model number".
•	If the above all conditions are satisfied then initialize the laptop variable with the above-mentioned specifications, return "Laptop purchased".
-String findGeneration(String processor):
•	If the number of processors is "Octa" return "Gen 11".
•	If the number of processors is "Quad" return "Gen 10".
•	If the processor is "Double" return "Gen 9".
•	Else return "Lower than 9".
Sample Input
Laptop l=new Laptop("Acer Quad","@#","12/12/2018");
Purchase p=new Purchase();
p.purchaseLaptop("Dell Quad","@#","12/12/2018");
Sample Output
Invalid model number
NOTE:
•	You can make suitable function calls and use the RUN CODE button to check your main() method output.
•	All the messages used in the return statements and messages are case-sensitive.
*/

package doselect58;

public class Laptop {

	String name;
	String model;
	String date;
	
	public Laptop(String name, String model, String date) {
		
		this.name = name;
		this.model = model;
		this.date = date;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	class Purchase{
		Laptop laptop;
		
		public String purchaseLaptop(String name, String model, String date) {
			
			String[] brandandprocessor = name.split(" ");
			char[] model1= model.toCharArray();
			int digitcount =0, uppercount =0, lowercount =0,specialcount=0;
			
			for(int i=0; i < model1.length;i++) {
				if(Character.isDigit(model1[i]))
					digitcount++;
				else if(Character.isUpperCase(model1[i]))
					uppercount++;
				else if(Character.isLowerCase(model1[i]))
					lowercount++;
				else
					specialcount++;
			}
			
			if(! (brandandprocessor[0].equals("Dell") || brandandprocessor[0].equals("Acer") 
					|| brandandprocessor[0].equals("HP")))
					return "Invalid brand name";
			else if(! (brandandprocessor[1].equals("Single") || brandandprocessor[0].equals("Double") 
					|| brandandprocessor[1].equals("Quad") || brandandprocessor[1].equals("Octa")))
				return "Invalid processor";
			else if(! (model.length() >= 9 && uppercount==3 && lowercount==3  
					&& digitcount ==2 && specialcount ==2 ))
				return "Invalid model number";
			else
				return "Laptop purchased";
		}
		
		public String findGeneration(String processor) {
		
			if(processor.equals("Octa"))
				return "Gen 11";
			else if(processor.equals("Quad"))
				return "Gen 10";
			else if(processor.equals("Double"))
				return "Gen 9";
			else
				return "Lower than 9";
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Laptop l=new Laptop("Acer Quad","@#","12/12/2018");
		Purchase p=l.new Purchase();
		System.out.println(p.purchaseLaptop("Dell Quad","@#","12/12/2018"));
		System.out.println(p.findGeneration("Quad"));
	}

}
