package com.sd22.datasource.mysql.service;

import com.sd22.datasource.mysql.entity.Tag;
import com.sd22.datasource.mysql.repository.TagRepository;
import com.sd22.datasource.mysql.service.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    @Transactional("mysqlTransactionManager")
    public List<Tag> getTags() {
        List<Tag> tags = new ArrayList<>();
        tagRepository.findAll().forEach(tags::add);
        return tags;
    }

    @Transactional("mysqlTransactionManager")
    public Tag addTag(Tag tag) {
       return tagRepository.save(tag);
    }

    @Transactional("mysqlTransactionManager")
    public Tag findTagById(int id) {
        return tagRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional("mysqlTransactionManager")
    public void deleteTagById(int id) {
        tagRepository.deleteById(id);
    }

    @Transactional("mysqlTransactionManager")
    public Tag updateTag(Tag tag){
        return tagRepository.save(tag);
    }
}
