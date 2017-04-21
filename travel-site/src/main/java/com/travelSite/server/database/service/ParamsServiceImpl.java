package com.travelSite.server.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.travelSite.server.database.dao.ParamsDAO;
import com.travelSite.server.database.model.PkParamsEntity;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("paramsService")
@Transactional
public class ParamsServiceImpl implements ParamsService {

    @Autowired
    private ParamsDAO paramsDAO;

    public void saveParam(PkParamsEntity pkParamsEntity) {
        paramsDAO.saveParam(pkParamsEntity);
    }

    public List<PkParamsEntity> findAllParams() {
        return paramsDAO.findAllParams();
    }

    public PkParamsEntity findParamById(int id) {
        return paramsDAO.findParamById(id);
    }

    public void deleteParamById(int id) {
        paramsDAO.deleteParamById(id);
    }

    public List<PkParamsEntity> findAllParamsByObjectId(int id) {

        List<PkParamsEntity> allList = paramsDAO.findAllParams();
        List<PkParamsEntity> out = new ArrayList<PkParamsEntity>();
        for(PkParamsEntity pkParamsEntity:allList){
            if (pkParamsEntity.getPkObjectsByObjectId().getObjectId()==id){
                out.add(pkParamsEntity);
            }
        }
        return out;
    }

    public void deleteAllParamsByObjectId(int id) {
        paramsDAO.deleteAllParamsByObjectId(id);
    }
}
