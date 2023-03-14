package com.immigrant.theimmigrantdreambackend.controller;

import com.immigrant.theimmigrantdreambackend.payload.ImmigrantBusinessDto;
import com.immigrant.theimmigrantdreambackend.service.ImmigrantBusinessService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/immigrant")
@RequiredArgsConstructor
public class ImmigrantBusinessController {
    private final ImmigrantBusinessService immigrantBusinessService;

    /**
     * Add new Immigrant business profile object.
     * @param immigrantBusinessDto
     * @return Immigrant business object profile.
     */
    @PostMapping("/business")
    public ResponseEntity<ImmigrantBusinessDto> addImmigrantBusiness(@Valid @RequestBody final ImmigrantBusinessDto immigrantBusinessDto) {
        return new ResponseEntity<>(immigrantBusinessService.saveImmigrantBusiness(immigrantBusinessDto), HttpStatus.CREATED);
    }

    /**
     * Retrieve an Immigrant business profile object.
     * @param id The Immigrant business profile ID.
     * @return Immigrant business profile object.
     */
    @GetMapping("{id}")
    public ResponseEntity<ImmigrantBusinessDto> getImmigrantBusinessById(@PathVariable("id") final String id) {
        return ResponseEntity.ok(immigrantBusinessService.getImmigrantBusinessById(id));
    }

    /**
     * Lists of all Immigrant businesses.
     * @return Immigrant businesses.
     */
    @GetMapping("/businesses")
    public ResponseEntity<List<ImmigrantBusinessDto>> getListOfImmigrantBusinesses() {
        return ResponseEntity.ok(immigrantBusinessService.getImmigrantBusinessList());
    }

    /**
     * Updates an Immigrant business profile object.
     * @param id The Immigrant business profile ID.
     * @param immigrantBusinessDto The ImmigrantBusinessDto object.
     * @return Immigrant business profile object.
     */
    @PutMapping("{id}")
    public ResponseEntity<ImmigrantBusinessDto> updateImmigrantBusinessById(@Valid @PathVariable("id") final String id,
                                                                            final ImmigrantBusinessDto immigrantBusinessDto) {
        return ResponseEntity.ok(immigrantBusinessService.updateImmigrantBusiness(id, immigrantBusinessDto));
    }

    /**
     * Deletes an Immigrant business profile object.
     * @param id Immigrant business profile ID.
     * @return Immigrant business profile object.
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteImmigrantBusinessById(@PathVariable("id") final String id) {
        immigrantBusinessService.deleteImmigrantBusiness(id);

        return new ResponseEntity<>("Immigrant Business Profile successfully deleted.", HttpStatus.OK);
    }
}
