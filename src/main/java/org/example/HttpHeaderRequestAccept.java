package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHeaderRequestAccept {



    //this will change the into Json input header acceptance
    public static String inputHeaderRequestAccept(String urlInfo, String acceptanceType) {
        StringBuilder response = new StringBuilder();
        HttpURLConnection connection = null;

        try {
            // Create a URL object with the endpoint you want to make a request to
            URL url = new URL(urlInfo);

            // Open a connection to the URL
            connection = (HttpURLConnection) url.openConnection();

            // Set the request method to GET
            connection.setRequestMethod("GET");

            // Set the "Accept" header
            connection.setRequestProperty("Accept", acceptanceType);

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
                System.out.println();
            }
            reader.close();

            // Print the response
            String jsonResponse = response.toString();
            System.out.println("Response: " + jsonResponse);
            return jsonResponse;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return null;
    }


    public static String convertJsonToXml(String jsonResponse) {
        try {
            ObjectMapper jsonMapper = new ObjectMapper();
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

            // Read JSON and convert to XML
            Object json = jsonMapper.readValue(jsonResponse, Object.class);
            String xml = xmlMapper.writeValueAsString(json);

            return xml;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String convertJsonToYaml(String jsonResponse) {
        try {
            ObjectMapper jsonMapper = new ObjectMapper();
            ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
            yamlMapper.enable(SerializationFeature.INDENT_OUTPUT);

            // Read JSON and convert to YAML
            Object json = jsonMapper.readValue(jsonResponse, Object.class);
            String yaml = yamlMapper.writeValueAsString(json);

            return yaml;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }



}
