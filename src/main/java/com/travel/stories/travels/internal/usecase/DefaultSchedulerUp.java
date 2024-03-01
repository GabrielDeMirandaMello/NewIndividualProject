package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.internal.entity.History;
import com.travel.stories.travels.internal.entity.User;
import com.travel.stories.travels.internal.repository.HistoryRepository;
import com.travel.stories.travels.internal.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class DefaultSchedulerUp {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HistoryRepository historyRepository;

    @Scheduled(cron = "0 0/1 * 1/1 * ? *")
    public void UpSystem(){
        List<User> allUser = userRepository.findAll();
        List<History> allStory = historyRepository.findAll();
        System.out.println(allUser);
        System.out.println(allStory);
    }
}
