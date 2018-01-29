package com.coalvalue.domain.entity;

import com.coalvalue.configuration.CommonConstant;
import com.coalvalue.domain.BaseDomain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Peter Xu on 06/30/2015.
 */
@Entity
@Table(name = "company")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public class Company extends BaseDomain {

    private String zipcode;
    private String unifiedSocialCreditCode;

    public String getAllowedThing() {
        return allowedThing;
    }

    public void setAllowedThing(String allowedThing) {
        this.allowedThing = allowedThing;
    }

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "COMPANY_TYPE")
    private String companyType;

    @Column(name = "LOGO_IMAGE")
    private String logoImage;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "FAX_NUMBER")
    private String faxNumber;

    @Column(name = "WEBSITE_URL")
    private String websiteUrl;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "CITY")
    private String city;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "district_id")
    private Integer districtId;
    private String businessStatus;

    @Column(name = "be_allowed")
    private String allowedThing;


    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

/*
    @OneToOne(optional = true,cascade = CascadeType.ALL)//,fetch = FetchType.LAZY)
    @JoinColumn(name="company_address_id")
    private CoalAddress address;
*/

    @Column(name = "company_address_id")
    private Integer companyAddressId;

    public Integer getCompanyAddressId() {
        return companyAddressId;
    }

    public void setCompanyAddressId(Integer companyAddressId) {
        this.companyAddressId = companyAddressId;
    }

    @Column(name = "COMPANY_DESC")
    private String companyDesc;

    @Column(name = "COMMENT")
    private String comment;

    @Column(name = "BACKGROUND_FILE")
    private String backgroundFile;

    @Column(name = "MAIN_BUSINESS")
    private String mainBusiness;

    @Column(name = "ORG_CODE_CERTIFICATION")
    private String orgCodeCertification;

    @Column(name = "ORG_CODE")
    private String orgCode;

    @Column(name = "operating_period")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date operatingPeriod;

    @Column(name = "Business_license")
    private String businessLicense;

    @Column(name = "legal_representative")
    private String legalRepresentative;

    @Column(name = "Tax_account")
    private String taxAccount;

    @Column(name = "tax_period")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date taxPeriod;

    @Column(name = "coal_license")
    private String coalLicense;

    @Column(name = "coal_license_period")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date coalLicensePeriod;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "bank_branch")
    private String bankBranch;

    @Column(name = "bank_account")
    private String bankAccount;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "apply_verification_time")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date applyVerificationTime;

    @Column(name = "approved_time")
    private Date approvedTime;

    @Column(name = "status")
    private String status;

    @Column(name = "public")
    private boolean open;

    @Column(name = "brand")
    private boolean brand;


    @Column(name = "thumbnail_image")
    private String thumbnailImage;
    @Column(name = "small_image")
    private String smallImage;

    @Column(name = "is_verified")
    private boolean isVerified;

    @Column(name = "companyNo")
    private String companyNo;

    @Column(name = "abbreviation_name")
    private String abbreviationName;

    @Column(name = "operational_product")
    private String operationalProduct;

    public String getOperationalProduct() {
        return operationalProduct;
    }

    public void setOperationalProduct(String operationalProduct) {
        this.operationalProduct = operationalProduct;
    }

    public String getAbbreviationName() {

        if(abbreviationName!=null){
            return abbreviationName;
        }else {
            return companyName;
        }

    }

    public void setAbbreviationName(String abbreviationName) {
        this.abbreviationName = abbreviationName;
    }

/*
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="companyId")
    private List<ZoneImage> images= new ArrayList<ZoneImage>(); ;

    public List<ZoneImage> getImages() {
        return images;
    }  public void setImages(List<ZoneImage> images) {
        this.images = images;
    }

*/


    public Company(String companyName, String companyLocation) {
        super();
        this.companyName = companyName;
        this.location = companyLocation;

    }


    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }


    public boolean isBrand() {
        return brand;
    }

    public void setBrand(boolean brand) {
        this.brand = brand;
    }

/*    public String getCertifiedBrand() {
        return certifiedBrand;
    }*/

    public String getSmallImage() {
        if(smallImage == null)
            return defaultUrl;
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }



    @Transient
    private String certifiedBrand;
