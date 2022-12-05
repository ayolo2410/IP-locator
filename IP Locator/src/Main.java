import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int geoid = Geoid.main();
        String[] finale = country.main(geoid);
        System.out.println(Arrays.toString(finale));

    }
}