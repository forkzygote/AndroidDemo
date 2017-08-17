package de.ying.pixabayproj.data.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

/**
 * Created by yingli on 7/29/17.
 *
 * PixabayMessage is the complete query message from response
 */

public class PixabayMessage {
    private int total;
    private int totalHits;
    private List<Hit> hits;

    public int getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(int totalHits) {
        this.totalHits = totalHits;
    }

    public List<Hit> getHits() {
        return hits;
    }

    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public JsonArray hits2JSON(){
        JsonArray hitsJA = new JsonArray();
        for (Hit hit : hits) {
            JsonObject hitJO = new JsonObject();
            hitJO.addProperty("id", hit.getId());
            hitJO.addProperty("user", hit.getUser());
            hitJO.addProperty("tags", hit.getTags());
            hitJO.addProperty("likes", hit.getLikes());
            hitJO.addProperty("favorites", hit.getFavorites());
            hitJO.addProperty("comments", hit.getComments());
            hitJO.addProperty("pageURL", hit.getPageURL());
            hitJO.addProperty("previewURL", hit.getPreviewURL());
            hitJO.addProperty("webformatURL", hit.getWebformatURL());
            hitsJA.add(hitJO);
        }
        return hitsJA;
    }
}
