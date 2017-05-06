package org.meditec.meditecserver.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.meditec.meditecserver.database.DataBaseClass;
import org.meditec.meditecserver.model.Diary;

public class DiaryService {
	
	private Map<String, Diary> diarylist = DataBaseClass.getDiaryList();
	
	public DiaryService() {
		diarylist.put("Alejandro", new Diary("Alejandro", "Terminar de revisar los pacientes, revisar informes"));
		diarylist.put("David", new Diary("David", "Terminar los informes, revisar documentos"));
	}
	
	public List<Diary> getAllDiary() {
		return new ArrayList<Diary>(diarylist.values());
	}
	
	public Diary getDiary(String diary) {
		return diarylist.get(diary);
	}
	
	public Diary addDiary(Diary diary) {		
		diarylist.put(diary.getAuthor(), diary);
		return diary;
	}
	
	public Diary updateDiary(Diary diary) {
		if (diary.getAuthor().isEmpty()) {
			return null;
		}
		diarylist.put(diary.getAuthor(), diary);
		return diary;
	}
	
	public Diary removeDiary(String diary) {
		return diarylist.remove(diary);
	}
}
