package com.gamepound.app.project.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gamepound.app.member.vo.MemberVo;
import com.gamepound.app.project.dao.ProjectDaoHJY;
import com.gamepound.app.project.vo.ProjectStatusVo;
import com.gamepound.app.project.vo.ProjectVo;
import com.gamepound.app.reward.dao.RewardDaoHJY;
import com.gamepound.app.reward.vo.RewardVo;
import com.gamepound.app.settlement.dao.SettlementDaoHJY;
import com.gamepound.app.settlement.vo.SettlementVo;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ProjectServiceHJY {
	
	/**
	 * 현지연 프로젝트 서비스
	 * */

	private final ProjectDaoHJY dao;
	private final RewardDaoHJY rewardDao;
	private final SettlementDaoHJY settlementDao;
	private final SqlSessionTemplate sst;

	// 작성중 프로젝트 조회
	public List<ProjectVo> getCurrentProject(MemberVo loginMember) {
		return dao.getCurrentProject(sst, loginMember);
	}

	// 프로젝트 올리기 (카테고리 저장 및 insert)
	public Map<String, String> newProject(ProjectVo vo) throws Exception {
		
		// 카테고리 null이거나 ''빈값 검증
		if(vo.getCategoryNo() == null || vo.getCategoryNo().isEmpty()) {
			throw new Exception("카테고리를 결정하지 않았습니다.");
		}
		
		// 타이틀 null이거나 ''빈값 검증 후 true면 프로젝트 타이틀을 설정해주세요 라고 하기
		if(vo.getTitle() == null || vo.getTitle().isEmpty()) {
			vo.setTitle("");
		}
		
		// 이미지 null이면 디폴트이미지 insert
		if(vo.getImageUrl() == null || vo.getImageUrl().isEmpty()) {
			vo.setImageUrl("default_prj.svg");
		}
		
		// 결과
		ProjectVo resultVo = dao.newProject(sst, vo); // 프로젝트 정보 가져오기
		
		Map<String, String> map = new HashMap<>();
		map.put("msg", "good");
		map.put("no", resultVo.getNo());
		
		return map;
	}

	// 프로젝트 내용 조회 (메인)
	public Map<String, Object> createMain(ProjectVo vo) {
		ProjectVo mainVo = dao.createMain(sst, vo);
		
		// 파일명에 경로 붙이기
		String fileName = mainVo.getImageUrl();
		String localAddr = "http://localhost:8889/gamepound";
		String uploadDir = "/resources/images/projectImg/";
		fileName = localAddr + uploadDir + fileName;
		mainVo.setImageUrl(fileName);
		
		// 퍼센트 계산 + 작성률 계산 후 리턴
		return calculatePercent(mainVo);
	}
	
	// 퍼센트 계산
	public Map<String, Object> calculatePercent(ProjectVo mainVo){
		Map<String, Object> map = new HashMap<String, Object>(); 
		map.put("mainVo", mainVo);
		
		// 기본정보 작성률
		String[] basic = {mainVo.getMainCategory(), mainVo.getSubCategory(), mainVo.getTitle(), mainVo.getImageUrl()};
		double basicPercent = calculateCompletionRate(basic);
		map.put("basicPercent", basicPercent);
		
		// 펀딩계획 작성률
		String[] plan = {mainVo.getGoalAmount(), mainVo.getStartDate(), mainVo.getEndDate()};
		double planPercent = calculateCompletionRate(plan);
		map.put("planPercent", planPercent);
		
		// 선물 작성률 : 선물 테이블에 행이있으면 100% 아니면 0%
		List<RewardVo> rewardVo = rewardDao.getRewardListByNo(sst, mainVo);
		double rewardPercent = (rewardVo != null && !rewardVo.isEmpty()) ? 100.0 : 0.0;
	    map.put("rewardPercent", rewardPercent);
		
		// 프로젝트계획 작성률
		String[] dateplan = {mainVo.getTxtDescription(), mainVo.getTxtBudget(), mainVo.getTxtSchedule(), mainVo.getTxtTeam(), mainVo.getTxtItem()};
		double dateplanPercent = calculateCompletionRate(dateplan);
		map.put("dateplanPercent", dateplanPercent);
		
		// 창작자 정보 작성률
		SettlementVo settlementVo = settlementDao.getSettlementByNo(sst, mainVo);
		String[] userinfo = null;
		if(settlementVo != null) {
			userinfo = new String[]{settlementVo.getBankName(), settlementVo.getName(), settlementVo.getAccountNum()};
		}
		double userinfoPercent = calculateCompletionRate(userinfo);
		map.put("userinfoPercent", userinfoPercent);
		
		// 전체 작성률
		double totalCompletionRate = (basicPercent + planPercent + rewardPercent + dateplanPercent + userinfoPercent) / 5;
		map.put("totalCompletionRate", totalCompletionRate);
		
		return map;
	}
	
	// 작성률 계산
	public double calculateCompletionRate(String[] row) {
        if (row == null || row.length == 0) {
            // 배열이나 리스트가 null이거나 비어있으면 작업이 없음
            return 0.0;
        }

        int totalTasks = row.length;
        int completedTasks = 0;

        for (String columnValue : row) {
            if (columnValue != null) {
                completedTasks++;
            }
        }

        // 작성률 계산
        double completionRate = ((double) completedTasks / totalTasks) * 100;
        return completionRate;
    }

	// 프로젝트 작성조회 : 펀딩계획
	public ProjectVo getPlan(ProjectVo vo) {
		return dao.getPlan(sst, vo);
	}

	// 프로젝트 작성조회 : 선물구성
	public List<RewardVo> getReward(ProjectVo vo) {
		return rewardDao.getRewardListByNo(sst, vo);
	}

	// 프로젝트 작성조회 : 프로젝트 계획
	public ProjectVo getDateplan(ProjectVo vo) {
		return dao.getDateplan(sst, vo);
	}

	// 프로젝트 작성조회 : 창작자 정보
	public SettlementVo getUserinfo(ProjectVo vo) {
		return settlementDao.getSettlementByNo(sst, vo);
	}

	
	
	// 프로젝트 작성저장 : 기본정보
	public int saveBasic(ProjectVo vo) {
		
		// 타이틀 널체크
	    if (vo.getTitle() == null || "undefined".equals(vo.getTitle()) || vo.getTitle().isEmpty()) {
	        vo.setTitle(null);
	    }

	    // 메인카테고리 넘버 널체크
	    if (vo.getMainCategoryNo() == null || "undefined".equals(vo.getMainCategoryNo()) || vo.getMainCategoryNo().isEmpty()) {
	        vo.setMainCategory(null);
	    }

	    // 카테고리 넘버 널체크
	    if (vo.getCategoryNo() == null || "undefined".equals(vo.getCategoryNo()) || vo.getCategoryNo().isEmpty()) {
	        vo.setCategoryNo(null);
	    }
		
		return dao.saveBasic(sst, vo);
	}

	// 프로젝트 작성저장 : 펀딩계획
	public int savePlan(ProjectVo vo) {
		return dao.savePlan(sst, vo);
	}

	// 프로젝트 작성 : 선물구성
	public int createReword(RewardVo vo) {
		return dao.createReword(sst, vo);
	}

	// 프로젝트 작성저장 : 선물구성
	public int saveReword(RewardVo vo) {
		// 금액 검증
		if(vo.getAmount().isEmpty()) {
			vo.setAmount(null);
		}
		// 선물이름 검증
		if(vo.getName().isEmpty()) {
			vo.setName(null);
		}
		
		return dao.saveReword(sst, vo);
	}

	// 프로젝트 선물삭제 : 선물구성
	public int deleteReword(RewardVo vo) {
		return dao.deleteReword(sst, vo);
	}

	// 프로젝트 작성저장 : 프로젝트 계획
	public int saveDateplan(ProjectVo vo) {
		return dao.saveDateplan(sst, vo);
	}

	// 프로젝트 작성저장 : 창작자 정보
	public int saveUserinfo(SettlementVo vo) {
		return dao.saveUserinfo(sst, vo);
	}

	// 이미지 파일저장
	public String imagefileSave(MultipartFile image, String root) throws Exception {

		// 랜덤파일이름 생성
		String fileName = image.getOriginalFilename();
		String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1);
		UUID uuid = UUID.randomUUID();
		fileName = uuid.toString() + "." + fileExtension;
		
		// 현재 날짜 기준으로 폴더 생성
	    LocalDate currentDate = LocalDate.now();
	    String currentDatePath = currentDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")) + "/";
	    String folderPath = root + currentDatePath;
	    String filePath = folderPath + fileName;
	    
	    // 이미지를 저장할 디렉토리 경로
	    Path directoryPath = Paths.get(folderPath);

	    // 디렉토리가 없으면 생성
	    if (!Files.exists(directoryPath)) {
	        Files.createDirectories(directoryPath);
	    }
	    
	    // 이미지 파일 저장
	    File dest = new File(filePath);
	    image.transferTo(dest);

	    return currentDatePath + fileName; // 최종 파일이름 반환
	}

	// 프로젝트 승인 요청
	public int approvalProject(ProjectVo vo) {
		return dao.approvalProject(sst, vo);
	}

	// 프로젝트 상태 가져오기
	public List<ProjectStatusVo> getProjectStatus() {
		return dao.getProjectStatus(sst);
	}

	
}
