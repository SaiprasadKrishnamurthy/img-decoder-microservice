package com.sai.imgscanner;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Map;

/**
 * Created by saipkri on 16/08/17.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Result {
    private String qrCodeText;
    private String barCodeText;
    private Map<String, Object> devicePlateMetadata;
}
