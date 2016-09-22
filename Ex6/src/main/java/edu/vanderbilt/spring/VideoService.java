package edu.vanderbilt.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VideoService {

	private VideoRepository videos_;
	
	@Autowired
	public VideoService(VideoRepository repo) {
		videos_ = repo;
	}
	
	@RequestMapping(value="/video/{id}", method=RequestMethod.GET)
	public Video getVideo(@PathVariable("id") Long videoId){
		
		System.out.println("id:" + videoId);
		
		return videos_.findOne(videoId);
	}
	
	@RequestMapping(value="/video", method=RequestMethod.POST)
	public Iterable<Video> addVideo(@RequestBody Video video){
		videos_.save(video);
		return videos_.findAll();
	}
	
	@RequestMapping(value="/test/foo", method=RequestMethod.GET)
	public String getVideo(){
		
		return "Test";
	}
	
	@RequestMapping(value="/video", method=RequestMethod.GET)
	public  Iterable<Video> getListOfVideos(){
		
		return videos_.findAll();
	}
	
	@RequestMapping(value="/video/{id}", method=RequestMethod.POST)
	public void updateVideo(@RequestBody Video video, 
							@PathVariable("id") Long videoId){
		
		Video dbVid = videos_.findOne(videoId);
		
		dbVid.setGenre(video.getGenre());
		dbVid.setName(video.getName());
		dbVid.setSize(video.getSize());
		dbVid.setURL(video.getURL());
		
		videos_.save(dbVid);
	}
	
	@RequestMapping(value="/video/{id}", method=RequestMethod.DELETE)
	public String deleteVid(@PathVariable("id") Long videoId){
		
		videos_.delete(videoId);
		
		return "Video " + videoId + " deleted";
	}
	
}
