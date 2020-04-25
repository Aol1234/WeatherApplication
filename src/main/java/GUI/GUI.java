package GUI;
import REST_API.*;
import com.google.gson.Gson;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;


public class GUI implements ActionListener {
    public JTextField tf;
    public String query;
    public JFrame f;
    public JButton b;

    public GUI() {
         this.f = new JFrame();//creating instance of JFrame

        this.tf = TextField();
        this.b = Button();//creating instance of JButton

        b.addActionListener(this);

        f.add(b);//adding button in JFrame
        f.add(tf);
        f.setSize(800,1000);//400 width and 500 height
        f.getContentPane().setBackground(Color.lightGray);
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    protected JButton Button() {
        JButton b = new JButton("click");//creating instance of JButton
        b.setAlignmentX(JButton.CENTER);
        b.setBounds(360,240, 80, 40);
        return b;
    }

    protected JTextField TextField() {
        JTextField textField = new JTextField("City Name....",20);
        textField.setAlignmentX(JTextField.CENTER);
        textField.setBounds(260,200, 300, 40);
        return  textField;
    }

    public static void main(String[] args) throws InterruptedException {
        GUI g = new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        REST_API r = new REST_API();
        this.query = r.QueryApi("Limerick");


        try {
            f.remove(b);
            f.remove(tf);

            Gson gson = new Gson();
            LinkedHashMap  <String, ArrayList<DayClass>> Days = new LinkedHashMap  <String, ArrayList<DayClass>>();
            OpenWeatherClass obj = gson.fromJson(this.query, OpenWeatherClass.class);
            for (OpenWeatherClass.Inner_K_V time:obj._list) {
                String day = time.getDay();

                Days.computeIfAbsent(day, k -> new ArrayList<>()).add(new DayClass(day, time.getDateTime(time.datetime), time.getTemp(), time.weather.get(0).getWeatherDesc()));

            }

            JPanel dayOne = new JPanel(); JPanel dayTwo = new JPanel();
            JPanel dayThree = new JPanel(); JPanel dayFour = new JPanel(); JPanel dayFive = new JPanel();
            JPanel daySix = new JPanel();

            int width = 156;
            int height = 500;


            f.getContentPane().setLayout(new BoxLayout(f.getContentPane(), BoxLayout.X_AXIS));
            dayOne.setPreferredSize(new Dimension(width, height));
            dayOne.setMaximumSize(new Dimension(width, height));

            f.getContentPane().setLayout(new BoxLayout(f.getContentPane(), BoxLayout.X_AXIS));
            dayTwo.setPreferredSize(new Dimension(width, height));
            dayTwo.setMaximumSize(new Dimension(width, height));

            f.getContentPane().setLayout(new BoxLayout(f.getContentPane(), BoxLayout.X_AXIS));
            dayThree.setPreferredSize(new Dimension(width, height));
            dayThree.setMaximumSize(new Dimension(width, height));

            f.getContentPane().setLayout(new BoxLayout(f.getContentPane(), BoxLayout.X_AXIS));
            dayFour.setPreferredSize(new Dimension(width, height));
            dayFour.setMaximumSize(new Dimension(width, height));

            f.getContentPane().setLayout(new BoxLayout(f.getContentPane(), BoxLayout.X_AXIS));
            dayFive.setPreferredSize(new Dimension(width, height));
            dayFive.setMaximumSize(new Dimension(width, height));

            f.getContentPane().setLayout(new BoxLayout(f.getContentPane(), BoxLayout.X_AXIS));
            daySix.setPreferredSize(new Dimension(width, height));
            daySix.setMaximumSize(new Dimension(width, height));



            JPanel[] col = {dayOne, dayTwo, dayThree, dayFour, dayFive, daySix};
            int i =0;

            for (Map.Entry<String, ArrayList<DayClass>> entry : Days.entrySet()) {
                String key = entry.getKey();
                ArrayList<DayClass> value = entry.getValue();

                col[i].setBorder(BorderFactory.createTitledBorder(key));
                col[i].add(new JLabel("<html><br></html>"));
                for (DayClass dayClass : value) {
                    col[i].add(new JLabel("Time: ", SwingConstants.LEFT));
                    col[i].add(new JLabel("<html><br></html>"));
                    col[i].add(new JLabel("<html><br></html>"));
                    col[i].add(new JLabel(dayClass.getDate(), SwingConstants.CENTER));
                    col[i].add(new JLabel("<html><br></html>"));
                    col[i].add(new JLabel("<html><br></html>"));
                    col[i].add(new JLabel("Weather: ", SwingConstants.LEFT));
                    col[i].add(new JLabel("<html><br></html>"));
                    col[i].add(new JLabel("<html><br></html>"));
                    col[i].add(new JLabel(dayClass.getDesc(), SwingConstants.CENTER));
                    col[i].add(new JLabel("<html><br></html>"));
                    col[i].add(new JLabel("<html><br></html>"));
                    col[i].add(new JLabel("Weather: " , SwingConstants.LEFT));
                    col[i].add(new JLabel("<html><br></html>"));
                    col[i].add(new JLabel("<html><br></html>"));
                    col[i].add(new JLabel(dayClass.getDesc(), SwingConstants.CENTER));
                    col[i].add(new JLabel("<html><br></html>"));
                    col[i].add(new JLabel("<html><br></html>"));
                }
                i++;
            }


            //this.f.getContentPane().add(info);
            this.f.getContentPane().add(dayOne);
            this.f.getContentPane().add(dayTwo);
            this.f.getContentPane().add(dayThree);
            this.f.getContentPane().add(dayFour);
            this.f.getContentPane().add(dayFive);

            f.revalidate();
            f.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
