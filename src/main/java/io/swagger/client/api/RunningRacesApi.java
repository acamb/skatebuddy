package io.swagger.client.api;

import io.swagger.client.ApiClient;
import io.swagger.client.EncodingUtils;

import io.swagger.client.model.Fault;
import io.swagger.client.model.RunningRace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-10-17T09:13:08.236+02:00")
public interface RunningRacesApi extends ApiClient.Api {


  /**
   * Get Running Race
   * Returns a running race for a given identifier.
    * @param id The identifier of the running race. (required)
   * @return RunningRace
   */
  @RequestLine("GET /running_races/{id}")
  @Headers({
    "Accept: application/json",
  })
  RunningRace getRunningRaceById(@Param("id") Integer id);

  /**
   * List Running Races
   * Returns a list running races based on a set of search criteria.
    * @param year Filters the list by a given year. (optional)
   * @return List&lt;RunningRace&gt;
   */
  @RequestLine("GET /running_races?year={year}")
  @Headers({
    "Accept: application/json",
  })
  List<RunningRace> getRunningRaces(@Param("year") Integer year);

  /**
   * List Running Races
   * Returns a list running races based on a set of search criteria.
   * Note, this is equivalent to the other <code>getRunningRaces</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetRunningRacesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>year - Filters the list by a given year. (optional)</li>
   *   </ul>
   * @return List&lt;RunningRace&gt;
   */
  @RequestLine("GET /running_races?year={year}")
  @Headers({
  "Accept: application/json",
  })
  List<RunningRace> getRunningRaces(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getRunningRaces</code> method in a fluent style.
   */
  public static class GetRunningRacesQueryParams extends HashMap<String, Object> {
    public GetRunningRacesQueryParams year(final Integer value) {
      put("year", EncodingUtils.encode(value));
      return this;
    }
  }
}
