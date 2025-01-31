package wo1261931780.JOSPexaminationSystemJava.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wo1261931780.JOSPexaminationSystemJava.config.ShowResult;
import wo1261931780.JOSPexaminationSystemJava.entity.AcademySingle;
import wo1261931780.JOSPexaminationSystemJava.entity.College;
import wo1261931780.JOSPexaminationSystemJava.service.CollegeService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Intellij IDEA.
 * Project:JOSP-examinationSystemJava
 * Package:wo1261931780.JOSPexaminationSystemJava.controller
 *
 * @author liujiajun_junw
 * @Date 2023-03-04-40  星期六
 * @description
 */
@RestController
@RequestMapping("/College")
public class CollegeController {
	@Autowired
	private CollegeService collegeService;
	
	@GetMapping("/list")
	public ShowResult<Page<College>> showMeAllCollegePage(@RequestParam Integer page
			, @RequestParam Integer limit
			, @RequestParam String sort
			, String academyName) {
		Page<College> pageInfo = new Page<>();// 页码，每页条数
		pageInfo.setCurrent(page);// 当前页
		pageInfo.setSize(limit);// 每页条数
		LambdaQueryWrapper<College> lambdaQueryWrapper = new LambdaQueryWrapper<>();
		lambdaQueryWrapper.like(College::getAcademyName, academyName);
		Page<College> testPage = collegeService.page(pageInfo, lambdaQueryWrapper);
		return ShowResult.sendSuccess(testPage);
	}
	@PostMapping("/insertOrUpdate")
	public ShowResult<College> insertOrUpdateCollege(College college) {
		boolean saveOrUpdate = collegeService.insertOrUpdate(college);
		if (saveOrUpdate) {
			return ShowResult.sendSuccess(college);
		} else {
			return ShowResult.sendError("保存失败");
		}
	}
	@GetMapping("/academyList")
	public ShowResult<List<AcademySingle>> showMeAllAcademyList(String academyName) {
		ArrayList<AcademySingle> singleArrayList = new ArrayList<>();
		collegeService.list().forEach(college -> {
			AcademySingle academySingle = new AcademySingle();
			academySingle.setKey(college.getAcademyCode());
			academySingle.setLabel(college.getAcademyName());
			singleArrayList.add(academySingle);
		});
		
		return ShowResult.sendSuccess(singleArrayList);
	}
}
