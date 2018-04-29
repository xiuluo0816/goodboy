package com.novel.basic.cms.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	public static String saveFile(MultipartFile myfile, String realPath) {

		File tmp = new File(realPath, myfile.getOriginalFilename());
		if (tmp.exists()) {
			return "上传失败，当前目录下" + myfile.getOriginalFilename() + "已存在！";
		} else {
			try {
				FileUtils.copyInputStreamToFile(myfile.getInputStream(), tmp);
			} catch (IOException e) {
				e.printStackTrace();
				return e.getMessage();
			}
			return "";
		}
	}

	/**
	 * 删除单个文件
	 * 
	 * @param sPath
	 *            被删除文件的文件名
	 * @return 单个文件删除成功返回true，否则返回false
	 */
	public static String deleteFile(String sPath) {
		File file = new File(sPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
			return "";
		} else {
			return "";
		}
	}
}
