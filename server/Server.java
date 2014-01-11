import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Server
{
    private static LogWatch log;
    public static void main(String[] args)
    {
        try
        {
            SSLServerSocketFactory servFactory = 
                (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket servSocket = 
                (SSLServerSocket) servFactory.createServerSocket(8888);
            SSLSocket socket;
            log = new LogWatch();
            System.err.println("Now entering the accept() loop");
            while(true)
            {
                socket = (SSLSocket) servSocket.accept();
                log.addListener(socket);
                System.err.println("Added a listener at socket: " + socket.toString());
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
