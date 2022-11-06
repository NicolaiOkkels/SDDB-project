package com.sd22.dbproject.services;

import com.sd22.dbproject.models.Tag;
import com.sd22.dbproject.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public List<Tag> getTags() {
        List<Tag> tags = new ArrayList<>();
        tagRepository.findAll().forEach(tags::add);
        return tags;
    }

    public void addTag(Tag tag) {
        tagRepository.save(tag);
    }

    public Optional<Tag> findTagById(int id) {
        return tagRepository.findById(id);
    }

    public void deleteTagById(int id) {
        tagRepository.deleteById(id);
    }
}
