package com.karn.adoption.mod1;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.ListCrudRepository;

@Configuration
class AssistantConfiguration {

    @Bean
    ApplicationRunner assistant(ChatClient chatClient) {
        return args -> {
            var content = chatClient.prompt("Do you know how calculator works? and what is 4 multiplied 5?").call().content();
            System.out.println("Response: " + content);
        };
    }
    @Bean
    ChatClient chatClient(ChatClient.Builder builder, DogRepository dogRepository, VectorStore store) {

        dogRepository.findAll().forEach(dog -> {
            var detail = new Document(("id : %s, name : %s, description : %s").formatted(
                    dog.id(), dog.name(), dog.description()));
            //store.add(List.of(detail));
        });
        var system = """
                You are a helpful assistant that answers questions about dogs available for adoption
                in Karn Pet Adoption Agency. You can also do basic arithmetic calculations.
                """;
        ChatOptions options = ChatOptions.builder()
                .model("gpt-3.5-turbo")//CHEAPEST MODEL
                .temperature(0.7)// Control randomness
                .maxTokens(100)//PREVENT LONG ANSWERS
                .build();
        return builder.defaultOptions(options).defaultAdvisors(new QuestionAnswerAdvisor(store)).defaultSystem(system).build();
    }

}

interface DogRepository extends ListCrudRepository<Dog, Integer> {
}

record Dog(@Id Integer id, String name, String description, String owner) {
}