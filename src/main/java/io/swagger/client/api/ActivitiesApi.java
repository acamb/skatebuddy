package io.swagger.client.api;

import io.swagger.client.ApiClient;
import io.swagger.client.EncodingUtils;

import io.swagger.client.model.ActivityZone;
import io.swagger.client.model.Comment;
import io.swagger.client.model.DetailedActivity;
import io.swagger.client.model.Fault;
import io.swagger.client.model.Lap;
import io.swagger.client.model.SummaryActivity;
import io.swagger.client.model.SummaryAthlete;
import io.swagger.client.model.UpdatableActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-10-17T09:13:08.236+02:00")
public interface ActivitiesApi extends ApiClient.Api {


  /**
   * Create an Activity
   * Creates a manual activity for an athlete, requires activity:write scope.
    * @param name The name of the activity. (required)
    * @param type Type of activity. For example - Run, Ride etc. (required)
    * @param startDateLocal ISO 8601 formatted date time. (required)
    * @param elapsedTime In seconds. (required)
    * @param description Description of the activity. (optional)
    * @param distance In meters. (optional)
    * @param trainer Set to 1 to mark as a trainer activity. (optional)
    * @param photoIds List of native photo ids to attach to the activity. (optional)
    * @param commute Set to 1 to mark as commute. (optional)
   * @return DetailedActivity
   */
  @RequestLine("POST /activities")
  @Headers({
    "Content-Type: application/x-www-form-urlencoded",
    "Accept: application/json",
  })
  DetailedActivity createActivity(@Param("name") String name, @Param("type") String type, @Param("startDateLocal") String startDateLocal, @Param("elapsedTime") Integer elapsedTime, @Param("description") String description, @Param("distance") Float distance, @Param("trainer") Integer trainer, @Param("photoIds") String photoIds, @Param("commute") Integer commute);

  /**
   * Get Activity
   * Returns the given activity that is owned by the authenticated athlete. Requires activity:read for Everyone and Followers activities. Requires activity:read_all for Only Me activities.
    * @param id The identifier of the activity. (required)
    * @param includeAllEfforts To include all segments efforts. (optional)
   * @return DetailedActivity
   */
  @RequestLine("GET /activities/{id}?include_all_efforts={includeAllEfforts}")
  @Headers({
    "Accept: application/json",
  })
  DetailedActivity getActivityById(@Param("id") Long id, @Param("includeAllEfforts") Boolean includeAllEfforts);

