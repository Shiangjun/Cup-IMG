package image.unnc.com.imagesimilarityapp.model;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * Created by zengye on 4/12/17.
 */

import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * Created by Kevinpaul on 17/4/10.
 */

public class image extends DataSupport implements Serializable {
    private long id;//编号
    private String name;//名字
    private String imageUrl;//图片路径
    private String image;//图片二进制
    private String author;//专利人
    private String instro;//介绍
    private String uploadTime;//上传时间
    private String remark;//备注
    private String type;//图片类型
    private double similarity;//相似度


    public image(long id, String name, String imageUrl, String image, String author, String instro, String uploadTime, String remark, String type, float similarity) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.image = image;
        this.author = author;
        this.instro = instro;
        this.uploadTime = uploadTime;
        this.remark = remark;
        this.type = type;
        this.similarity = similarity;
    }

    public image() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getInstro() {
        return instro;
    }

    public void setInstro(String instro) {
        this.instro = instro;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }


}
