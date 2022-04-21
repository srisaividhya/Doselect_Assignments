/*Question 31:

Your task here is to implement a Java code based on the following specifications. Note that your code should match the specifications in a precise manner. Consider default visibility of classes, data fields, and methods unless mentioned otherwise.
Specifications:
class definitions: 
  class Dog:
    data members:
     String name
     int age
     int weight

   Dog(String name, int age, int weight): constructor with public visibility
    Define getter setters with public visibility
    toString(): has been implemented for you

  class Implementation:
     method definition:
       filterByAgeAndWeight(List<Dog> listDog):
           return type: List<Dog> 
           visibility: public

       separateWithDelimeter(List<Dog> listDog):
           return type: String 
           visibility: public
Task:
class Dog:
- Define the class according to the above specifications
class Implementation:
Implement the below method for this class:
•	List<Dog> filterByAgeAndWeight(List<Dog> listDog): fetch dog details on the basis of:
•	age greater than 10
•	weight greater than 25
•	get the filtered data, put it into a list and return the list
•	String separateWithDelimeter(List<Dog> listDog):  concat and return the dogs details with delimeter "$~$~" 
Refer sample output for clarity
Sample Input
 List<Dog> list = new ArrayList<Dog>();
  list.add(new Dog("German Shepherd ", 20, 35));
  list.add(new Dog("Labrador ", 5, 40));
  list.add(new Dog("Pitbull ", 29, 100));
  list.add(new Dog("Poodle", 10, 45));
Sample Output
[Dog{name='German Shepherd ', age=20, weight=35}, Dog{name='Pitbull ', age=29, weight=100}] */

package doselect31;

import java.util.ArrayList;
import java.util.List;

public class Dog {
	String name;
	int age;
	int weight;
	public Dog(String name, int age, int weight) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Dog{name='" + name +"', age="+age+ ", weight=" + weight + "}";
	}
	public static void main(String[] args) {
		List<Dog> list = new ArrayList<Dog>();
		list.add(new Dog("German Shepherd ", 20, 35));
		list.add(new Dog("Labrador ", 5, 40));
		list.add(new Dog("Pitbull ", 29, 100));
		list.add(new Dog("Poodle", 10, 45));
		Implementation implementation=new Implementation();
		System.out.println(implementation.filterByAgeAndWeight(list));
		System.out.println(implementation.separateWithDelimeter(list));
	}
}
class Implementation{
    public List<Dog> filterByAgeAndWeight(List<Dog> listDog){
    	int i=0;
    	List<Dog> list=new ArrayList<>();
    	for(Dog d:listDog) {
    		if(listDog.get(i).getAge()>10 && listDog.get(i).getWeight()>25) {
    			list.add(d);
    		}
    		i++;
    	}
    	return list;
    }
    public String separateWithDelimeter(List<Dog> listDog){
    	StringBuffer sb=new StringBuffer();  
		int n=listDog.size();
		sb.append(listDog.get(0));
		for(int i=1;i<n;i++) {
			sb.append("$$");
			sb.append(listDog.get(i));
		}
		return sb.toString();
    }
}
