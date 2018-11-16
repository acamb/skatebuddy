package strava.acambieri.skatebuddy.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import strava.acambieri.skatebuddy.model.Stats;
import strava.acambieri.skatebuddy.model.User;

import java.util.List;

public interface UserMapper {
    @ResultMap("userMap")
    @Select(
            "SELECT * FROM USERS WHERE USERNAME = #{user.username}"
    )
    public User getUser(@Param("user") User user);

    @Update(
            "UPDATE USERS " +
                    "SET EMAIL = #{user.email}, " +
                    "    ACCESS_TOKEN = #{user.accessToken}, " +
                    "    REFRESH_TOKEN = #{user.refreshToken}, " +
                    "    TOKEN_EXPIRES_AT = #{user.tokenExpiresAt}, " +
                    "    STRAVA_ID = #{user.stravaId} " +
                    "WHERE USERNAME = #{user.username}"
    )
    public void updateUser(@Param("user") User user);

    @Insert(
            "INSERT INTO USERS (USERNAME) " +
                    "VALUES (#{user.username})"
    )
    public void createUser(@Param("user") User user);

    @Insert(
            "INSERT INTO STATS (USERNAME,SPEED_MAX,SPEED_AVG,KM_MAX,KM_TOTAL) VALUES (#{username},0,0,0,0)"
    )
    void initStats(User user);

    @Select(
            "SELECT U.* FROM USERS U,STATS S WHERE U.USERNAME = S.USERNAME AND ACCESS_TOKEN IS NOT NULL AND REFRESH_TOKEN IS NOT NULL AND AUTOIMPORT = 'Y'"
    )
    @ResultMap("userMap")
    List<User> getImportableUsers();
}
