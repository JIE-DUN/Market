package com.li.utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.li.entity.Item;

public class FileUploadUtil {
	
	/**
     * 新增和更新的公共方法
     */
    public static void itemCommon(Item item,CommonsMultipartFile[] files, HttpServletRequest request) throws IOException {
        if(files.length>0) {
            for (int s = 0; s < files.length; s++) {
            	if(files[s].getOriginalFilename() != null && files[s].getOriginalFilename() != ""){
            		String n = UUIDUtils.create();
            		String path = SystemContext.getRealPath() + Consts.ITEMUPLOAD + n + files[s].getOriginalFilename();
            		File newFile = new File(path);
            		//通过CommonsMultipartFile的方法直接写文件
            		files[s].transferTo(newFile);
            		if (s == 0) {
            			item.setUrl1(request.getContextPath()+Consts.ITEMUPLOAD + n + files[s].getOriginalFilename());
            		}
            		if (s == 1) {
            			item.setUrl2(request.getContextPath()+Consts.ITEMUPLOAD + n + files[s].getOriginalFilename());
            		}
            		if (s == 2) {
            			item.setUrl3(request.getContextPath()+Consts.ITEMUPLOAD + n + files[s].getOriginalFilename());
            		}
            		if (s == 3) {
            			item.setUrl4(request.getContextPath()+Consts.ITEMUPLOAD + n + files[s].getOriginalFilename());
            		}
            		if (s == 4) {
            			item.setUrl5(request.getContextPath()+Consts.ITEMUPLOAD + n + files[s].getOriginalFilename());
            		}
            	}
            }
        }
    }
}
