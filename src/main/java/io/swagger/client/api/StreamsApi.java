package io.swagger.client.api;

import io.swagger.client.ApiClient;
import io.swagger.client.EncodingUtils;

import io.swagger.client.model.Fault;
import io.swagger.client.model.StreamSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-10-17T09:13:08.236+02:00")
public interface StreamsApi extends ApiClient.Api {


  /**
   * Get Activity Streams
   * Returns the given activity&#39;s streams. Requires activity:read scope. Requires activity:read_all scope for Only Me activities.
    * @param id The identifier of the activity. (required)
    * @param keys Desired stream types. (required)
    * @param keyByType Must be true. (required)
   * @return StreamSet
   */
  @RequestLine("GET /activities/{id}/streams?keys={keys}&key_by_type={keyByType}")
  @Headers({
    "Accept: application/json",
  })
  StreamSet getActivityStreams(@Param("id") Long id, @Param("keys") List<String> keys, @Param("keyByType") Boolean keyByType);

  /**
   * Get Activity Streams
   * Returns the given activity&#39;s streams. Requires activity:read scope. Requires activity:read_all scope for Only Me activities.
   * Note, this is equivalent to the other <code>getActivityStreams</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetActivityStreamsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param id The identifier of the activity. (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>keys - Desired stream types. (required)</li>
   *   <li>keyByType - Must be true. (required)</li>
   *   </ul>
   * @return StreamSet
   */
  @RequestLine("GET /activities/{id}/streams?keys={keys}&key_by_type={keyByType}")
  @Headers({
  "Accept: application/json",
  })
  StreamSet getActivityStreams(@Param("id") Long id, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getActivityStreams</code> method in a fluent style.
   */
  public static class GetActivityStreamsQueryParams extends HashMap<String, Object> {
    public GetActivityStreamsQueryParams keys(final List<String> value) {
      put("keys", EncodingUtils.encodeCollection(value, "csv"));
      return this;
    }
    public GetActivityStreamsQueryParams keyByType(final Boolean value) {
      put("key_by_type", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Get segment effort streams
   * Returns a set of streams for a segment effort completed by the authenticated athlete. Requires read_all scope.
    * @param id The identifier of the segment effort. (required)
    * @param keys The types of streams to return. (required)
    * @param keyByType Must be true. (required)
   * @return StreamSet
   */
  @RequestLine("GET /segment_efforts/{id}/streams?keys={keys}&key_by_type={keyByType}")
  @Headers({
    "Accept: application/json",
  })
  StreamSet getSegmentEffortStreams(@Param("id") Long id, @Param("keys") List<String> keys, @Param("keyByType") Boolean keyByType);

  /**
   * Get segment effort streams
   * Returns a set of streams for a segment effort completed by the authenticated athlete. Requires read_all scope.
   * Note, this is equivalent to the other <code>getSegmentEffortStreams</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetSegmentEffortStreamsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param id The identifier of the segment effort. (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>keys - The types of streams to return. (required)</li>
   *   <li>keyByType - Must be true. (required)</li>
   *   </ul>
   * @return StreamSet
   */
  @RequestLine("GET /segment_efforts/{id}/streams?keys={keys}&key_by_type={keyByType}")
  @Headers({
  "Accept: application/json",
  })
  StreamSet getSegmentEffortStreams(@Param("id") Long id, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getSegmentEffortStreams</code> method in a fluent style.
   */
  public static class GetSegmentEffortStreamsQueryParams extends HashMap<String, Object> {
    public GetSegmentEffortStreamsQueryParams keys(final List<String> value) {
      put("keys", EncodingUtils.encodeCollection(value, "csv"));
      return this;
    }
    public GetSegmentEffortStreamsQueryParams keyByType(final Boolean value) {
      put("key_by_type", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Get Segment Streams
   * Returns the given segment&#39;s streams. Requires read_all scope for private segments.
    * @param id The identifier of the segment. (required)
    * @param keys The types of streams to return. (required)
    * @param keyByType Must be true. (required)
   * @return StreamSet
   */
  @RequestLine("GET /segments/{id}/streams?keys={keys}&key_by_type={keyByType}")
  @Headers({
    "Accept: application/json",
  })
  StreamSet getSegmentStreams(@Param("id") Long id, @Param("keys") List<String> keys, @Param("keyByType") Boolean keyByType);

  /**
   * Get Segment Streams
   * Returns the given segment&#39;s streams. Requires read_all scope for private segments.
   * Note, this is equivalent to the other <code>getSegmentStreams</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetSegmentStreamsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param id The identifier of the segment. (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>keys - The types of streams to return. (required)</li>
   *   <li>keyByType - Must be true. (required)</li>
   *   </ul>
   * @return StreamSet
   */
  @RequestLine("GET /segments/{id}/streams?keys={keys}&key_by_type={keyByType}")
  @Headers({
  "Accept: application/json",
  })
  StreamSet getSegmentStreams(@Param("id") Long id, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getSegmentStreams</code> method in a fluent style.
   */
  public static class GetSegmentStreamsQueryParams extends HashMap<String, Object> {
    public GetSegmentStreamsQueryParams keys(final List<String> value) {
      put("keys", EncodingUtils.encodeCollection(value, "csv"));
      return this;
    }
    public GetSegmentStreamsQueryParams keyByType(final Boolean value) {
      put("key_by_type", EncodingUtils.encode(value));
      return this;
    }
  }
}
