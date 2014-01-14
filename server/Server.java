import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Server
{
    private static LogWatch log;
    public static String logName;
    public static void main(String[] args)
    {
       /*
        * store the apth to the log file
        */
       if(args.length > 0)
       {
          logName = new String(args[0]);
       }
        try
        {
            /* create an ssl server socket */
            SSLServerSocketFactory servFactory = 
                (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket servSocket = 
                (SSLServerSocket) servFactory.createServerSocket(8888);
            SSLSocket socket;
            /* 
             * create a logging daemon that will keep reading
             * changes in the specified logfile 
             */
            log = new LogWatch(logName);
            System.err.println("The log daemon is now running");
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
