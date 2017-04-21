package com.travelSite.server.database.dao;

import com.travelSite.server.database.model.*;

import java.util.List;

public interface ParamsDAO {

    void saveParam(PkParamsEntity pkParamsEntity);

    List<PkParamsEntity> findAllParams();

    PkParamsEntity findParamById(int id);

    void deleteParamById(int id);

    List<PkParamsEntity> findAllParamsByObjectId(int id);

    void deleteAllParamsByObjectId(int id);
}
