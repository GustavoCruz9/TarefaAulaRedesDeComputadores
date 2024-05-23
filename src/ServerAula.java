import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerAula {

	public static void main(String[] args) {
		try {
			 ServerSocket serverSocket = new ServerSocket(12345);
	         System.out.println("Servidor aguardando conexão...");
	
	         while (true) {
	             Socket clientSocket = serverSocket.accept(); 
	             System.out.println("Cliente conectado: " + clientSocket);
	
	             BufferedReader entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	             PrintWriter saida = new PrintWriter(clientSocket.getOutputStream(), true);
	
	             String message = entrada.readLine();
	             System.out.println("Mensagem recebida do cliente: " + message);
	
	             String upperCaseMessage = message.toUpperCase();
	             saida.println(upperCaseMessage); 
	
	             clientSocket.close(); 
	         }
		} catch (IOException e) {
            e.printStackTrace();
        }
	}

}
