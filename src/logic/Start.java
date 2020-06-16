package logic;

import interfazGrafica.Login;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;

public class Start {
    public static void main(String[] args) throws MalformedURLException{
        
        Login login = new Login();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        
        java.net.URL url = ClassLoader.getSystemResource("imagenes/icon.png");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.createImage(url);
        login.setIconImage(img);
  }
}
