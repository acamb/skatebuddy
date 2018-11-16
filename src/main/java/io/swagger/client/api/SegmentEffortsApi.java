package io.swagger.client.api;

import io.swagger.client.ApiClient;
import io.swagger.client.EncodingUtils;

import io.swagger.client.model.DetailedSegmentEffort;
import io.swagger.client.model.Fault;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-10-17T09:13:08.236+02:00")
public interface SegmentEffortsApi extends ApiClient.Api {


  /**
   * List Segment Efforts
   * Returns a set of the authenticated athlete&#39;s segment efforts for a given segment.
    * @param id The identifier of the segment. (required)
    * @param page Page number. (optional)
    * @param perPage Number of items per page. Defaults to 30. (optional, default to 30)
   * @return List&lt;DetailedSegmentEffort&gt;
   */
  @RequestLine("GET /segments/{id}/all_efforts?page={page}&per_page={perPage}")
  @Headers({
    "Accept: application/json",
  })
  List<DetailedSegmentEffort> getEffortsBySegmentId(@Param("id") Integer id, @Param("page") Integer page, @Param("perPage") Integer perPage);

  /**
   * List Segment Efforts
   * Returns a set of the authenticated athlete&#39;s segment efforts for a given segment.
   * Note, this is equivalent to the other <code>getEffortsBySegmentId</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetEffortsBySegmentIdQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param id The identifier of the segment. (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>page - Page number. (optional)</li>
   *   <li>perPage - Number of items per page. Defaults to 30. (optional, default to 30)</li>
   *   </ul>
   * @return List&lt;DetailedSegmentEffort&gt;
   */
  @RequestLine("GET /segments/{id}/all_efforts?page={page}&per_page={perPage}")
  @Headers({
  "Accept: application/json",
  })
  List<DetailedSegmentEffort> getEffortsBySegmentId(@Param("id") Integer id, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getEffortsBySegmentId</code> method in a fluent style.
   */
  public static class GetEffortsBySegmentIdQueryParams extends HashMap<String, Object> {
    public GetEffortsBySegmentIdQueryParams page(final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public GetEffortsBySegmentIdQueryParams perPage(final Integer value) {
      put("per_page", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Get Segment Effort
   * Returns a segment effort from an activity that is owned by the authenticated athlete.
    * @param id The identifier of the segment effort. (required)
   * @return DetailedSegmentEffort
   */
  @RequestLine("GET /segment_efforts/{id}")
  @Headers({
    "Accept: application/json",
  })
  DetailedSegmentEffort getSegmentEffortById(@Param("id") Long id);
}
