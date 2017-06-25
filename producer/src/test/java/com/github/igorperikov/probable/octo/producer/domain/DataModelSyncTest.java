package com.github.igorperikov.probable.octo.producer.domain;

import com.github.igorperikov.probable.octo.common.hollow.data.Actor;
import com.github.igorperikov.probable.octo.common.hollow.data.Channel;
import com.github.igorperikov.probable.octo.common.hollow.data.Event;
import com.github.igorperikov.probable.octo.common.hollow.data.Movie;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Ignore
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
        verifyFieldsNamesEquality(Event.class, EventEntity.class);
    }

    @Test
    public void movieDatabaseEntityShouldContainSameAmountOfFieldsAsHollowEntity() {
        verifyFieldsEquality(Movie.class, MovieEntity.class);
    }

    private <H, E> void verifyFieldsEquality(Class<H> hollowClass, Class<E> entityClass) {
        Set<FieldTuple> hollowFields = Arrays.stream(hollowClass.getDeclaredFields())
                .map(field -> new FieldTuple(field.getType(), field.getName()))
                .collect(Collectors.toSet());
        Set<FieldTuple> entityFields = Arrays.stream(entityClass.getDeclaredFields())
                .map(field -> new FieldTuple(field.getType(), field.getName()))
                .collect(Collectors.toSet());
        Assert.assertThat(hollowFields, Matchers.equalTo(entityFields));
    }

    private <H, E> void verifyFieldsNamesEquality(Class<H> hollowClass, Class<E> entityClass) {
        Set<FieldTuple> hollowFields = Arrays.stream(hollowClass.getDeclaredFields())
                .map(field -> new FieldTuple(field.getName()))
                .collect(Collectors.toSet());
        Set<FieldTuple> entityFields = Arrays.stream(entityClass.getDeclaredFields())
                .map(field -> new FieldTuple(field.getName()))
                .collect(Collectors.toSet());
        Assert.assertThat(hollowFields, Matchers.equalTo(entityFields));
    }

    private class FieldTuple {
        Class<?> type;
        final String name;

        public FieldTuple(String name) {
            this.name = name;
        }

        public FieldTuple(Class<?> type, String name) {
            this.type = type;
            this.name = name;
        }

        @Override
        public String toString() {
            return "FieldTuple{" +
                    "type=" + type +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            FieldTuple that = (FieldTuple) o;

            if (type != null ? !type.equals(that.type) : that.type != null) return false;
            return name.equals(that.name);
        }

        @Override
        public int hashCode() {
            int result = type != null ? type.hashCode() : 0;
            result = 31 * result + name.hashCode();
            return result;
        }
    }
}
