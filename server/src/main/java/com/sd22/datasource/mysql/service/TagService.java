package com.sd22.datasource.mysql.service;

import com.sd22.datasource.mysql.entity.Tag;
import com.sd22.datasource.mysql.repository.TagRepository;
import com.sd22.datasource.mysql.service.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public List<Tag> getTags() {
        List<Tag> tags = new ArrayList<>();
        tagRepository.findAll().forEach(tags::add);
        return tags;
    }

    public Tag addTag(Tag tag) {
       return tagRepository.save(tag);
    }

    public Tag findTagById(int id) {
        return tagRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteTagById(int id) {
        tagRepository.deleteById(id);
    }

    public Tag updateTag(Tag tag){
        return tagRepository.save(tag);
    }
}
