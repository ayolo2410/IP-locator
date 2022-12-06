import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class country {
    public static String[] main(int geoid){
        String path = "E:\\College\\Minor\\Code\\Country-CSV\\GeoLite2-Country-Locations-en.csv";
        String line = "";
        ArrayList<String> geo_id = new ArrayList<String>();
        ArrayList<String> con_id = new ArrayList<String>();
        ArrayList<String> coun_id = new ArrayList<String>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine(); //read skip the first line i.e. header
            while((line = br.readLine()) != null) {
                String[] values = line.split(",");
                geo_id.add(values[0]);
                con_id.add(values[3]);
                coun_id.add(values[5]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int [] geo_int = Geoid.convert(geo_id); //using convert method from the Geoid class

        int index = Geoid.search_ip4(geo_int,geoid, 0, geo_int.length); //using search_ip4 from the Geoid class

        String[] final1 = new String[2];
        final1[0] = con_id.get(index);
        final1[1] = coun_id.get(index);
        return final1;
    }
}
