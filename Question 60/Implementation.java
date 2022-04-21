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
