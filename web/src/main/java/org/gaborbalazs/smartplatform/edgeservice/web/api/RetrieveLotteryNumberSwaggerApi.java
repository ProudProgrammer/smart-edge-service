package org.gaborbalazs.smartplatform.edgeservice.web.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.gaborbalazs.smartplatform.edgeservice.service.domain.Draw;
import org.gaborbalazs.smartplatform.edgeservice.service.domain.DrawnNumbers;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;

import java.util.List;

@Api(tags = {"Retrieve Lottery Number"})
@ApiModel(value = "Retrieve Lottery Number", description = "Endpoints for retrieving lottery numbers")
public interface RetrieveLotteryNumberSwaggerApi {

    @ApiOperation("Retrieve a set of randomly generated lottery numbers based on lottery type")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Consumer-Name", value = "Name of the consumer", paramType = "header", defaultValue = "Swagger"),
            @ApiImplicitParam(name = "Request-Id", value = "Request ID", paramType = "header", defaultValue = "swagger0-0000-0000-0000-swagger00000"),
            @ApiImplicitParam(name = "Locale", value = "Locale for response message localization.", paramType = "header", defaultValue = "en-US")})
    @ApiResponses({
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 501, message = "Not Implemented")})
    DrawnNumbers retrieve(
            @ApiParam(value = "Lottery type", required = true, allowableValues = "five-out-of-ninety,six-out-of-forty-five,scandinavian") LotteryType lotteryType,
            @ApiParam(value = "Generator type", allowableValues = "default,experimental") GeneratorType generatorType);

    @ApiOperation("Retrieve a set of randomly generated lottery numbers based on quantity and pool size")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Consumer-Name", value = "Name of the consumer", paramType = "header", defaultValue = "Swagger"),
            @ApiImplicitParam(name = "Request-Id", value = "Request ID", paramType = "header", defaultValue = "swagger0-0000-0000-0000-swagger00000"),
            @ApiImplicitParam(name = "Locale", value = "Locale for response message localization.", paramType = "header", defaultValue = "en-US")})
    @ApiResponses({
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 501, message = "Not Implemented")})
    DrawnNumbers retrieve(
            @ApiParam(value = "Quantity of drawn numbers", required = true) int quantity,
            @ApiParam(value = "Pool size of numbers", required = true) int poolSize,
            @ApiParam(value = "Generator type", allowableValues = "default,experimental") GeneratorType generatorType);

    @ApiOperation("Retrieving drawn lottery numbers from Szerencsejatek Zrt. based on lottery type")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Consumer-Name", value = "Name of the consumer", paramType = "header", defaultValue = "Swagger"),
            @ApiImplicitParam(name = "Request-Id", value = "Request ID", paramType = "header", defaultValue = "swagger0-0000-0000-0000-swagger00000"),
            @ApiImplicitParam(name = "Locale", value = "Locale for response message localization.", paramType = "header", defaultValue = "en-US")})
    @ApiResponses({
            @ApiResponse(code = 400, message = "Bad Request")})
    List<? extends Draw> retrieve(
            @ApiParam(value = "Lottery type", required = true, allowableValues = "five-out-of-ninety,six-out-of-forty-five,scandinavian,joker") LotteryType lotteryType);
}