package booking;

import io.restassured.response.Response;
import utils.RestUtils;

import java.util.Map;

public class BookingApi {

    public static Response createBooking(Map<String,Object>payLoad)
    {
        String url= (String) Base.dataFromJsonFile.get("endpoint");
        return RestUtils.performPost(url,payLoad,null);
    }

    public static Response createBooking(Object payLoad)
    {
        String url= (String) Base.dataFromJsonFile.get("endpoint");
        return RestUtils.performPost(url,payLoad,null);
    }


}
