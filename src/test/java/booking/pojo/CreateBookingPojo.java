package booking.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CreateBookingPojo {

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid=true;
    private BookingDates bookingdates;
    private String additionalneeds="Breakfast";

}
