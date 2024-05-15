package de.telran.summary8;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageFileExample {
    private static String path = "resources/Picture.png";

    public static void main(String[] args) throws IOException {


        BufferedImage image = ImageIO.read(new File(path));
        System.out.println(image.getHeight());
        System.out.println(image.getData());


    }


}
