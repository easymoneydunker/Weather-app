import javax.swing.*;
import java.awt.*;
public class Application extends JFrame {
    public Application(){
        JFrame frame = new JFrame();
        frame.setSize(300, 400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Enter city name: ", SwingConstants.CENTER);
        JTextField textField = new JTextField("", 5);
        JButton jButton = new JButton("Get weather");

        jButton.addActionListener(event -> {
            String city = textField.getText().trim();
            String output = GetURL.getURLContent("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid="+ Main.APIKEY +"&units=metric");
            if (!output.isEmpty()) {
                String result = JSONObjectWeatherInfo.getJSONObjectWeatherInfo(output);
                JOptionPane.showMessageDialog(null, result);
            }
        });

        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));
        container.add(label);
        container.add(textField);
        container.add(jButton);

        frame.setVisible(true);
    }

}
