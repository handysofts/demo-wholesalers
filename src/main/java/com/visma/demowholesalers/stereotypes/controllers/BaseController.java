package com.visma.demowholesalers.stereotypes.controllers;

import com.visma.demowholesalers.utils.ConstantHolder;

/**
 * Created by Vasif Mustafayev.
 * vmustafayev@gmail.com
 */
public abstract class BaseController implements ConstantHolder {

    public static final String PAGE_NAME_INDEX = "index";

    public static final String CONTENT_FRAGMENT_FILE_NAME = "content_fragment_file_name";
    public static final String CONTENT_BODY = "content_body";
    public static final String PAGE_TITLE = "page_title";


    protected static final String ATTRIBUTE_CUSTOMER_LIST = "attribute_customer_list";
    protected static final String ATTRIBUTE_PRODUCT_LIST = "attribute_product_list";

}
