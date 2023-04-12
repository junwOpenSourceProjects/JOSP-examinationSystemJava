package wo1261931780.JOSPexaminationSystemJava.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import wo1261931780.JOSPexaminationSystemJava.DAO.ScoreInfoMapper;
import java.util.List;
import wo1261931780.JOSPexaminationSystemJava.entity.ScoreInfo;
/**
*Created by Intellij IDEA.
*Project:JOSP-ExaminationSystemJava
*Package:wo1261931780.JOSPexaminationSystemJava.service
*@author liujiajun_junw
*@Date 2023-04-21-40  星期三
*@description
*/
@Service
public class ScoreInfoService extends ServiceImpl<ScoreInfoMapper, ScoreInfo> {

    
    public int updateBatch(List<ScoreInfo> list) {
        return baseMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<ScoreInfo> list) {
        return baseMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<ScoreInfo> list) {
        return baseMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(ScoreInfo record) {
        return baseMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(ScoreInfo record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
