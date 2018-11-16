package io.swagger.client.api;

import io.swagger.client.ApiClient;
import io.swagger.client.EncodingUtils;

import io.swagger.client.model.DetailedClub;
import io.swagger.client.model.Fault;
import io.swagger.client.model.SummaryActivity;
import io.swagger.client.model.SummaryAthlete;
import io.swagger.client.model.SummaryClub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-10-17T09:13:08.236+02:00")
public interface ClubsApi extends ApiClient.Api {


  /**
   * List Club Activities
   * Retrieve recent activities from members of a specific club. The authenticated athlete must belong to the requested club in order to hit this endpoint. Pagination is supported. Athlete profile visibility is respected for all activities.
    * @param id The identifier of the club. (required)
    * @param page Page number. (optional)
    * @param perPage Number of items per page. Defaults to 30. (optional, default to 30)
   * @return List&lt;SummaryActivity&gt;
   */
  @RequestLine("GET /clubs/{id}/activities?page={page}&per_page={perPage}")
  @Headers({
    "Accept: application/json",
  })
  List<SummaryActivity> getClubActivitiesById(@Param("id") Integer id, @Param("page") Integer page, @Param("perPage") Integer perPage);

  /**
   * List Club Activities
   * Retrieve recent activities from members of a specific club. The authenticated athlete must belong to the requested club in order to hit this endpoint. Pagination is supported. Athlete profile visibility is respected for all activities.
   * Note, this is equivalent to the other <code>getClubActivitiesById</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetClubActivitiesByIdQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param id The identifier of the club. (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>page - Page number. (optional)</li>
   *   <li>perPage - Number of items per page. Defaults to 30. (optional, default to 30)</li>
   *   </ul>
   * @return List&lt;SummaryActivity&gt;
   */
  @RequestLine("GET /clubs/{id}/activities?page={page}&per_page={perPage}")
  @Headers({
  "Accept: application/json",
  })
  List<SummaryActivity> getClubActivitiesById(@Param("id") Integer id, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getClubActivitiesById</code> method in a fluent style.
   */
  public static class GetClubActivitiesByIdQueryParams extends HashMap<String, Object> {
    public GetClubActivitiesByIdQueryParams page(final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public GetClubActivitiesByIdQueryParams perPage(final Integer value) {
      put("per_page", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * List Club Administrators.
   * Returns a list of the administrators of a given club.
    * @param id The identifier of the club. (required)
    * @param page Page number. (optional)
    * @param perPage Number of items per page. Defaults to 30. (optional, default to 30)
   * @return List&lt;SummaryAthlete&gt;
   */
  @RequestLine("GET /clubs/{id}/admins?page={page}&per_page={perPage}")
  @Headers({
    "Accept: application/json",
  })
  List<SummaryAthlete> getClubAdminsById(@Param("id") Integer id, @Param("page") Integer page, @Param("perPage") Integer perPage);

  /**
   * List Club Administrators.
   * Returns a list of the administrators of a given club.
   * Note, this is equivalent to the other <code>getClubAdminsById</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetClubAdminsByIdQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param id The identifier of the club. (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>page - Page number. (optional)</li>
   *   <li>perPage - Number of items per page. Defaults to 30. (optional, default to 30)</li>
   *   </ul>
   * @return List&lt;SummaryAthlete&gt;
   */
  @RequestLine("GET /clubs/{id}/admins?page={page}&per_page={perPage}")
  @Headers({
  "Accept: application/json",
  })
  List<SummaryAthlete> getClubAdminsById(@Param("id") Integer id, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getClubAdminsById</code> method in a fluent style.
   */
  public static class GetClubAdminsByIdQueryParams extends HashMap<String, Object> {
    public GetClubAdminsByIdQueryParams page(final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public GetClubAdminsByIdQueryParams perPage(final Integer value) {
      put("per_page", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Get Club
   * Returns a given club using its identifier.
    * @param id The identifier of the club. (required)
   * @return DetailedClub
   */
  @RequestLine("GET /clubs/{id}")
  @Headers({
    "Accept: application/json",
  })
  DetailedClub getClubById(@Param("id") Integer id);

  /**
   * List Club Members
   * Returns a list of the athletes who are members of a given club.
    * @param id The identifier of the club. (required)
    * @param page Page number. (optional)
    * @param perPage Number of items per page. Defaults to 30. (optional, default to 30)
   * @return List&lt;SummaryAthlete&gt;
   */
  @RequestLine("GET /clubs/{id}/members?page={page}&per_page={perPage}")
  @Headers({
    "Accept: application/json",
  })
  List<SummaryAthlete> getClubMembersById(@Param("id") Integer id, @Param("page") Integer page, @Param("perPage") Integer perPage);

  /**
   * List Club Members
   * Returns a list of the athletes who are members of a given club.
   * Note, this is equivalent to the other <code>getClubMembersById</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetClubMembersByIdQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param id The identifier of the club. (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>page - Page number. (optional)</li>
   *   <li>perPage - Number of items per page. Defaults to 30. (optional, default to 30)</li>
   *   </ul>
   * @return List&lt;SummaryAthlete&gt;
   */
  @RequestLine("GET /clubs/{id}/members?page={page}&per_page={perPage}")
  @Headers({
  "Accept: application/json",
  })
  List<SummaryAthlete> getClubMembersById(@Param("id") Integer id, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getClubMembersById</code> method in a fluent style.
   */
  public static class GetClubMembersByIdQueryParams extends HashMap<String, Object> {
    public GetClubMembersByIdQueryParams page(final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public GetClubMembersByIdQueryParams perPage(final Integer value) {
      put("per_page", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * List Athlete Clubs
   * Returns a list of the clubs whose membership includes the authenticated athlete.
    * @param page Page number. (optional)
    * @param perPage Number of items per page. Defaults to 30. (optional, default to 30)
   * @return List&lt;SummaryClub&gt;
   */
  @RequestLine("GET /athlete/clubs?page={page}&per_page={perPage}")
  @Headers({
    "Accept: application/json",
  })
  List<SummaryClub> getLoggedInAthleteClubs(@Param("page") Integer page, @Param("perPage") Integer perPage);

  /**
   * List Athlete Clubs
   * Returns a list of the clubs whose membership includes the authenticated athlete.
   * Note, this is equivalent to the other <code>getLoggedInAthleteClubs</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetLoggedInAthleteClubsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>page - Page number. (optional)</li>
   *   <li>perPage - Number of items per page. Defaults to 30. (optional, default to 30)</li>
   *   </ul>
   * @return List&lt;SummaryClub&gt;
   */
  @RequestLine("GET /athlete/clubs?page={page}&per_page={perPage}")
  @Headers({
  "Accept: application/json",
  })
  List<SummaryClub> getLoggedInAthleteClubs(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getLoggedInAthleteClubs</code> method in a fluent style.
   */
  public static class GetLoggedInAthleteClubsQueryParams extends HashMap<String, Object> {
    public GetLoggedInAthleteClubsQueryParams page(final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public GetLoggedInAthleteClubsQueryParams perPage(final Integer value) {
      put("per_page", EncodingUtils.encode(value));
      return this;
    }
  }
}
