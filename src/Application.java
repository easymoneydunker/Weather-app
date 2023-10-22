import org.json.JSONObject;
import javax.swing.*;
import java.awt.*;
public class Application extends JFrame {
    public Application(){
        JFrame frame = new JFrame();
        frame.setSize(300, 400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StringBuilder parameters = new StringBuilder();

        JLabel label = new JLabel("Enter city name: ", SwingConstants.CENTER);
        JTextField textField = new JTextField("", 5);
        JButton jButton = new JButton("Get weather");

        jButton.addActionListener(event -> {
            String city = textField.getText().trim();
            String output = GetURL.getURLContent("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid="+ Main.APIKEY +"&units=metric");
            if (!output.isEmpty()){
                JSONObject obj = new JSONObject(output);
                parameters.append("The temperature is ").append(obj.getJSONObject("main").getDouble("temp")).append("\n");
                parameters.append("Feels like ").append(obj.getJSONObject("main").getDouble("feels_like")).append("\n");
                parameters.append("Max is ").append(obj.getJSONObject("main").getDouble("temp_max")).append("\n");
                parameters.append("Min is ").append(obj.getJSONObject("main").getDouble("temp_min")).append("\n");
                parameters.append("Presure is ").append(obj.getJSONObject("main").getDouble("pressure")).append("\n");
            }
            JOptionPane.showMessageDialog(null,  parameters.toString());
        });

        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));
        container.add(label);
        container.add(textField);
        container.add(jButton);

        frame.setVisible(true);
    }

}
