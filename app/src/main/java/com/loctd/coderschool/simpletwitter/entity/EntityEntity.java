package com.loctd.coderschool.simpletwitter.entity;

import com.loctd.coderschool.simpletwitter.model.Entity;
import com.loctd.coderschool.simpletwitter.model.Media;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

public class EntityEntity extends RealmObject {
    private RealmList<MediaEntity> media;

    public EntityEntity(RealmList<MediaEntity> media) {
        this.media = media;
    }

    public EntityEntity() {
    }

    public static EntityEntity fromEntity(Entity entity){
        List<Media> medias = entity.getMedia();
        List<MediaEntity> mediaEntities = new ArrayList<>();
        if (medias != null){
            for (Media media: medias){
                mediaEntities.add(MediaEntity.fromMedia(media));
                RealmList<MediaEntity> mediaEntityRealmList = new RealmList<>();
                mediaEntityRealmList.addAll(mediaEntities);
                return new EntityEntity(mediaEntityRealmList);
            }
        }
        return new EntityEntity(null);

    }

    public Entity toEntity(){
        if (this.media!=null){
            List<Media> medias = new ArrayList<>();
            for (MediaEntity mediaEntity: this.media){
                medias.add(mediaEntity.toMedia());
            }
            return new Entity(medias);
        }
        return new Entity(null);
    }

    public List<MediaEntity> getMedia() {
        return media;
    }

    public void setMedia(RealmList<MediaEntity> media) {
        this.media = media;
    }
}
