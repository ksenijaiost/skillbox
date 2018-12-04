import java.awt.*;
import java.awt.image.BufferedImage;

public class FirstDayTaskThree {
    public static void main(String[] args) throws AWTException {
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        System.out.println("Ширина экрана = "+ image.getWidth());
        System.out.println("Высота = " + image.getHeight());
    }
}
