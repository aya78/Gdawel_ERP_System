package Tests;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
public class SlackNotificationListener extends TestListenerAdapter{
        private final String webhookUrl = "https://app.slack.com/client/T051DKLR22F/D051SCDKJJV";

        @Override
        public void onTestFailure(ITestResult tr) {
            super.onTestFailure(tr);

            String testName = tr.getName();
            String testClass = tr.getTestClass().getName();
            String errorMessage = tr.getThrowable().getMessage();

            JsonObject messageJson = new JsonObject();
            messageJson.addProperty("text", "Test failed: " + testName + " in " + testClass + ". Error: " + errorMessage);

            try {
                URL url = new URL(webhookUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setDoOutput(true);

                OutputStream os = connection.getOutputStream();
                os.write(new Gson().toJson(messageJson).getBytes());
                os.flush();
                os.close();

                if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
                }

                connection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

}
