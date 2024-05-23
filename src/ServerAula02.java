import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerAula02 {
	public static void main(String[] args) {
		try {
            ServerSocket socket = new ServerSocket(12349);
            System.out.println("Servidor aguardando conexão...");

            while (true) {
                Socket cliente = socket.accept();
                System.out.println("Cliente conectado: " + cliente);

                InputStream inputStream = cliente.getInputStream(); 
                FileOutputStream fileOutputStream = new FileOutputStream("imagemRecebida.jpg"); 

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }

                fileOutputStream.close();
                System.out.println("Imagem recebida e salva.");

                cliente.close(); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
