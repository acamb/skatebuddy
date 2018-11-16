package io.swagger.client.api;

import io.swagger.client.ApiClient;
import io.swagger.client.EncodingUtils;

import io.swagger.client.model.ActivityStats;
import io.swagger.client.model.DetailedAthlete;
import io.swagger.client.model.Fault;
import io.swagger.client.model.Zones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-10-17T09:13:08.236+02:00")
public interface AthletesApi extends ApiClient.Api {


  /**
   * Get Authenticated Athlete
   * Returns the currently authenticated athlete. Tokens with profile:read_all scope will receive a detailed athlete representation; all others will receive a summary representation.
   * @return DetailedAthlete
   */
  @RequestLine("GET /athlete")
  @Headers({
    "Accept: application/json",
  })
  DetailedAthlete getLoggedInAthlete();

  /**
   * Get Zones
   * Returns the the authenticated athlete&#39;s heart rate and power zones. Requires profile:read_all.
   * @return Zones
   */
  @RequestLine("GET /athlete/zones")
  @Headers({
    "Accept: application/json",
  })
  Zones getLoggedInAthleteZones();

  /**
   * Get Athlete Stats
   * Returns the activity stats of an athlete.
    * @param id The identifier of the athlete. Must match the authenticated athlete. (required)
    * @param page Page number. (optional)
    * @param perPage Number of items per page. Defaults to 30. (optional, default to 30)
   * @return ActivityStats
   */
  @RequestLine("GET /athletes/{id}/stats?page={page}&per_page={perPage}")
  @Headers({
    "Accept: application/json",
  })
  ActivityStats getStats(@Param("id") Integer id, @Param("page") Integer page, @Param("perPage") Integer perPage);

  /**
   * Get Athlete Stats
   * Returns the activity stats of an athlete.
   * Note, this is equivalent to the other <code>getStats</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetStatsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param id The identifier of the athlete. Must match the authenticated athlete. (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>page - Page number. (optional)</li>
   *   <li>perPage - Number of items per page. Defaults to 30. (optional, default to 30)</li>
   *   </ul>
   * @return ActivityStats
   */
  @RequestLine("GET /athletes/{id}/stats?page={page}&per_page={perPage}")
  @Headers({
  "Accept: application/json",
  })
  ActivityStats getStats(@Param("id") Integer id, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getStats</code> method in a fluent style.
   */
  public static class GetStatsQueryParams extends HashMap<String, Object> {
    public GetStatsQueryParams page(final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public GetStatsQueryParams perPage(final Integer value) {
      put("per_page", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Update Athlete
   * Update the currently authenticated athlete. Requires profile:write scope.
    * @param weight The weight of the athlete in kilograms. (required)
   * @return DetailedAthlete
   */
  @RequestLine("PUT /athlete")
  @Headers({
    "Accept: application/json",
  })
  DetailedAthlete updateLoggedInAthlete(@Param("weight") Float weight);
}
