package com.devpro.imageload.Image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public List<ImageEntity> getAllImages() {
        return imageRepository.findAll();
    }

    public ImageEntity getImageById(Long id) {
        return imageRepository.findById(id).orElse(null);
    }

    public void uploadImage(String imageName, MultipartFile file) throws IOException {
        ImageEntity image = new ImageEntity();
        image.setImageName(imageName);
        image.setImageData(file.getBytes());
        imageRepository.save(image);
    }

    public byte[] downloadImage(Long id) {
        ImageEntity image = imageRepository.findById(id).orElse(null);
        return (image != null) ? image.getImageData() : null;
    }
}
