import java.net.InetAddress;

public class IPaddress {
    public static int main() {
        try {

            // get IP address and hostname for local system
            InetAddress myIP = InetAddress.getLocalHost();
            System.out.println("Your IP is :"+myIP.getHostAddress());


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return -1;

    }
}
