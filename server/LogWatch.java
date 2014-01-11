import org.apache.commons.io.input.*; 
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class LogWatch extends TailerListenerAdapter
{
    private static File logFile;
    private static ArrayList<Listener> listenerList;
    public LogWatch()
    {
        listenerList = new ArrayList<Listener>();
        try
        {
            logFile = new File("nginx");
            Tailer tailer = Tailer.create(logFile,this);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addListener(SSLSocket sock)
    {
        listenerList.add(new Listener(sock));
        String str = null;
        try
        {
            BufferedReader out = new BufferedReader(
                    new FileReader(logFile));
            while((str = out.readLine()) != null)
            {
                listenerList.get(listenerList.size() - 1).write(str);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void handle(String message)
    {
        for(Listener k : listenerList)
        {
            k.write(message);
        }
    }
}
