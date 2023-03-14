package com.immigrant.theimmigrantdreambackend.controller;

import com.immigrant.theimmigrantdreambackend.payload.ImmigrantStoryDto;
import com.immigrant.theimmigrantdreambackend.service.ImmigrantStoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/immigrant")
public class ImmigrantStoryController {

    private final ImmigrantStoryService immigrantStoryService;

    /**
     * Save an Immigrant story object.
     * @param immigrantStoryDto
     * @return Saved story of an Immigrant story object.
     */
    @PostMapping("/story")
    public ResponseEntity<ImmigrantStoryDto> addImmigrantStory(@Valid @RequestBody final ImmigrantStoryDto immigrantStoryDto) {
        final ImmigrantStoryDto savedStory = immigrantStoryService.saveImmigrantStory(immigrantStoryDto);

        return new ResponseEntity<>(savedStory, HttpStatus.CREATED);
    }

    /**
     * Get an Immigrant story object.
     * @param id The Immigrant story ID.
     * @return Immigrant Story object
     */
    @GetMapping("/story/{id}")
    public ResponseEntity<ImmigrantStoryDto> getImmigrantStoryById(@PathVariable("id") final String id) {
        return ResponseEntity.ok(immigrantStoryService.getImmigrantStoryById(id));
    }

    /**
     * Lists all Immigrant Stories.
     * @return Lists of all Immigrant Stories.
     */
    @GetMapping("/stories")
    public ResponseEntity<List<ImmigrantStoryDto>> getListsOfImmigrantStories() {
        return ResponseEntity.ok(immigrantStoryService.getImmigrantStoriesList());
    }

    /**
     * Updates an Immigrant story.
     * @param id The Immigrant story ID.
     * @param immigrantStoryDto The ImmigrantStoryDto object.
     * @return The updated Immigrant story.
     */
    @PutMapping("/story/{id}")
    public ResponseEntity<ImmigrantStoryDto> updateImmigrantStoryById(@PathVariable("id") String id, @Valid @RequestBody final ImmigrantStoryDto immigrantStoryDto) {
        return ResponseEntity.ok(immigrantStoryService.updateImmigrantStory(id, immigrantStoryDto));
    }

    /**
     * Deletes an Immigrant profile.
     * @param id The Immigrant story ID.
     * @return A success message.
     */
    @DeleteMapping("/story/{id}")
    public ResponseEntity<String> deleteImmigrantStoryById(@PathVariable("id") String id) {
        immigrantStoryService.deleteImmigrantStory(id);
        return new ResponseEntity<>("Immigrant Profile was successfully deleted", HttpStatus.OK);
    }

}
