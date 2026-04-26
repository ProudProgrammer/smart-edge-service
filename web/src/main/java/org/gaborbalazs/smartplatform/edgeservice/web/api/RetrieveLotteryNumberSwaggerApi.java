package org.gaborbalazs.smartplatform.edgeservice.web.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.gaborbalazs.smartplatform.edgeservice.service.domain.Draw;
import org.gaborbalazs.smartplatform.edgeservice.service.domain.GeneratedNumbers;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;

import java.util.List;

@Tag(name = "Retrieve Lottery Number", description = "Endpoints for retrieving lottery numbers")
public interface RetrieveLotteryNumberSwaggerApi {

    @Operation(summary = "Retrieve a set of randomly generated lottery numbers based on lottery type",
            parameters = {
                    @Parameter(name = "Consumer-Name", in = ParameterIn.HEADER, description = "Name of the consumer", schema = @Schema(defaultValue = "Swagger")),
                    @Parameter(name = "Request-Id", in = ParameterIn.HEADER, description = "Request ID", schema = @Schema(defaultValue = "swagger0-0000-0000-0000-swagger00000")),
                    @Parameter(name = "Locale", in = ParameterIn.HEADER, description = "Locale for response message localization.", schema = @Schema(defaultValue = "en-US"))})
    @ApiResponses({
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            @ApiResponse(responseCode = "501", description = "Not Implemented")})
    GeneratedNumbers retrieveGenerated(
            @Parameter(description = "Lottery type", required = true, schema = @Schema(allowableValues = {"five-out-of-ninety", "six-out-of-forty-five", "scandinavian", "joker"})) LotteryType lotteryType,
            @Parameter(description = "Generator type", schema = @Schema(allowableValues = {"default", "experimental"})) GeneratorType generatorType);

    @Operation(summary = "Retrieve a set of randomly generated lottery numbers based on quantity and pool size",
            parameters = {
                    @Parameter(name = "Consumer-Name", in = ParameterIn.HEADER, description = "Name of the consumer", schema = @Schema(defaultValue = "Swagger")),
                    @Parameter(name = "Request-Id", in = ParameterIn.HEADER, description = "Request ID", schema = @Schema(defaultValue = "swagger0-0000-0000-0000-swagger00000")),
                    @Parameter(name = "Locale", in = ParameterIn.HEADER, description = "Locale for response message localization.", schema = @Schema(defaultValue = "en-US"))})
    @ApiResponses({
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            @ApiResponse(responseCode = "501", description = "Not Implemented")})
    GeneratedNumbers retrieveGenerated(
            @Parameter(description = "Quantity of drawn numbers", required = true) int quantity,
            @Parameter(description = "Pool size of numbers", required = true) int poolSize,
            @Parameter(description = "Generator type", schema = @Schema(allowableValues = {"default", "experimental"})) GeneratorType generatorType);

    @Operation(summary = "Retrieving drawn lottery numbers from Szerencsejatek Zrt. based on lottery type",
            parameters = {
                    @Parameter(name = "Consumer-Name", in = ParameterIn.HEADER, description = "Name of the consumer", schema = @Schema(defaultValue = "Swagger")),
                    @Parameter(name = "Request-Id", in = ParameterIn.HEADER, description = "Request ID", schema = @Schema(defaultValue = "swagger0-0000-0000-0000-swagger00000")),
                    @Parameter(name = "Locale", in = ParameterIn.HEADER, description = "Locale for response message localization.", schema = @Schema(defaultValue = "en-US"))})
    @ApiResponses({
            @ApiResponse(responseCode = "400", description = "Bad Request")})
    List<Draw> retrieveDrawn(
            @Parameter(description = "Lottery type", required = true, schema = @Schema(allowableValues = {"five-out-of-ninety", "six-out-of-forty-five", "scandinavian", "joker"})) LotteryType lotteryType);
}