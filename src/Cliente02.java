import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente02 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12349); 

            String imagePath = System.getProperty("user.home") + "/Desktop/modoserio.png";
            FileInputStream fileInputStream = new FileInputStream(imagePath);
            OutputStream outputStream = socket.getOutputStream(); 

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("Imagem enviada.");

            fileInputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
