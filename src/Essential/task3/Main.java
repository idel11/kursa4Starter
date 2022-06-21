package Essential.task3;

import Essential.task3.models.*;
import Essential.task3.repositories.DriverRepoImpl;
import Essential.task3.repositories.RouteRepoImpl;
import Essential.task3.repositories.TransportRepoImpl;
import Essential.task3.services.DriverServiceImpl;
import Essential.task3.services.RouteServiceImpl;
import Essential.task3.services.TransportServiceImpl;

import java.util.ArrayList;

import static Essential.task3.models.DriverQualification.*;

public class Main {
    public static void main(String[] args) {

        Driver driver1 = new Driver(1, "Kolya", "Ly", "777 77 77", BUS_DRIVER);
        Driver driver2 = new Driver(2, "Tolya", "My", "555 55 55", TRAM_DRIVER);
        ArrayList<Driver> driversArray = new ArrayList<>();
        driversArray.add(driver1);
        driversArray.add(driver2);

        Route firstRoute = new Route(1, "Kyiv", "Poltava");
        Route secondRoute = new Route(2, "Odesa", "Lviv");
        Route thirdRoute = new Route(3, "Lviv", "Kyiv");
        ArrayList<Route> routesArray = new ArrayList<>();
        routesArray.add(firstRoute);
        routesArray.add(secondRoute);
        routesArray.add(thirdRoute);

        Transport bus1 = new Bus(1, "ikarus", 40, driver1,
                firstRoute, BUS_DRIVER, "pass", 2);
        Transport bus2 = new Bus(2, "mers", 40, null,
                firstRoute, BUS_DRIVER, "pass", 2);
        Transport tram1 = new Tram(3, "euro", 60, driver2,
                secondRoute, TRAM_DRIVER, 4);

        ArrayList<Transport> transArray = new ArrayList<>();
        transArray.add(bus1);
        transArray.add(bus2);
        transArray.add(tram1);

        TransportRepoImpl ttrr = new TransportRepoImpl(transArray);
        DriverRepoImpl ddrr = new DriverRepoImpl(driversArray);
        RouteRepoImpl rroo = new RouteRepoImpl(routesArray);

        DriverServiceImpl drsrv = new DriverServiceImpl();
        RouteServiceImpl rsv = new RouteServiceImpl();
        TransportServiceImpl trsrv = new TransportServiceImpl();

        System.out.println("===================== test driver service ====================");
        System.out.println(drsrv.getTransportNoDriver(ttrr));
        drsrv.assignDriverToTransport(bus2, driver1);
        System.out.println(drsrv.getTransportNoDriver(ttrr));
        System.out.println(drsrv.getAllByRoute(secondRoute, ttrr));
        System.out.println(drsrv.getBySurname("My", ddrr));
        System.out.println(drsrv.getById(1, ddrr));
        System.out.println();


        System.out.println("==================== test route service =====================");
        System.out.println(rsv.getRouteById(rroo, 2));
        System.out.println(rsv.getAllRoutes(rroo));
        rsv.removeRoute(rroo, secondRoute);
        System.out.println(rsv.getAllRoutes(rroo));
        rsv.addRoute(rroo, secondRoute);
        System.out.println(rsv.getAllRoutes(rroo));
        System.out.println(rsv.getRoutesNoTransport(rroo, ttrr));
        System.out.println();


        System.out.println("==================== test transport service =====================");

        routesArray.add(firstRoute);
        routesArray.add(secondRoute);
        transArray.add(tram1);
        System.out.println(rsv.getAllRoutes(rroo));
        System.out.println(trsrv.getAllTrans(ttrr));
        System.out.println(drsrv.getAll(ddrr));

        System.out.println(trsrv.getAllTransByModel(ttrr,"ikarus"));
        System.out.println(trsrv.getTransById(ttrr,2));

        Transport tram4 = new Tram(4, "ukr", 50, null,
                null, TRAM_DRIVER, 6);

        trsrv.addTrans(ttrr,tram4);
        System.out.println(trsrv.getTransById(ttrr,4));

        trsrv.assignTransOnRoute(ttrr, firstRoute);
        System.out.println(trsrv.getAllTransByModel(ttrr,"ukr"));

        drsrv.assignDriverToTransport(tram4, driver2);
        trsrv.assignTransOnRoute(ttrr, firstRoute);
        System.out.println(trsrv.getAllTransByModel(ttrr,"ukr"));

        trsrv.removeTransFromRoute(tram4,firstRoute);
        System.out.println(trsrv.getTransById(ttrr,4));

        trsrv.removeTransFromRoute(bus2,firstRoute);
        System.out.println(trsrv.getTransById(ttrr,2));


    }
}
