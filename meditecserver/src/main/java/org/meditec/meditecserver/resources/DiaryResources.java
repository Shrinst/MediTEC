package org.meditec.meditecserver.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.meditec.meditecserver.model.Diary;
import org.meditec.meditecserver.service.DiaryService;

@Path("diarylist")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DiaryResources {
	
	private DiaryService diaryService = new DiaryService();
	
	@GET
	public List<Diary> getDiarys() {
		return diaryService.getAllDiary();
	}
	
	@POST
	public Diary addDiary(Diary diary) {
		return diaryService.addDiary(diary);
	}
	
	@PUT
	@Path("{diary}")
	public Diary updateDiary(@PathParam("diary") String authorName, Diary diary) {
		diary.setAuthor(authorName);
		return diaryService.updateDiary(diary);
	}
	
	@DELETE
	@Path("{diary}")
	public void deleteDiary(@PathParam("diary") String authorName) {
		diaryService.removeDiary(authorName);
	}
	
	
	@GET
	@Path("{diary}")
	public Diary getDiary(@PathParam("diary") String authorName) {
		return diaryService.getDiary(authorName);
	}
}
