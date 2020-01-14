// 
// Decompiled by Procyon v0.5.36
// 

package com.codenvy.example.spring.initial;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

public class MyListener implements ServletContextListener
{
    public void contextInitialized(final ServletContextEvent event) {
        System.out.println("[bisterco] Initialising listener 2020.1...");
        //final FirebaseOptions options = new FirebaseOptions.Builder().setServiceAccount(this.getJsonKey()).setDatabaseUrl("https://dbengine.firebaseio.com/").build();
        //FirebaseApp.initializeApp(options);
        final FirebaseOptions options = new FirebaseOptions.Builder().setServiceAccount(this.getJsonKey()).setDatabaseUrl("https://dbengine-64154.firebaseio.com").build();
        FirebaseApp.initializeApp(options);
        
        /* - não consegui chegar no arquivo json ...
        try {
			FileInputStream serviceAccount =
					  new FileInputStream("/wsjs1/WebContent/WEB-INF/dbengine-firekey.json");

			FirebaseOptions options = new FirebaseOptions.Builder()
          		  //.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				  .setServiceAccount(serviceAccount)	
          		  .setDatabaseUrl("https://dbengine-64154.firebaseio.com")
          		  .build();

          		FirebaseApp.initializeApp(options);

        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
        		
    }
    
    public void contextDestroyed(final ServletContextEvent event) {
    }
    
    private InputStream getJsonKey() {
        String text = "";
        try {
            String line = "";
            final StringBuilder builder = new StringBuilder();
            //final URL url = new URL("http://www.mocky.io/v2/579d4dae1100009c07ac331c");
            final URL url = new URL("http://www.mocky.io/v2/5e1df38836000024c6c7450c");
            final BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            reader.close();
            text = builder.toString();
        }
        catch (MalformedURLException ex) {}
        catch (IOException ex2) {}
        return new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
    }
}
