package com.coalvalue.service;

import com.alibaba.fastjson.JSON;
import com.coalvalue.domain.OperationResult;
import com.coalvalue.domain.entity.Company;
import com.coalvalue.domain.entity.Equipment;
import com.coalvalue.domain.entity.StorageSpace;
import com.coalvalue.enumType.EquipmentBulletinDisplayModeEnum;
import com.coalvalue.enumType.EquipmentStatusEnum;
import com.coalvalue.enumType.EquipmentTypeEnum;

import com.coalvalue.repository.EquipmentRepository;
//import com.coalvalue.util.SequenceGenerator;
import com.domain.entity.User;
import com.service.BaseServiceImpl;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Session;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("equipmentService")
public class EquipmentServiceImpl extends BaseServiceImpl implements EquipmentService {

    public static final String myTopic_messages = "queue.led";

   // @Value("${server_live.url}")
   // private String serverLiveUrl;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private CompanyService companyService;


    @Autowired
    private JmsTemplate jmsTemplate;
  //  @Autowired
   // private SequenceGenerator sequenceGenerator;






    @Override
    public Equipment userLogin(String userId, String pwd, String loginIP, Object o) {
        return null;
    }

    @Override
    public Equipment login(String userId, String pwd, String loginIP, Object o) {


        return equipmentRepository.findByUserIdAndPin(userId, pwd);
    }

    @Override
    public Page<Equipment> query(Pageable pageRequest, User user) {


        return equipmentRepository.findByCompanyId(user.getCompanyId(), pageRequest);
    }

    @Override
    @Transactional
    public OperationResult create(String deviceId, EquipmentTypeEnum typeEnum, User user) {
        OperationResult operationResult = new OperationResult();
        operationResult.setSuccess(true);

        Equipment equipment = equipmentRepository.findByCompanyIdAndTypeAndName(user.getCompanyId(), EquipmentTypeEnum.Bulletin.getText(), deviceId);
        if(equipment== null){

            equipment = new Equipment();
            equipment.setName(deviceId);

          //  equipment.setDeviceId(sequenceGenerator.nextUuidNO());
            equipment.setType(typeEnum.getText());
            equipment.setCompanyId(user.getCompanyId());

            equipmentRepository.save(equipment);
        }
        operationResult.setResultObject(equipment);
        return operationResult;
    }

    @Override
    public Map<String, Object> getByMapId(Integer clientId) {
        Equipment equipment = equipmentRepository.findById(clientId);


        return getContent(equipment,true);
    }

    @Override
    public void sendMessage(Equipment transportOperation, String message, User user) {

    }

    @Override
    public String getBulletinDisplayContent(Equipment equipment) {

        if(equipment.getType().equals(EquipmentTypeEnum.Bulletin.getText())){
            String attribute =null;// ledService.getAttribute(equipment.getId());
            return attribute;
        }

        return "";

    }

    @Override
    public OperationResult command_change_diplay_content(Equipment transportOperation, String message, User user) {
        OperationResult operationResult = new OperationResult();

         transportOperation.setDisplayConent(message);
        operationResult.setResultObject(transportOperation);
        operationResult.setSuccess(true);
        return operationResult;
    }


    @Override
    public List<Equipment> getPrinterForCompany(Company company) {
        OperationResult operationResult = new OperationResult();

        List<Equipment> equipments = equipmentRepository.findByCompanyIdAndType(company.getId(), EquipmentTypeEnum.Printer.getText());

        return equipments;
    }


    @Override
    public OperationResult printer( StorageSpace storageSpace, String text) {
        OperationResult operationResult = new OperationResult();

        Company company = companyService.getCompanyById(storageSpace.getCompanyId());
/*        Equipment equipments = equipmentRepository.findByCompanyIdAndTypeAndName(company.getId(),EquipmentTypeEnum.Printer.getText(),ResourceType.STORAGE.getText()+""+storageSpace.getId());

        if(equipments != null){

            Channel c = GatewayService.get(equipments.getDeviceId());
            c.write(text);
        }*/


        List<Equipment> equipments = equipmentRepository.findByCompanyIdAndType(company.getId(), EquipmentTypeEnum.Printer.getText());

        if(equipments.size() != 0){

    /*        ChannelHandlerContext c = GatewayService.get(equipments.get(0).getDeviceId());
            if(c != null && c.channel().isActive()){
                Map<String, Object> retsult = new LinkedHashMap<>();

                String jsonStrin = JSON.toJSONString(retsult);
                retsult.put("id", transportOperation.getId()+"");
                WxTemporaryQrcode wxeneral = wxService.getByTransportation(transportOperation, Constants.WX_QRCODE_TYPE_transportOperation);
                retsult.put("weixin_qrcode_content", wxeneral.getContent());

                retsult.put("no", transportOperation.getNo());
                retsult.put("driverName", transportOperation.getDriverName());
                retsult.put("driverPhone", transportOperation.getDriverPhone());
                Test.ProtoTest res = Test.ProtoTest.newBuilder()
                        .setId(1)
                        .setTitle("res 提煤单 ")
                        .setContent(jsonStrin)
                        .build();
                c.writeAndFlush(res);

                operationResult.setResultMessage("发送成功");
            }else{
                operationResult.setResultMessage("设备 不在线，发送 失败");
            }*/

        }
        return operationResult;
    }

