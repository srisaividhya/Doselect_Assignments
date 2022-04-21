/*Question 60:

Alan has recently learned about strings in his programming classes. He decided to create some interesting strings using the concepts.
Help Alan!
Implement a Java code based on the following specifications. Note that your code should match the specifications in a precise manner. Consider default visibility of classes, data fields and methods unless mentioned otherwise.
Specifications:
class Implementation:
   method definiton:
    splitAddAndReturnCharacter(String str)

        visibility: public
        return type: char
Task:
class Implementation
-Implement the below method for this class
•	char splitAddAndReturnCharacter(String str): Sum all the character values i.e. ‘a’ = 1, ‘b’ = 2, ‘c’ = 3, …, ‘z’ = 26 and return the character corresponding to the sum value. If it exceeds 26 then take sum % 26.
Note: string str consisting of lowercase English alphabets only.
Sample Input:
java
Sample Output
h
NOTE:
•	You can make suitable function calls and use RUN CODE button to check your main() method output.
ALLOWED TECHNOLOGIES
•	Java 8 */


package doselect60;

import java.util.Scanner;

public class Implementation {

	public static char splitAddAndReturnCharacter(String str) {
		int sum = 0;
		 
	    for (int i = 0; i < str.length(); i++)
	    {
	        sum += (str.charAt(i) - 'a' + 1);
	        System.out.println(sum);
	    }
	    if (sum % 26 == 0)
	        return 'z';
	    else
	    {
	        sum = sum % 26;
	        return (char)('a' + sum - 1);
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		str= str.toLowerCase();
		System.out.println(splitAddAndReturnCharacter(str));
	}

}
