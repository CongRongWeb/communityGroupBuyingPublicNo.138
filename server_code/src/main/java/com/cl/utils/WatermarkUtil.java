package com.cl.utils;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @Author: Ynw
 * @Date: 2024/09/18/10:50
 * @Description:
 */
public class WatermarkUtil {
    private static final List<String> ALLOWED_EXTENSIONS = Arrays.asList("jpg");

    public static void main(String[] args) {
        list();
    }

    public static void list() {
        String path = "F:\\educationProject\\医院挂号系统\\hospitalRegistration\\picture\\";
        File file1 = new File(path);
        if (file1.exists()) {
            File path2 = new File("F:\\educationProject\\医院挂号系统\\hospitalRegistration\\picture2\\");
            if(!path2.exists()) {
                path2.mkdirs();
            }
            File[] files = file1.listFiles();
            //File file2 = files[0];
            for (int i = 0;i<files.length;i++) {
                File file2 = files[i];
                //带水印版本的名字
                String watermarkName = file2.getName();
                // 创建带水印的文件对象
                //创建带水印且压缩画质的版本
                File newWatermarkName = new File(path2.getAbsolutePath()+"/" + watermarkName);
                try {
                    // 为文件添加水印并压缩
                    addWatermarkAndCompress(file2, newWatermarkName,"微信：grapro666 QQ: 3642795578");
                } catch (IOException e) {
                }
            }
        }
    }

    /**
     * 检查文件名是否允许。
     *
     * 此方法通过检查文件名的扩展名来确定文件名是否被允许。文件名必须包含至少一个点（.）
     * 以标识扩展名，并且扩展名必须在预定义的允许扩展名列表中。
     *
     * @param fileName 要检查的文件名。
     * @return 如果文件名的扩展名被允许，则返回true；否则返回false。
     */
    private Boolean isAllowed(String fileName) {
        // 检查文件名是否为空或不包含点（.）
        if(fileName == null || fileName.lastIndexOf(".") == -1){
            return false;
        }
        // 提取文件名的扩展名，并转换为小写
        String extension = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
        // 检查提取的扩展名是否在允许的扩展名列表中
        return ALLOWED_EXTENSIONS.contains(extension);
    }




    /**
     * 给图片添加水印并压缩保存。
     *
     * 此方法接收原始图片文件、目标输出文件和水印文本作为参数，它将原始图片读入，
     * 添加水印后，按照原始尺寸进行压缩，并保存到目标文件中。
     *
     * @param originalFile 原始图片文件，添加水印和压缩的基础文件。
     * @param outputFile 添加水印并压缩后的图片保存位置。
     * @param watermarkText 要添加的水印文本。
     * @throws IOException 如果读取或写入文件发生错误。
     */
    private static void addWatermarkAndCompress(File originalFile, File outputFile,String watermarkText) throws IOException {
        // 读取原始图片
        BufferedImage originalImage = ImageIO.read(originalFile);
        // 添加水印
        BufferedImage watermarkedImage = addWatermark(originalImage, watermarkText);
        // 获取原图尺寸，以保持压缩后的图片尺寸与原图相同
        // 获取原图尺寸
        int originalWidth = originalImage.getWidth();
        int originalHeight = originalImage.getHeight();

        // 使用Thumbnails.of方法对添加水印后的图片进行缩放和压缩
        // 按比例缩放并压缩
        Thumbnails.of(watermarkedImage)
                .size(originalWidth, originalHeight)
                .outputQuality(0.4) // 调整画质压缩
                .toFile(outputFile);
    }


    /**
     * 给图片添加水印。
     *
     * @param image 原始图片。
     * @param watermarkText 水印文本。
     * @return 添加了水印的图片。
     */
    private static BufferedImage addWatermark(BufferedImage image, String watermarkText) {
        // 获取原始图片的宽度和高度
        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();
        // 创建Graphics2D对象，用于在图片上绘制水印
        // 创建用于绘制水印的Graphics2D对象
        Graphics2D g2d = (Graphics2D) image.getGraphics();
        // 设置透明度，使水印呈现半透明效果
        // 设置水印的属性
        AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f);
        g2d.setComposite(alphaChannel);
        // 设置水印文字颜色为灰色
        g2d.setColor(Color.GRAY);
        // 设置水印文字的字体、大小和样式
        // 使用支持中文的字体，例如SimHei（黑体）
        Font font = new Font("SimHei", Font.BOLD, 40);
        g2d.setFont(font);
        // 获取水印文字的尺寸信息
        FontMetrics fontMetrics = g2d.getFontMetrics();
        Rectangle2D rect = fontMetrics.getStringBounds(watermarkText, g2d);
        int textWidth = (int) rect.getWidth();
        int textHeight = (int) rect.getHeight();
        // 用于随机生成水印位置偏移量
        Random random = new Random();
        // 平铺方式添加水印，通过控制行间距和文字在行内的偏移，实现错落有致的布局效果
        // 平铺方式添加水印，单双行错开并随机偏移
        for (int y = 0; y < imageHeight; y += textHeight + 400) {
            // 判断当前行为偶数行还是奇数行，奇数行文字向右偏移
            boolean oddRow = (y / (textHeight + 400)) % 2 == 0;
            for (int x = oddRow ? 0 : textWidth / 2; x < imageWidth; x += textWidth + 600) {
                // 随机生成水平和垂直偏移量，使水印位置略有变化，避免整齐排列
                int xOffset = random.nextInt(200) - 100; // 随机偏移 -50 到 50 像素
                int yOffset = random.nextInt(100) - 50;  // 随机偏移 -25 到 25 像素
                // 在图片上绘制水印文字，位置略有偏移
                g2d.drawString(watermarkText, x + xOffset, y + yOffset);
            }
        }
        // 释放Graphics2D资源
        g2d.dispose();
        // 返回添加了水印的图片
        return image;
    }
}
