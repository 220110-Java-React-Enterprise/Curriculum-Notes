import com.fasterxml.jackson.databind.ObjectMapper;
import dtos.ApiResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        //Classloading resources
        Properties props = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream input = loader.getResourceAsStream("api-key.properties");
        props.load(input);


        //Building the URL string
        StringBuilder sb = new StringBuilder("https://api.rawg.io/api/games");
        sb.append("?key=").append(props.getProperty("api-key"))
                .append("&page=1")
                .append("&page_size=1");


        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                    .url(sb.toString())
                    .build();

        try(Response response = client.newCall(request).execute()) {
            ObjectMapper mapper = new ObjectMapper();
            ApiResponse apiResponse = mapper.readValue(response.body().string(), ApiResponse.class);
            System.out.println(apiResponse);

        } catch(NullPointerException e) {
                e.printStackTrace();
        }
    }
}
