package org.meditec.meditecserver.service;
/**
 * 
 * @author Vinicio
 * 
 *
 */

import java.util.ArrayList;
import java.util.List;

import org.meditec.meditecserver.database.DataBaseClass;
import org.meditec.meditecserver.model.Diary;

public class DiaryService {
	
	private ArrayList<Diary> diarylist = DataBaseClass.getDiaryList();
	
	public DiaryService() {
			
	}
	
	public List<Diary> getAllDiary() {
		return new ArrayList<Diary>(diarylist);
	}
	/**
	 * Get all the diary
	 * @return diary list
	 */
	
	public List<Diary> getAllDairyPerAuthor(String author) {
		List<Diary> diaryList =  new ArrayList<>();
		
		for (Diary diary : this.diarylist) {			
			if (diary.getAuthor().equals(author)) {
				diaryList.add(diary);
			}
		}
		
		return diaryList;
	}
	/**
	 * Get all the dairy per author
	 * @param patientName
	 * @return clinicalCases
	 */
	
	public Diary getDiary(String diary) {
		Diary diaryResult = new Diary();
		
		for (Diary diary1 : diarylist) {
			if (diary1.getAuthor().equals(diary)) {
				diaryResult = diary1;;
			}
		}
		
		return diaryResult;
	}
	/**
	 * Get all the clinical cases per patient
	 * @param patientName
	 * @return clinicalCases
	 */
	
	public Diary addDiary(Diary diary) {		
		diarylist.add(diary);
		return diary;
	}
	/**
	 * Add a new diary
	 * @param diary
	 * @return diary
	 */	
	
	public void removeDiary(String diary) {
		diarylist.remove(diary);
	}
	/**
	 * Remove diary
	 * @param diary
	 * @return diarylist
	 */
}
