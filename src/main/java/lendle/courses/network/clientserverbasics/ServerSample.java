/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lendle.courses.network.clientserverbasics;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author user
 */
public class ServerSample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try(ServerSocket server = new ServerSocket(10000)){
            while(true){
                Socket socket = server.accept();// 等待別人連線
                OutputStream output = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(output,"utf-8"); //utf-8 萬國編碼
                osw.write("123");
                osw.flush();
            }
        }
    }
    
}
