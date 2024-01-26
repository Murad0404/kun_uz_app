package com.example.kun_uz_lesson_1.service;

import com.example.kun_uz_lesson_1.dto.ArticleTypeDTO;
import com.example.kun_uz_lesson_1.dto.RegionDTO;
import com.example.kun_uz_lesson_1.entity.ArticleTypeEntity;
import com.example.kun_uz_lesson_1.entity.RegionEntity;
import com.example.kun_uz_lesson_1.enums.AppLanguage;
import com.example.kun_uz_lesson_1.exp.AppBadException;
import com.example.kun_uz_lesson_1.repository.ArticleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleTypeService {
    @Autowired
    private ArticleTypeRepository articleTypeRepository;
    public void create(ArticleTypeDTO articleTypeDTO) {
        Optional<ArticleTypeEntity> optionalArticleType = articleTypeRepository.findAllByOrderNumber(articleTypeDTO.getOrder_number());
        if (optionalArticleType.isPresent()) {
            throw new AppBadException("Order_number is wrong");
        }
        ArticleTypeEntity articleTypeEntity = new ArticleTypeEntity();
        articleTypeEntity.setName_uz(articleTypeDTO.getName_uz());
        articleTypeEntity.setName_ru(articleTypeDTO.getName_ru());
        articleTypeEntity.setName_en(articleTypeDTO.getName_en());
        articleTypeEntity.setOrderNumber(articleTypeDTO.getOrder_number());
        articleTypeRepository.save(articleTypeEntity);
    }

    public ArticleTypeDTO toDTO(ArticleTypeEntity articleTypeEntity){
        ArticleTypeDTO articleTypeDTO = new ArticleTypeDTO();
        articleTypeDTO.setId(articleTypeEntity.getId());
        articleTypeDTO.setName_uz(articleTypeEntity.getName_uz());
        articleTypeDTO.setName_ru(articleTypeEntity.getName_ru());
        articleTypeDTO.setName_en(articleTypeEntity.getName_en());
        articleTypeDTO.setVisible(articleTypeEntity.getVisible());
        articleTypeDTO.setCreatedDate(articleTypeEntity.getCreatedDate());
        articleTypeDTO.setUpdatedDate(articleTypeEntity.getUpdatedDate());
        articleTypeDTO.setOrder_number(articleTypeEntity.getOrderNumber());
        return articleTypeDTO;
    }

    public List<ArticleTypeDTO> getAll() {
        List<ArticleTypeEntity> articleTypeEntities = articleTypeRepository.findAll();
        List<ArticleTypeDTO> articleTypeDTOS = new LinkedList<>();
        if (!articleTypeEntities.isEmpty()){
            for (ArticleTypeEntity articleType : articleTypeEntities){
               articleTypeDTOS.add(toDTO(articleType));
            }
            return articleTypeDTOS;
        }
        throw new AppBadException("ArticleTypeEntity yo'q");
    }

    public List<ArticleTypeDTO> getAllPage(Integer page,Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<ArticleTypeEntity> articleTypeEntities = articleTypeRepository.findAll(pageable);
        List<ArticleTypeDTO> articleTypeDTOS = new LinkedList<>();
        if (!articleTypeEntities.isEmpty()){
            for (ArticleTypeEntity articleType : articleTypeEntities){
                articleTypeDTOS.add(toDTO(articleType));
            }
            return articleTypeDTOS;
        }
        throw new AppBadException("ArticleTypeEntity yo'q");
    }
    public ArticleTypeDTO getById(Integer id) {
        Optional<ArticleTypeEntity> optionalArticleTypeEntity = articleTypeRepository.findById(id);
        if (optionalArticleTypeEntity.isEmpty()){
            throw new AppBadException("ushbu id li ArticleTypeEntity yo'q");
        }
        ArticleTypeEntity articleTypeEntity = optionalArticleTypeEntity.get();
        return toDTO(articleTypeEntity);
    }
    public ArticleTypeDTO updateById(Integer id,ArticleTypeDTO articleTypeDTO) {
        Optional<ArticleTypeEntity> optionalArticleType = articleTypeRepository.findById(id);
        if (optionalArticleType.isEmpty()){
            throw new AppBadException("bunday id li ArticleTypeEntity yo'q ");
        }
        ArticleTypeEntity articleTypeEntity = optionalArticleType.get();
        articleTypeEntity.setName_uz(articleTypeDTO.getName_uz());
        articleTypeEntity.setName_ru(articleTypeDTO.getName_ru());
        articleTypeEntity.setName_en(articleTypeDTO.getName_en());
        articleTypeEntity.setOrderNumber(articleTypeDTO.getOrder_number());
        articleTypeRepository.save(articleTypeEntity);
        return articleTypeDTO;
    }
    public Boolean deleteById(Integer id){
        try {
            articleTypeRepository.deleteById(id);
            return true;
        }
        catch (AppBadException e){
            return false;
        }
    }

    public List<ArticleTypeDTO> getByLang(AppLanguage lang) {
        Iterable<ArticleTypeEntity> entityList = articleTypeRepository.findAll();

        List<ArticleTypeDTO> dtoList = new LinkedList<>();

        for (ArticleTypeEntity entity : entityList) {
            ArticleTypeDTO dto = new ArticleTypeDTO();
            dto.setId(entity.getId());
            switch (lang) {
                case uz -> dto.setName(entity.getName_uz());
                case ru -> dto.setName(entity.getName_ru());
                default -> dto.setName(entity.getName_en());
            }
            dtoList.add(dto);
        }
        return dtoList;
    }
}
