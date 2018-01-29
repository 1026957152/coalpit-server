package com.service;/*
package com.service;

import com.coalvalue.domain.MediaResource;
import com.coalvalue.domain.Product;
import com.coalvalue.enumType.CoalSizeEnum;
import com.coalvalue.enumType.MediaTypeEnum;
import com.coalvalue.repository.AccessStatisticRepository;
import com.coalvalue.repository.MediaResourceRepository;
import com.coalvalue.util.FileUtil;
import com.coalvalue.util.tts.DebugLog;
import com.coalvalue.util.tts.MscTest;
import com.coalvalue.weixin.pojo.WeixinMedia;
import com.coalvalue.weixin.service.AccessTokenManagerService;
import com.coalvalue.weixin.util.AdvancedUtil;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.SynthesizeToUriListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.util.Map;
import java.util.UUID;

*/
/**
 * Created by silence yuan on 2015/7/25.
 *//*


@Service("ttsService")
public class TtsServiceImpl extends BaseServiceImpl implements TtsService {

    @Autowired
    private AccessStatisticRepository accessStatisticRepository;

    @Autowired
    private MediaResourceRepository mediaResourceRepository;


    @Autowired
    private ServletContext servletContext;

    @Autowired
    private DocumentResourceService  documentResourceService;

    @Autowired
    private OpenIdService  openIdService;

*/
/*
    @Autowired
    private RunService  runService;
*//*




    @Autowired
    private MerchantService  merchantService;

    @Autowired
    private CoalSupplyService  coalSupplyService;

    @Autowired
    private ProductService  productService;



    @Autowired
    private StorageSpaceService  storageSpaceService;

    @Autowired
    private CallingQueuingService  callingQueuingService;



    @Override
    public AccessStatistic access(String message, SynthesizeToUriListener synthesizeToUriListener) {

      //  ToMp3("E:/workspace/ReportWeb/WebRoot/","audio/REC_20150126_175835.amr");

        System.out.println("---------------FileUtil.getWebAppDir： "+ FileUtil.getWebAppDir());


        String filePathToGraphsDir = servletContext.getRealPath("/myfiles");//filePathToGraphsDir:D:\mei_0628\src\main\webapp\myfiles

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");

        StringBuffer uniqueFileName = new StringBuffer();

        uniqueFileName.append(filePathToGraphsDir).append(System.getProperty("file.separator"));
        uniqueFileName.append(uuid)
                .append(".pcm");

        logger.debug("====================================  mp3 file path is :{}", uniqueFileName.toString());
        MscTest.getInstance().synthesize(message,uniqueFileName.toString(),synthesizeToUriListener);


        return null;

    }

    */
