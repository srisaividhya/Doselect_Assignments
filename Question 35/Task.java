/*Question 35:
Complete the classes using the Specifications given below. Consider default visibility of classes, data fields, and methods unless mentioned otherwise.
Specifications
class definitions:
 class Task:
  data members: 
    String name
    int hours
  Task(String name, int hours): constructor with public visibility

class ToDoList:
data members:
   List<Task> tasks

 method definitions:
   addTask(Task t) throws Exception:   
    return type: String
    visibility: public   

   completeTask(Task t) throws Exception:
    return type: String
    visibility: public  

 class TaskException extends Exception:
  method definition:
   TaskException(String msg)
     visibility: public 
Task
Class Task
- define the String variable name.
- define the int variable hours
-define a constructor according to the above specifications.
Class ToDoList
Implement the below methods for this class:
-String addTask(Task t) throws Exception:


•	Write a code to validate the criteria for getting the award.
•	throw a TaskException if 'hours' is less than 1 or greater than 24 with the message "Invalid time".
•	throw a TaskException if the given object is already present in the ArrayList with the message "Already present".
•	If no above exception is found then add the given task to the given ArrayList and return a string message "Task will be completed".
-String completeTask(Task t) throws Exception:
Write a code to complete the task.
•	If addTask() method throws a TaskException then returns a message "Task incomplete".(Use try-catch block)
•	If it throws any other exception then return a message "Other exception".
•	If no exception is found then return a message "Task completed".
Sample Input
Task t= new Task("Gym",12);
ToDoList lst=new ToDoList();
String t1=lst.addTask(t);
t1.toLowerCase();
Sample Output
task will be completed
NOTE:
•	You can make suitable function calls and use the RUN CODE button to check your main() method output.
ALLOWED TECHNOLOGIES
•	Java 8
*/

package doselect35;
import java.util.ArrayList;
import java.util.List;

public class Task {
	String name;
	int hours;
	
	Task(String name, int hours){
		this.name=name;
		this.hours=hours;
	}
	public String getName() {
		return  this.name;
	}
	public int getHours() {
		return this.hours;
	}
	public void setNme(String name) {
		this.name=name;
	}
	public void setHours(int hours) {
		this.hours=hours;
	}

	public static void main(String[] args) throws Exception{
		Task t = new Task("Gym",12);
		ToDoList list=new ToDoList();
		
		try {
			System.out.println(list.addTask(t).toLowerCase());
		}
		catch(Exception e) {
			System.out.println(e.getMessage().toLowerCase());
		}

	}

}


class ToDoList{
	List<Task> tasks = new ArrayList<>();
	
	
	public String addTask(Task t) throws Exception{
		int hour = t.getHours();
		if(hour <1 || hour >24) {
			throw new TaskException("Invalid time");
		}
		if(tasks.contains(t)) {
			throw new TaskException("Already Present");
		}
		else {
			tasks.add(t);
			return "Task will be completed";
		}
	}
	
	public String completeTask(Task t) throws Exception{
		try {
			addTask(t);
		}
		catch(TaskException e) {
			return "Task incomplete";
		}
		catch(Exception e) {
			return "Other Exception";
		}
		return "Task completed";
	}
}
@SuppressWarnings("serial")
 class TaskException extends Exception {
	public TaskException(String msg) {
		super(msg);
	}

}
