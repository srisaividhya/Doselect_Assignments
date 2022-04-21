/*
Question 33:

Your task here is to implement a Java code based on the following specifications. Note that your code should match the specifications in a precise manner. Consider default visibility of classes, data fields, and methods unless mentioned otherwise.
Specifications:
class Person
  data members:
     Integer id
     String name
     LocalDate birthDate
      visibility: private

   Person(Integer id, String name, LocalDate birthDate): constructor with public visibility
  Define getter setters with public visibility
  toString() method has been implemented for you 

class Implementation:
 method definition:
  filterListByBirth(List<Person> persons) :
   return type: List<Person>
   visibility: public
 
  limitSkipAndReturn(List<Person> persons, int pageNumber, int pageSize) :
    return type: List<Person> 
    visibility: public
Task:
class Person:
- define the class according to the above specifications
class Implementation:
Implement the below method for this class using in Stream API:
•	List<Person> filterListByBirth(List<Person> persons): filter and return the list by date of birth
•	List<Person> limitSkipAndReturn(List<Person> persons, int pageNumber, int pageSize):  get the multiplication of pageNumber and pageSize, skip those indexes, now limit the pageSize and return the list
Example: For the below list in the sample input, page number * page size = 2, skip the first 2 indexes in the list, now limit the page size = 2, after limiting the page size we get the desired result as given below in sample output
Refer to the sample input output for more clarifications
Sample Input
 Person p1 = new Person(1, "Mito", LocalDate.of(1991, 1, 21));
 Person p2 = new Person(2, "Code", LocalDate.of(1990, 2, 21));
 Person p3 = new Person(3, "Jaime", LocalDate.of(1980, 6, 23));
 Person p4 = new Person(4, "Duke", LocalDate.of(2019, 5, 15));
 Person p5 = new Person(5, "James", LocalDate.of(2010, 1, 4));

List<Person> persons = Arrays.asList(p1, p2, p3, p4, p5);
------------------------------------------------------

imp.filterListByBirth(persons)
imp.limitSkipAndReturn(persons, 1, 2)
Sample Output
[Person{id=3, name='Jaime', birthDate=1980-06-23}, Person{id=2, name='Code', birthDate=1990-02-21}, Person{id=1, name='Mito', birthDate=1991-01-21}, Person{id=5, name='James', birthDate=2010-01-04}, Person{id=4, name='Duke', birthDate=2019-05-15}]
---------------------------------------------------------
[Person{id=3, name='Jaime', birthDate=1980-06-23}, Person{id=4, name='Duke', birthDate=2019-05-15}]
NOTE
•	You can make suitable function calls and use the RUN CODE button to check your main() method output.
ALLOWED TECHNOLOGIES
•	Java 8 */


package doselect33;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person {
	private Integer id;
	private String name;
	private LocalDate birthDate;
	public Person(Integer id, String name, LocalDate birthDate) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
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
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "Product{id="+id+" name='" + name +"', birthDate="+birthDate+"}";
	}
	public static void main(String[] args) {
		Person p1 = new Person(1, "Mito", LocalDate.of(1991, 1, 21));
		Person p2 = new Person(2, "Code", LocalDate.of(1990, 2, 21));
		Person p3 = new Person(3, "Jaime", LocalDate.of(1980, 6, 23));
		Person p4 = new Person(4, "Duke", LocalDate.of(2019, 5, 15));
		Person p5 = new Person(5, "James", LocalDate.of(2010, 1, 4));
		List<Person> persons = Arrays.asList(p1, p2, p3, p4, p5);
		Implementation imp=new Implementation();
		System.out.println(imp.filterListByBirth(persons));
		System.out.println(imp.limitSkipAndReturn(persons, 1, 2));
	}
}
class Implementation{
	public List<Person> filterListByBirth(List<Person> persons){
		List<Person> persons1=new ArrayList<>(persons);
		Collections.sort(persons1, Comparator.comparing(Person::getBirthDate));
		return persons1;
	}
	public List<Person> limitSkipAndReturn(List<Person> persons,int pageNumber,int pageSize){
		List<Person> list=new ArrayList<>();
		int temp1=pageNumber*pageSize;
		int temp2=0;
		for(int i=temp1;i<persons.size();i++) {
			if(temp2==temp1)
				return list;
			list.add(persons.get(i));
			temp2++;
		}
		return list;
	}
}
