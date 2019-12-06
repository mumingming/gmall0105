package com.atguigu.gmall.manage.util;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class PmsUploadUtil {


    public static String uploadImage(MultipartFile multipartFile) {

        String imgUrl =  "http://192.168.199.128";

        // 上传图片到服务器
        // 配置fdfs的全局链接地址    PmsUploadUtil.class方法名   （反射）
        String tracker = PmsUploadUtil.class.getResource("/tracker.conf").getPath();// 获得配置文件的路径

        try {
            //创建客户端连接括号内是路径
            ClientGlobal.init(tracker);
        } catch (Exception e) {
            e.printStackTrace();
        }

        TrackerClient trackerClient = new TrackerClient();

        // 获得一个trackerServer的实例
        TrackerServer trackerServer = null;
        try {
            trackerServer = trackerClient.getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 通过tracker获得一个Storage链接客户端
        StorageClient storageClient = new StorageClient(trackerServer,null);

        try {

            byte[] bytes = multipartFile.getBytes();// 获得上传的二进制对象

            // 获得文件后缀名
            String originalFilename = multipartFile.getOriginalFilename();// a.jpg   先获得文件的全名
            System.out.println(originalFilename);
            int i = originalFilename.lastIndexOf(".");//获取最后一个点的下标
            String extName = originalFilename.substring(i+1);//进行截取
            //第一个参数是要上传的文件名，第二个是文件扩展名，第三个源数据列表
            String[] uploadInfos = storageClient.upload_file(bytes, extName, null);

            for (String uploadInfo : uploadInfos) {
                imgUrl += "/"+uploadInfo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imgUrl;
    }
}
