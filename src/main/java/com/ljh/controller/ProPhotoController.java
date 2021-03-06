package com.ljh.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ljh.domain.entity.InfoResult;
import com.ljh.domain.entity.po.ProPhoto;
import com.ljh.service.ProPhotoService;
import com.ljh.util.Utils;

@Controller
@RequestMapping("/prophoto")
public class ProPhotoController {

    @Autowired
    private ProPhotoService proPhotoService;

    @Value("${production.uploadphoto.savepath}")
    private String uploadPath;
    
    @Value("${production.uploadphoto.copypath}")
	private String copyPath;

    @PostMapping(value = "/uploadphoto/{proId}")
    @ResponseBody
    public InfoResult uploadPhoto(@PathVariable Long proId, MultipartFile photos, HttpServletRequest request) {
        String filename = photos.getOriginalFilename();
        String filePath = ClassUtils.getDefaultClassLoader().getResource("static").getPath() + uploadPath + proId + "/"
				+ filename;
		String copyPath1 = copyPath + proId + "/" + filename;
        try {
			File newfile = new File(filePath);
			File copyfile = new File(copyPath1);
			if (!newfile.getParentFile().exists()) {
				newfile.getParentFile().mkdirs();
			}
			if (!copyfile.getParentFile().exists()) {
				copyfile.getParentFile().mkdirs();
			}
			photos.transferTo(newfile);
			Utils.copyFile(newfile, copyfile);
			int i = proPhotoService.save(new ProPhoto(proId, filePath, filename));
			if (i <= 0) {
				newfile.delete();
				copyfile.delete();
			}
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new InfoResult(1, "uploading file fail");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new InfoResult(1, "uploading file fail");
        }
        return new InfoResult();
    }

    @DeleteMapping("/byProId/{proId}")
    @ResponseBody
    public InfoResult deleteByProId(@PathVariable Long proId) {
        String filePath = ClassUtils.getDefaultClassLoader().getResource("static").getPath() + uploadPath + proId + "/";
        File file = new File(filePath);
        List<ProPhoto> photos = proPhotoService.findAllByProId(proId);
        photos.forEach((item) -> {
            int i = proPhotoService.delete(item.getId());
            if (i > 0) {
                String url = item.getUrl();
                File deleteFile = new File(url);
                deleteFile.delete();
            }
        });
        System.out.println(file.delete());
        return new InfoResult();
    }
}
