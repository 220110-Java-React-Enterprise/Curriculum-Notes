import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        RestTemplate rest = new RestTemplate();
        String resourceUrl = "https://movie-database-imdb-alternative.p.rapidapi.com/?s=Avengers: Endgame&r=json&page=1";
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-host", "movie-database-imdb-alternative.p.rapidapi.com");
        headers.add("x-rapidapi-key", "d5c1cba0ccmshc857fda3a3f5cf0p1083ddjsn1ab79e547703");
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> restTemplateResponse = rest.exchange(resourceUrl, HttpMethod.GET, requestEntity, String.class);

        System.out.println(restTemplateResponse.getBody());


        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://movie-database-imdb-alternative.p.rapidapi.com/?s=Avengers%20Endgame&r=json&page=1")
                .get()
                .addHeader("x-rapidapi-host", "movie-database-imdb-alternative.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "d5c1cba0ccmshc857fda3a3f5cf0p1083ddjsn1ab79e547703")
                .build();

        Response okHttpResponse = client.newCall(request).execute();
        System.out.println(okHttpResponse.body().string());
    }
}
