package com.briup.smart.common.utils.multipart;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

import org.springframework.web.multipart.MultipartFile;

import com.briup.smart.web.vm.FieldError;

public class FileUpLoad {
	public String uploadPicture(MultipartFile file) {
		Collection<FieldError> fs = new HashSet<>();

		System.out.println("file:" + file);
		System.out.println("fileName:" + file.getName());

		// 定义上传文件的存放位置
		String filePath = "D:\\uploadPicture\\";
		// 判断文件夹是否存在,不存在则创建
		File file1 = new File(filePath);
		if (!file1.exists()) {
			file1.mkdirs();
		}

		// 获取上传文件的名字
		String fileName = file.getOriginalFilename();
		Random random = new Random();
		int num = 1 + random.nextInt(100000);
		fileName = num + fileName;
		// 设置路径 父路径名字符串 ,文件名
		File dest = new File(filePath, fileName);
		// 转储
		try {
			System.out.println("保存图片：" + dest);
			file.transferTo(dest);
			System.out.println("上传图片成功");
		} catch (IllegalStateException e) {
			fs.add(new FieldError("error", "非法状态"));
		} catch (IOException e) {
			fs.add(new FieldError("error", "输入异常"));
		}

		String path = filePath + fileName;
		System.out.println("图片path：" + path);
		return path;
	}
}
