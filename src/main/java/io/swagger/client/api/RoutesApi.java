package io.swagger.client.api;

import io.swagger.client.ApiClient;
import io.swagger.client.EncodingUtils;

import io.swagger.client.model.Fault;
import io.swagger.client.model.Route;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-10-17T09:13:08.236+02:00")
public interface RoutesApi extends ApiClient.Api {


  /**
   * Export Route GPX
   * Returns a GPX file of the route. Requires read_all scope for private routes.
    * @param id The identifier of the route. (required)
   */
  @RequestLine("GET /routes/{id}/export_gpx")
  @Headers({
    "Accept: application/json",
  })
  void getRouteAsGPX(@Param("id") Integer id);

  /**
   * Export Route TCX
   * Returns a TCX file of the route. Requires read_all scope for private routes.
    * @param id The identifier of the route. (required)
   */
  @RequestLine("GET /routes/{id}/export_tcx")
  @Headers({
    "Accept: application/json",
  })
  void getRouteAsTCX(@Param("id") Integer id);

  /**
   * Get Route
   * Returns a route using its identifier. Requires read_all scope for private routes.
    * @param id The identifier of the route. (required)
   * @return Route
   */
  @RequestLine("GET /routes/{id}")
  @Headers({
    "Accept: application/json",
  })
  Route getRouteById(@Param("id") Integer id);

  /**
   * List Athlete Routes
   * Returns a list of the routes created by the authenticated athlete using their athlete ID. Private routes are filtered out unless requested by a token with read_all scope.
    * @param id The identifier of the athlete. (required)
    * @param page Page number. (optional)
    * @param perPage Number of items per page. Defaults to 30. (optional, default to 30)
   * @return List&lt;Route&gt;
   */
  @RequestLine("GET /athletes/{id}/routes?page={page}&per_page={perPage}")
  @Headers({
    "Accept: application/json",
  })
  List<Route> getRoutesByAthleteId(@Param("id") Integer id, @Param("page") Integer page, @Param("perPage") Integer perPage);

  /**
   * List Athlete Routes
   * Returns a list of the routes created by the authenticated athlete using their athlete ID. Private routes are filtered out unless requested by a token with read_all scope.
   * Note, this is equivalent to the other <code>getRoutesByAthleteId</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetRoutesByAthleteIdQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param id The identifier of the athlete. (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>page - Page number. (optional)</li>
   *   <li>perPage - Number of items per page. Defaults to 30. (optional, default to 30)</li>
   *   </ul>
   * @return List&lt;Route&gt;
   */
  @RequestLine("GET /athletes/{id}/routes?page={page}&per_page={perPage}")
  @Headers({
  "Accept: application/json",
  })
  List<Route> getRoutesByAthleteId(@Param("id") Integer id, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getRoutesByAthleteId</code> method in a fluent style.
   */
  public static class GetRoutesByAthleteIdQueryParams extends HashMap<String, Object> {
    public GetRoutesByAthleteIdQueryParams page(final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public GetRoutesByAthleteIdQueryParams perPage(final Integer value) {
      put("per_page", EncodingUtils.encode(value));
      return this;
    }
  }
}
