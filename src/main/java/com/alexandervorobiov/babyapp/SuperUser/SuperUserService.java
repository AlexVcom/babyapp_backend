package com.alexandervorobiov.babyapp.SuperUser;

import com.alexandervorobiov.babyapp.Child.Child;
import com.alexandervorobiov.babyapp.Child.ChildRegistrationDto;
import com.alexandervorobiov.babyapp.Child.ChildRepo;
import com.alexandervorobiov.babyapp.Child.hint.HintDto;
import com.alexandervorobiov.babyapp.Child.hint.HintRepository;
import com.alexandervorobiov.babyapp.Child.tip.FoodTipDto;
import com.alexandervorobiov.babyapp.Child.tip.FoodTipsRepository;
import com.alexandervorobiov.babyapp.Child.tip.TipsService;
import com.alexandervorobiov.babyapp.SuperUser.dto.SuperUserDto;
import com.alexandervorobiov.babyapp.SuperUser.dto.SuperUserRegistrationDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
@Transactional
@RequiredArgsConstructor
public class SuperUserService {

    private final SuperUserRepo superUserRepo;
    private final ModelMapper modelMapper;
    private final TipsService tipsService;
    private final ChildRepo childRepo;
    private final HintRepository hintRepository;
    private final FoodTipsRepository foodTipsRepository;


    public List<SuperUserDto> findAllUsers() {
        List<SuperUserDto> superUserDto = superUserRepo.findAll()
                .stream()
                .map(u -> modelMapper.map(u, SuperUserDto.class))

                .collect(Collectors.toList());
        return superUserDto;
    }

    public Optional<SuperUserRegistrationDto> findByUserName(String superUser) {
        Optional<SuperUserRegistrationDto> userName = superUserRepo.findByName(superUser)
                .stream()
                .map(n -> modelMapper.map(n, SuperUserRegistrationDto.class))
                .findFirst();
        return userName;
    }

    public SuperUserDto findUser(Long id) {
        return superUserRepo.findById(id)
                .map(user -> modelMapper.map(user, SuperUserDto.class))
                .orElseThrow(() -> new RuntimeException("Super user not found for " + id));
    }

    public SuperUserDto findUserWithDetails(Long id) {
        SuperUserDto superUserDto = superUserRepo.findById(id)
                .map(user -> modelMapper.map(user, SuperUserDto.class))
                .orElseThrow(() -> new RuntimeException("Super user not found for " + id));
//        superUserDto.getChildren()
//                .forEach(childDetailsDto -> childDetailsDto.getHint()
//                        .addAll(hintRepository.findForHints(childDetailsDto.getAge())
//                                .stream()
//                                .map(h-> new HintDto(h.getDescription()))
//                                .collect(Collectors.toList())
//        ));
        superUserDto.getChildren()
                .forEach(childDetailsDto -> {
                            childDetailsDto.getHint()
                                    .addAll(hintRepository.findForHints(childDetailsDto.getAge())
                                            .stream()
                                            .map(h -> new HintDto(h.getDescription()))
                                            .collect(Collectors.toList()));

                            childDetailsDto.getTips()
                                    .addAll(foodTipsRepository.findForTips(childDetailsDto.getAge())
                                            .stream()
                                            .map(t -> new FoodTipDto(t.getDescription()))
                                            .collect(Collectors.toList()));

                        }
                );


//        superUserDto.getChildren()
//                .forEach(childDetailsDto -> childDetailsDto.getTips()
//                        .addAll(foodTipsRepository.findForTips(childDetailsDto.getAge())
//                                .stream()
//                                .map(t -> new FoodTipDto(t.getDescription()))
//                                .collect(Collectors.toList())
//                        ));

//        tipsService.setTips(superUserDto);
//        tipsService.setHints(superUserDto);
        return superUserDto;
    }


    public SuperUser saveSuperUser(SuperUserRegistrationDto superUserDto) {
        SuperUser superUser = modelMapper.map(superUserDto, SuperUser.class);
        for (ChildRegistrationDto c : superUserDto.getChildren()) {
            modelMapper.map(c, Child.class);
        }
        superUserRepo.save(superUser);
        return superUser;
    }

    public void deleteSuperUser(Long id) {
        superUserRepo.deleteById(id);
    }

    public SuperUser updateSuperUser(SuperUserDto superUserDto) {
        SuperUser superUser = modelMapper.map(superUserDto, SuperUser.class);
//        superUser.setId(id);
        superUserRepo.save(superUser);
        return superUser;
    }
}











