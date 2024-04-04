package com.hobbyprojects.tinkeringwithcode.util;

import com.hobbyprojects.tinkeringwithcode.model.PersonalDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.hobbyprojects.tinkeringwithcode.util.AgeUtil.isAdult;
import static com.hobbyprojects.tinkeringwithcode.util.AgeUtil.isLegalToDrinkFor;

@Service
@Slf4j
public class StreamsUtil {

    Map<String, Integer> nameAgeMap = Map.of("Amar", 44, "Akbar", 24, "Anthony", 30, "Nanu", 15);
    PersonalDetails amar =
            PersonalDetails.builder().name("Amar").age(44).hasDrivingLicense(true).build();

    Map<String, PersonalDetails> personalDetailsMap =
            Map.of(
                    "Amar",
                    PersonalDetails.builder().name("Amar").age(44).hasDrivingLicense(true).build(),
                    "Akbar",
                    PersonalDetails.builder().name("Akbar").age(24).hasDrivingLicense(true).build(),
                    "Anthony",
                    PersonalDetails.builder().name("Anthony").age(30).hasDrivingLicense(true).build(),
                    "Nanu",
                    PersonalDetails.builder().name("Nanu").age(15).hasDrivingLicense(false).build());

    List<String> names = List.of("Amar", "Akbar", "Anthony", "Karan", "Arjun", "Amar", "Akbar");

    public static void main(String[] args) {
        StreamsUtil streamsUtil = new StreamsUtil();
        List<String> distinctNames = streamsUtil.distinctNames();
        log.info("Get Distinct Names :- ");
        distinctNames.forEach(System.out::println);
        List<String> namesInUpperCase = streamsUtil.printInUpperCaseForGivenSize(5);
        log.info("Get Names in Upper Case :- ");
        namesInUpperCase.forEach(System.out::println);
        log.info("Get people who are allowed to drink :- ");
        List<String> peopleAllowedToDrink = streamsUtil.getPeopleWhoAreAllowedToDrink();
        peopleAllowedToDrink.forEach(System.out::println);
        log.info("Get people who are allowed to drive :- ");
        List<String> peopleAllowedToDrive = streamsUtil.getPeopleWhoAreAllowedToDrive();
        peopleAllowedToDrive.forEach(System.out::println);
        //        List<String> streamsUtil.addMissingNamesToMap();
    }

    public boolean checkAgeBasedOnCriteria(int givenAge, String criteria) {
        return switch (criteria) {
            case "Drinking" -> isLegalToDrinkFor(givenAge);
            default -> throw new IllegalStateException("Unexpected value: " + criteria);
        };
    }

    public boolean checkAgeBasedOnCriteria(int givenAge, String criteria, boolean hasDrivingLicense) {
        return switch (criteria) {
            case "Drinking" -> isLegalToDrinkFor(givenAge);
            case "Driving " -> isAdult(givenAge) && hasDrivingLicense;
            default -> throw new IllegalStateException("Unexpected value: " + criteria);
        };
    }


    public List<String> getPeopleWhoAreAllowedToDrink() {
        return nameAgeMap.entrySet().stream()
                .filter(nameAge -> checkAgeBasedOnCriteria(nameAge.getValue(), "Drinking"))
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> getPeopleWhoAreAllowedToDrive() {
        return personalDetailsMap.entrySet().stream()
                .filter(personalDetails -> checkAgeBasedOnCriteria(personalDetails.getValue().getAge(), "Drinking", personalDetails.getValue().isHasDrivingLicense()))
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> distinctNames() {
        return names.stream().distinct().toList();
    }

    public List<String> printInUpperCaseForGivenSize(int size) {
        return names.stream().filter(name -> name.length() > size).map(String::toUpperCase).toList();
    }

    public void sortNamesByAgeIn(String order) {
    }

    //    public void addMissingNamesToMap() {
    //        names.stream()
    //                .map(name -> );
    //
    //    }

}
