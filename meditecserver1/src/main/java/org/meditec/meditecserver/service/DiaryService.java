package org.meditec.meditecserver.service;

import org.meditec.meditecserver.database.DataBaseClass;
import org.meditec.meditecserver.lists.DiaryList;
import org.meditec.meditecserver.model.Diary;

public class DiaryService {	
	
	
	private DiaryList diarylist = DataBaseClass.getDiaryList();
	
	public DiaryService() {		
			
	}
	
	public DiaryList getAllDiary() {
		return diarylist;
	}
	
	public DiaryList getAllDairyPerAuthor(String author) {
		DiaryList diaryList =  new DiaryList();
		
		
		for (Diary diary = this.diarylist.getHead(); diary != null; diary = diary.getNext()) {			
			if (diary.getAuthor().equals(author)) {
				diaryList.insertFirst(diary.getAuthor(), diary.getText());
			}
		}
		
		return diaryList;
	}
	
	public Diary getDiary(String diaryR) {
		Diary diaryResult = new Diary();
		
		for (Diary diary = this.diarylist.getHead(); diary != null; diary = diary.getNext()) {			
			if (diary.getAuthor().equals(diaryR)) {
				diaryResult = diary;
				break;
			}
		}
		
		return diaryResult;
	}
	
	public Diary addDiary(Diary diary) {		
		diarylist.insertFirst(diary.getAuthor(), diary.getText());
		return diary;
	}	
	
	public void removeDiary(String diary) {
		diarylist.delete(diary);
	}
}
