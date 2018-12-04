import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;

import java.io.FileInputStream;
import java.io.InputStream;

public class MyThreat extends Thread {

    String ACCESS_TOKEN = "xwTX64uaERgAAAAAAAABHv0K-Rwl5QFjZfPC-yNkiky4KUXr1eRhHFtiAe_Kz1bu";
    DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
    DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

    public MyThreat(){

    }

    public void run(){
        while (true) {
            System.out.println("");
            try {
                sleep(5000);
                InputStream in = new FileInputStream("");
                FileMetadata metadata = client
                        .files()
                        .uploadBuilder("")
                        .uploadAndFinish(in);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
