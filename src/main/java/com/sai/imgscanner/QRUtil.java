package com.sai.imgscanner;


import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;

/**
 * Created by saipkri on 16/08/17.
 */
public class QRUtil {

    private QRUtil() {
    }

    public static String decode(final byte[] image) throws Exception {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(
                        ImageIO.read(new ByteArrayInputStream(image)))));
        Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap);
        return qrCodeResult.getText();
    }
}
