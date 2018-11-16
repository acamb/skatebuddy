package io.swagger.client.api;

import io.swagger.client.ApiClient;
import io.swagger.client.EncodingUtils;

import io.swagger.client.model.DetailedGear;
import io.swagger.client.model.Fault;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-10-17T09:13:08.236+02:00")
public interface GearsApi extends ApiClient.Api {


  /**
   * Get Equipment
   * Returns an equipment using its identifier.
    * @param id The identifier of the gear. (required)
   * @return DetailedGear
   */
  @RequestLine("GET /gear/{id}")
  @Headers({
    "Accept: application/json",
  })
  DetailedGear getGearById(@Param("id") Integer id);
}
