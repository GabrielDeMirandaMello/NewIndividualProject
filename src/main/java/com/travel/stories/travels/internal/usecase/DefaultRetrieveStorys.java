package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.api.usecase.RetrieveStorys;
import com.travel.stories.travels.internal.entity.History;
import com.travel.stories.travels.internal.repository.StoryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@NoArgsConstructor
public class DefaultRetrieveStorys implements RetrieveStorys {

    @Autowired
    private StoryRepository storyRepository;

    @Override
    public ResponseEntity<List<History>> execute(String type, String filtrate, String buscar) {
        List<History> listStory = new ArrayList<>();
        if (type.equals("public")) {
            if (buscar != null) {
                return switch (filtrate) {
                    case "name" ->
                            ResponseEntity.status(HttpStatus.OK).body(this.storyRepository.findAllByNameUserContainsIgnoreCase(buscar));
                    case "title" ->
                            ResponseEntity.status(HttpStatus.OK).body(this.storyRepository.findAllByTitleContainsIgnoreCase(buscar));
                    case "description" ->
                            ResponseEntity.status(HttpStatus.OK).body(this.storyRepository.findAllByDescriptionContainsIgnoreCase(buscar));
                    default -> ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                };
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        }
        else {
            if (buscar != null) {
                return this.getList(
                        this.storyRepository.findAllByNameUserContainsIgnoreCase(type), filtrate, buscar);
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        }
    }

    private ResponseEntity<List<History>> getList(List<History> story,String filtrate, String buscar) {
        return switch (filtrate) {
            case "title" ->  ResponseEntity.status(HttpStatus.OK).body(this.addInListTitle(story, buscar, "title"));

            case "description" ->
                    ResponseEntity.status(HttpStatus.OK).body(this.addInListTitle(story, buscar, "description"));
            default -> ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        };
    }

    private List<History> addInListTitle(List<History> newListStory, String buscar, String filter) {
        List<History> listFiltrate = new ArrayList<>();
        if (filter.equals("title")) {
            for (History history : newListStory) {
                if (history.getTitle().contains(buscar)) {
                    listFiltrate.add(history);
                }
            }
        } else {
            for (History history : newListStory) {
                if (history.getDescription().contains(buscar)) {
                    listFiltrate.add(history);
                }
            }
        }
        return listFiltrate;
    }
}
