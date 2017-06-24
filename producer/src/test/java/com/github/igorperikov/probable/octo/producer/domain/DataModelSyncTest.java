package com.github.igorperikov.probable.octo.producer.domain;

import com.github.igorperikov.probable.octo.hollow.data.Actor;
import com.github.igorperikov.probable.octo.hollow.data.Channel;
import com.github.igorperikov.probable.octo.hollow.data.Event;
import com.github.igorperikov.probable.octo.hollow.data.Movie;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataModelSyncTest {
    @Test
    public void actorDatabaseEntityShouldContainSameAmountOfFieldsAsHollowEntity() {
        verifyFieldsEquality(Actor.class, ActorEntity.class);
    }

    @Test
    public void channelDatabaseEntityShouldContainSameAmountOfFieldsAsHollowEntity() {
        verifyFieldsEquality(Channel.class, ChannelEntity.class);
    }

    @Test
    public void eventDatabaseEntityShouldContainSameAmountOfFieldsAsHollowEntity() {
        verifyFieldsEquality(Event.class, EventEntity.class);
    }

    @Test
    public void movieDatabaseEntityShouldContainSameAmountOfFieldsAsHollowEntity() {
        verifyFieldsEquality(Movie.class, MovieEntity.class);
    }

    private <H, E> void verifyFieldsEquality(Class<H> hollowClass, Class<E> entityClass) {
        List<FieldTuple> hollowFields = Arrays.stream(hollowClass.getDeclaredFields())
                .map(field -> new FieldTuple(field.getType(), field.getName()))
                .collect(Collectors.toList());
        List<FieldTuple> entityFields = Arrays.stream(entityClass.getDeclaredFields())
                .map(field -> new FieldTuple(field.getType(), field.getName()))
                .collect(Collectors.toList());
        Assert.assertTrue(
                "JPA and hollow entity contains different fields, resolve conflict",
                hollowFields.retainAll(entityFields) == false
        );
    }

    private class FieldTuple {
        Class<?> type;
        String name;

        public FieldTuple(Class<?> type, String name) {
            this.type = type;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            FieldTuple that = (FieldTuple) o;

            if (type != null ? !type.equals(that.type) : that.type != null) return false;
            return name != null ? name.equals(that.name) : that.name == null;
        }

        @Override
        public int hashCode() {
            int result = type != null ? type.hashCode() : 0;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }
    }
}
