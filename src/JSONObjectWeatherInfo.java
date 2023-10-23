import org.json.JSONObject;
import java.util.Objects;
public class JSONObjectWeatherInfo {
    public static String getJSONObjectWeatherInfo(String jsonFile){
        StringBuilder parameters = new StringBuilder();
        try {
            Objects.requireNonNull(jsonFile);
            JSONObject obj = new JSONObject(jsonFile);
            parameters.append("The temperature is ").append(obj.getJSONObject("main").getDouble("temp")).append("\n").append("°C");
            parameters.append("Feels like ").append(obj.getJSONObject("main").getDouble("feels_like")).append("\n").append("°C");
            parameters.append("Max is ").append(obj.getJSONObject("main").getDouble("temp_max")).append("\n").append("°C");
            parameters.append("Min is ").append(obj.getJSONObject("main").getDouble("temp_min")).append("\n").append("°C");
            parameters.append("Presure is ").append(obj.getJSONObject("main").getDouble("pressure")).append("\n");

        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        return parameters.toString();
    }
}
