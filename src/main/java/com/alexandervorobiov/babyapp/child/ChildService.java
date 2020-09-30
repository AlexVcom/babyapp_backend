package com.alexandervorobiov.babyapp.child;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class ChildService {
    private final ChildRepository childRepo;
    private final ModelMapper modelMapper;

    public Child saveChild(ChildRegistrationDto childRegistrationDto){
        Child child = modelMapper.map(childRegistrationDto, Child.class);
        childRepo.save(child);
        return child;
    }

    public Optional<ChildRegistrationDto> findByChildName (String child){
        return childRepo.findByName(child)
                .stream()
                .map(n -> modelMapper.map(n,ChildRegistrationDto.class))
                .findFirst();
    }
}
