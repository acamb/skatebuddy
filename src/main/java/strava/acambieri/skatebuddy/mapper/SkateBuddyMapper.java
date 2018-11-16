package strava.acambieri.skatebuddy.mapper;

import org.apache.ibatis.annotations.*;
import strava.acambieri.skatebuddy.model.Activity;
import strava.acambieri.skatebuddy.model.User;
import strava.acambieri.skatebuddy.model.Wheel;

import java.util.List;

public interface SkateBuddyMapper {



    @Insert(
            "INSERT INTO STATS (USERNAME) VALUES (#{user.username})"
    )
    public void createStats(@Param("user") User user);



    @Select(
            "SELECT * " +
                    "FROM WHEELS " +
                    "WHERE USERNAME = #{user.username} " +
                    "ORDER BY START_DATE DESC"
    )
    @ResultMap("wheelMap")
    public List<Wheel> getWheels(@Param("user") User user);

    @Update(
            "UPDATE STATS " +
                    "SET CURRENT_WHEEL = #{wheel.id} " +
                    "WHERE USERNAME = #{user.username}"
    )
    public void setCurrentWheel(@Param("user") User user, @Param("wheel") Wheel wheel);

    @Insert(
            "INSERT INTO WHEELS (USERNAME,NAME,START_DATE,TOTAL_KM,CURRENT_KM) " +
                    "VALUES (#{user.username},#{wheel.name},SYSDATE,0,0)"
    )
    @Options(useGeneratedKeys=true, keyProperty="wheel.id")
    public void addWheel(@Param("user") User user, @Param("wheel") Wheel wheel);

    @Update(
            "UPDATE STATS " +
                    "SET LAST_IMPORTED_ACT = #{user.stats.lastImportedActivityDate}, " +
                        "CURRENT_WHEEL = #{user.stats.currentWheel.id}, " +
                        "SPEED_MAX = #{user.stats.maxSpeed}, " +
                        "SPEED_AVG = #{user.stats.avgSpeed}, " +
                        "KM_MAX = #{user.stats.maxRunKM}, " +
                        "KM_AVG = #{user.stats.avgRunKM}, " +
                        "KM_TOTAL = #{user.stats.totalKM}, " +
                        "ROTATION_KM = #{user.stats.rotationKM}," +
                        "AUTOIMPORT = #{user.stats.autoimport,typeHandler=strava.acambieri.skatebuddy.mapper.type.YNBooleanTypeHandler} " +
                    "WHERE USERNAME = #{user.username}"
    )
    public void updateStats(@Param("user") User user);



    @Insert(
            "INSERT INTO ACTIVITIES (ID,NAME,DATE,DISTANCE,TIME,SPEED_AVG,SPEED_MAX,STRAVA_ID,WHEEL) " +
                    "VALUES" +
                    "(#{act.id}," +
                    "#{act.name}," +
                    "#{act.date}," +
                    "#{act.distance}," +
                    "#{act.time}," +
                    "#{act.avgSpeed}," +
                    "#{act.maxSpeed}," +
                    "#{act.stravaId}," +
                    "#{wheel.id})"
    )
    public void insertActivy(@Param("act") Activity act,@Param("wheel") Wheel wheel);

    @Update(
            "UPDATE STATS S " +
                    "SET SPEED_AVG = ( SELECT AVG(A.SPEED_AVG) FROM ACTIVITIES A,USERS U WHERE A.STRAVA_ID = U.STRAVA_ID AND S.USERNAME = U.USERNAME), " +
                    "KM_AVG = ( SELECT AVG(A.DISTANCE) FROM ACTIVITIES A,USERS U WHERE A.STRAVA_ID = U.STRAVA_ID AND S.USERNAME = U.USERNAME), " +
                    "s.SPEED_MAX = ( SELECT MAX(A.SPEED_MAX) FROM ACTIVITIES A,USERS U WHERE A.STRAVA_ID = U.STRAVA_ID AND S.USERNAME = U.USERNAME ), " +
                    "s.KM_MAX = ( SELECT MAX(A.DISTANCE) FROM ACTIVITIES A,USERS U WHERE A.STRAVA_ID = U.STRAVA_ID AND S.USERNAME = U.USERNAME ), " +
                    "S.KM_TOTAL = (SELECT SUM(A.DISTANCE) FROM ACTIVITIES A,USERS U WHERE A.STRAVA_ID = U.STRAVA_ID AND S.USERNAME = U.USERNAME ) " +
                    "WHERE USERNAME = #{username}"
    )
    public void calculateAvgPerUser(User user);



    @Update(
            "UPDATE WHEELS SET TOTAL_KM = #{stats.currentWheel.totalKM}, " +
                    "CURRENT_KM = #{stats.currentWheel.currentKM} " +
                    "WHERE ID = #{stats.currentWheel.id}"
    )
    void updateCurrentWheel(User user);

    @Update(
            "UPDATE WHEELS SET " +
                    "LAST_ROTATION_DATE = SYSDATE," +
                    "CURRENT_KM = 0, " +
                    "ROTATION_COUNTER = #{rotationCounter} " +
                    "WHERE ID = #{id}"
    )
    void rotateWheel(Wheel currentWheel);

    @Delete(
            "DELETE FROM WHEELS WHERE ID = #{id}"
    )
    void deleteWheel(@Param("id") Long id);

    @Update(
            "UPDATE STATS SET CURRENT_WHEEL = NULL WHERE CURRENT_WHEEL = #{id}"
    )
    void disassociateWheel(@Param("id") Long id);

    @Select(
            "SELECT WHEELS.* " +
                    "FROM WHEELS,STATS " +
                    "WHERE ID = CURRENT_WHEEL " +
                    "AND STATS.USERNAME = #{user.username}"
    )
    @ResultMap("wheelMap")
    Wheel getCurrentWheel(@Param("user") User user);

    @Select(
            "SELECT A.* FROM ACTIVITIES A,USERS U WHERE " +
                    "A.STRAVA_ID = U.STRAVA_ID " +
                    "AND USERNAME = #{username} ORDER BY DATE DESC"
    )
    @ResultMap("activityMap")
    List<Activity> getActivities(User user);

    @Update(
            "UPDATE WHEELS " +
                    "SET TOTAL_KM = (SELECT SUM(DISTANCE) FROM ACTIVITIES WHERE WHEEL = #{id})," +
                    "CURRENT_KM = (SELECT SUM(DISTANCE) FROM ACTIVITIES WHERE WHEEL = #{id} AND (DATE > LAST_ROTATION_DATE OR LAST_ROTATION_DATE IS NULL)) " +
                    "WHERE ID = #{id}"
    )
    void recalculateWheel(Wheel currentWheel);

    @Select(
            "SELECT A.* FROM ACTIVITIES A,USERS U WHERE " +
                    "A.STRAVA_ID = U.STRAVA_ID " +
                    "AND USERNAME = #{user.username} " +
                    "AND ID = #{id}"
    )
    @ResultMap("activityMap")
    Activity getActivity(@Param("user") User user,@Param("id") long id);

    @Delete(
            "DELETE FROM ACTIVITIES WHERE ID = #{id} AND STRAVA_ID = #{user.stravaId}"
    )
    void deleteActivity(@Param("user") User user,@Param("id") long id);

    @Update(
            "UPDATE ACTIVITIES SET WHEEL = #{wheel.id} WHERE ID = #{id}"
    )
    void updateActivity(Activity activity);
}
