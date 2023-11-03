package com.cg.product;

import com.cg.exception.DataInputException;
import com.cg.model.Category;
import com.cg.model.Product;
import com.cg.model.ProductAvatar;
import com.cg.product.DTO.ProductCreReqDTO;
import com.cg.product.DTO.ProductDTO;
import com.cg.product.DTO.ProductUpReqDTO;
import com.cg.productAvatar.ProductAvatarRepository;
import com.cg.service.upload.IUploadService;
import com.cg.utils.UploadUtils;
import com.cg.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductAvatarRepository productAvatarRepository;

    @Autowired
    private IUploadService uploadService;

    @Autowired
    private UploadUtils uploadUtils;

    @Autowired
    private ValidateUtils validateUtils;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }



    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public ProductDTO createProduct(ProductCreReqDTO productCreReqDTO, Category category) {
        ProductAvatar productAvatar = new ProductAvatar();
        productAvatarRepository.save(productAvatar);

        uploadAndSaveProductImage(productCreReqDTO, productAvatar);

        Product product = productCreReqDTO.toProduct(category);

        product.setProductAvatar(productAvatar);
        productRepository.save(product);

        return new ProductDTO().toDTO(product);
    }

    @Override
    public List<ProductDTO> findAllProductDTO() {
        return productRepository.findAllByDeletedIsFalse().stream().map(Product::toDTO).collect(Collectors.toList());
    }

    @Override
    public ProductDTO update(Long id, ProductUpReqDTO productUpReqDTO, Category category) {
        ProductAvatar productAvatar = new ProductAvatar();
        productAvatarRepository.save(productAvatar);

        uploadAndSaveProductImage(productUpReqDTO.toDTO(), productAvatar);

        Product productUpdate = productUpReqDTO.toProductChangeImage(category);
        productUpdate.setId(id);
        productUpdate.setProductAvatar(productAvatar);
        productRepository.save(productUpdate);
        return new ProductDTO().toDTO(productUpdate);
    }

    @Override
    public void deleteByIdTrue(Product product) {
        product.setDeleted(true);
        productRepository.save(product);
    }

    @Override
    public List<ProductDTO> findAllByCategoryLike(Long categoryId) {
        return productRepository.findAllByCategoryLike(categoryId);
    }

    @Override
    public List<ProductDTO> findProductByName(String keySearch) {
        return productRepository.findProductByName(keySearch);
    }

    @Override
    public List<ProductDTO> findAllByCategoryLikeAndAndTitleLike(Long categoryId, String keySearch) {
        return productRepository.findAllByCategoryLikeAndAndTitleLike(categoryId,keySearch);
    }

    @Override
    public Page<ProductDTO> findAllProductDTOPage(Pageable pageable) {
         return productRepository.findAllProductDTOPage(pageable);
    }

    @Override
    public Optional<Product> findByIdAndDeletedFalse(Long id) {
        return productRepository.findByIdAndDeletedFalse(id);
    }

    private void uploadAndSaveProductImage(ProductCreReqDTO productCreReqDTO, ProductAvatar productAvatar) {
        try {
            Map uploadResult = uploadService.uploadImage(productCreReqDTO.getAvatar(), uploadUtils.buildImageUploadParams(productAvatar));
            String fileUrl = (String) uploadResult.get("secure_url");
            String fileFormat = (String) uploadResult.get("format");

            productAvatar.setFileName(productAvatar.getId() + "." + fileFormat);
            productAvatar.setFileUrl(fileUrl);
            productAvatar.setFileFolder(UploadUtils.IMAGE_UPLOAD_FOLDER);
            productAvatar.setCloudId(productAvatar.getFileFolder() + "/" + productAvatar.getId());
            productAvatarRepository.save(productAvatar);

        } catch (IOException e) {
            e.printStackTrace();
            throw new DataInputException("Upload hình ảnh thất bại");
        }
    }


}