  /**
   * Get Activity
   * Returns the given activity that is owned by the authenticated athlete. Requires activity:read for Everyone and Followers activities. Requires activity:read_all for Only Me activities.
   * Note, this is equivalent to the other <code>getActivityById</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetActivityByIdQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param id The identifier of the activity. (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>includeAllEfforts - To include all segments efforts. (optional)</li>
   *   </ul>
   * @return DetailedActivity
   */
  @RequestLine("GET /activities/{id}?include_all_efforts={includeAllEfforts}")
  @Headers({
  "Accept: application/json",
  })
  DetailedActivity getActivityById(@Param("id") Long id, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getActivityById</code> method in a fluent style.
   */
  public static class GetActivityByIdQueryParams extends HashMap<String, Object> {
    public GetActivityByIdQueryParams includeAllEfforts(final Boolean value) {
      put("include_all_efforts", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * List Activity Comments
   * Returns the comments on the given activity. Requires activity:read for Everyone and Followers activities. Requires activity:read_all for Only Me activities.
    * @param id The identifier of the activity. (required)
    * @param page Page number. (optional)
    * @param perPage Number of items per page. Defaults to 30. (optional, default to 30)
   * @return List&lt;Comment&gt;
   */
  @RequestLine("GET /activities/{id}/comments?page={page}&per_page={perPage}")
  @Headers({
    "Accept: application/json",
  })
  List<Comment> getCommentsByActivityId(@Param("id") Long id, @Param("page") Integer page, @Param("perPage") Integer perPage);

  /**
   * List Activity Comments
   * Returns the comments on the given activity. Requires activity:read for Everyone and Followers activities. Requires activity:read_all for Only Me activities.
   * Note, this is equivalent to the other <code>getCommentsByActivityId</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetCommentsByActivityIdQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param id The identifier of the activity. (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>page - Page number. (optional)</li>
   *   <li>perPage - Number of items per page. Defaults to 30. (optional, default to 30)</li>
   *   </ul>
   * @return List&lt;Comment&gt;
   */
  @RequestLine("GET /activities/{id}/comments?page={page}&per_page={perPage}")
  @Headers({
  "Accept: application/json",
  })
  List<Comment> getCommentsByActivityId(@Param("id") Long id, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getCommentsByActivityId</code> method in a fluent style.
   */
  public static class GetCommentsByActivityIdQueryParams extends HashMap<String, Object> {
    public GetCommentsByActivityIdQueryParams page(final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public GetCommentsByActivityIdQueryParams perPage(final Integer value) {
      put("per_page", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * List Activity Kudoers
   * Returns the athletes who kudoed an activity identified by an identifier. Requires activity:read for Everyone and Followers activities. Requires activity:read_all for Only Me activities.
    * @param id The identifier of the activity. (required)
    * @param page Page number. (optional)
    * @param perPage Number of items per page. Defaults to 30. (optional, default to 30)
   * @return List&lt;SummaryAthlete&gt;
   */
  @RequestLine("GET /activities/{id}/kudos?page={page}&per_page={perPage}")
  @Headers({
    "Accept: application/json",
  })
  List<SummaryAthlete> getKudoersByActivityId(@Param("id") Integer id, @Param("page") Integer page, @Param("perPage") Integer perPage);

  /**
   * List Activity Kudoers
   * Returns the athletes who kudoed an activity identified by an identifier. Requires activity:read for Everyone and Followers activities. Requires activity:read_all for Only Me activities.
   * Note, this is equivalent to the other <code>getKudoersByActivityId</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetKudoersByActivityIdQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param id The identifier of the activity. (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>page - Page number. (optional)</li>
   *   <li>perPage - Number of items per page. Defaults to 30. (optional, default to 30)</li>
   *   </ul>
   * @return List&lt;SummaryAthlete&gt;
   */
  @RequestLine("GET /activities/{id}/kudos?page={page}&per_page={perPage}")
  @Headers({
  "Accept: application/json",
  })
  List<SummaryAthlete> getKudoersByActivityId(@Param("id") Integer id, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getKudoersByActivityId</code> method in a fluent style.
   */
  public static class GetKudoersByActivityIdQueryParams extends HashMap<String, Object> {
    public GetKudoersByActivityIdQueryParams page(final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public GetKudoersByActivityIdQueryParams perPage(final Integer value) {
      put("per_page", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * List Activity Laps
   * Returns the laps of an activity identified by an identifier. Requires activity:read for Everyone and Followers activities. Requires activity:read_all for Only Me activities.
    * @param id The identifier of the activity. (required)
   * @return List&lt;Lap&gt;
   */
  @RequestLine("GET /activities/{id}/laps")
  @Headers({
    "Accept: application/json",
  })
  List<Lap> getLapsByActivityId(@Param("id") Long id);

  /**
   * List Athlete Activities
   * Returns the activities of an athlete for a specific identifier. Requires activity:read. Only Me activities will be filtered out unless requested by a token with activity:read_all.
    * @param before An epoch timestamp to use for filtering activities that have taken place before a certain time. (optional)
    * @param after An epoch timestamp to use for filtering activities that have taken place after a certain time. (optional)
    * @param page Page number. (optional)
    * @param perPage Number of items per page. Defaults to 30. (optional, default to 30)
   * @return List&lt;SummaryActivity&gt;
   */
  @RequestLine("GET /athlete/activities?before={before}&after={after}&page={page}&per_page={perPage}")
  @Headers({
    "Accept: application/json",
  })
  List<SummaryActivity> getLoggedInAthleteActivities(@Param("before") Integer before, @Param("after") Integer after, @Param("page") Integer page, @Param("perPage") Integer perPage);

  /**
   * List Athlete Activities
   * Returns the activities of an athlete for a specific identifier. Requires activity:read. Only Me activities will be filtered out unless requested by a token with activity:read_all.
   * Note, this is equivalent to the other <code>getLoggedInAthleteActivities</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetLoggedInAthleteActivitiesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>before - An epoch timestamp to use for filtering activities that have taken place before a certain time. (optional)</li>
   *   <li>after - An epoch timestamp to use for filtering activities that have taken place after a certain time. (optional)</li>
   *   <li>page - Page number. (optional)</li>
   *   <li>perPage - Number of items per page. Defaults to 30. (optional, default to 30)</li>
   *   </ul>
   * @return List&lt;SummaryActivity&gt;
   */
  @RequestLine("GET /athlete/activities?before={before}&after={after}&page={page}&per_page={perPage}")
  @Headers({
  "Accept: application/json",
  })
  List<SummaryActivity> getLoggedInAthleteActivities(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getLoggedInAthleteActivities</code> method in a fluent style.
   */
  public static class GetLoggedInAthleteActivitiesQueryParams extends HashMap<String, Object> {
    public GetLoggedInAthleteActivitiesQueryParams before(final Integer value) {
      put("before", EncodingUtils.encode(value));
      return this;
    }
    public GetLoggedInAthleteActivitiesQueryParams after(final Integer value) {
      put("after", EncodingUtils.encode(value));
      return this;
    }
    public GetLoggedInAthleteActivitiesQueryParams page(final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public GetLoggedInAthleteActivitiesQueryParams perPage(final Integer value) {
      put("per_page", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Get Activity Zones
   * Summit Feature. Returns the zones of a given activity. Requires activity:read for Everyone and Followers activities. Requires activity:read_all for Only Me activities.
    * @param id The identifier of the activity. (required)
   * @return List&lt;ActivityZone&gt;
   */
  @RequestLine("GET /activities/{id}/zones")
  @Headers({
    "Accept: application/json",
  })
  List<ActivityZone> getZonesByActivityId(@Param("id") Integer id);

  /**
   * Update Activity
   * Updates the given activity that is owned by the authenticated athlete. Requires activity:write. Also requires activity:read_all in order to update Only Me activities
    * @param id The identifier of the activity. (required)
    * @param body  (optional)
   * @return DetailedActivity
   */
  @RequestLine("PUT /activities/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  DetailedActivity updateActivityById(@Param("id") Long id, UpdatableActivity body);
}
