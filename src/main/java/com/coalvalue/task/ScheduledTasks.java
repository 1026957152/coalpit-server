package com.coalvalue.task;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
@Qualifier("myScheduledTasks")
public class ScheduledTasks {


    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");



   // @Scheduled(fixedDelayString = "${fixed.delay.construct.today_index}")
    public void reportStatistic() {

        // TODO follow 这个 区域的 topic后，   （event 中 相关的 公司， 是否 落在 topic 中，========）

        System.out.println("======= task send message to user");
    //    List<PrivilegedUser> privilegedUsers = privilegedUserRepository.findByTypeAndAppId(PrivilegedTypeEnum.scan_qrcode.getText(),Constants.CORPID);
   //     collectionEventService.run();



    }


}

/*
	var date=new Date();
	var hour=date.getHours();
	var str=‘‘;
	switch(hour){
	case 0:case 1:case 2:case 3:case 4:str=‘凌晨好！‘;break;
	case 5:case 6:str=‘早上好！‘;break;
	case 7: case 8:case 9:case 10:case 11:str=‘上午好！‘;break;
	case 12:case 13:str=‘中午好！‘;break;
	case 14:case 15:case 16:str=‘下午好！‘;break;
	case 17:case 18:case 19:case 20:str=‘晚上好！‘;break;
	case 23:case 22:case 21:str=‘太晚了，休息吧！‘;break;
	}
 */