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
    String[] patterns;
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
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void setPattern(String[] param)
    {
        if(param == null)
            patterns = null;
        else
        {
           patterns = new String[param.length];
           int counter = 0;
           for(String str : param)
           {
              patterns[counter++] = new String(str);
           }
        }
    }

    public String[] getPattern()
    {
        return patterns;
    }

    public boolean check(String str)
    {
       for(String pattern : patterns)
       {
          if(str.toLowerCase().contains(pattern.toLowerCase()))
          {
             return true;
          }
       }
       return false;
    }
}
