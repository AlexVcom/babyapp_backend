package com.alexandervorobiov.babyapp.superUser;

import com.alexandervorobiov.babyapp.child.Child;
import com.alexandervorobiov.babyapp.child.ChildRegistrationDto;
import com.alexandervorobiov.babyapp.child.hint.HintDto;
import com.alexandervorobiov.babyapp.child.hint.HintRepository;
import com.alexandervorobiov.babyapp.child.tip.FoodTipDto;
import com.alexandervorobiov.babyapp.child.tip.FoodTipsRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class SuperUserService {

    private final SuperUserRepository superUserRepository;
    private final ModelMapper modelMapper;
    private final HintRepository hintRepository;
    private final FoodTipsRepository foodTipsRepository;


    public List<SuperUserDto> findAllUsers() {
        return superUserRepository.findAll()
                .stream()
                .map(u -> modelMapper.map(u, SuperUserDto.class))
                .collect(Collectors.toList());
    }

    public Optional<SuperUserRegistrationDto> findByUserName (String superUser){
        return superUserRepository.findByName(superUser)
                .stream()
                .map(n -> modelMapper.map(n,SuperUserRegistrationDto.class))
                .findFirst();
    }

    public SuperUserDto findUser(Long id) {
        return superUserRepository.findById(id)
                .map(user -> modelMapper.map(user, SuperUserDto.class))
                .orElseThrow(() -> new RuntimeException("Super user not found for " + id));
    }

    public SuperUserDto findUserWithDetails(Long id) {
        SuperUserDto superUserDto = superUserRepository.findById(id)
                .map(user -> modelMapper.map(user, SuperUserDto.class))
                .orElseThrow(() -> new RuntimeException("Super user not found for " + id));

        superUserDto.getChildren()
                .forEach(childDetailsDto -> {
                    childDetailsDto.getHint()
                            .addAll(hintRepository.findForHints(childDetailsDto.getAge())
                                    .stream()
                                    .map(h-> new HintDto(h.getDescription()))
                                    .collect(Collectors.toList()));

                    childDetailsDto.getTips()
                            .addAll(foodTipsRepository.findForTips(childDetailsDto.getAge())
                                    .stream()
                                    .map(t->new FoodTipDto(t.getDescription()))
                                    .collect(Collectors.toList()));
                }
        );
        return superUserDto;
    }


    public SuperUser saveSuperUser(SuperUserRegistrationDto superUserDto) {
        SuperUser superUser = modelMapper.map(superUserDto,SuperUser.class);
        for (ChildRegistrationDto c : superUserDto.getChildren()) {
                    modelMapper.map(c, Child.class);
        }
        superUserRepository.save(superUser);
        return superUser;
    }

    public void deleteSuperUser(Long id) {
        superUserRepository.deleteById(id);
    }
    public SuperUser updateSuperUser(SuperUserDto superUserDto) {
        SuperUser superUser = modelMapper.map(superUserDto, SuperUser.class);
        superUserRepository.save(superUser);
        return superUser;
    }
}











