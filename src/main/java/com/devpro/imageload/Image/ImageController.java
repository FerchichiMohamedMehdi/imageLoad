package com.devpro.imageload.Image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping
    public List<ImageEntity> getAllImages() {
        return imageService.getAllImages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable Long id) {
        byte[] imageData = imageService.downloadImage(id);
        return ResponseEntity.ok().body(imageData);
    }

    @PostMapping("/upload")
    public void uploadImage(@RequestParam("imageName") String imageName, @RequestParam("file") MultipartFile file) throws IOException {
        imageService.uploadImage(imageName, file);
    }
}

