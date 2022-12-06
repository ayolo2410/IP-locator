import java.net.*;
import java.util.Scanner;

public class Ipfinder{
    public static int main() {
        try {
            Scanner sc =new Scanner(System.in);
            System.out.println("Enter The Website Name:");
            String a= sc.next();
            // get IP address and hostname for local system
            InetAddress myIP = InetAddress.getByName(a);
            System.out.println(myIP.getHostAddress());
    

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
    }
}