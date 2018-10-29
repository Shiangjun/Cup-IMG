package image.unnc.com.imagesimilarityapp;

/**
 * Created by zengye on 4/28/17.
 */

public class imgStruct {
    private long id;
    private double similarity;

    imgStruct(long id, double similarity){
        this.id = id;
        this.similarity = similarity;
    }

    public double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



}
