 curl -i -X POST -d username=vaibhav -d password=vaibhav -c /home/rohini/Desktop/vaibhav.txt  http://localhost:8080\/login

 
 
 1xf63f5j7ku7vscqxmb90bt1n
 This creates a new cookie file at the path passed in the argument. This cookie contains the JSessionId. This JSessionId gets invalidated after 15 minutes of inactivity as mentioned in the session-timeout tag of the web.xml

Accessing a resource after successful authentication :

 
 
 curl -i -X POST -b /home/rohini/Desktop/vaibhav.txt http://localhost:8080\/welcome/vaibhav
 