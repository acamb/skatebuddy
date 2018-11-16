package io.swagger.client.api;

import io.swagger.client.ApiClient;
import io.swagger.client.EncodingUtils;

import io.swagger.client.model.DetailedSegment;
import io.swagger.client.model.ExplorerResponse;
import io.swagger.client.model.Fault;
import io.swagger.client.model.SegmentLeaderboard;
import io.swagger.client.model.SummarySegment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-10-17T09:13:08.236+02:00")
public interface SegmentsApi extends ApiClient.Api {


  /**
   * Explore segments
   * Returns the top 10 segments matching a specified query.
    * @param bounds The latitude and longitude for two points describing a rectangular boundary for the search: [southwest corner latitutde, southwest corner longitude, northeast corner latitude, northeast corner longitude] (required)
    * @param activityType Desired activity type. (optional)
    * @param minCat The minimum climbing category. (optional)
    * @param maxCat The maximum climbing category. (optional)
   * @return ExplorerResponse
   */
  @RequestLine("GET /segments/explore?bounds={bounds}&activity_type={activityType}&min_cat={minCat}&max_cat={maxCat}")
  @Headers({
    "Accept: application/json",
  })
  ExplorerResponse exploreSegments(@Param("bounds") List<Float> bounds, @Param("activityType") String activityType, @Param("minCat") Integer minCat, @Param("maxCat") Integer maxCat);

