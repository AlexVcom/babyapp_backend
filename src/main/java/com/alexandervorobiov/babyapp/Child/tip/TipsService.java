package com.alexandervorobiov.babyapp.Child.tip;

import com.alexandervorobiov.babyapp.Child.hint.HintDto;
import com.alexandervorobiov.babyapp.Child.hint.HintRepository;
import com.alexandervorobiov.babyapp.SuperUser.SuperUserRepo;
import com.alexandervorobiov.babyapp.SuperUser.dto.SuperUserDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@Data
@RequiredArgsConstructor
public class TipsService {

    private final FoodTipsRepository tipRepository;
    private final HintRepository hintRepository;
    private final SuperUserRepo superUserRepo;
    private final ModelMapper modelMapper;


    public void setTips(SuperUserDto superUser) {
//        superUser = superUserRepo.findById(id)
//                .map(user -> modelMapper.map(user, SuperUserDto.class))
//                .orElseThrow(() -> new RuntimeException("Super user not found for "));

        superUser.getChildren().forEach(child -> child.getTips().addAll(tipRepository.findForTips(child.getAge())
                .stream()
                .map(tip -> new FoodTipDto(tip.getDescription()))
                .collect(Collectors.toList())));


//        public void setHints (SuperUserDto superUser){
//            superUser = superUserRepo.findById(id)
//                    .map(user -> modelMapper.map(user, SuperUserDto.class))
//                    .orElseThrow(() -> new RuntimeException("Super user not found for "));
//
//
//            superUser.getChildren().forEach(child ->
//                    child.getHint()
//                            .addAll(hintRepository
//                                    .findForHints
//                                            (child.getAge())
//                                    .stream()
//                                    .map(hint -> new HintDto(hint.getDescription()))
//                                    .collect(Collectors.toList())));
//        }
    }
}
