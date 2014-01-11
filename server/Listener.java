import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.*;

public class Listener
{
    SSLSocket socket;
    PrintWriter out;
    OutputStreamWriter outWriter;
    public Listener(SSLSocket sock)
    {
        socket = sock;
        try
        {
            OutputStream outStream = socket.getOutputStream();
            out = new PrintWriter(outStream, true);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void write(String message)
    {
        try
        {
            out.print(message);
            out.println();
            out.flush();
            System.err.println("Written to a socket");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
