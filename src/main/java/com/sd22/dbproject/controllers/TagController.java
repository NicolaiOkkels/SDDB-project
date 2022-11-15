package com.sd22.dbproject.controllers;

import com.sd22.dbproject.entities.Tag;
import com.sd22.dbproject.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    //Get all tag
    @GetMapping("/")
    public List<Tag> getTags() {
        return tagService.getTags();
    }

    //Add a tag
    @PostMapping("/add")
    public void addTag(@RequestBody Tag tag) {
        tagService.addTag(tag);
    }

    //Find tag by id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Tag>> findCountryById(@PathVariable int id) {
            Optional<Tag> tag = tagService.findTagById(id);
            if (tag.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(tag);
            } else {
                return ResponseEntity.ok(tag);
            }
    }

    //DELETE tag by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<Tag>> delete(@PathVariable("id") int id) {
        Optional<Tag> tag = tagService.findTagById(id);
        if (tag.isEmpty()) {
            //id does not exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(tag);
        }
        tagService.deleteTagById(id);

        return ResponseEntity.ok(tag);
    }
    //PUT,update by id
    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<Tag>> update(@PathVariable("id") int id, @RequestBody Tag requestTag) {
        Optional<Tag> tag = tagService.findTagById(id);
        if (tag.isEmpty()) {
            //id does not exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(tag);
        }
        tagService.updateTag(requestTag);

        return ResponseEntity.ok(tag);
    }

}
