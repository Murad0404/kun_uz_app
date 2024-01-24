package com.example.kun_uz_lesson_1.service;

import com.example.kun_uz_lesson_1.dto.ArticleTypeDTO;
import com.example.kun_uz_lesson_1.entity.ArticleTypeEntity;
import com.example.kun_uz_lesson_1.exp.AppBadException;
import com.example.kun_uz_lesson_1.repository.ArticleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleTypeService {
    @Autowired
    private ArticleTypeRepository articleTypeRepository;
    public void create(ArticleTypeDTO articleTypeDTO) {
        Optional<ArticleTypeEntity> optionalArticleType = articleTypeRepository.findAllByOrder_number(articleTypeDTO.getOrder_number());
        if (optionalArticleType.isEmpty()) {
            throw new AppBadException("Order_number is wrong");
        }
        ArticleTypeEntity articleTypeEntity = new ArticleTypeEntity();
        articleTypeEntity.setName_uz(articleTypeDTO.getName_uz());
        articleTypeEntity.setName_ru(articleTypeEntity.getName_ru());
        articleTypeEntity.setName_en(articleTypeEntity.getName_en());
        articleTypeEntity.setOrder_number(articleTypeEntity.getOrder_number());
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
        articleTypeDTO.setOrder_number(articleTypeEntity.getOrder_number());
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
    public ArticleTypeDTO getById(Integer id) {
        Optional<ArticleTypeEntity> optionalArticleTypeEntity = articleTypeRepository.findById(id);
        if (optionalArticleTypeEntity.isEmpty()){
            throw new AppBadException("ushbu id li ArticleTypeEntity yo'q");
        }
        ArticleTypeEntity articleTypeEntity = optionalArticleTypeEntity.get();
        ArticleTypeDTO articleTypeDTO = new ArticleTypeDTO();
        articleTypeDTO.setId(articleTypeEntity.getId());
        articleTypeDTO.setName_uz(articleTypeEntity.getName_uz());
        articleTypeDTO.setName_ru(articleTypeEntity.getName_ru());
        articleTypeDTO.setName_en(articleTypeEntity.getName_en());
        articleTypeDTO.setVisible(articleTypeEntity.getVisible());
        articleTypeDTO.setCreatedDate(articleTypeEntity.getCreatedDate());
        articleTypeDTO.setUpdatedDate(articleTypeEntity.getUpdatedDate());
        articleTypeDTO.setOrder_number(articleTypeEntity.getOrder_number());
        return articleTypeDTO;
    }
    public ArticleTypeDTO updateById(Integer id,ArticleTypeDTO articleTypeDTO) {
        Optional<ArticleTypeEntity> optionalArticleType = articleTypeRepository.findById(id);
        if (optionalArticleType.isEmpty()){
            throw new AppBadException("bunday id li ArticleTypeEntity yo'q ");
        }
        ArticleTypeEntity articleTypeEntity = new ArticleTypeEntity();
        articleTypeEntity.setName_uz(articleTypeDTO.getName_uz());
        articleTypeEntity.setName_ru(articleTypeEntity.getName_ru());
        articleTypeEntity.setName_en(articleTypeEntity.getName_en());
        articleTypeEntity.setOrder_number(articleTypeEntity.getOrder_number());
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
}
