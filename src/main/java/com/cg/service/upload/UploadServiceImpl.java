package com.cg.service.upload;

import com.cloudinary.Cloudinary;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class UploadServiceImpl implements IUploadService {

    private final Cloudinary cloudinary;

    @Override
    public Map uploadImage(MultipartFile multipartFile, Map options) throws IOException {
        return cloudinary.uploader().upload(multipartFile.getBytes(), options);
    }

    @Override
    public Map destroyImage(String publicId, Map options) throws IOException {
        return cloudinary.uploader().destroy(publicId, options);
    }

}
