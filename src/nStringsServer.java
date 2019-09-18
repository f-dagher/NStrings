/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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
 * https://docs.oracle.com/javase/tutorial/networking/sockets/examples/EchoServer.java
 * 
 * 
 */ 

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class nStringsServer {
	static String WORD;
	static int N;

	public static void main(String[] args) {
		
		try 
		{
			System.out.println("Welcome to the Server");
			
			//Enter the port number
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the Port Number you wish to use...");
			int portNumber = scanner.nextInt();
			int count = 0;
			int flag = 0;
					
			
			//Setup a connection
			ServerSocket serverSocket = new ServerSocket(portNumber);
			
			while(flag == 0)
			{
				
				Socket clientSocket = serverSocket.accept();
				
				System.out.println("Connection Established...");
	
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	
				//Read the inputs from client first int then string
				String inputLine;
				while ((inputLine = in.readLine()) != null)
				{
					if (count == 0) 
					{
						N = Integer.parseInt(inputLine);
						count = 1;
					} 
					else if (count == 1) 
					{
						WORD = inputLine;
						
						//Send to the client the string, N times
						for (int i = 0; i < N; i++) 
						{
							out.println(WORD);
						}
					}
	
				}
				
				//close all streams and set flag to 1 to end the program
				scanner.close();
				in.close();
				out.close();
				clientSocket.close();
				serverSocket.close();
				flag = 1;
				System.out.println("Connection closed");
			}
			
		

			
		} catch (IOException ioe) {
			System.err.println("Error in I/O");
            System.err.println(ioe.getMessage());
            System.exit(-1);
		}
	}


}
