package org.lanqiao.model;

public class orderForm {
    private String orderId;
    private String userId;
    private String bookId;
    private String bookNames;
    private String rentTime;
    private Integer rentNum;
    private Integer buyNum;
    private String totalPrice;
    private Integer orderStatus;
    private String orderTime;
    private String returnTime;
    private String bookImg;
    private String flag;

    @Override
    public String toString() {
        return "orderForm{" +
                "orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", bookNames='" + bookNames + '\'' +
                ", rentTime='" + rentTime + '\'' +
                ", rentNum=" + rentNum +
                ", buyNum=" + buyNum +
                ", totalPrice='" + totalPrice + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderTime='" + orderTime + '\'' +
                ", returnTime='" + returnTime + '\'' +
                ", bookImg='" + bookImg + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookNames() {
        return bookNames;
    }

    public void setBookNames(String bookNames) {
        this.bookNames = bookNames;
    }

    public String getRentTime() {
        return rentTime;
    }

    public void setRentTime(String rentTime) {
        this.rentTime = rentTime;
    }

    public Integer getRentNum() {
        return rentNum;
    }

    public void setRentNum(Integer rentNum) {
        this.rentNum = rentNum;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getBookImg() {
        return bookImg;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
