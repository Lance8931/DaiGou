package com.ljh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljh.domain.entity.po.ProPhoto;
import com.ljh.domain.mapper.ProPhotoMapper;
import com.ljh.service.ProPhotoService;

@Service
public class ProPhotoServiceImpl implements ProPhotoService {

    @Autowired
    private ProPhotoMapper proPhotoMapper;

    @Override
    public int save(ProPhoto p) {
        return proPhotoMapper.insertByProPhoto(p);
    }

    @Override
    public void edit(ProPhoto p) {
        proPhotoMapper.update(p);
    }

    @Override
    public List<ProPhoto> findAllByProId(long proId) {
        return proPhotoMapper.findAllByProId(proId);
    }

    @Override
    public int deleteByProId(long proId) {
        return proPhotoMapper.deleteByProId(proId);
    }

    @Override
    public int delete(Long Id) {
        return proPhotoMapper.delete(Id);
    }

}
