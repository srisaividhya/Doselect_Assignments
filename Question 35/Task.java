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
