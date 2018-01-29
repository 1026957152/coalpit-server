package com.coalvalue.service;


import com.coalvalue.domain.entity.QualityInspectionReport;
import com.coalvalue.domain.entity.QualityTestItem;
import com.coalvalue.enumType.QualityIndicatorEnum;
import com.coalvalue.repository.QualityInspectionReportRepository;
import com.coalvalue.repository.QualityTestItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("qualityInspectionService")
public class QualityInspectionServiceImpl implements QualityInspectionService {

    @Autowired
    private QualityTestItemRepository qualityTestItemRepository;

    @Autowired
    private QualityInspectionReportRepository qualityInspectionReportRepository;




    @Override
    public QualityInspectionReport queryQualityInpectionReportById(Integer id) {
        return qualityInspectionReportRepository.findById(id);
    }





    @Override
    public Page<QualityTestItem> queryQualityTestItems(QualityInspectionReport qualityInspectionReport, Pageable pageable) {
        return qualityTestItemRepository.findByInspectionReportId(qualityInspectionReport.getId(),pageable);
    }

    @Override
    public Page<QualityInspectionReport> queryQualityInspectionReportsByCompanyId(Integer companyId, Pageable pageRequest) {
        return qualityInspectionReportRepository.findByCompanyId(companyId,pageRequest);
    }

    @Override
    public List<QualityTestItem> queryQualityTestItems(QualityInspectionReport qualityInspectionReport) {
        return qualityTestItemRepository.findByInspectionReportId(qualityInspectionReport.getId());
    }

    @Override
    @Transactional
    public QualityTestItem queryQualityTestItemBySymbol(QualityIndicatorEnum qnet, QualityInspectionReport qualityInspectionReport) {
        QualityTestItem qualityTestItem = qualityTestItemRepository.findByInspectionReportIdAndSymbol(qualityInspectionReport.getId(), qnet.getSymbol());

        if(qualityTestItem == null){
            qualityTestItem = new QualityTestItem();
            qualityTestItem.setSymbol(qnet.getSymbol());

            qualityTestItem.setInspectionReportId(qualityInspectionReport.getId());
            qualityTestItem = qualityTestItemRepository.save(qualityTestItem);
        }
        return qualityTestItem;
    }


    @Override
    @Transactional
    public List<QualityTestItem> queryQualityTestItemBySymbols(List<QualityIndicatorEnum> qnet, QualityInspectionReport qualityInspectionReport) {

        List<String> symbols = qnet.stream().map((a)->(a.getSymbol())).collect(Collectors.toList());

        List<QualityTestItem> qualityTestItems = qualityTestItemRepository.findByInspectionReportIdAndSymbolIn(qualityInspectionReport.getId(), symbols);

        return qualityTestItems;
    }

