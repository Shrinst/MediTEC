package package1;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by aguis on 7/5/2017.
 */

public class HttpManager {

    public static String getData(RequestPackage requestPackage) {

        BufferedReader reader = null;
        HttpURLConnection httpURLConnection = null;
        String uri = requestPackage.getUri();

        try {
            URL url = new URL(uri);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(requestPackage.getMethod());
            httpURLConnection.setRequestProperty("Accept", "application/json");

            StringBuilder stringBuilder = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }

            return stringBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    

    public static String postData(RequestPackage requestPackage) {

        BufferedReader reader = null;
        HttpURLConnection httpURLConnection = null;
        String uri = requestPackage.getUri();

        try {
            URL url = new URL(uri);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setRequestMethod(requestPackage.getMethod());
            httpURLConnection.setDoOutput(true);

            JSONObject jsonObject = new JSONObject();

            for (int i = 0; i < requestPackage.getMessageAttributes().size(); i++) {
                jsonObject.accumulate(requestPackage.getMessageAttributes().get(i), requestPackage.getMessageValues().get(i));
            }
            /*jsonObject.accumulate("author", "TOBE");
            jsonObject.accumulate("id", 1);
            jsonObject.accumulate("message", "Hello From Android");*/
            String data = jsonObject.toString();

            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            writer.write(data);
            writer.close();
            outputStream.close();

            StringBuilder stringBuilder = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }

            return stringBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String putData(RequestPackage requestPackage) {

        BufferedReader reader = null;
        HttpURLConnection httpURLConnection = null;
        String uri = requestPackage.getUri();

        try {
            URL url = new URL(uri);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setRequestMethod(requestPackage.getMethod());
            httpURLConnection.setDoOutput(true);

            JSONObject jsonObject = new JSONObject();

            for (int i = 0; i < requestPackage.getMessageAttributes().size(); i++) {
                jsonObject.accumulate(requestPackage.getMessageAttributes().get(i), requestPackage.getMessageValues().get(i));
            }


            String data = jsonObject.toString();

            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            writer.write(data);
            writer.close();
            outputStream.close();

            StringBuilder stringBuilder = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }

            return stringBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String deleteData(RequestPackage requestPackage) {

        BufferedReader reader = null;
        HttpURLConnection httpURLConnection = null;
        String uri = requestPackage.getUri();

        try {
            URL url = new URL(uri);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setRequestMethod(requestPackage.getMethod());


            StringBuilder stringBuilder = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }

            return stringBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}