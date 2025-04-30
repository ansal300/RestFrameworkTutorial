package booking;

import booking.pojo.BookingDates;
import booking.pojo.CreateBookingPojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import report.ExtentReportManager;
import utils.ExcelUtils;
import utils.JsonUtils;
import utils.RestUtils;

import java.io.IOException;
import java.util.*;

public class BookingTest {

    @Test(dataProvider ="getData" )
    public void createBooking(CreateBookingPojo createBookingPojo) throws IOException {
        ExtentReportManager.logInfo("Starting the test");
        //Map<String,Object> payLoad=Payloads.getCreateBookingPayloadAsMap("Jim","Brown",111);
        CreateBookingPojo payLoad = Payloads.createPayloadAsPojo(createBookingPojo.getFirstname()
        ,createBookingPojo.getLastname(),createBookingPojo.getTotalprice(),createBookingPojo.getBookingdates());
        Response response = BookingApi.createBooking(payLoad);
        Assert.assertEquals(response.statusCode(), 200);
        ExtentReportManager.logPass("Test is passed");

    }

    @DataProvider(name = "getData")
    public Iterator<CreateBookingPojo> getCreateBookingData() throws IOException {
        List<LinkedHashMap<String, String>> mapdata = ExcelUtils.readFromExcel("src/test/resources/TestData.xlsx");

        List<CreateBookingPojo> createBookingPojoList = new ArrayList<>();
        for (LinkedHashMap<String, String> data : mapdata) {
            BookingDates bookingDates=new BookingDates().toBuilder().build();
            CreateBookingPojo object = new CreateBookingPojo().toBuilder()
                    .firstname(data.get("FirstName"))
                    .lastname(data.get("LastName"))
                    .totalprice
                            (Integer.parseInt(data.get("TotalPrice"))).
                    bookingdates(bookingDates).
            build();
            createBookingPojoList.add(object);
        }

        return createBookingPojoList.iterator();
    }

    @Test
    public void test() throws IOException {
      List<LinkedHashMap<String,String>>data=  ExcelUtils.readDataFromExcel("src/test/resources/TestData.xlsx");
      System.out.println( "first name is " + data.get(0).get("FirstName"));
    }
}
