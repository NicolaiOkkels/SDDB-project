package com.sd22.datasource.mysql.controller;

import com.sd22.datasource.mysql.entity.Tag;
import com.sd22.datasource.mysql.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class TagController {

    @Autowired
    private TagService tagService;

    //Get all tags
    @GetMapping("/")
    public ResponseEntity<List<Tag>> getTags() {
        List<Tag> tags = tagService.getTags();
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }

    //Add a review
    @PostMapping("/add")
    public ResponseEntity<Tag> addTag(@RequestBody Tag tag) {
        Tag newTag = tagService.addTag(tag);
        return new ResponseEntity<>(newTag,HttpStatus.CREATED);
    }

    //Find tag by id
    @GetMapping("/{id}")
    public ResponseEntity<Tag> findTagById(@PathVariable int id) {
        Tag tag = tagService.findTagById(id);
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

    //DELETE tag by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Tag> delete(@PathVariable("id") int id) {
        tagService.deleteTagById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //PUT, update by id
    @PutMapping("/update")
    public ResponseEntity<Tag> update(@RequestBody Tag tag) {
        Tag updateTag = tagService.updateTag(tag);
        return new ResponseEntity<>(updateTag, HttpStatus.OK);
    }
}
