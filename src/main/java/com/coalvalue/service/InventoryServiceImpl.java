package com.coalvalue.service;

import com.coalvalue.domain.entity.Inventory;
import com.coalvalue.domain.entity.Product;
import com.coalvalue.domain.entity.StorageSpace;
import com.coalvalue.enumType.InventoryStatusEnum;
import com.coalvalue.enumType.ResourceType;
import com.coalvalue.repository.InventoryRepository;
import com.coalvalue.repository.InventoryTransferRepository;
import com.coalvalue.repository.StorageSpaceRepository;
import com.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("inventoryService")
public class InventoryServiceImpl extends BaseServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private StorageSpaceRepository storageSpaceRepository;


    @Autowired
    private CompanyService companyService;




    @Autowired
    private InventoryTransferRepository inventoryTransferRepository;



    @Autowired
    private Validator promotionFormValidator;


    @Autowired
    private ProductService productService;







    @Override
    @Transactional
    public Inventory getStorageInventory(Product product, StorageSpace storageSpace) {


        Integer itemid  = product.getId();

        Integer companyId = product.getCompanyId();
        String  itemType =  ResourceType.COAL_PRODUCT.getText();



        Inventory inventory = inventoryRepository.findByStorageIdAndItemIdAndItemType(storageSpace.getId(),itemid,itemType);

        if(inventory == null){
            inventory = new Inventory();
            inventory.setItemId(itemid);


            inventory.setItemType(itemType);
            inventory.setQuantityOnHand(new BigDecimal(0));

            inventory.setStorageId(storageSpace.getId());
            inventory.setCompanyId(companyId);
            inventory = inventoryRepository.save(inventory);

        }


        return inventory;
    }

    @Override
    public List<Inventory> getInventory(Product product, Pageable pageable) {

        return inventoryRepository.findByItemIdAndItemType(product.getId(), ResourceType.COAL_PRODUCT.getText());
    }



    @Override
    public Inventory getInventory(Product product, StorageSpace storageSpace) {

        Inventory inventory = inventoryRepository.findByStorageIdAndItemIdAndItemType(storageSpace.getId(),product.getId(), ResourceType.COAL_PRODUCT.getText());

        return inventory;
    }

    @Override
    public Inventory getInventoryById(Integer inventoryId) {
        return inventoryRepository.findById(inventoryId);
    }



    @Override
    public List<Inventory> getInventoryByStorage(StorageSpace a) {

        return inventoryRepository.findByStorageIdAndItemType(a.getId(), ResourceType.COAL_PRODUCT.getText());
    }

    @Override
    public List<Inventory> getInventoryByProductId(Integer productId) {

        return inventoryRepository.findByItemIdAndItemType(productId, ResourceType.COAL_PRODUCT.getText());


    }

    @Override
    public List<Inventory> getInventory(Product product, InventoryStatusEnum open) {
        return inventoryRepository.findByItemIdAndItemTypeAndStatus(product.getId(), ResourceType.COAL_PRODUCT.getText(),open.getText());

    }

    @Override
    public List<Map<String, Object>> getInventoryMap(Product product, InventoryStatusEnum open) {
        return getInventoryMap(product,open,null);
    }

    @Override
    public Map<String,Object> getInventoryPage(Product product, Pageable pageable) {


        Page<Inventory> pages = inventoryRepository.findByItemIdAndItemType(product.getId(), ResourceType.COAL_PRODUCT.getText(),pageable);

        Map<String,Object> objectMap = new HashMap<>();
        objectMap.put("totalElements",pages.getTotalElements());
        objectMap.put("totalPages",pages.getTotalPages());

        objectMap.put("totalElements",pages.getTotalElements());
        objectMap.put("content",getContent(pages,true));
        return objectMap;

    }



    private List<Map<String, Object>> getContent(Page<Inventory> result, boolean isMoobile){
        List<Map<String, Object>> content = new LinkedList<>();


        List<Map<String, Object>> maps = new ArrayList<>();

        for(Inventory inventory : result){
            content.add(getContentElement(inventory,true));
        }


        return content;
    }


    private Map<String, Object> getContentElement(Inventory inventory, boolean isMoobile){




            Map<String,Object> element = new HashMap<>();
            element.put("quantityOnHand", inventory.getQuantityOnHand());
            element.put("status", inventory.getStatus());
        element.put("id", inventory.getId());


            StorageSpace storageSpace = storageSpaceRepository.findById(inventory.getStorageId());


            String storageSpaceUrl =   null;//linkTo(methodOn(MobileStorageSpaceController.class).storageDetail(storageSpace.getId(),null,null)).withSelfRel().getHref();

            element.put("storageUrl", storageSpaceUrl);
        element.put("storageId", storageSpace.getId());
            element.put("storageAddress", storageSpace.getProvinceCityDistrictStreetString());
            element.put("storageName", storageSpace.getName());
            element.put("averageWaitingTime", storageSpace.getProvinceCityDistrictStreetString());

            element.put("loadingCount", storageSpace.getLoadingCount());
            element.put("pendingCount", storageSpace.getPendingCount());

            List<Integer> internal = Arrays.asList(1,2,3,4,5);


            element.put("timeliness", getTimeliness(internal,LocalDateTime.ofInstant(inventory.getModifyDate().toInstant(), ZoneId.systemDefault()))+"");





        return element;
    }
    @Override
    public List<Inventory> getInventory(Product product) {

        return getInventory(product.getId());

    }

    @Override
    public List<Map<String, Object>> getInventoryMap(Product product, InventoryStatusEnum open, Integer i) {

        List<Inventory> inventories = null;
        if(open != null){
            inventories = getInventory(product,open);
        }else{
            inventories = getInventory(product);
        }



        List<Map<String, Object>> maps = new ArrayList<>();

        for(Inventory inventory : inventories){

            List<Integer> internal = Arrays.asList(1,2,3,4,5);
            if(i != null){
                if(getTimeliness(internal,LocalDateTime.ofInstant(inventory.getModifyDate().toInstant(), ZoneId.systemDefault())) < i){
                    Map<String,Object> element = new HashMap<>();
                    maps.add(getContentElement(inventory,true));
                }
            }


        }


        return maps;

    }

    @Override
    public List<Inventory> getInventory(Integer productId) {

        return inventoryRepository.findByItemIdAndItemType(productId, ResourceType.COAL_PRODUCT.getText());

    }


    private Integer getTimeliness(List<Integer> internal ,LocalDateTime testDate){
        LocalDateTime current = LocalDateTime.now();

        List<Map> periods  = new ArrayList<>();
        LocalDateTime beforeDate = current;
        for(int i = 0 ; i< internal.size(); i++){


            Integer integer  = internal.get(i);
            LocalDateTime date1 = current.minusHours(integer);
            if(isWithinRange(testDate,beforeDate,date1)){
                return i;
            }
   /*         Map map = new HashMap<>();
            map.put("beforeDate",beforeDate);
            map.put("afterDate",date1);
            periods.add(map);
            //Period period = Period.between(beforeDate, date1);
            beforeDate =date1;*/
        }

        return 1000;


    }

    boolean isWithinRange(LocalDateTime testDate,LocalDateTime startDate,LocalDateTime endDate) {
        return !(testDate.isBefore(endDate) || testDate.isAfter(startDate));
    }
}
