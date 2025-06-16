import com.google.gson.Gson;

public class UtilJson {
    public static ExchangeRatesResponse parsear(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, ExchangeRatesResponse.class);
    }
}