    @Override
    public List<Equipment> getLedForCompany(Company company) {

        return equipmentRepository.findByCompanyIdAndType(company.getId(),EquipmentTypeEnum.Bulletin.getText());
    }

    @Override
    public Map<String,Object> getEquipmentByCompany(Company company, Pageable pageable, User user) {



        Page<Equipment> page = equipmentRepository.findByCompanyId(company.getId(),pageable);
        String url = "";

        Map<String,Object> objectMap = new HashMap<>();
        objectMap.put("totalElements",page.getTotalElements());
        objectMap.put("totalPages",page.getTotalPages());



        objectMap.put("totalElements",page.getTotalElements());
        objectMap.put("content",getContent(page, true));
        return objectMap;





    }

    @Override
    public Equipment getById(Integer clientId) {
        return equipmentRepository.findById(clientId);

      //  new Location();
    }

    @Override
    @Transactional
    public Equipment updateEquipment(Equipment equipment) {

        return equipmentRepository.save(equipment);
    }

    @Override
    public void setAttribute(Equipment equipment, String text) {


    }

    @Override
    public void changePrice(Company company, Map map) {

        System.out.println("Producer sends "  + " using map message");
        ActiveMQQueue destination = new ActiveMQQueue(myTopic_messages);


        List<Equipment> equipments = equipmentRepository.findByCompanyIdAndType(company.getId(),EquipmentTypeEnum.Bulletin.getText());
        System.out.println("equipments size "  +equipments.size());

        for(Equipment equipment:equipments){
            if(equipment.getStatus().equals(EquipmentStatusEnum.Bound.getText())){
                System.out.println("设备 绑定了 绑定了"  +equipments.toString());
                jmsTemplate.send(destination, new MessageCreator() {
                    public javax.jms.Message createMessage(Session session) throws JMSException {
                        MapMessage mapMessage = session.createMapMessage();
                        mapMessage.setString("event", "changePrice");
                        mapMessage.setString("equipmentId", equipment.getDeviceId());
                        mapMessage.setString("content", JSON.toJSONString(map));
                        return mapMessage;

                    }});
            }else{
                System.out.println("该设备没有绑定 "  +equipments.toString());
            }

        }


    }
    //@Scheduled(cron="0/3 * * * * ?")
    public void executeUploadTask() {

        // 间隔1分钟,执行工单上传任务
        Thread current = Thread.currentThread();
        System.out.println("equipments size " );

        ActiveMQQueue destination = new ActiveMQQueue(myTopic_messages);

        jmsTemplate.send(destination, new MessageCreator() {
            public javax.jms.Message createMessage(Session session) throws JMSException {
                MapMessage mapMessage = session.createMapMessage();
                mapMessage.setString("event", "changePrice");
                mapMessage.setString("equipmentId", "changePrice");
                mapMessage.setString("content","00");

                return mapMessage;

            }});


    }

