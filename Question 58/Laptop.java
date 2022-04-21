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
