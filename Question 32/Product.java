/*Question 32:

Your task here is to implement a Java code based on the following specifications. Note that your code should match the specifications in a precise manner. Consider default visibility of classes, data fields, and methods unless mentioned otherwise.
Specifications:
class Product
  data members:
     Integer id;
     String name;
     Double price;
      visibility: private

   Product(Integer id, String name, Double price): constructor with public visibility
  Define getter setters with public visibility
  toString() method has been implemented for you 

class Implementation:
 method definition:
  getProductName(List<Product> products) :
   return type: Map<String, List<Product>> 
   visibility: public
 
  getSum(List<Product> products) :
    return type: Map<String, Double>
    visibility: public
Task:
class Product:
- define the class according to the above specifications
class Implementation:
Implement the below method for this class using in Stream API:
•	Map<String, List<Product>> getProductName(List<Product> products): 
fetch and return the details of all the products
•	 Map<String, Double> getSum(List<Product> products):  sum all the product in the list and return it
Sample Input
Product pr1 = new Product(1, "Ceviche", 15.0);
Product pr2 = new Product(2, "Chilaquiles", 25.50);
Product pr3 = new Product(3, "Bandeja Paisa", 35.50);
Product pr4 = new Product(4, "Ceviche", 15.0);

List<Product> pr = Arrays.asList(pr1, pr2, pr3, pr4);
Implementation imp = new Implementation();
------------------------------------------------------

imp.getProductName(pr)
imp.getSum(pr)
Sample Output
{Bandeja Paisa=[Product{id=3, name='Bandeja Paisa', price=35.5}], Chilaquiles=[Product{id=2, name='Chilaquiles', price=25.5}]}
---------------------------------------------------------
{Ceviche=30.0, Bandeja Paisa=35.5, Chilaquiles=25.5}
NOTE
•	You can make suitable function calls and use the RUN CODE button to check your main() method output.
ALLOWED TECHNOLOGIES
•	Java 8*/


package doselect32;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Product {
	private Integer id;
	private String name;
	private Double price;
	public Product(Integer id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product{id="+id+" name='" + name +"', price="+price+"}";
	}
	public static void main(String[] args) {
		Product pr1 = new Product(1, "Ceviche", 15.0);
		Product pr2 = new Product(2, "Chilaquiles", 25.50);
		Product pr3 = new Product(3, "Bandeja Paisa", 35.50);
		Product pr4 = new Product(4, "Ceviche", 15.0);
		List<Product> pr = Arrays.asList(pr1, pr2, pr3, pr4);
		Implementation implementation=new Implementation();
		System.out.println(implementation.getProductName(pr));
		System.out.println(implementation.getSum(pr));
	}
}
class Implementation{
	public Map<String, List<Product>> getProductName(List<Product> products){
		Map<String, List<Product>> tempMap = new HashMap<String, List<Product>>();
		for(Product p:products) {
			List<Product> ProductList=new ArrayList<>();
			if(p.getPrice()>20.0) {
				if(!tempMap.containsKey(p.getName())) {
					ProductList.add(p);
					tempMap.put(p.getName(),ProductList);
				}
				else {
					List<Product> temp=new ArrayList<>();
					ProductList.add(p);
					temp=tempMap.get(p.getName());
					temp.addAll(ProductList);
					tempMap.put(p.getName(),temp) ;
				}
			}
		}
		return tempMap;
	}
	public Map<String, Double> getSum(List<Product> products){
		Map<String, Double> tempMap = new HashMap<String, Double>();
		for(Product p:products) {
			if(!tempMap.containsKey(p.getName())) {
				tempMap.put(p.getName(),p.getPrice());
			}
			else {
				double temp=tempMap.get(p.getName());
				temp+=p.getPrice();
				tempMap.put(p.getName(),temp);
			}
		}
		return tempMap;
	}
}
