package com.muaaz.joosuf.encrypted.redditclient.RedditClientApi.JPosts;

import com.google.gson.annotations.SerializedName;

class All_Awardings {
    @SerializedName("is_enabled")
    private String is_enabled;
    @SerializedName("count")
    private String count;
    @SerializedName("subreddit_id")
    private String subreddit_id;
    @SerializedName("description")
    private String description;
    @SerializedName("coin_reward")
    private String coin_reward;
    @SerializedName("icon_width")
    private String icon_width;
    @SerializedName("icon_url")
    private String icon_url;
    @SerializedName("days_of_premium")
    private String days_of_premium;
    @SerializedName("icon_height")
    private String icon_height;

    public String getIs_enabled() {
        return is_enabled;
    }

    public void setIs_enabled(String is_enabled) {
        this.is_enabled = is_enabled;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getSubreddit_id() {
        return subreddit_id;
    }

    public void setSubreddit_id(String subreddit_id) {
        this.subreddit_id = subreddit_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoin_reward() {
        return coin_reward;
    }

    public void setCoin_reward(String coin_reward) {
        this.coin_reward = coin_reward;
    }

    public String getIcon_width() {
        return icon_width;
    }

    public void setIcon_width(String icon_width) {
        this.icon_width = icon_width;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getDays_of_premium() {
        return days_of_premium;
    }

    public void setDays_of_premium(String days_of_premium) {
        this.days_of_premium = days_of_premium;
    }

    public String getIcon_height() {
        return icon_height;
    }

    public void setIcon_height(String icon_height) {
        this.icon_height = icon_height;
    }
}
