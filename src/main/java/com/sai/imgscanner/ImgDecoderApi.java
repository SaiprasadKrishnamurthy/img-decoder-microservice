package com.sai.imgscanner;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by saipkri on 16/08/17.
 */
@RestController("api")
@Api("Image decoder Rest API")
public class ImgDecoderApi {

    @ApiOperation("Scans the base 64 encoded images in the payload (QR, BAR and Device Plate), decodes them and gets the textual (structured) information back.")
    @PostMapping(value = "/text", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> scanImage(@RequestBody final Images images) throws Exception {
        Result result = new Result();
        if (StringUtils.isNotBlank(images.getQrCodeBase64())) {
            String qrText = QRUtil.decode(java.util.Base64.getDecoder().decode(images.getQrCodeBase64()));
            result.setQrCodeText(qrText);
        }
        if (StringUtils.isNotBlank(images.getBarCodeBase64())) {
            String barText = QRUtil.decode(java.util.Base64.getDecoder().decode(images.getBarCodeBase64()));
            result.setBarCodeText(barText);
        }

        // TODO implement Device plate
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
