/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lendle.courses.network.clientserverbasics;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

/**
 *
 * @author lendle
 */
public class DictClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Socket socket = new Socket("dict.org", 2628);
        socket.setSoTimeout(15000);
        //hint: 從 socket 取得 OutputStream
        OutputStream out = socket.getOutputStream();
        ////////////////////////////////////////////
        Writer writer = new OutputStreamWriter(out, "UTF-8"); // number to byte
        //hint: 輸出 DEFINE wn gold\r\n
        writer.write("DEFINE wn gold\r\n"); // \r\n : Enter
        /////////////////////////////
        writer.flush();
        //hint: 從socket 取得 InputStream
        InputStream in = socket.getInputStream();
        
        ////////////////////////////////
        BufferedReader reader = new BufferedReader( // read by line
                new InputStreamReader(in, "UTF-8"));
        for (String line = reader.readLine(); !line.equals("."); line = reader.readLine()) {
            //hint: 將 line 變數輸出到終端機
            System.out.println(line);
            //////////////////////
        }
        writer.write("quit\r\n");
        writer.flush();
        socket.close();
    }

}
