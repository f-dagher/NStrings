/*
 * Copyright (c) 1995, 2013, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * 
 * 
 * WEBSITE: https://docs.oracle.com/javase/tutorial/networking/sockets/examples/EchoClient.java
 * 
 * 
 */


import java.io.*;
import java.net.*;
import java.util.Scanner;


public class nStringsClient {
	static int N; //Keep track of n to know how many times to read back from the server to exit the client

	public static void main(String[] args)  {
		
		try 
		{	
			System.out.println("Client Side...");
			
			System.out.println("Enter the I.P Address you wish to connect to...");
			Scanner scanner = new Scanner(System.in);
			
			String hostName = scanner.nextLine();
			System.out.println("Enter the Port Number as specified by the Server");
			int portNumber = scanner.nextInt();
			int count = 0;
			
			//Connect to server
			Socket socket = new Socket(hostName, portNumber);
			
			//Setup streams in order to read and write to the server 
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	        
	        //Create new file
	        File file = new File("Received.out");
	        FileWriter fr = new FileWriter(file, false);
	        BufferedWriter fWrite = new BufferedWriter(fr);
 
	        System.out.println("Please enter an integer press enter and then enter a string...");
	     
	        //Send the user input to the server
	        String userInput;
            while (count != 2) {
          
            	
            	if (count == 0)
            	{
            		userInput = stdIn.readLine();
            		out.println(userInput);
            		N = Integer.parseInt(userInput);
            		count = 1;
            	}
            	else if (count == 1)
            	{
            		userInput = stdIn.readLine();
            		out.println(userInput);
            		count = 2;
            	}
            }
	        
	        //Receive N words from the server and write them to the file
	        for (int i = 0; i < N; i++)
	        {
	        	fWrite.write(in.readLine());
	        	fWrite.newLine();	        	
	        }
	        System.out.println("File 'Received.out' has been created");
	        
	        
	        //close all streams
	        scanner.close();
	        socket.close();
	        in.close();
	        out.close();
	        stdIn.close();
	        fWrite.close();
	        	

	        
		} catch (IOException ioe) {
			System.err.println("Error in I/O");
            System.err.println(ioe.getMessage());
            System.exit(-1);
		}
		
	
		

	}

}
