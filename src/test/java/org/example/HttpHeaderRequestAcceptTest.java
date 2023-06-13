package org.example;

import org.junit.Assert;
import org.junit.Test;

public class HttpHeaderRequestAcceptTest {

    @Test
    public void testConvertJsonToXml() {
        // Sample JSON response
        String jsonResponse = "{\"userId\": 1, \"id\": 1, \"title\": \"sunt aut facere\", \"body\": \"quia et suscipit\"}";

        // Expected XML response
        String expectedXmlResponse = "<LinkedHashMap>" + System.lineSeparator() +
                "  <userId>1</userId>" + System.lineSeparator() +
                "  <id>1</id>" + System.lineSeparator() +
                "  <title>sunt aut facere</title>" + System.lineSeparator() +
                "  <body>quia et suscipit</body>" + System.lineSeparator() +
                "</LinkedHashMap>" + System.lineSeparator();

        // Convert JSON to XML
        String xmlResponse = HttpHeaderRequestAccept.convertJsonToXml(jsonResponse);

        // Assert that the XML response matches the expected XML
        Assert.assertEquals(expectedXmlResponse, xmlResponse);
    }

    @Test
    public void testConvertJsonToYaml() {
        // Sample JSON response
        String jsonResponse = "{\"userId\": 1, \"id\": 1, \"title\": \"sunt aut facere\", \"body\": \"quia et suscipit\"}";

        // Expected YAML response
        String expectedYamlResponse = "---\n"+"userId: 1\n" +
                "id: 1\n" +
                "title: \"sunt aut facere\"\n" +
                "body: \"quia et suscipit\"\n";

        // Convert JSON to YAML
        String yamlResponse = HttpHeaderRequestAccept.convertJsonToYaml(jsonResponse);

        // Assert that the YAML response matches the expected YAML
        Assert.assertEquals(expectedYamlResponse, yamlResponse);
    }
}
