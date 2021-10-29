## LDAP_Server_Client

I wrote these 2 scripts a I was studying about LDAP Injection

Run the LDAPserver.py

```
python LDAPserver.py 9090
```

#### Note that the LDAPInfo.java file connects to ldap://localhost:9090 by default
#### so you need to run the server on port 9090

Compile the LDAPInfo.java file
```
javac -d classes LDAPInfo.java
```

To run the program
```
java -cp classes LDAPInfo bob
```

## Happy Learning!
