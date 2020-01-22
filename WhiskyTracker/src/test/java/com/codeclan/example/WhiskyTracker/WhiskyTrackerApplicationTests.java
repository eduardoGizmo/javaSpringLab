package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskyByYear(){
		List<Whisky> found = whiskyRepository.findWhiskyByYear(1991);
		assertEquals(1991, found.get(0).getYear());
	}

	@Test
	public void canFindDistilleriesThatHaveRegionName(){
		List<Distillery> found = distilleryRepository.findDistilleriesByRegion("Lowland");
		assertEquals("Rosebank", found.get(0).getName());
	}

	@Test
	public void canFindWhiskyByDistilleryNameAndAge(){
		List<Whisky> found = whiskyRepository.findWhiskyByDistilleryNameAndAge("Macallan", 25);
		assertEquals("The Macallan Anniversary Malt", found.get(0).getName());
	}

	@Test
	public void canFindWhiskiesByRegion(){
		List<Whisky> found = whiskyRepository.findWhiskyByDistilleryRegion("Lowland");
		assertEquals("The Rosebank 12 - Flora and Fona", found.get(0).getName());
	}

//	@Test
//	public void canFindDistilleriesThatHaveWhiskiesAged(){
//
//	}

}
