## LDAP_Server_Client

I wrote these 2 scripts a I was studying about LDAP Injection

1. install ldaptor library

```
pip3 install ldaptor
```

Run the LDAPserver.py

```
python3 LDAPserver.py 9090
```

![image](https://user-images.githubusercontent.com/33607657/139359127-07a079ad-fb76-466c-8340-07fc457dedf6.png)


#### Note that the LDAPInfo.java file connects to ldap://localhost:9090 by default
#### so you need to run the server on port 9090

Compile the LDAPInfo.java file
```
javac -d classes LDAPInfo.java
```

![image](https://user-images.githubusercontent.com/33607657/139358599-17d6690c-bcf4-4ca2-a9c2-6da5dd4ccd40.png)



To run the program
```
java -cp classes LDAPInfo bob
```

![image](https://user-images.githubusercontent.com/33607657/139358631-956d9df9-2e82-4e9c-9d46-16a2255e37fc.png)

## Happy Learning!
