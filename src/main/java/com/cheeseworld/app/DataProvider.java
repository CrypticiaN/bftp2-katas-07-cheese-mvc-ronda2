package com.cheeseworld.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class DataProvider {

    private CheeseRepository cheeseRepository;

    @Autowired
    public DataProvider(CheeseRepository cheeseRepository) {
        this.cheeseRepository = cheeseRepository;
    }

    @PostConstruct
    void loadInitialCheese() {
        List<Cheese> allCheeses = List.of(
                new Cheese("Rochefort|stinky french cheese|250gr"),
                new Cheese("Manchego|gourmet spanish cheese|100gr"),
                new Cheese("Monterey Jack|creamy american cheese|180gr"),
                new Cheese("Cabrales|super stinky cheese|100gr"),
                new Cheese("Aged British Cheddar|british crystalline and flaky cheese|300gr"),
                new Cheese("Smoked Gouda|dutch buttery and crumbly cheese|200gr"),
                new Cheese("Camembert|french creamy and smelly cheese|180gr"),
                new Cheese("Brie|Mouldy and creamy french stinky cheese|350gr")
        );

        cheeseRepository.saveAll(allCheeses);
    }
}
