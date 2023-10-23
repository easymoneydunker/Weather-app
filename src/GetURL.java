import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
public class GetURL {
    static String getURLContent(String urlAdress){
        StringBuffer content = new StringBuffer();
        try{
            URL url = new URL(urlAdress);
            URLConnection urlConnection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            while (reader.ready()){
                content.append(reader.readLine() + "\n");
            }
            reader.close();
        }
        catch (Exception e) {
            System.out.println("City not found");
        }
        return content.toString();
    }
}