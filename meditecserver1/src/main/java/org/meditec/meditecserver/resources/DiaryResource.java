package org.meditec.meditecserver.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.meditec.meditecserver.lists.DiaryList;
import org.meditec.meditecserver.model.Diary;

import org.meditec.meditecserver.service.DiaryService;

@Path("diarylist")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DiaryResource {
	
	private DiaryService diaryService = new DiaryService();
	
	@GET
	public List<Diary> getDiarys(@QueryParam("author") String filter) {
		
//		if (filter != null) {
//			return diaryService.getAllDairyPerAuthor(filter);
//		}
		
		List<Diary> lista1 = new ArrayList<Diary>();
		DiaryList diaryList = diaryService.getAllDiary();
		Diary diary = diaryList.getHead();
		
		while (diary != null) {
			lista1.add(diary);
			diary = diary.getNext();
		}
		
		
		return lista1;
	}
	
	@POST
	public Diary addDiary(Diary diary) {
		return diaryService.addDiary(diary);
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
