import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        LocalDateTime now = LocalDateTime.now();

        Date dateNow = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        Date dateLtd = Date.from(now.plusHours(2).atZone(ZoneId.systemDefault()).toInstant());

        return airport.getTerminals().stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE))
                .filter(flight -> flight.getDate().after(dateNow))
                .filter(flight -> flight.getDate().before(dateLtd))
                .collect(Collectors.toList());
    }

}