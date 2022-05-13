# NStrings
Send N Strings via Sockets with a server and client


The objective of this lab is to get familiar with TCP/IP.
For this assignment, you should write a client/server application that does the following.

The server program runs waiting for a connection from a client. It is not required to be concurrent.
The clients and the server should (in general) run on different machines.
The client sends two lines to the server. The first line consists of an integer n. The next line has a string. Both n and the string must be read from command line. The server responds by sending n lines to the client, each containing the string sent by the client. The client then writes each of those n lines to a file "received.out" and quits.


