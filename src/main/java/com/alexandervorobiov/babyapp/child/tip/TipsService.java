package com.alexandervorobiov.babyapp.child.tip;

import com.alexandervorobiov.babyapp.superUser.SuperUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TipsService {

    private final FoodTipsRepository tipRepository;

    public void setTips(SuperUserDto superUser) {
        superUser.getChildren().forEach(child -> child.getTips().addAll(tipRepository.findForTips(child.getAge())
                .stream()
                .map(tip -> new FoodTipDto(tip.getDescription()))
                .collect(Collectors.toList())));
    }
}
