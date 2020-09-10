package club.zqg.utils;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * <p>Description: </p>
 *
 * @author xuyangwei
 * @date 2019年9月13日
 */

public class QRCodeGenerator {
    /**
     *  POM 依赖
     *         <!-- https://mvnrepository.com/artifact/com.google.zxing/core -->
     *         <dependency>
     *             <groupId>com.google.zxing</groupId>
     *             <artifactId>core</artifactId>
     *             <version>3.3.0</version>
     *         </dependency>
     *
     *         <dependency>
     *             <groupId>com.google.zxing</groupId>
     *             <artifactId>javase</artifactId>
     *             <version>3.3.0</version>
     *         </dependency>
     */


    //指定需要生成的二维码图片名称  【目录必须存在】
    private static String QR_CODE_IMAGE_PATH = "C:\\Users\\Administrator\\Desktop\\qr\\zz.png";

    private static void generateQRCodeImage(String text, String filePath) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 350, 350);
            Path path = FileSystems.getDefault().getPath(filePath);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        }catch (WriterException | IOException e) {
            System.out.println("-------生成二维码失败--------");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        QRCodeGenerator.generateQRCodeImage("http://www.zqg-slg.club",QR_CODE_IMAGE_PATH);
    }
}