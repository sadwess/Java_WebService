package Serveur;

import Service.BankService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.ws.Endpoint;

public class Serveur {
    public static void main(String[] args) 
    {
    
        Endpoint.publish("http://localhost:8090/",new BankService());
        try {
            
            String url = "http://api.exchangeratesapi.io/v1/latest?access_key=1e1850a24505297e472dfd4cf5359fd6";
            URL urlForGetRequest = new URL(url);
            String readLine = null;
            HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
            conection.setRequestMethod("GET");
            int responseCode = conection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
                StringBuffer response = new StringBuffer();
                while ((readLine = in.readLine()) != null) {
                    response.append(readLine);
                }
                in.close();
                System.out.println(response.toString());
            } else {
                throw new Exception("Error in API Call");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("working");
    }
}