package com.ljh.service;

import java.util.List;

import com.ljh.domain.entity.po.ProPhoto;

public interface ProPhotoService {
    List<ProPhoto> findAllByProId(long proId);

    int save(ProPhoto p);

    void edit(ProPhoto p);

    int delete(Long id);

    int deleteByProId(long proId);
}
