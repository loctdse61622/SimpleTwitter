package com.loctd.coderschool.simpletwitter.util;

import com.loctd.coderschool.simpletwitter.entity.TweetEntity;
import com.loctd.coderschool.simpletwitter.model.Tweet;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmUtil {
    public static void store(final List<Tweet> tweets){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.where(TweetEntity.class).findAll().deleteAllFromRealm();
                for (Tweet tweet: tweets){
//                    TweetEntity tweetEntity = realm.createObject(TweetEntity.class);
//                    tweetEntity.fromTweet(tweet);
                    TweetEntity entity = TweetEntity.fromTweet(tweet);
                    realm.copyToRealmOrUpdate(entity);
                }
            }

        });
        realm.close();
    }

    public static List<Tweet> getAll(){
        Realm realm = Realm.getDefaultInstance();
        List<Tweet> tweets = new ArrayList<>();
        RealmResults<TweetEntity> results = realm.where(TweetEntity.class).findAll();
        for (TweetEntity tweetEntity: results){
            tweets.add(tweetEntity.toTweet());
        }
        realm.close();
        return tweets;
    }
}
