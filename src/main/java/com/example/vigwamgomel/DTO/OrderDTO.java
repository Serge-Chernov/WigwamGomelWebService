package com.example.vigwamgomel.DTO;

import com.example.vigwamgomel.entity.User;
import com.example.vigwamgomel.enums.Size;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;

public class OrderDTO {
    private User user;
    private String status;
    private String wigwamSize;
    private String wigwamColor;
    private String windowsCount;
    private String bottomType;
    private String bottomColor;
    private String pillowType;
    private String pillowColor;

    Size[] sizes = Size.values();

    public OrderDTO() {
    }

    public OrderDTO(User user, String status, String wigwamSize, String wigwamColor, String windowsCount, String bottomType, String bottomColor, String pillowType, String pillowColor) {
        this.user = user;
        this.status = status;
        this.wigwamSize = wigwamSize;
        this.wigwamColor = wigwamColor;
        this.windowsCount = windowsCount;
        this.bottomType = bottomType;
        this.bottomColor = bottomColor;
        this.pillowType = pillowType;
        this.pillowColor = pillowColor;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWigwamSize() {
        return wigwamSize;
    }

    public void setWigwamSize(String wigwamSize) {
        this.wigwamSize = wigwamSize;
    }

    public String getWigwamColor() {
        return wigwamColor;
    }

    public void setWigwamColor(String wigwamColor) {
        this.wigwamColor = wigwamColor;
    }

    public String getWindowsCount() {
        return windowsCount;
    }

    public void setWindowsCount(String windowsCount) {
        this.windowsCount = windowsCount;
    }

    public String getBottomType() {
        return bottomType;
    }

    public void setBottomType(String bottomType) {
        this.bottomType = bottomType;
    }

    public String getBottomColor() {
        return bottomColor;
    }

    public void setBottomColor(String bottomColor) {
        this.bottomColor = bottomColor;
    }

    public String getPillowType() {
        return pillowType;
    }

    public void setPillowType(String pillowType) {
        this.pillowType = pillowType;
    }

    public String getPillowColor() {
        return pillowColor;
    }

    public void setPillowColor(String pillowColor) {
        this.pillowColor = pillowColor;
    }

    public Size[] getSizes() {
        return sizes;
    }
}