  /**
   * Explore segments
   * Returns the top 10 segments matching a specified query.
   * Note, this is equivalent to the other <code>exploreSegments</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link ExploreSegmentsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>bounds - The latitude and longitude for two points describing a rectangular boundary for the search: [southwest corner latitutde, southwest corner longitude, northeast corner latitude, northeast corner longitude] (required)</li>
   *   <li>activityType - Desired activity type. (optional)</li>
   *   <li>minCat - The minimum climbing category. (optional)</li>
   *   <li>maxCat - The maximum climbing category. (optional)</li>
   *   </ul>
   * @return ExplorerResponse
   */
  @RequestLine("GET /segments/explore?bounds={bounds}&activity_type={activityType}&min_cat={minCat}&max_cat={maxCat}")
  @Headers({
  "Accept: application/json",
  })
  ExplorerResponse exploreSegments(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>exploreSegments</code> method in a fluent style.
   */
  public static class ExploreSegmentsQueryParams extends HashMap<String, Object> {
    public ExploreSegmentsQueryParams bounds(final List<Float> value) {
      put("bounds", EncodingUtils.encodeCollection(value, "csv"));
      return this;
    }
    public ExploreSegmentsQueryParams activityType(final String value) {
      put("activity_type", EncodingUtils.encode(value));
      return this;
    }
    public ExploreSegmentsQueryParams minCat(final Integer value) {
      put("min_cat", EncodingUtils.encode(value));
      return this;
    }
    public ExploreSegmentsQueryParams maxCat(final Integer value) {
      put("max_cat", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Get Segment Leaderboard
   * Returns the specified segment leaderboard.
    * @param id The identifier of the segment leaderboard. (required)
    * @param gender Filter by gender. (optional)
    * @param ageGroup Summit Feature. Filter by age group. (optional)
    * @param weightClass Summit Feature. Filter by weight class. (optional)
    * @param following Filter by friends of the authenticated athlete. (optional)
    * @param clubId Filter by club. (optional)
    * @param dateRange Filter by date range. (optional)
    * @param contextEntries  (optional)
    * @param page Page number. (optional)
    * @param perPage Number of items per page. Defaults to 30. (optional, default to 30)
   * @return SegmentLeaderboard
   */
  @RequestLine("GET /segments/{id}/leaderboard?gender={gender}&age_group={ageGroup}&weight_class={weightClass}&following={following}&club_id={clubId}&date_range={dateRange}&context_entries={contextEntries}&page={page}&per_page={perPage}")
  @Headers({
    "Accept: application/json",
  })
  SegmentLeaderboard getLeaderboardBySegmentId(@Param("id") Long id, @Param("gender") String gender, @Param("ageGroup") String ageGroup, @Param("weightClass") String weightClass, @Param("following") Boolean following, @Param("clubId") Long clubId, @Param("dateRange") String dateRange, @Param("contextEntries") Integer contextEntries, @Param("page") Integer page, @Param("perPage") Integer perPage);

  /**
   * Get Segment Leaderboard
   * Returns the specified segment leaderboard.
   * Note, this is equivalent to the other <code>getLeaderboardBySegmentId</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetLeaderboardBySegmentIdQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param id The identifier of the segment leaderboard. (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>gender - Filter by gender. (optional)</li>
   *   <li>ageGroup - Summit Feature. Filter by age group. (optional)</li>
   *   <li>weightClass - Summit Feature. Filter by weight class. (optional)</li>
   *   <li>following - Filter by friends of the authenticated athlete. (optional)</li>
   *   <li>clubId - Filter by club. (optional)</li>
   *   <li>dateRange - Filter by date range. (optional)</li>
   *   <li>contextEntries -  (optional)</li>
   *   <li>page - Page number. (optional)</li>
   *   <li>perPage - Number of items per page. Defaults to 30. (optional, default to 30)</li>
   *   </ul>
   * @return SegmentLeaderboard
   */
  @RequestLine("GET /segments/{id}/leaderboard?gender={gender}&age_group={ageGroup}&weight_class={weightClass}&following={following}&club_id={clubId}&date_range={dateRange}&context_entries={contextEntries}&page={page}&per_page={perPage}")
  @Headers({
  "Accept: application/json",
  })
  SegmentLeaderboard getLeaderboardBySegmentId(@Param("id") Long id, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getLeaderboardBySegmentId</code> method in a fluent style.
   */
  public static class GetLeaderboardBySegmentIdQueryParams extends HashMap<String, Object> {
    public GetLeaderboardBySegmentIdQueryParams gender(final String value) {
      put("gender", EncodingUtils.encode(value));
      return this;
    }
    public GetLeaderboardBySegmentIdQueryParams ageGroup(final String value) {
      put("age_group", EncodingUtils.encode(value));
      return this;
    }
    public GetLeaderboardBySegmentIdQueryParams weightClass(final String value) {
      put("weight_class", EncodingUtils.encode(value));
      return this;
    }
    public GetLeaderboardBySegmentIdQueryParams following(final Boolean value) {
      put("following", EncodingUtils.encode(value));
      return this;
    }
    public GetLeaderboardBySegmentIdQueryParams clubId(final Long value) {
      put("club_id", EncodingUtils.encode(value));
      return this;
    }
    public GetLeaderboardBySegmentIdQueryParams dateRange(final String value) {
      put("date_range", EncodingUtils.encode(value));
      return this;
    }
    public GetLeaderboardBySegmentIdQueryParams contextEntries(final Integer value) {
      put("context_entries", EncodingUtils.encode(value));
      return this;
    }
    public GetLeaderboardBySegmentIdQueryParams page(final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public GetLeaderboardBySegmentIdQueryParams perPage(final Integer value) {
      put("per_page", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * List Starred Segments
   * List of the authenticated athlete&#39;s starred segments. Private segments are filtered out unless requested by a token with read_all scope.
    * @param page Page number. (optional)
    * @param perPage Number of items per page. Defaults to 30. (optional, default to 30)
   * @return List&lt;SummarySegment&gt;
   */
  @RequestLine("GET /segments/starred?page={page}&per_page={perPage}")
  @Headers({
    "Accept: application/json",
  })
  List<SummarySegment> getLoggedInAthleteStarredSegments(@Param("page") Integer page, @Param("perPage") Integer perPage);

  /**
   * List Starred Segments
   * List of the authenticated athlete&#39;s starred segments. Private segments are filtered out unless requested by a token with read_all scope.
   * Note, this is equivalent to the other <code>getLoggedInAthleteStarredSegments</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetLoggedInAthleteStarredSegmentsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>page - Page number. (optional)</li>
   *   <li>perPage - Number of items per page. Defaults to 30. (optional, default to 30)</li>
   *   </ul>
   * @return List&lt;SummarySegment&gt;
   */
  @RequestLine("GET /segments/starred?page={page}&per_page={perPage}")
  @Headers({
  "Accept: application/json",
  })
  List<SummarySegment> getLoggedInAthleteStarredSegments(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getLoggedInAthleteStarredSegments</code> method in a fluent style.
   */
  public static class GetLoggedInAthleteStarredSegmentsQueryParams extends HashMap<String, Object> {
    public GetLoggedInAthleteStarredSegmentsQueryParams page(final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public GetLoggedInAthleteStarredSegmentsQueryParams perPage(final Integer value) {
      put("per_page", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Get Segment
   * Returns the specified segment. read_all scope required in order to retrieve athlete-specific segment information, or to retrieve private segments.
    * @param id The identifier of the segment. (required)
   * @return DetailedSegment
   */
  @RequestLine("GET /segments/{id}")
  @Headers({
    "Accept: application/json",
  })
  DetailedSegment getSegmentById(@Param("id") Long id);

  /**
   * Star Segment
   * Stars/Unstars the given segment for the authenticated athlete. Requires profile:write scope.
    * @param id The identifier of the segment to star. (required)
    * @param starred If true, star the segment; if false, unstar the segment. (required)
   * @return DetailedSegment
   */
  @RequestLine("PUT /segments/{id}/starred")
  @Headers({
    "Content-Type: application/x-www-form-urlencoded",
    "Accept: application/json",
  })
  DetailedSegment starSegment(@Param("id") Long id, @Param("starred") Boolean starred);
}