    private List<Map<String, Object>> getContent(Page<Equipment> result, boolean isMoobile){
        List<Map<String, Object>> content = new LinkedList<>();
        for(Equipment transport :result){

            Map<String, Object> supplyContainer = new HashMap<String, Object>();

            supplyContainer.put("id", transport.getId());
            supplyContainer.put("companyId", transport.getId());


            supplyContainer.put("name", transport.getName());

            supplyContainer.put("deviceId",  transport.getDeviceId());


            //supplyContainer.put("equipmentType", EquipmentTypeEnum.fromString(transport.getType()).getDisplayText());

 /*           if(transport.getDisplayMode() != null){
                supplyContainer.put("displayMode", EquipmentBulletinDisplayModeEnum.fromString(transport.getDisplayMode()).getDisplayText());
            }else {
                supplyContainer.put("displayMode", "");
            }*/


            supplyContainer.put("displayContent", getBulletinDisplayContent(transport) );

            supplyContainer.put("driverName",  transport.getType());

            supplyContainer.put("driverPhone",  transport.getId());


            String authenticateCommandUri = "";//linkTo(methodOn(MobileEquipmentController.class).detail(transport.getId(), null)).withSelfRel().getHref();
            supplyContainer.put("url", authenticateCommandUri);


            if(EquipmentTypeEnum.Bulletin.getText().equals(transport.getType())){

                if(transport.getDeviceId() != null){
             /*       if(GatewayService.getLedEquipments().contains(transport.getDeviceId())){
                        supplyContainer.put("status", EquipmentStatusEnum.Online.getDisplayText());
                    }else{

                        supplyContainer.put("status",  EquipmentStatusEnum.Offline.getDisplayText());
                    }*/
                }


            }else {
                if(transport.getDeviceId() != null){
                 /*   ChannelHandlerContext channelHandlerContext = GatewayService.get(transport.getDeviceId());
                    if(channelHandlerContext != null){
                        Channel channal =channelHandlerContext.channel();

                        if(channal.isActive()){
                            supplyContainer.put("status", EquipmentStatusEnum.Online.getDisplayText());
                        }else{

                            supplyContainer.put("status",  EquipmentStatusEnum.Offline.getDisplayText());
                        }
                    }else{
                        supplyContainer.put("status",  EquipmentStatusEnum.Offline.getDisplayText());

                    }*/

                }else {
                    supplyContainer.put("status",  EquipmentStatusEnum.Unbound.getDisplayText());

                }
            }




            content.add(supplyContainer);
        }


        return content;
    }


    private Map<String, Object> getContent(Equipment transport, boolean isMoobile){


            Map<String, Object> supplyContainer = new HashMap<String, Object>();

            supplyContainer.put("id", transport.getId());
            supplyContainer.put("companyId", transport.getId());


            supplyContainer.put("name", transport.getName());

            supplyContainer.put("deviceId",  transport.getDeviceId());


            supplyContainer.put("equipmentType", EquipmentTypeEnum.fromString(transport.getType()).getDisplayText());

            if(transport.getDisplayMode() != null){
                supplyContainer.put("displayMode", EquipmentBulletinDisplayModeEnum.fromString(transport.getDisplayMode()).getDisplayText());
            }else {
                supplyContainer.put("displayMode", "");
            }


            supplyContainer.put("displayContent", getBulletinDisplayContent(transport) );




            String authenticateCommandUri = "";//linkTo(methodOn(MobileEquipmentController.class).detail(transport.getId(), null)).withSelfRel().getHref();
            supplyContainer.put("url", authenticateCommandUri);


            if(EquipmentTypeEnum.Bulletin.getText().equals(transport.getType())){

                if(transport.getDeviceId() != null){
            /*        if(GatewayService.getLedEquipments().contains(transport.getDeviceId())){
                        supplyContainer.put("status", EquipmentStatusEnum.Online.getDisplayText());
                    }else{

                        supplyContainer.put("status",  EquipmentStatusEnum.Offline.getDisplayText());
                    }*/
                }


            }else {
                if(transport.getDeviceId() != null){
                  /*  ChannelHandlerContext channelHandlerContext = GatewayService.get(transport.getDeviceId());
                    if(channelHandlerContext != null){
                        Channel channal =channelHandlerContext.channel();

                        if(channal.isActive()){
                            supplyContainer.put("status", EquipmentStatusEnum.Online.getDisplayText());
                        }else{

                            supplyContainer.put("status",  EquipmentStatusEnum.Offline.getDisplayText());
                        }
                    }else{
                        supplyContainer.put("status",  EquipmentStatusEnum.Offline.getDisplayText());

                    }*/

                }else {
                    supplyContainer.put("status",  EquipmentStatusEnum.Unbound.getDisplayText());

                }
            }
       // supplyContainer.put("serverUrl", getServerUrl(transport));



        return supplyContainer;
    }

   /* private String getServerUrl(Equipment transport) {

        if(EquipmentTypeEnum.Camera.getText().equals(transport.getType())){
            return serverLiveUrl;
        }
        return null;
    }*/
}