    @Override
    public String toWxPresentation(QualityInspectionReport qualityInspectionReport) {


        List<QualityIndicatorEnum> qualityIndicatorEnums = new ArrayList<>();
        qualityIndicatorEnums.add(QualityIndicatorEnum.Qnetar);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Qgrad);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Qgrd);

        qualityIndicatorEnums.add(QualityIndicatorEnum.Var);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Vd);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Star);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Std);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Aar);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Ad);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Mad);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Mt);
        qualityIndicatorEnums.add(QualityIndicatorEnum.CRC);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Fc);
        qualityIndicatorEnums.add(QualityIndicatorEnum.HGI);
        qualityIndicatorEnums.add(QualityIndicatorEnum.G);
        qualityIndicatorEnums.add(QualityIndicatorEnum.AFT);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Hdaf);

        qualityIndicatorEnums.add(QualityIndicatorEnum.Y);



        Map<String,String> result = new HashMap<>();
        Map<String, String> set =getSet(qualityIndicatorEnums,qualityInspectionReport);
        for(String symbole : set.keySet()){
            result.put(symbole,set.get(symbole));
        }

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append ("全水分(Mt):").append(result.get(QualityIndicatorEnum.Mt.getSymbol())).append("\n");
        stringBuffer.append ("分析水(Mad):").append(result.get(QualityIndicatorEnum.Mad.getSymbol())).append("\n");
        stringBuffer.append ("灰分(Ad):").append(result.get(QualityIndicatorEnum.Ad.getSymbol())).append("\n");
        stringBuffer.append ("挥发分(Vd):").append(result.get(QualityIndicatorEnum.Vd.getSymbol())).append("\n");
        stringBuffer.append ("固定碳(Fc):").append(result.get(QualityIndicatorEnum.Fc.getSymbol())).append("\n");
        stringBuffer.append ("全硫(St,d):").append(result.get(QualityIndicatorEnum.Std.getSymbol())).append("\n");
        stringBuffer.append ("氢(Hdaf):").append(result.get(QualityIndicatorEnum.Hdaf.getSymbol())).append("\n");
        stringBuffer.append("低位发热量(Qgrd):").append(result.get(QualityIndicatorEnum.Qgrd.getSymbol())).append("\n");
        stringBuffer.append( "高位发热量(Qnet,ar):").append(result.get(QualityIndicatorEnum.Qnetar.getSymbol())).append("\n");
        return stringBuffer.toString();

    }

    @Override
    public Map<String, String> getHomePresentation(QualityInspectionReport qualityIndex) {







        Map<String,String> result = new HashMap<>();


        List<QualityIndicatorEnum> qualityIndicatorEnums = new ArrayList<>();
        qualityIndicatorEnums.add(QualityIndicatorEnum.Qnetar);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Qgrad);

        qualityIndicatorEnums.add(QualityIndicatorEnum.Qgrd);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Var);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Vd);


        qualityIndicatorEnums.add(QualityIndicatorEnum.Star);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Std);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Vad);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Vdaf);

        qualityIndicatorEnums.add(QualityIndicatorEnum.Aar);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Ad);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Mad);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Mt);
        qualityIndicatorEnums.add(QualityIndicatorEnum.CRC);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Fc);
        qualityIndicatorEnums.add(QualityIndicatorEnum.HGI);
        qualityIndicatorEnums.add(QualityIndicatorEnum.G);
        qualityIndicatorEnums.add(QualityIndicatorEnum.AFT);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Shale_content);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Y);

        Map<String, String> set =getSet(qualityIndicatorEnums,qualityIndex);
        for(String symbole : set.keySet()){
            result.put(QualityIndicatorEnum.fromString(symbole).name(),set.get(symbole));
        }


      return result;


    }


    @Override
    public List<Map<String, Object>> getHomePresentationDisplay(QualityInspectionReport qualityIndex) {

      //  Map<String,Object> result = new HashMap<>();


        return getHomePresentation(qualityIndex.getId());
    }


    @Override
    public Map getQualityPresentationDetail(QualityInspectionReport qualityIndex) {

        Map returnMap = new HashMap<>();
        //  Map<String,Object> result = new HashMap<>();


        List<QualityIndicatorEnum> qualityIndicatorEnums = new ArrayList<>();
        qualityIndicatorEnums.add(QualityIndicatorEnum.Qgrd);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Qnetar);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Vdaf);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Var);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Std);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Star);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Ad);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Aar);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Mad);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Mt);
        qualityIndicatorEnums.add(QualityIndicatorEnum.CRC);
        qualityIndicatorEnums.add(QualityIndicatorEnum.HGI);
        qualityIndicatorEnums.add(QualityIndicatorEnum.FCd);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Fc);
        qualityIndicatorEnums.add(QualityIndicatorEnum.G);
        qualityIndicatorEnums.add(QualityIndicatorEnum.AFT);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Y);
        ;
        Map<String,String> sets = getSet(qualityIndicatorEnums,qualityIndex);
        List<Map<String, Object>> maps = new ArrayList<>();

        for(QualityIndicatorEnum qualityIndicatorEnum: qualityIndicatorEnums){
            Map<String, Object> map = new HashMap<>();
            map.put("unit", qualityIndicatorEnum.getUnit());
            map.put("symbol", qualityIndicatorEnum.getDisplayText());
            map.put("tip", qualityIndicatorEnum.getHelpMessage());
            String value = sets.get(qualityIndicatorEnum.getSymbol());
            if(value != null){
                if(value.equals("-1")){
                    map.put("value", "?");
                }else{
                    map.put("value", value);
                }

            }else{
                map.put("value","未定义" );

            }
            maps.add(map);
        }
   /*     for(String symbol : sets.keySet()){
            Map<String, Object> map = new HashMap<>();
            QualityIndicatorEnum qualityIndicatorEnum = QualityIndicatorEnum.fromString(symbol);
*//*
            QualityTestItem qualityTestItem = queryQualityTestItemBySymbol(qualityIndicatorEnum,qualityIndex);
            //result.put(qualityIndicatorEnum.getDisplayText(),qualityTestItem.getValue());
*//*
            map.put("unit", qualityIndicatorEnum.getUnit());
            map.put("symbol", qualityIndicatorEnum.getDisplayText());
            map.put("value", sets.get(symbol));
            maps.add(map);
        }*/

        returnMap.put("indicators", maps);
        List<String> tags = new ArrayList<>();

        if(sets.get(QualityIndicatorEnum.Std.getSymbol()) != null || sets.get(QualityIndicatorEnum.Star.getSymbol()) != null){
            System.out.println("------------- 包含 Std ｛｝"+sets.get(QualityIndicatorEnum.Std.getSymbol()));

            BigDecimal bigDecimal = new BigDecimal((String)sets.get(QualityIndicatorEnum.Std.getSymbol()));

        }

        returnMap.put("tags",tags);




        List<QualityIndicatorEnum> mainQualityIndicatorEnums = new ArrayList<>();

        mainQualityIndicatorEnums.add(QualityIndicatorEnum.Qnetar);
        mainQualityIndicatorEnums.add(QualityIndicatorEnum.Vdaf);
        mainQualityIndicatorEnums.add(QualityIndicatorEnum.Std);
        mainQualityIndicatorEnums.add(QualityIndicatorEnum.Mt);
        mainQualityIndicatorEnums.add(QualityIndicatorEnum.Ad);



        List<Map<String, Object>> mainQualityMaps = new ArrayList<>();
        for(QualityIndicatorEnum qualityIndicatorEnum: mainQualityIndicatorEnums){
            Map<String, Object> map = new HashMap<>();
            map.put("unit", qualityIndicatorEnum.getUnit());
            map.put("symbol", qualityIndicatorEnum.getDisplayText());
            String value = sets.get(qualityIndicatorEnum.getSymbol());
            if(value != null){
                if(value.equals("-1")){
                    map.put("value", "?");
                }else{
                    map.put("value", value);
                }
            }else{
                map.put("value","未定义" );
            }
            mainQualityMaps.add(map);
        }
        returnMap.put("mainIndicators", mainQualityMaps);
        returnMap.put("tags",tags);
        return returnMap;


    }

    @Override
    public List getByCompanyId(Integer id) {

        List<Map> list = new ArrayList<>();
        List<QualityInspectionReport> qualityInspectionReports = qualityInspectionReportRepository.findByCompanyId(id);
        for(QualityInspectionReport qualityInspectionReport:qualityInspectionReports){
            Map map = new HashMap<>();

            List<Map<String, Object>> maps = getHomePresentationDisplay(qualityInspectionReport);
            map.put("indicators", maps);
            map.put("name", qualityInspectionReport.getRemark());
            map.put("createDate", qualityInspectionReport.getCreateDate());
            list.add(map);
        }
        return list;
    }


    public Map<String, String> getSet(List<QualityIndicatorEnum> qualityIndicatorEnums,QualityInspectionReport qualityIndex) {

        Map<String,String> result = new HashMap<>();


        List<QualityTestItem> qualityTestItems = queryQualityTestItemBySymbols(qualityIndicatorEnums,qualityIndex);
        for(QualityTestItem qualityIndicatorEnum : qualityTestItems){
            result.put(qualityIndicatorEnum.getSymbol(),qualityIndicatorEnum.getValue());
        }

        return result;

    }
    public Map<String, String> getSet(List<QualityIndicatorEnum> qualityIndicatorEnums,Integer qualityIndexId) {

        Map<String,String> result = new HashMap<>();


        List<QualityTestItem> qualityTestItems = queryQualityTestItemBySymbols(qualityIndicatorEnums,qualityIndexId);
        for(QualityTestItem qualityIndicatorEnum : qualityTestItems){
            result.put(qualityIndicatorEnum.getSymbol(),qualityIndicatorEnum.getValue());
        }

        return result;

    }

    private List<QualityTestItem> queryQualityTestItemBySymbols(List<QualityIndicatorEnum> qualityIndicatorEnums, Integer qualityIndexId) {

        List<String> symbols = qualityIndicatorEnums.stream().map((a)->(a.getSymbol())).collect(Collectors.toList());

        List<QualityTestItem> qualityTestItems = qualityTestItemRepository.findByInspectionReportIdAndSymbolIn(qualityIndexId, symbols);

        return qualityTestItems;
    }


    @Override
    public List getGradle(Integer id) {





        QualityInspectionReport qualityInspectionReport = queryQualityInpectionReportById(id);



        Map<String,String> result = new HashMap<>();


        List<QualityIndicatorEnum> qualityIndicatorEnums = new ArrayList<>();
        qualityIndicatorEnums.add(QualityIndicatorEnum.Qnetar);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Qgrad);

        qualityIndicatorEnums.add(QualityIndicatorEnum.Qgrd);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Var);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Vd);


        qualityIndicatorEnums.add(QualityIndicatorEnum.Star);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Std);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Vad);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Vdaf);

        qualityIndicatorEnums.add(QualityIndicatorEnum.Aar);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Ad);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Mad);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Mt);
        qualityIndicatorEnums.add(QualityIndicatorEnum.CRC);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Fc);
        qualityIndicatorEnums.add(QualityIndicatorEnum.HGI);
        qualityIndicatorEnums.add(QualityIndicatorEnum.G);
        qualityIndicatorEnums.add(QualityIndicatorEnum.AFT);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Shale_content);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Y);

        Map<String, String> set =getSet(qualityIndicatorEnums,qualityInspectionReport);

        BigDecimal bigDecimal = new BigDecimal((String)set.get(QualityIndicatorEnum.Std.name()));



        return null;

    }

    @Override
    public List<Map<String, Object>> getHomePresentation(Integer qualityReportId) {


        List<QualityIndicatorEnum> qualityIndicatorEnums = new ArrayList<>();
        qualityIndicatorEnums.add(QualityIndicatorEnum.Qnetar);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Var);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Star);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Aar);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Mad);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Mt);
        qualityIndicatorEnums.add(QualityIndicatorEnum.CRC);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Fc);
        qualityIndicatorEnums.add(QualityIndicatorEnum.HGI);
        qualityIndicatorEnums.add(QualityIndicatorEnum.G);
        qualityIndicatorEnums.add(QualityIndicatorEnum.AFT);
        qualityIndicatorEnums.add(QualityIndicatorEnum.Y);



        Map<String,String> sets = getSet(qualityIndicatorEnums,qualityReportId);
        List<Map<String, Object>> maps = new ArrayList<>();

        for(String symbol : sets.keySet()){
            Map<String, Object> map = new HashMap<>();
            QualityIndicatorEnum qualityIndicatorEnum = QualityIndicatorEnum.fromString(symbol);
/*
            QualityTestItem qualityTestItem = queryQualityTestItemBySymbol(qualityIndicatorEnum,qualityIndex);
            //result.put(qualityIndicatorEnum.getDisplayText(),qualityTestItem.getValue());
*/

            map.put("unit", qualityIndicatorEnum.getUnit());
            map.put("symbol", qualityIndicatorEnum.getDisplayText());
            map.put("value", sets.get(symbol));
            maps.add(map);
        }



        return maps;



    }
}
