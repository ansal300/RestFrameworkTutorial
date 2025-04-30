package booking;

import booking.pojo.BookingDates;
import booking.pojo.CreateBookingPojo;
import net.datafaker.Faker;

import java.util.LinkedHashMap;
import java.util.Map;

public class Payloads {

    public static String getCreateBookingPayloadAsString(String firstName,String lastName,int totalPrice)
    {
        String payLoad="{\n" +
                "    \"firstname\" : \""+firstName+"\",\n" +
                "    \"lastname\" : \""+lastName+"\",\n" +
                "    \"totalprice\" : "+totalPrice+",\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        return payLoad;
    }

    public static Map<String,Object>getCreateBookingPayloadAsMap(String firstName,String lastName,int totalPrice)
    {
        Map<String,Object> dates=new LinkedHashMap<>();
        dates.put("checkin","2018-01-01");
        dates.put("checkout","2019-01-01");

        Map<String,Object> data=new LinkedHashMap<>();
        data.put("firstname",firstName);
        data.put("lastname",lastName);
        data.put("totalprice",totalPrice);
        data.put("depositpaid",true);
        data.put("bookingdates",dates);
        data.put("additionalneeds","Breakfast");

        return data;
    }

    public static CreateBookingPojo createPayloadAsPojo(String firstName,String lastName)
    {
        BookingDates bookingDates=BookingDates.builder()
                .checkin("2018-01-01")
                .checkout("2019-01-01").build();
        CreateBookingPojo object= new CreateBookingPojo().toBuilder()
                .firstname(firstName)
                .lastname(lastName)
                .bookingdates(bookingDates)
                .build();


        return object;
    }

    public static CreateBookingPojo createPayloadAsPojo()
    {
        Faker faker=new Faker();
        BookingDates bookingDates=BookingDates.builder()
                .checkin("2018-01-01")
                .checkout("2019-01-01").build();
        CreateBookingPojo object= new CreateBookingPojo().toBuilder()
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName())
                .bookingdates(bookingDates)
                .build();


        return object;
    }

    public static CreateBookingPojo createPayloadAsPojo
            (String firstName,String lastName,int total,BookingDates bookingDates)
    {
        CreateBookingPojo object= new CreateBookingPojo().toBuilder()
                .firstname(firstName)
                .lastname(lastName)
                .totalprice(total)
                .bookingdates(bookingDates)
                .build();


        return object;
    }
}
