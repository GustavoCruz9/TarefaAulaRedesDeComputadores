import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 12345); 

			BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
																							
			PrintWriter saida = new PrintWriter(socket.getOutputStream(), true); 
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			System.out.println("Digite uma mensagem para o servidor:");
			String messagem = input.readLine(); 
			saida.println(messagem); 

			String resposta = entrada.readLine();
			System.out.println("Resposta do servidor: " + resposta);

			socket.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
