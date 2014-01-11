import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;

public class Client
{
    public static void main(String[] args)
    {
        try
        {
            SSLSocketFactory sslFactory = 
                (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket socket = 
                (SSLSocket) sslFactory.createSocket("localhost",8888);
            
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputReader = 
                new InputStreamReader(inputStream);
            BufferedReader input = new BufferedReader(inputReader);

            FileWriter fstream = new FileWriter("log",true);
            PrintWriter out = new PrintWriter(fstream);
            String str = null;
            while((str = input.readLine()) != null)
            {
                out.print(str);
                out.println();
                out.flush();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
