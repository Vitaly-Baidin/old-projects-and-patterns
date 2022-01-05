import core.Line;
import core.Station;
import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase
{
    StationIndex stationIndex;
    RouteCalculator routeCalculator;

    Line line1 = new Line(1,"first");
    Line line2 = new Line(2,"second");
    Line line3 = new Line(3,"third");

    Station station11 = new Station("11", line1);
    Station station12 = new Station("12", line1);
    Station station13 = new Station("13", line1);
    Station station14 = new Station("14", line1);
    Station station15 = new Station("15", line1);
    Station station16 = new Station("16", line1);

    Station station21 = new Station("21", line2);
    Station station22 = new Station("22", line2);
    Station station23 = new Station("23", line2);
    Station station24 = new Station("24", line2);

    Station station31 = new Station("31", line3);
    Station station32 = new Station("32", line3);
    Station station33 = new Station("33", line3);

    List<Station> connect1 = new ArrayList<>();
    List<Station> connect2 = new ArrayList<>();

    protected void setUp() throws Exception
    {
        stationIndex = new StationIndex();

        connect1.add(station13);
        connect1.add(station23);
        connect2.add(station15);
        connect2.add(station32);

        line1.addStation(station11);
        line1.addStation(station12);
        line1.addStation(station13);
        line1.addStation(station14);
        line1.addStation(station15);
        line1.addStation(station16);
        line2.addStation(station21);
        line2.addStation(station22);
        line2.addStation(station23);
        line2.addStation(station24);
        line3.addStation(station31);
        line3.addStation(station32);
        line3.addStation(station33);

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        stationIndex.addStation(station11);
        stationIndex.addStation(station12);
        stationIndex.addStation(station13);
        stationIndex.addStation(station14);
        stationIndex.addStation(station15);
        stationIndex.addStation(station16);
        stationIndex.addStation(station21);
        stationIndex.addStation(station22);
        stationIndex.addStation(station23);
        stationIndex.addStation(station24);
        stationIndex.addStation(station31);
        stationIndex.addStation(station32);
        stationIndex.addStation(station33);

        stationIndex.addConnection(connect1);
        stationIndex.addConnection(connect2);

        routeCalculator = new RouteCalculator(stationIndex);
    }

    public void testGetRouteOnTheLine()
    {
        List<Station> actual = routeCalculator.getShortestRoute(station11, station14);
        List<Station> expected = new ArrayList<>();
        expected.add(station11);
        expected.add(station12);
        expected.add(station13);
        expected.add(station14);
        assertEquals(actual, expected);
    }

    public void testGetRouteWithOneConnection()
    {
        List<Station> actual = routeCalculator.getShortestRoute(station11, station24);
        List<Station> expected = new ArrayList<>();
        expected.add(station11);
        expected.add(station12);
        expected.add(station13);
        expected.add(station23);
        expected.add(station24);
        assertEquals(actual, expected);
    }

    public void testGetRouteWithTwoConnection()
    {
        List<Station> actual = routeCalculator.getShortestRoute(station22, station33);
        List<Station> expected = new ArrayList<>();
        expected.add(station22);
        expected.add(station23);
        expected.add(station13);
        expected.add(station14);
        expected.add(station15);
        expected.add(station32);
        expected.add(station33);
        assertEquals(actual, expected);
    }

    public void testCalculateDuration()
    {
        double actual = RouteCalculator.calculateDuration(routeCalculator.getShortestRoute(station11, station14));
        double expected = 7.5;
        assertEquals(actual, expected);
    }
}























