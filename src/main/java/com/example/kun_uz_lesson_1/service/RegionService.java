package com.example.kun_uz_lesson_1.service;

import com.example.kun_uz_lesson_1.dto.RegionDTO;
import com.example.kun_uz_lesson_1.entity.RegionEntity;
import com.example.kun_uz_lesson_1.enums.AppLanguage;
import com.example.kun_uz_lesson_1.exp.AppBadException;
import com.example.kun_uz_lesson_1.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public RegionDTO create(RegionDTO regionDTO) {
        Optional<RegionEntity> optionalRegion = regionRepository.findAllByOrderNumber(regionDTO.getOrder_number());
        if (optionalRegion.isPresent()) {
            throw new AppBadException("Order_number is wrong");
        }
        RegionEntity regionEntity = new RegionEntity();
        regionEntity.setName_uz(regionDTO.getName_uz());
        regionEntity.setName_ru(regionDTO.getName_ru());
        regionEntity.setName_en(regionDTO.getName_en());
        regionEntity.setOrderNumber(regionDTO.getOrder_number());
        regionRepository.save(regionEntity);
        return regionDTO;
    }

    public RegionDTO toDTO(RegionEntity regionEntity){
        RegionDTO regionDTO = new RegionDTO();
        regionDTO.setId(regionEntity.getId());
        regionDTO.setName_uz(regionEntity.getName_uz());
        regionDTO.setName_ru(regionEntity.getName_ru());
        regionDTO.setName_en(regionEntity.getName_en());
        regionDTO.setVisible(regionEntity.getVisible());
        regionDTO.setCreatedDate(regionEntity.getCreatedDate());
        regionDTO.setUpdatedDate(regionEntity.getUpdatedDate());
        regionDTO.setOrder_number(regionEntity.getOrderNumber());
        return regionDTO;
    }

    public List<RegionDTO> getAll() {
        List<RegionEntity> regionEntities = regionRepository.findAll();
        List<RegionDTO> regionDTOS = new LinkedList<>();
        if (!regionEntities.isEmpty()){
            for (RegionEntity regionEntity : regionEntities){
                regionDTOS.add(toDTO(regionEntity));
            }
            return regionDTOS;
        }
        throw new AppBadException("RegionEntity yo'q");
    }
    public RegionDTO getById(Integer id) {
        Optional<RegionEntity> optionalRegion = regionRepository.findById(id);
        if (optionalRegion.isEmpty()){
            throw new AppBadException("ushbu id li RegionEntity yo'q");
        }
        RegionEntity regionEntity = optionalRegion.get();
        return toDTO(regionEntity);
    }
    public RegionDTO updateById(Integer id,RegionDTO regionDTO) {
        Optional<RegionEntity> optionalRegion = regionRepository.findById(id);
        if (optionalRegion.isEmpty()){
            throw new AppBadException("bunday id li RegionEntity yo'q ");
        }
        RegionEntity regionEntity = optionalRegion.get();
        regionEntity.setName_uz(regionDTO.getName_uz());
        regionEntity.setName_ru(regionDTO.getName_ru());
        regionEntity.setName_en(regionDTO.getName_en());
        regionEntity.setOrderNumber(regionDTO.getOrder_number());
        regionRepository.save(regionEntity);
        return regionDTO;
    }
    public Boolean deleteById(Integer id){
        try {
            regionRepository.deleteById(id);
            return true;
        }
        catch (AppBadException e){
            return false;
        }
    }

    public List<RegionDTO> getByLang(AppLanguage lang) {
        Iterable<RegionEntity> entityList = regionRepository.findAll();

        List<RegionDTO> dtoList = new LinkedList<>();

        for (RegionEntity entity : entityList) {
            RegionDTO dto = new RegionDTO();
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
