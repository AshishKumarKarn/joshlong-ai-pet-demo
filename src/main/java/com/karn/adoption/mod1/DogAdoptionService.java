package com.karn.adoption.mod1;


import com.karn.adoption.common.DogAdoptionEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
class DogAdoptionService {
    private final DogRepository dogRepository;
    private final ApplicationEventPublisher publisher;

    DogAdoptionService(DogRepository dogRepository, ApplicationEventPublisher publisher) {
        this.dogRepository = dogRepository;
        this.publisher = publisher;

    }

    void adoptDog(int id, String owner) {
        dogRepository.findById(id).ifPresent(
                dog -> {
                    dogRepository.save(new Dog(dog.id(), dog.name(), dog.description(), owner));
                    this.publisher.publishEvent(new DogAdoptionEvent(dog.id(), dog.name()));
                }
        );
    }

}
