import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Geoid {
    public static int main() {
        String path = "E:\\College\\Minor\\Code\\Country-CSV\\GeoLite2-Country-Blocks-IPv4.csv";
        String line = "";
        ArrayList<String> ip1 = new ArrayList<String>();
        ArrayList<String> ip2 = new ArrayList<String>();
        ArrayList<String> ip3 = new ArrayList<String>();
        ArrayList<String> ip4 = new ArrayList<String>();
        ArrayList<String> ip5 = new ArrayList<String>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine(); //read skip the first line i.e. header
            while((line = br.readLine()) != null) {
                String[] values = line.split("\\D");
                ip1.add(values[0]);
                ip2.add(values[1]);
                ip3.add(values[2]);
                ip4.add(values[3]);
                ip5.add(values[5]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("Enter ip (xxx.xxx.xxx.xxx): ");
        Scanner input = new Scanner(System.in);
        String inputip = input.next();
        String[] input_ip= inputip.split("[.]", 0);


        int[] int_ip1 = convert(ip1);
        int[] int_ip2 = convert(ip2);
        int[] int_ip3 = convert(ip3);
        int[] int_ip4 = convert(ip4);


        int target = Integer.parseInt(input_ip[0]);
        int first1 = firstoccurrence(int_ip1, target); // find first occurrence of number in the first bit
        int last1 = lastoccurrence(int_ip1, target); // find last occurrence of number in the first bit

        int target2 = Integer.parseInt(input_ip[1]);
        int first2 = firstoccurrence(int_ip2, target2, first1, last1);
        int last2 = lastoccurrence(int_ip2, target2, first1, last1);

        int target3 = Integer.parseInt(input_ip[2]);
        int first3 = firstoccurrence(int_ip3, target3, first2, last2);
        int last3 = lastoccurrence(int_ip3, target3, first2, last2);

        int target4 = Integer.parseInt(input_ip[3]);
        int index = search_ip4(int_ip4, target4, first3, last3);

        return Integer.parseInt(ip5.get(index));
    }

3
    //converts string arraylist to integer arraylist
    static int[] convert(ArrayList<String> ip){
        int[] int_ip = new int[ip.size()];
        int i = 0;
        for (String s : ip) {
            int_ip[i] = Integer.parseInt(s);
            i++;
        }
        return int_ip;
    }

    static int search_ip4(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start)/2; // same as (start + end) / 2

            if(target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    static int firstoccurrence(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if ((mid == 0 || arr[mid - 1] < target) && arr[mid] == target)
                return mid;
            else if (target > arr[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    static int lastoccurrence(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if ((mid == end || arr[mid + 1] > target) && arr[mid] == target)
                return mid;
            else if (target < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
    //----------------------------------------------------------------------------------------------------------------------
    //overloaded methods
    static int firstoccurrence(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if ((mid == 0 || arr[mid - 1] < target) && arr[mid] == target)
                return mid;
            else if (target > arr[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    static int lastoccurrence(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if ((mid == end || arr[mid + 1] > target) && arr[mid] == target)
                return mid;
            else if (target < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
}
