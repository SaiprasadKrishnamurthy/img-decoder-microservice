package com.sai.imgscanner;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by saipkri on 16/08/17.
 */
@Data
@ApiModel
public class Images {
    @ApiModelProperty("Base64 encoded image representing the QR code")
    private String qrCodeBase64;
    @ApiModelProperty("Base64 encoded image representing the Bar code")
    private String barCodeBase64;
    @ApiModelProperty("Base64 encoded image representing the device plate")
    private String devicePlateBase64;
}
