package io.swagger.client.api;

import io.swagger.client.ApiClient;
import io.swagger.client.EncodingUtils;

import io.swagger.client.model.Fault;
import java.io.File;
import io.swagger.client.model.Upload;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-10-17T09:13:08.236+02:00")
public interface UploadsApi extends ApiClient.Api {


  /**
   * Upload Activity
   * Uploads a new data file to create an activity from. Requires activity:write scope.
    * @param file The uploaded file. (optional)
    * @param name The desired name of the resulting activity. (optional)
    * @param description The desired description of the resulting activity. (optional)
    * @param trainer Whether the resulting activity should be marked as having been performed on a trainer. (optional)
    * @param commute Whether the resulting activity should be tagged as a commute. (optional)
    * @param dataType The format of the uploaded file. (optional)
    * @param externalId The desired external identifier of the resulting activity. (optional)
   * @return Upload
   */
  @RequestLine("POST /uploads")
  @Headers({
    "Content-Type: multipart/form-data",
    "Accept: application/json",
  })
  Upload createUpload(@Param("file") File file, @Param("name") String name, @Param("description") String description, @Param("trainer") String trainer, @Param("commute") String commute, @Param("dataType") String dataType, @Param("externalId") String externalId);

  /**
   * Get Upload
   * Returns an upload for a given identifier. Requires activity:write scope.
    * @param uploadId The identifier of the upload. (required)
   * @return Upload
   */
  @RequestLine("GET /uploads/{uploadId}")
  @Headers({
    "Accept: application/json",
  })
  Upload getUploadById(@Param("uploadId") Long uploadId);
}
