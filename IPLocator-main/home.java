import java.util.Scanner;

public class home {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int z=1;
        do {
            System.out.println("Choose Your option:");
            System.out.println("1.Your Private IP");
            System.out.println("2.Search IP Address of a Website ");
            System.out.println("3.Search GEO Location of a IP Address");
            System.out.println("4.Exit");
            System.out.println("Enter The Choice:");
            int a = sc.nextInt();
            switch (a){
                case 1:
                    ipaddress.main();
                    break;
                case 2:
                    Ipfinder.main();
                    break;
                case 3:
                    Main.main();
                    break;
                case 4:
                    z=0;
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid Choice!");
                    break;
            }
        }while (z==1);
    }
}
