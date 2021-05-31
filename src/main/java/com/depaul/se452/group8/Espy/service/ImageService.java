package com.depaul.se452.group8.Espy.service;

import com.depaul.se452.group8.Espy.model.Images;
import com.depaul.se452.group8.Espy.repository.ImagesRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {
    @Autowired
    private ImagesRepository imagesRepository;

    public void addImageAndCaptionToUser(Integer userId, MultipartFile imageFile, String caption) throws IOException {
        Images images = new Images();
        images.setCaption(caption);
        images.setImageBase64(convertByteArrayToBase64String(imageFile.getBytes()));
        images.setUserId(userId);
        images.setCreatedAt(LocalDateTime.now());
        images.setUpdatedAt(LocalDateTime.now());
        imagesRepository.save(images);
    }

    public List<Images> getAllImagesByUserId(Integer userId) {
        List<Images> filteredImages = new ArrayList<>();
        for (Images image: imagesRepository.findAll()) {
            if (image.getUserId().equals(userId))
                filteredImages.add(image);
        }
        return filteredImages;
    }

    public String convertByteArrayToBase64String(byte[] bytes) {
        return new String(Base64.encodeBase64(bytes));
    }
}
