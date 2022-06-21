package Essential.task3.services;

import Essential.task3.models.Route;
import Essential.task3.repositories.RouteRepoImpl;
import Essential.task3.repositories.TransportRepoImpl;

import java.util.ArrayList;
import java.util.List;

public interface RouteService {

    public void addRoute(RouteRepoImpl rtm, Route route);

    public void removeRoute(RouteRepoImpl rtm, Route route);

    public Route getRouteById(RouteRepoImpl rtm, int id);

    public ArrayList<Route> getAllRoutes(RouteRepoImpl rtm);

    public ArrayList<Route> getRoutesNoTransport(RouteRepoImpl rtm, TransportRepoImpl tr);

}