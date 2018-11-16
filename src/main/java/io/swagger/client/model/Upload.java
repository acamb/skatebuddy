/*
 * Strava API v3
 * Strava API
 *
 * OpenAPI spec version: 3.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Upload
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-10-17T09:13:08.236+02:00")
public class Upload {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("external_id")
  private String externalId = null;

  @JsonProperty("error")
  private String error = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("activity_id")
  private Long activityId = null;

  public Upload id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * The unique identifier of the upload
   * @return id
  **/
  @ApiModelProperty(value = "The unique identifier of the upload")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Upload externalId(String externalId) {
    this.externalId = externalId;
    return this;
  }

   /**
   * The external identifier of the upload
   * @return externalId
  **/
  @ApiModelProperty(value = "The external identifier of the upload")
  public String getExternalId() {
    return externalId;
  }

  public void setExternalId(String externalId) {
    this.externalId = externalId;
  }

  public Upload error(String error) {
    this.error = error;
    return this;
  }

   /**
   * The error associated with this upload
   * @return error
  **/
  @ApiModelProperty(value = "The error associated with this upload")
  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public Upload status(String status) {
    this.status = status;
    return this;
  }

   /**
   * The status of this upload
   * @return status
  **/
  @ApiModelProperty(value = "The status of this upload")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Upload activityId(Long activityId) {
    this.activityId = activityId;
    return this;
  }

   /**
   * The identifier of the activity this upload resulted into
   * @return activityId
  **/
  @ApiModelProperty(value = "The identifier of the activity this upload resulted into")
  public Long getActivityId() {
    return activityId;
  }

  public void setActivityId(Long activityId) {
    this.activityId = activityId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Upload upload = (Upload) o;
    return Objects.equals(this.id, upload.id) &&
        Objects.equals(this.externalId, upload.externalId) &&
        Objects.equals(this.error, upload.error) &&
        Objects.equals(this.status, upload.status) &&
        Objects.equals(this.activityId, upload.activityId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, externalId, error, status, activityId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Upload {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    externalId: ").append(toIndentedString(externalId)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    activityId: ").append(toIndentedString(activityId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