@Transient
    private Date certifiedDate;


    @Transient
    private String defaultUrl = "css/defaultUrl.jpg";


    public String getDefaultUrl() {
        return defaultUrl;
    }

    public boolean isCertifiedBrand() {
        return CommonConstant.COMPANY_VERIFICATION_BRAND.equals(certifiedBrand);
    }



    public void setCertifiedBrand(boolean certifiedBrand) {
        if(certifiedBrand) {
            this.certifiedBrand = CommonConstant.COMPANY_VERIFICATION_BRAND;
        }else {
            this.certifiedBrand = null;
        }

    }

    public Date getCertifiedDate() {
        return certifiedDate;
    }

    public void setCertifiedDate(Date certifiedDate) {
        this.certifiedDate = certifiedDate;
    }

    public Company() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyType() {
        return companyType;
    }

    public String getLogoImage() {
        return logoImage;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public String getUrl() {
        return websiteUrl;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getLocation() {
        return location;
    }

    public String getCompanyDesc() {
        return companyDesc;
    }

    public String getCompanyShortDesc() {

        if(getCompanyDesc() == null){
            return  "";
        }
        return     getCompanyDesc().length() > CommonConstant.STRING_COMPANY_SHORT_DESC_LENGTH ? getCompanyDesc().substring(0, CommonConstant.STRING_COMPANY_SHORT_DESC_LENGTH) +"..." :getCompanyDesc();

    }

    public String getComment() {
        return comment;
    }

    public String getBackgroundFile() {
        return backgroundFile;
    }

    public String getMainBusiness() {
        return mainBusiness;
    }

    public String getOrgCodeCertification() {
        return orgCodeCertification;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public Date getOperatingPeriod() {
        return operatingPeriod;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public String getTaxAccount() {
        return taxAccount;
    }

    public Date getTaxPeriod() {
        return taxPeriod;
    }

    public String getCoalLicense() {
        return coalLicense;
    }

    public Date getCoalLicensePeriod() {
        return coalLicensePeriod;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public String getAccountName() {
        return accountName;
    }

    public Date getApplyVerificationTime() {
        return applyVerificationTime;
    }

    public Date getApprovedTime() {
        return approvedTime;
    }

    public String getStatus() {
        return status;
    }

    public boolean isOpen() {
        return open;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public void setLogoImage(String logoImage) {
        this.logoImage = logoImage;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public void setUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setBackgroundFile(String backgroundFile) {
        this.backgroundFile = backgroundFile;
    }

    public void setMainBusiness(String mainBusiness) {
        this.mainBusiness = mainBusiness;
    }

    public void setOrgCodeCertification(String orgCodeCertification) {
        this.orgCodeCertification = orgCodeCertification;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public void setOperatingPeriod(Date operatingPeriod) {
        this.operatingPeriod = operatingPeriod;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public void setTaxAccount(String taxAccount) {
        this.taxAccount = taxAccount;
    }

    public void setTaxPeriod(Date taxPeriod) {
        this.taxPeriod = taxPeriod;
    }

    public void setCoalLicense(String coalLicense) {
        this.coalLicense = coalLicense;
    }

    public void setCoalLicensePeriod(Date coalLicensePeriod) {
        this.coalLicensePeriod = coalLicensePeriod;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setApplyVerificationTime(Date applyVerificationTime) {
        this.applyVerificationTime = applyVerificationTime;
    }

    public void setApprovedTime(Date approvedTime) {
        this.approvedTime = approvedTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOpen(boolean isPublic) {
        this.open = isPublic;
    }

    @Transient
    private Set<String> uneditable = new HashSet<String>()
    {{
            this.add("companyName");
            this.add("companyType");
            this.add("logoImage");
            this.add("operatingPeriod");
            this.add("businessLicense");
            this.add("legalRepresentative");
            this.add("taxAccount");
            this.add("taxPeriod");
            this.add("coalLicense");
            this.add("coalLicensePeriod");
        }};

    public Set<String> getUneditable(){
        if(this.status != CommonConstant.COMPANY_PARTIALAPPLICATION){
            return uneditable;
        }
        return new HashSet<String>();
    }

    public void changeStatus(String newStauts, String comment){
        String oldStatus = this.getStatus();

/*
        if (newStatusId.equals(AccountState.LOAN_CANCELLED.getValue())
                || newStatusId.equals(AccountState.LOAN_CLOSED_OBLIGATIONS_MET.getValue())
                || newStatusId.equals(AccountState.LOAN_CLOSED_WRITTEN_OFF.getValue())
                || newStatusId.equals(AccountState.SAVINGS_CANCELLED.getValue())
                || newStatusId.equals(AccountState.CUSTOMER_ACCOUNT_INACTIVE.getValue())) {
            this.setClosedDate(transactionDate);
        }
        if (newStatusId.equals(AccountState.LOAN_CLOSED_WRITTEN_OFF.getValue())) {
            writeOff(transactionDate);
        }

        if (newStatusId.equals(AccountState.LOAN_CLOSED_RESCHEDULED.getValue())) {
            reschedule(transactionDate);
        }

        if (newStatusId.equals(AccountState.SAVINGS_INACTIVE.getValue())) {
            ((SavingsBO) this).removeRecommendedAmountOnFutureInstallments();
        }

        if (oldStatusId.equals(AccountState.SAVINGS_INACTIVE.getValue())
                && newStatusId.equals(AccountState.SAVINGS_ACTIVE.getValue())) {
            ((SavingsBO) this).resetRecommendedAmountOnFutureInstallments();
        }

        if (AccountState.fromShort(newStatusId).isClosedLoanAccountState()
                || AccountState.fromShort(newStatusId).isCancelledLoanAccountState()) {
            changeStateForAllFees(FeeStatus.INACTIVE);
        } else if (AccountState.fromShort(newStatusId).isActiveLoanAccountState()) {
            changeStateForAllFees(FeeStatus.ACTIVE);
        }*/


    }


    @Transient
    public boolean isCertified(){

        if(status != null) {
          return   status.equals(CommonConstant.COMPANY_APPROVED);

        }
        return  false;
    }



    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    public String getCompanyNo() {
        return companyNo;
    }



    public void setBusinessStatus(String businessStatus) {
        this.businessStatus = businessStatus;
    }

    public String getBusinessStatus() {
        return businessStatus;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getUnifiedSocialCreditCode() {
        return unifiedSocialCreditCode;
    }

    public void setUnifiedSocialCreditCode(String unifiedSocialCreditCode) {
        this.unifiedSocialCreditCode = unifiedSocialCreditCode;
    }
}
