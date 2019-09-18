# NStrings
Send N Strings via Sockets with a server and client


The objective of this lab is to get familiar with TCP/IP.
For this assignment, you should write a client/server application that does the following.

The server program runs waiting for a connection from a client. It is not required to be concurrent.
The clients and the server should (in general) run on different machines.
The client sends two lines to the server. The first line consists of an integer n. The next line has a string. Both n and the string must be read from command line. The server responds by sending n lines to the client, each containing the string sent by the client. The client then writes each of those n lines to a file "received.out" and quits.
I prefer the programs be written in Java. If you are using python or C/C++, you will lose points if your program does not close the sockets when the program quits.
In order to prevent two students from using the same socket number on the same machine, you should use the socket number that is 20000 + x, where x is the last 4 digits of your student number.
Check the class page for clarifications etc.
You can download the basic client server code in the language of your choice from any site, including the page linked from the class webpage, but please cite that source in your report and code. Not doing so is a breach of academic honesty. 
Some host names in one of the undergrad labs (LAS 1004) are ptl10,....,ptl23.
