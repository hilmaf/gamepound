package com.gamepound.app.category.vo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class CategoryVo {
	private String no;
	private String mainCategoryNo;
	private String subCategoryNo;
	private String mainCategory;
	private String subCategory;
	
	private List<SubCategoryVo> subCategoryList = new ArrayList<SubCategoryVo>();
}
