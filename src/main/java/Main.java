import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Main {
    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        String url = "https://api.nasa.gov/planetary/apod?api_key=SHaWEyCdF8pFIR7LiHkqO5zWMddtZMWkLLq6ZDYk";
        saveImageFromNasaApi(url);

    }

    private static void saveImageFromNasaApi(String urlNASA) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build();

        HttpGet request = new HttpGet(urlNASA);

        CloseableHttpResponse response = httpClient.execute(request);

        //json в java-объект
        InfoJson infoJson = objectMapper.readValue(response.getEntity().getContent(), InfoJson.class);
        String url = infoJson.getUrl();

        //новый http-запрос
        HttpGet requestNew = new HttpGet(url);
        CloseableHttpResponse responseNew = httpClient.execute(requestNew);
        String[] arrayUrlImage = url.split("/");

        //сохраняем ответ в файл с именем, извлеченным из url
        File file = new File(arrayUrlImage[arrayUrlImage.length - 1]);
        ImageIO.write(ImageIO.read(responseNew.getEntity().getContent()), "jpg", file);

    }

}
