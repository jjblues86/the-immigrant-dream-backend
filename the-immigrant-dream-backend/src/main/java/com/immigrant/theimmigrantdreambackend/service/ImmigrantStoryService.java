package com.immigrant.theimmigrantdreambackend.service;

import com.immigrant.theimmigrantdreambackend.payload.ImmigrantStoryDto;

import java.util.List;

public interface ImmigrantStoryService {
    List<ImmigrantStoryDto> getImmigrantStoriesList();
    ImmigrantStoryDto saveImmigrantStory(ImmigrantStoryDto immigrantStoryDto);
    ImmigrantStoryDto getImmigrantStoryById(String id);
    ImmigrantStoryDto updateImmigrantStory(String id, ImmigrantStoryDto immigrantStoryDto);
    void deleteImmigrantStory(String id);
}
