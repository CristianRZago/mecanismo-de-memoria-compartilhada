import java.net.*;
import java.io.*;
public class DateServer
{ public static void main(String[] args) throws IOException {
  Socket client = null;
  ServerSocket sock = null;
  try { sock = new ServerSocket(6013); // escutando por conexoes
	   while (true){client = sock.accept();
			System.out.println("server = " + sock);
			System.out.println("client = " + client);
			PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
			// escreve a data no socket
			pout.println(new java.util.Date().toString());
			pout.close();
			client.close(); }	}
		catch (IOException ioe) { System.err.println(ioe); }
		finally {	if (sock != null)
			    sock.close();
			if (client != null)
			    client.close();	} } }
