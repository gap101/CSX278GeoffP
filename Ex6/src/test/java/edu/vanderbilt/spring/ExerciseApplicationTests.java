package edu.vanderbilt.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExerciseApplicationTests {

	@Autowired
	VideoService videoService;
	
	@Test
	public void contextLoads() {	
	}
	
	@Test
	public void videoServiceLoaded() {
		assertNotNull(videoService);
	}
	
	@Test
	public void addVideoReturnsAListOfVideos() {
		Video video = new Video();
		Iterable<Video> videos = videoService.addVideo(video);
		assertNotNull(videos);
		assertTrue(videos.iterator().hasNext());
	}
	
	@Test
	public void getVideoReturnsListOfAllVids() {
		Video video = new Video();
		Video video2 = new Video();
		videoService.addVideo(video);
		videoService.addVideo(video2);
		
		Iterable<Video> videos = videoService.getListOfVideos();
		assertNotNull(videos);
		assertTrue(videos.iterator().hasNext());
		videos.iterator().next();
		assertTrue(videos.iterator().hasNext());

	}
	
	
	
	@Test
	public void postVideo() {
		Video video3 = new Video();
		video3.setId(new Long(1));
		video3.setGenre("horror");
		
		videoService.addVideo(video3);
		
		Video v = videoService.getVideo(new Long(1));
		
		assertTrue(v.getGenre().equals("horror"));
		
	}
	
	@Test
	public void postVideoId() {
		Video video3 = new Video();
		video3.setGenre("path");
		
		videoService.updateVideo(video3, new Long(1));
		
		Video v = videoService.getVideo(new Long(1));
		
		assertTrue(v.getGenre().equals("path"));
		
	}
	
	@Test
	public void deleteTest(){
		
		videoService.deleteVid(new Long(1));
		
		Video v = videoService.getVideo(new Long(1));
		
		assertTrue(v == null);

	}

}