/**
     * 将上传的录音转为mp3格式
     * @param webroot 项目的根目录
     * @param sourcePath 文件的相对地址
     *//*

    public static String ToMp3(String webroot, String mySourcePath){

        //webroot = FileUtil.BASE_DIR;
       // webroot="";

        webroot = LanhuaServiceImpl.getPath(LanhuaServiceImpl.ffmpeg_path);
        System.out.println("---------------------- webroot = FileUtil.BASE_DIR;-------- "+ webroot );
    //    String path = ServletActionContext.getServletContext().getRealPath("/WEB-INF/classes/ffmpeg.exe");

        //File file = new File(sourcePath);
        String sourcePath = mySourcePath;
        String targetPath = mySourcePath.replace(".pcm",".mp3");


        //转换后文件的存储地址，直接将原来的文件名后加mp3后缀名
       // String targetPath = sourcePath+".war";//转换后文件的存储地址，直接将原来的文件名后加mp3后缀名



        Runtime run = null;
        try {
            run = Runtime.getRuntime();
            long start=System.currentTimeMillis();
      //     Process p=run.exec(webroot+"ffmpeg -y -f u8 -ar 16000 -i "+webroot+sourcePath+" -c:a libmp3lame -q:a 8 "+webroot+targetPath);//执行ffmpeg.exe,前面是ffmpeg.exe的地址，中间是需要转换的文件地址，后面是转换后的文件地址。-i是转换方式，意思是可编码解码，mp3编码方式采用的是libmp3lame
           // Process p=run.exec(webroot+"ffmpeg -f alsa  -ar 16000 -i "+webroot+sourcePath+" -c:a libmp3lame -q:a 8 "+webroot+targetPath);//执行ffmpeg.exe,前面是ffmpeg.exe的地址，中间是需要转换的文件地址，后面是转换后的文件地址。-i是转换方式，意思是可编码解码，mp3编码方式采用的是libmp3lame
         //   Process p=run.exec(webroot+"ffmpeg -y  -ar 16000  -ac 1 -acodec pcm_u16 -i  "+webroot+sourcePath+" -c:a libmp3lame -q:a 8 "+webroot+targetPath);//执行ffmpeg.exe,前面是ffmpeg.exe的地址，中间是需要转换的文件地址，后面是转换后的文件地址。-i是转换方式，意思是可编码解码，mp3编码方式采用的是libmp3lame

     //       Process p=run.exec(webroot+"ffmpeg -y -f u8 -ar 16000 -ac 2  -i "+webroot+sourcePath+" -ar 16000 -ac 2  "+webroot+targetPath);//执行ffmpeg.exe,前面是ffmpeg.exe的地址，中间是需要转换的文件地址，后面是转换后的文件地址。-i是转换方式，意思是可编码解码，mp3编码方式采用的是libmp3lame
           // Process p=run.exec(webroot+"ffmpeg -y -f s16le  -ar 8000 -ac 2  -i "+webroot+sourcePath.replace(".pcm","") +"  -c:a libmp3lame -q:a 8  "+webroot+targetPath);//执行ffmpeg.exe,前面是ffmpeg.exe的地址，中间是需要转换的文件地址，后面是转换后的文件地址。-i是转换方式，意思是可编码解码，mp3编码方式采用的是libmp3lame

            Process p=run.exec(webroot+"ffmpeg -y -f s16le  -ar 8000 -ac 2  -i "+sourcePath +"  -c:a libmp3lame -q:a 8  "+targetPath);//执行ffmpeg.exe,前面是ffmpeg.exe的地址，中间是需要转换的文件地址，后面是转换后的文件地址。-i是转换方式，意思是可编码解码，mp3编码方式采用的是libmp3lame
            System.out.println("---------------------- sourcePath-------- "+ sourcePath );
            System.out.println("---------------------- targetPath-------- "+ targetPath );

            //释放进程
            p.getOutputStream().close();
            p.getInputStream().close();
            p.getErrorStream().close();
            p.waitFor();
            long end=System.currentTimeMillis();
            System.out.println(sourcePath+" convert success, costs:"+(end-start)+"ms");
            //删除原来的文件
            //if(file.exists()){
            //file.delete();
            //}
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //run调用lame解码器最后释放内存
            run.freeMemory();
        }

        //return webroot+targetPath;
        return targetPath;
    }



    public static void main(String[] args) {

        ToMp3("E:/","mei/m/ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttts_test.pcm");

    }

    public void sendMessageTransportScan(TransportOperation transportOperation, String fromUserName) {

        SynthesizeToUriListener synthesizeToUriListener = new SynthesizeToUriListener() {

            public void onBufferProgress(int progress) {
                DebugLog.Log("*************合成进度*************" + progress);

            }

            public void onSynthesizeCompleted(String uri, SpeechError error) {

                if (error == null) {
                    DebugLog.Log("*************合成成功*************");
                    DebugLog.Log("合成音频生成路径：" + uri);
                } else
                    DebugLog.Log("*************" + error.getErrorCode()
                            + "*************");




//   WeixinMedia weixinMedia = AdvancedUtil.uploadMedia(accessToken, "voice", Constants.HOST_WEBSITE+ "/weixinmpapi/test.mp3");

              //  String filePath = ToMp3("E:/","mei/m/ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttts_test");

                String filePath = ToMp3("E:/",uri);

                MediaResource mediaResource = documentResourceService.createMedia(transportOperation, filePath,MediaTypeEnum.SHIPMENT_active_driver.getText());

                mediaResource = documentResourceService.getMediaByObject(transportOperation, MediaTypeEnum.SHIPMENT_active_driver.getText());


                DebugLog.Log("转换后 的 mp3  路径：" + filePath);
                String accessToken = AccessTokenManagerService.getAccessToken().getAccessToken();//CommonUtil.getToken(Constants.CORPID, Constants.APP_SECRET).getAccessToken();

                // WeixinMedia weixinMedia = AdvancedUtil.uploadMedia(accessToken, "voice", "http://localhost:8085/weixinmpapi/beep.mp3");
                WeixinMedia weixinMedia = null;
                try {
                    weixinMedia = AdvancedUtil.send(accessToken, "voice", mediaResource.getFilePath());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println(weixinMedia.getMediaId());
                System.out.println(weixinMedia.getType());
                System.out.println(weixinMedia.getCreatedAt());

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("++++++++++++++++++++++++++++++++++evoicevoicevoice");
                String message = AdvancedUtil.makeVoiceCustomMessage(fromUserName,weixinMedia.getMediaId());
                AdvancedUtil.sendCustomMessage(accessToken,message);
                System.out.println("++++++++++++++++++++++++++++evoicevoicevoicevoicevoicevoicevoicevoicevoicevoicevoicevoice");
            }
        };


        StorageSpace storageSpace = storageSpaceService.getOriginStorage(transportOperation.getSpaceId());
        Product product = productService.getById(transportOperation.getProductId());
        YardQueuing yardQueuing = callingQueuingService.getByProductAndStorage(product,storageSpace);

        Integer count = 0;
        String trucks = "";
        if(yardQueuing != null){


            Map<String,Object> ret = callingQueuingService.getWaitingNo(transportOperation,yardQueuing);//= yardQueuing.getWaitingCount() != null ? yardQueuing.getWaitingCount()-1 : -1;
            count = (Integer)ret.get("count");
            trucks =  (String)ret.get("trucks");

            //count = yardQueuing.getWaitingCount() != null ? yardQueuing.getWaitingCount()-1 : -1;
        }


        StringBuffer message = new StringBuffer();
        message.append("尊敬的 "+transportOperation.getDriverName()+ "先生,您好，")
                .append("欢迎来到："+storageSpace.getName()+" 提货，");
        message.append(" "+(product.getCoalType() +","+ product.getGranularity())+"，");

        if(count != 0 ){
            message.append("您前方有, "+(count)+"辆车，请您耐心等待。");
        }else {
            message.append("您前方没有车辆排队，您可以立即装车。");
        }



       // String  message = "尊敬的 先生 您好，您的 目的地址是 陕西省榆林市横山县，货物送达后，您有权要求对方支付全额货款，如对方不支付，您可以扣押他的 货物，如遇到特殊情况，你可以报警。感谢您的 使用，祝您一路顺风";
        AccessStatistic path = access(message.toString(),synthesizeToUriListener);



       // AccessStatistic path = access("从前天晚上给他打完电话开始，身上就莫名其妙的痒，好久之后，都听到舍友的呼吸声了，我还是难受的睡不着，不知道怎么了。记得那是小的时候，总会因为着风了身上会起一大片红色的疙瘩，像南瓜子那么大，一片一片的，特别的难受。自从长大以后就在再也没有过这种情况，怎么现在又是, ",
         //       synthesizeToUriListener);
    }

    public void sendMessageShipmentScan(Shipping shipping, String fromUserName) {

        SynthesizeToUriListener synthesizeToUriListener = new SynthesizeToUriListener() {

            public void onBufferProgress(int progress) {
                DebugLog.Log("*************合成进度*************" + progress);

            }

            public void onSynthesizeCompleted(String uri, SpeechError error) {
                if (error == null) {
                    DebugLog.Log("*************合成成功*************");
                    DebugLog.Log("合成音频生成路径：" + uri);
                } else
                    DebugLog.Log("*************" + error.getErrorCode()
                            + "*************");



                String filePath = ToMp3("E:/",uri);

                MediaResource mediaResource = documentResourceService.createMedia(shipping, filePath,MediaTypeEnum.SHIPMENT_active_driver.getText());

                mediaResource = documentResourceService.getMediaByObject(shipping, MediaTypeEnum.SHIPMENT_active_driver.getText());

                DebugLog.Log("转换后 的 mp3  路径：" + filePath);
                String accessToken = AccessTokenManagerService.getAccessToken().getAccessToken();//CommonUtil.getToken(Constants.CORPID, Constants.APP_SECRET).getAccessToken();

                WeixinMedia weixinMedia = null;
                try {
                    weixinMedia = AdvancedUtil.send(accessToken, "voice", mediaResource.getFilePath());
                } catch (Exception e) {
                    e.printStackTrace();
                }


                System.out.println(weixinMedia.getMediaId());
                System.out.println(weixinMedia.getType());
                System.out.println(weixinMedia.getCreatedAt());


                System.out.println("++++++++++++++++++++++++++++++++++evoicevoicevoice");
                String message = AdvancedUtil.makeVoiceCustomMessage(fromUserName,weixinMedia.getMediaId());
                AdvancedUtil.sendCustomMessage(accessToken,message);
                System.out.println("++++++++++++++++++++++++++++evoicevoicevoicevoicevoicevoicevoicevoicevoicevoicevoicevoice");
            }
        };


        //String  message =  陕西省榆林市横山县，;



        StringBuffer message = new StringBuffer();
        message.append("尊敬的 "+shipping.getLogDriverName()+ "先生,您好，")
                .append("此次运输，货物净重："+shipping.getShippingWeight()+"吨,")
                .append("目的地址, "+shipping.getDestination()+",")
                .append("货物送达后，您有权要求对方现金支付全额运费,或者和收货人协商，您有权留置同等价值的货物，如果遇到特殊情况，你可以选择报警。祝您一路顺风");
        AccessStatistic path = access(message.toString(),synthesizeToUriListener);

    }

    public void sendMessageOrderScan(CoalOrder coalOrder, String fromUserName) {

        sendMessage(coalOrder, fromUserName);



    }

    @Override
    @Async
    public void sendMessage(CoalOrder coalOrder, String fromUserName){
        SynthesizeToUriListener synthesizeToUriListener = new SynthesizeToUriListener() {

            public void onBufferProgress(int progress) {
                DebugLog.Log("*************合成进度*************" + progress);

            }

            public void onSynthesizeCompleted(String uri, SpeechError error) {
                if (error == null) {
                    DebugLog.Log("*************合成成功*************");
                    DebugLog.Log("合成音频生成路径：" + uri);
                } else
                    DebugLog.Log("*************" + error.getErrorCode()
                            + "*************");



                String filePath = ToMp3("E:/",uri);

                MediaResource mediaResource = documentResourceService.createMedia(coalOrder, filePath,MediaTypeEnum.COAL_ORDER_active_customer_buyer.getText());

                mediaResource = documentResourceService.getMediaByObject(coalOrder, MediaTypeEnum.COAL_ORDER_active_customer_buyer.getText());

                DebugLog.Log("转换后 的 mp3  路径：" + filePath);
                String accessToken = AccessTokenManagerService.getAccessToken().getAccessToken();//CommonUtil.getToken(Constants.CORPID, Constants.APP_SECRET).getAccessToken();

                WeixinMedia weixinMedia = null;
                try {
                    weixinMedia = AdvancedUtil.send(accessToken, "voice", mediaResource.getFilePath());
                } catch (Exception e) {
                    e.printStackTrace();
                }


                System.out.println(weixinMedia.getMediaId());
                System.out.println(weixinMedia.getType());
                System.out.println(weixinMedia.getCreatedAt());


                System.out.println("++++++++++++++++++++++++++++++++++evoicevoicevoice");
                String message = AdvancedUtil.makeVoiceCustomMessage(fromUserName,weixinMedia.getMediaId());
                AdvancedUtil.sendCustomMessage(accessToken,message);
                System.out.println("++++++++++++++++++++++++++++evoicevoicevoicevoicevoicevoicevoicevoicevoicevoicevoicevoice");
            }
        };

        Merchant merchant = merchantService.getMerchantById(coalOrder.getPurchaserMerchantId());
        Merchant supplerMerchant = merchantService.getMerchantById(coalOrder.getSupplierMerchantId());
        //String  message = "尊敬的 "+merchant.getPrincipalName()+ "先生 您好，您的 订单已经 生成，在 付款之前，您有可以拨打电话，修改 交付数量，时间，以及煤炭种类。";


        CoalSupply coalSupply  = productService.getCoalSupply(coalOrder.getProductId());
        String type = CoalSizeEnum.fromString(coalSupply.getGranularity()).getText();
        StringBuffer message = new StringBuffer();
        message.append("尊敬的 "+merchant.getPrincipalName()+ "先生 您好，您的订单已经 生成,")
                .append("单价："+coalOrder.getPrice()+"元/吨，")
                .append("数量：" +coalOrder.getQuantity() + "吨， 类型：" + type+"," )
                .append("供应商："+supplerMerchant.getName()+"，")
                .append("在付款之前，您可以拨打电话，修改，交付数量，时间，以及煤炭种类。谢谢您的信赖，我们将竭诚为您服务");
        AccessStatistic path = access(message.toString(),synthesizeToUriListener);
    }
    public void sendMessage(User consignee, Shipping shipping, String message) {


        WeixinOpenId weixinOpenId = openIdService.getOpenIdByUser(consignee);
        if(weixinOpenId == null){
            return ;
        }
        SynthesizeToUriListener synthesizeToUriListener = new SynthesizeToUriListener() {

            public void onBufferProgress(int progress) {
                DebugLog.Log("*************合成进度*************" + progress);

            }

            public void onSynthesizeCompleted(String uri, SpeechError error) {
                if (error == null) {
                    DebugLog.Log("*************合成成功*************");
                    DebugLog.Log("合成音频生成路径：" + uri);
                } else
                    DebugLog.Log("*************" + error.getErrorCode()
                            + "*************");



                String filePath = ToMp3("E:/",uri);

                MediaResource mediaResource = documentResourceService.createMedia(shipping, filePath,MediaTypeEnum.SHIPMENT_create_send_consignee.getText());

                mediaResource = documentResourceService.getMediaByObject(shipping, MediaTypeEnum.SHIPMENT_create_send_consignee.getText());

                DebugLog.Log("转换后 的 mp3  路径：" + filePath);
                String accessToken = AccessTokenManagerService.getAccessToken().getAccessToken();//CommonUtil.getToken(Constants.CORPID, Constants.APP_SECRET).getAccessToken();

                WeixinMedia weixinMedia = null;
                try {
                    weixinMedia = AdvancedUtil.send(accessToken, "voice", mediaResource.getFilePath());
                } catch (Exception e) {
                    e.printStackTrace();
                }


                System.out.println(weixinMedia.getMediaId());
                System.out.println(weixinMedia.getType());
                System.out.println(weixinMedia.getCreatedAt());


                System.out.println("++++++++++++++++++++++++++++++++++evoicevoicevoice");
                String message = AdvancedUtil.makeVoiceCustomMessage(weixinOpenId.getOpenId(),weixinMedia.getMediaId());
                AdvancedUtil.sendCustomMessage(accessToken,message);
                System.out.println("++++++++++++++++++++++++++++evoicevoicevoicevoicevoicevoicevoicevoicevoicevoicevoicevoice");
            }
        };

       // String  message = "尊敬的 "+coalOrder.getId()+ "先生 您好，您的 订单已经 生成，您有可以拨打电话，在 未付款之前，该办 交付数量，时间，以及煤炭种类。";
        AccessStatistic path = access(message,synthesizeToUriListener);
    }

    public void sendMessageCustomerMenoScan(CustomerMemo merchant, String fromUserName) {

        SynthesizeToUriListener synthesizeToUriListener = new SynthesizeToUriListener() {

            public void onBufferProgress(int progress) {
                DebugLog.Log("*************合成进度*************" + progress);

            }

            public void onSynthesizeCompleted(String uri, SpeechError error) {

                if (error == null) {
                    DebugLog.Log("*************合成成功*************");
                    DebugLog.Log("合成音频生成路径：" + uri);
                } else
                    DebugLog.Log("*************" + error.getErrorCode()
                            + "*************");




//   WeixinMedia weixinMedia = AdvancedUtil.uploadMedia(accessToken, "voice", Constants.HOST_WEBSITE+ "/weixinmpapi/test.mp3");

                //  String filePath = ToMp3("E:/","mei/m/ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttts_test");

                String filePath = ToMp3("E:/",uri);

                MediaResource mediaResource = documentResourceService.createMedia(merchant, filePath,MediaTypeEnum.Customer_memo_create_and_bind_user.getText());

                mediaResource = documentResourceService.getMediaByObject(merchant, MediaTypeEnum.Customer_memo_create_and_bind_user.getText());
                logger.debug("mediaResource =         =======================   ========== {}", mediaResource.toString());


                DebugLog.Log("转换后 的 mp3  路径：" + filePath);
                String accessToken = AccessTokenManagerService.getAccessToken().getAccessToken();//CommonUtil.getToken(Constants.CORPID, Constants.APP_SECRET).getAccessToken();

                // WeixinMedia weixinMedia = AdvancedUtil.uploadMedia(accessToken, "voice", "http://localhost:8085/weixinmpapi/beep.mp3");
                WeixinMedia weixinMedia = null;
                try {
                    weixinMedia = AdvancedUtil.send(accessToken, "voice", mediaResource.getFilePath());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println(weixinMedia.getMediaId());
                System.out.println(weixinMedia.getType());
                System.out.println(weixinMedia.getCreatedAt());

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("++++++++++++++++++++++++++++++++++evoicevoicevoice");
                String message = AdvancedUtil.makeVoiceCustomMessage(fromUserName,weixinMedia.getMediaId());
                AdvancedUtil.sendCustomMessage(accessToken,message);
                System.out.println("++++++++++++++++++++++++++++evoicevoicevoicevoicevoicevoicevoicevoicevoicevoicevoicevoice");
            }
        };


        StringBuffer message = new StringBuffer();
       // StorageSpace storageSpace = storageSpaceService.getOriginStorage(transportOperation.getSpaceId());
        message.append("尊敬的 "+ "先生,您好，")
                .append("已经为您建立了帐号："+" ，您可以随时了解供货情况，您可以修改您的基本信息。，");


        // String  message = "尊敬的 先生 您好，您的 目的地址是 陕西省榆林市横山县，货物送达后，您有权要求对方支付全额货款，如对方不支付，您可以扣押他的 货物，如遇到特殊情况，你可以报警。感谢您的 使用，祝您一路顺风";
        AccessStatistic path = access(message.toString(),synthesizeToUriListener);


    }
}
*/
