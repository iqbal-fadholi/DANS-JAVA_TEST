package com.dansmulticorp.service.exchangemodel;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties
public class DansJobResourceResponseModel {
    public String id;
    public String type;
    public String url;
    public String created_at;
    public String company;
    public String company_url;
    public String location;
    public String title;
    public String description;
    public String how_to_apply;
    public String company_logo;
}
