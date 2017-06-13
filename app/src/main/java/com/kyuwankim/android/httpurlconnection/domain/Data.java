package com.kyuwankim.android.httpurlconnection.domain;

/**
 * Created by kimkyuwan on 207. 6. 13..
 */

public class Data {
    private SearchPublicToiletPOIService searchPublicToiletPOIService;

    public SearchPublicToiletPOIService getSearchPublicToiletPOIService () {
        return searchPublicToiletPOIService;
    }

    public void setSearchPublicToiletPOIService (SearchPublicToiletPOIService SearchPublicToiletPOIService) {
        this.searchPublicToiletPOIService = SearchPublicToiletPOIService;
    }












    @Override
    public String toString() {
        return "ClassPojo [SearchPublicToiletPOIService = "+searchPublicToiletPOIService+"]";
    }
}
