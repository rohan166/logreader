An ssl encrypted server and client written in Java to let users read logs from a
server without logging in.
Written during the 2014 Intuit DevOps Hackathon.

## Instructions

1. git clone the repository
2. place the server on the production server, and compile it
3. place the client on the local machine, and compile it
4. use the keytool command to create a mutual authentication keystore and place this keystore in both the server and the client folders. Use the password 123456. (If you decide to use some other password, accordingly edit runserver in /server and readlogs in /client)
5. run ./runserver and pass the log to be read as an argument. Now the log daemon will start.
6. run ./readlogs on the client machine and pass the keywords to be filtered as arguments. (any number of keywords)
7. after you terminate the client program, a copy of the logs will be saved in /client/logs.
