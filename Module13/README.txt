1. In Tomcat's server.xml file, uncomment the AJP connector, as shown below.
<Connector port="8009" enableLookups="false" redirectPort="8443" protocol="AJP/1.3" />

2. In Tomcat's server.xml file, rewrite hosts. For example
<Context docBase="PATH_TO_PROJECT/Module11/module11-web/target/web" path="" reloadable="true"/> 

3. Install Apatch and downdload mod_jk-apache-2.2.4.so. Placed mod_jk-apache-2.2.4.so to your Apache2.2.4\modules\ directory. (Apache and Mod_jk you can find in module 13 folder)  

4. Creates worker.properties file in PATH_TO_APACHE\Apache2.2\conf\, as shown below:
 
worker.list=myworker
worker.myworker.type=ajp13
worker.myworker.host=localhost
worker.myworker.port=8009

5. Modified httpd.conf in Apache2.2\conf folder
Add:
LoadModule jk_module modules/mod_jk-apache-2.2.4.so

<IfModule jk_module>

    JkWorkersFile conf/worker.properties
    JkLogFile logs/mod_jk.log
    JkLogStampFormat "[%b %d %Y - %H:%M:%S] "
    JkRequestLogFormat "%w %V %T"
    JkLogLevel info

    JkOptions +ForwardKeySize +ForwardURICompat -ForwardDirectories
	
	DocumentRoot "PATH_TO_PROJECT/Module11/module11-web/"
	
	Alias /html "PATH_TO_PROJECT/Module11/module11-web/src/main/webapp/WEB-INF/jsp"
	
	<Directory PATH_TO_PROJECT/Module11/module11-web>
                Order deny,allow
		Allow from all
    	</Directory>
	
	JkMount /test/* myworker
	
</IfModule>

6. You can verify the syntax of these modifications via cmd:

PATH_TO_APACHE\Apache2.2\bin>httpd.exe -t
Syntax OK

PATH_TO_APACHE\Apache2.2\bin>

7. Start Apache via cmd:
PATH_TO_APACHE\Apache2.2\bin> httpd -k install
			      httpd -k start 

8. Strart Tomcat

9.Conclusion
Apatch work on 8080 port
Tomcat work on 8081 port

http://hostname:8080/html/dombo.html -- Access via Apache (All htmls in jsp folders from project publish to apache)
http://hostname:8080/test/1	     -- Try Tomcat's test via Apache (Apache redirect to Tomcat)
http://hostname:8081/ 		     -- Access from Tomcat directly
