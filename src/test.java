import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class test{
	public static void main(String[] args) {
		
//		new test().Exercise1();
//		System.out.println( new test().Exercise2(10));
//		new test().Exercise3();
		new test().Exercise4(10);

	}
	
	public void Exercise1() {
		try {
			Scanner Input = new Scanner(System.in);
			System.out.println("Saiaser un Nombre : ");
			double UserInput = Input.nextDouble();
			System.out.printf("Le nombre %.2f est entier.", UserInput);
		}catch(InputMismatchException err) {
			System.out.println("La Valeur n'epas un entire ...");
		}
	}
	
	public int Exercise2(int nb) {
		if (nb <= 1) return 1;
		return new test().Exercise2(nb - 1) * nb;
	}

	public void Exercise3() {
		
		try {
			Scanner Input = new Scanner(System.in);
			System.out.print("Saiser un nombre Positif:\t");
			int userInput = Input.nextInt();
			if (userInput > 0) {
				for (int i=1;i<= userInput;i++)
				{
					System.out.println(i + "x" + userInput + "= " + (i * userInput));
					System.out.println("-----------------------------------");
				}
			} else {
				System.out.println("Voulez saiser un nombre Positif..");
			}
		}catch(InputMismatchException err) {
			System.out.println("Voulez saiser un nombre entier...");
		}
		
	}

   public void Exercise4(int nb) {
	    String[] Spliting = String.valueOf(nb).split("");
	    for (int i = Spliting.length - 1;i>=0 ;i--) {
	    	System.out.print(Spliting[i]);
	    }
	    
   }
}


