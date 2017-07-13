package com.example.ueditor.upload;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;



import com.example.ueditor.PathFormat;
import com.example.ueditor.define.AppInfo;
import com.example.ueditor.define.BaseState;
import com.example.ueditor.define.FileType;
import com.example.ueditor.define.State;
import org.apache.tomcat.util.codec.binary.Base64;


public class Base64Uploader {
	
	public State save(HttpServletRequest request, Map<String, Object> conf) {
	    String filedName = (String) conf.get("fieldName");
		String fileName = request.getParameter(filedName);
		byte[] data = decode(fileName);

		long maxSize = ((Long) conf.get("maxSize")).longValue();

		if (!validSize(data, maxSize)) {
			return new BaseState(false, AppInfo.MAX_SIZE);
		}

		String suffix = FileType.getSuffix("JPG");

		String savePath = PathFormat.parse((String) conf.get("savePath"),
				(String) conf.get("filename"));
		
		savePath = savePath + suffix;
//		String rootPath = ConfigManager.getRootPath(request,conf);
		String rootPath = "";
		String physicalPath = rootPath + savePath;

		State storageState = StorageManager.saveBinaryFile(data, physicalPath);

		if (storageState.isSuccess()) {
			storageState.putInfo("url", PathFormat.format(savePath));
			storageState.putInfo("type", suffix);
			storageState.putInfo("original", "");
		}

		return storageState;
	}

	private byte[] decode(String content) {
		return Base64.decodeBase64(content);
	}

	private boolean validSize(byte[] data, long length) {
		return data.length <= length;
	}
	
}