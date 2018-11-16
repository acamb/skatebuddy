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
import io.swagger.client.model.BaseStream;
import java.util.ArrayList;
import java.util.List;

/**
 * DistanceStream
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-10-17T09:13:08.236+02:00")
public class DistanceStream {
  @JsonProperty("original_size")
  private Integer originalSize = null;

  /**
   * The level of detail (sampling) in which this stream was returned
   */
  public enum ResolutionEnum {
    LOW("low"),
    
    MEDIUM("medium"),
    
    HIGH("high");

    private String value;

    ResolutionEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ResolutionEnum fromValue(String text) {
      for (ResolutionEnum b : ResolutionEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("resolution")
  private ResolutionEnum resolution = null;

  /**
   * The base series used in the case the stream was downsampled
   */
  public enum SeriesTypeEnum {
    DISTANCE("distance"),
    
    TIME("time");

    private String value;

    SeriesTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SeriesTypeEnum fromValue(String text) {
      for (SeriesTypeEnum b : SeriesTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("series_type")
  private SeriesTypeEnum seriesType = null;

  @JsonProperty("data")
  private List<Float> data = null;

  public DistanceStream originalSize(Integer originalSize) {
    this.originalSize = originalSize;
    return this;
  }

   /**
   * The number of data points in this stream
   * @return originalSize
  **/
  @ApiModelProperty(value = "The number of data points in this stream")
  public Integer getOriginalSize() {
    return originalSize;
  }

  public void setOriginalSize(Integer originalSize) {
    this.originalSize = originalSize;
  }

  public DistanceStream resolution(ResolutionEnum resolution) {
    this.resolution = resolution;
    return this;
  }

   /**
   * The level of detail (sampling) in which this stream was returned
   * @return resolution
  **/
  @ApiModelProperty(value = "The level of detail (sampling) in which this stream was returned")
  public ResolutionEnum getResolution() {
    return resolution;
  }

  public void setResolution(ResolutionEnum resolution) {
    this.resolution = resolution;
  }

  public DistanceStream seriesType(SeriesTypeEnum seriesType) {
    this.seriesType = seriesType;
    return this;
  }

   /**
   * The base series used in the case the stream was downsampled
   * @return seriesType
  **/
  @ApiModelProperty(value = "The base series used in the case the stream was downsampled")
  public SeriesTypeEnum getSeriesType() {
    return seriesType;
  }

  public void setSeriesType(SeriesTypeEnum seriesType) {
    this.seriesType = seriesType;
  }

  public DistanceStream data(List<Float> data) {
    this.data = data;
    return this;
  }

  public DistanceStream addDataItem(Float dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }
    this.data.add(dataItem);
    return this;
  }

   /**
   * The sequence of distance values for this stream, in meters
   * @return data
  **/
  @ApiModelProperty(value = "The sequence of distance values for this stream, in meters")
  public List<Float> getData() {
    return data;
  }

  public void setData(List<Float> data) {
    this.data = data;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DistanceStream distanceStream = (DistanceStream) o;
    return Objects.equals(this.originalSize, distanceStream.originalSize) &&
        Objects.equals(this.resolution, distanceStream.resolution) &&
        Objects.equals(this.seriesType, distanceStream.seriesType) &&
        Objects.equals(this.data, distanceStream.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(originalSize, resolution, seriesType, data);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DistanceStream {\n");
    
    sb.append("    originalSize: ").append(toIndentedString(originalSize)).append("\n");
    sb.append("    resolution: ").append(toIndentedString(resolution)).append("\n");
    sb.append("    seriesType: ").append(toIndentedString(seriesType)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

