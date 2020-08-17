package com.alexandervorobiov.babyapp.Child;

import com.alexandervorobiov.babyapp.SuperUser.SuperUser;
import com.alexandervorobiov.babyapp.SuperUser.SuperUserRepo;
import com.alexandervorobiov.babyapp.SuperUser.SuperUserService;
import com.alexandervorobiov.babyapp.SuperUser.dto.SuperUserDto;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

@Data
@Service
@Transactional
public class ChildService {
    private final ChildRepo childRepo;
    private final ModelMapper modelMapper;
    private final SuperUserRepo superUserRepo;
    private final SuperUserService superUserService;


    public Child saveChild(ChildRegistrationDto childRegistrationDto){
        Child child = modelMapper.map(childRegistrationDto, Child.class);
        childRepo.save(child);

//        superUser.getChildren().add(child);
        return child;
    }

    public Optional<ChildRegistrationDto> findByChildName (String child){
        Optional<ChildRegistrationDto> userName = childRepo.findByName(child)
                .stream()
                .map(n -> modelMapper.map(n,ChildRegistrationDto.class))
                .findFirst();
        return userName;
    }
}
