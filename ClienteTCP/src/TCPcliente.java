import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPcliente {

	public static void main(String argv[]) throws Exception  {
		
		String sentence; 
		String modifiedSentence; 
		int PUERTO = 3248; 
		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		
		Socket clientSocket = new Socket("192.168.1.126",PUERTO);
		
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		
		
		
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		
		System.out.println("Please Input:");
		sentence = inFromUser.readLine(); 
		
		outToServer.writeBytes(sentence + "\n");
		
		modifiedSentence = inFromServer.readLine(); 
		
		System.out.println("FROM SERVER: " + modifiedSentence);
		
		
		
		clientSocket.close(); 
		
				
	}
	
}
